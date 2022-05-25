<template>
  <div>
    <br/>
    <el-row>
      <el-form ref="form" :model="activityInfo" label-width="100px">
        <el-col :span="6" :offset="1">
          <el-form-item label="活动类型：">
            <el-input
                clearable
                placeholder="请输入活动类型"
                size="large"
                v-model="activityInfo.activityType">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="活动内容：">
            <el-input
                clearable
                placeholder="请输入活动内容"
                size="large"
                v-model="activityInfo.activityContent">
            </el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="2" :offset="19" class="btn-add">
        <el-button type="primary" icon="el-icon-search" size="small" @click="initActivityList">搜索</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="22" :offset="1">
        <el-table
            :data="activityCommitteeList"
            stripe
            style="width: 100%">
          <el-table-column
              prop="activityId"
              label="活动编号"
              width="90">
          </el-table-column>
          <el-table-column
              prop="activityType"
              label="活动类型"
              width="130">
          </el-table-column>
          <el-table-column
              prop="activityContent"
              label="活动内容"
              width="130">
          </el-table-column>
          <el-table-column
              prop="activityStartTime"
              label="开始时间"
              width="200">
          </el-table-column>
          <el-table-column
              prop="activityEndTime"
              label="结束时间"
              width="200">
          </el-table-column>
          <el-table-column
              prop="organ.organName"
              label="发起机构">
          </el-table-column>
          <el-table-column
              prop="activityPerson"
              label="针对人群">
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <br/>
    <el-row>
      <el-col :span="10" :offset="12">
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page.sync="pageInfo.pageNum"
            :page-size="pageInfo.pageSize"
            layout="total, prev, pager, next, jumper"
            :total="pageInfo.total">
        </el-pagination>
      </el-col>
    </el-row>
    <br/>

    <!--  弹框打印  -->
    <el-dialog title="表格保存预览" width="70%" :visible.sync="selectWindow">
      <el-table :data="selectData" id="selectTable" height="380px">
        <el-table-column prop="activityId" label="活动编号" width="90"></el-table-column>
        <el-table-column prop="activityType" label="活动类型" width="110"></el-table-column>
        <el-table-column prop="activityContent" label="活动内容"></el-table-column>
        <el-table-column prop="activityStartTime" label="开始时间" width="160"></el-table-column>
        <el-table-column prop="activityEndTime" label="结束时间" width="160"></el-table-column>
        <el-table-column prop="organ.organName" label="发起机构"></el-table-column>
        <el-table-column prop="activityPerson" label="针对人群"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exportExcel">确定保存</el-button>
      </div>
    </el-dialog>


    <!--  弹框  -->
    <el-dialog title="活动信息" :visible.sync="activityDialogShow">
      <el-form :model="activityEditTemp">
        <el-form-item label="活动类型" :label-width="'120px'">
          <el-input v-model="activityEditTemp.activityType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动内容" :label-width="'120px'">
          <el-input v-model="activityEditTemp.activityContent" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动开始时间" :label-width="'120px'">
          <el-date-picker
              v-model="activityEditTemp.activityStartTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动结束时间" :label-width="'120px'">
          <el-date-picker
              v-model="activityEditTemp.activityEndTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动发起机构" :label-width="'120px'">
          <el-select
              v-model="activityEditTemp.activityOrganId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入机构名称"
              :remote-method="selectOrgan">
<!--              :loading="loading"-->
            <el-option
                v-for="item in organList"
                :key="item.organId"
                :label="item.organName"
                :value="item.organId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动针对人群" :label-width="'120px'">
          <el-input v-model="activityEditTemp.activityPerson"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditActivity">取 消</el-button>
        <el-button type="primary" @click="ensureActivity">确 定</el-button>
      </div>
    </el-dialog>

    <!--  弹框  -->
    <el-dialog title="活动信息" :visible.sync="activityNewDialogShow">
      <el-form :model="activityNew">
        <el-form-item label="活动类型" :label-width="'120px'">
          <el-input v-model="activityNew.activityType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动内容" :label-width="'120px'">
          <el-input v-model="activityNew.activityContent" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="活动开始时间" :label-width="'120px'">
          <el-date-picker
              v-model="activityNew.activityStartTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动结束时间" :label-width="'120px'">
          <el-date-picker
              v-model="activityNew.activityEndTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动发起机构" :label-width="'120px'">
          <el-select
              v-model="activityNew.activityOrganId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入机构名称"
              :remote-method="selectOrgan">
<!--              :loading="loading"-->
            <el-option
                v-for="item in organList"
                :key="item.organId"
                :label="item.organName"
                :value="item.organId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动针对人群" :label-width="'120px'">
          <el-input v-model="activityNew.activityPerson"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditActivity">取 消</el-button>
        <el-button type="primary" @click="ensureAddActivity">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import {addOneActivity, ensureDeleteActivity, selectActivityPage, updateByActivity} from "@/api/activity";
import {getOrganByName} from "@/api/organ";
import htmlToExcel from "@/utils/htmlToExcel";

export default {
  name: "index",
  data() {
    return {
      organList: [],
      activityCommitteeList: [],
      pageInfo: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      activityInfo: {
        activityId:'',
        activityType: '',
        activityContent: '',
        activityStartTime: '',
        activityEndTime: '',
        activityOrganId: '',
        activityPerson: ''
      },
      activityEditTemp: {
        activityType: '',
        activityContent: '',
        activityStartTime: '',
        activityEndTime: '',
        activityOrganId: '',
        activityPerson:''
      },
      activityNew: {
        activityType: '',
        activityContent: '',
        activityStartTime: '',
        activityEndTime: '',
        activityOrganId: '',
        activityPerson:''
      },
      activityDialogShow: false,
      activityNewDialogShow: false,

      selectData:[],
      selectWindow:false,

    }
  },
  created() {
    this.initActivityList();
    this.getActivityList();
  },
  methods: {
    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','活动信息')
    },
     exportExcelSelect(){
      this.selectWindow = true;
    },
    async getActivityList(){
      const { data: res } = await this.$http.post("getActivityList");
      console.log(res);
      this.selectData=res.data.activityList;// 将返回数据赋值
    },

    selectOrgan(organName){
      getOrganByName({organName}).then(res => {
        if (res.data.code === "SUCCESS") {
          this.organList = res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },
    //初始化数据
    initActivityList() {
      let condition = Object.assign({}, this.activityInfo)
      let activityPageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      selectActivityPage(activityPageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          this.activityCommitteeList = res.data.data.list
          this.pageInfo.pageNum = res.data.data.pageNum
          this.pageInfo.total = res.data.data.total
          console.log(res);
        } else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })

    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageInfo.pageSize = val
      this.initActivityList()
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageInfo.pageNum = val
      this.initActivityList()
    },
    //修改活动信息
    editActivity(activity) {
      this.activityEditTemp = Object.assign({}, activity)
      this.activityDialogShow = true
    },
    //取消修改
    cancelEditActivity() {
      this.activityEditTemp = {
        activityType: '',
        activityContent: '',
        activityStartTime: '',
        activityEndTime: '',
        activityOrganId: '',
        activityPerson:''
      }
      this.activityNew = {
        activityType: '',
        activityContent: '',
        activityStartTime: '',
        activityEndTime: '',
        activityOrganId: '',
        activityPerson:''
      }
      this.activityDialogShow = false
      this.activityNewDialogShow = false
      console.log("取消修改")
    },
    //确定修改
    ensureActivity() {
      updateByActivity(this.activityEditTemp).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("修改成功")
          this.initActivityList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
      })
      this.activityDialogShow = false
    },
    deleteActivity(activity) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        ensureDeleteActivity(activity.activityId).then(res => {
          if (res.data.code === "SUCCESS"){
            this.$message.success("删除成功")
            this.initActivityList()
          }else {
            this.$message.error(res.data.msg)
          }
        }).catch(error => {
          console.log(error)
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    addActivity() {
      this.activityNewDialogShow = true
    },
    ensureAddActivity(){
      addOneActivity(this.activityNew).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("添加成功")
          this.initActivityList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.activityNewDialogShow = false
    }
  }
}

</script>

<style scoped>
.btn-add {
  margin-bottom: 10px;
  text-align: center;
}
</style>