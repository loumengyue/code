<template>
  <div>
    <br/>
    <el-row>
      <el-form ref="form" :model="organInfo" label-width="100px">
        <el-col :span="6" :offset="1">
          <el-form-item label="机构名称：">
            <el-input
                clearable
                placeholder="请输入机构名称"
                size="large"
                v-model="organInfo.organName">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="机构负责人：">
            <el-input
                clearable
                placeholder="请输入机构负责人"
                size="large"
                v-model="organInfo.organLeader">
            </el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="2" :offset="19" class="btn-add">
        <el-button type="primary" icon="el-icon-search" size="small" @click="search">搜索</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="22" :offset="1">
        <el-table
            :data="organList"
            border
            style="width: 100%">
          <el-table-column
              prop="organName"
              label="机构名称">
          </el-table-column>
          <el-table-column
              prop="organDuty"
              label="机构职责">
          </el-table-column>
          <el-table-column
              prop="organPhone"
              label="办公电话"
              width="140">
          </el-table-column>
          <el-table-column
              prop="organLeader"
              label="机构负责人"
              width="140">
          </el-table-column>
          <el-table-column
              prop="organLeaderPhone"
              label="负责人电话"
              width="140">
          </el-table-column>
          <el-table-column
              prop="organTime"
              label="机构成立时间"
              width="180">
          </el-table-column>

          <el-table-column
              prop="village.villageName"
              label="所属村委">
          </el-table-column>
<!--          <el-table-column
              prop="village"
              label="所属村委">
            <template slot-scope="{row}">
              {{row.village.villageName}}
            </template>
          </el-table-column>-->
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
        <el-table-column prop="organName" label="机构名称"></el-table-column>
        <el-table-column prop="organDuty" label="机构职责"></el-table-column>
        <el-table-column prop="organPhone" label="办公电话" width="140"></el-table-column>
        <el-table-column prop="organLeader" label="机构负责人" width="140"></el-table-column>
        <el-table-column prop="organLeaderPhone" label="负责人电话" width="140"></el-table-column>
        <el-table-column prop="organTime" label="机构成立时间" width="180"></el-table-column>
        <el-table-column prop="village.villageName" label="所属村委"></el-table-column>
<!--        <el-table-column prop="village" label="所属村委"></el-table-column>-->
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exportExcel">确定保存</el-button>
      </div>
    </el-dialog>

    <!--  弹框  -->
    <el-dialog title="机构信息" :visible.sync="organDialogShow">
      <el-row>
        <el-col :span="20">
          <el-form :model="organEditTemp">
            <el-form-item label="机构名称" :label-width="'120px'">
              <el-input v-model="organEditTemp.organName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="机构职责" :label-width="'120px'">
              <el-input v-model="organEditTemp.organDuty" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="办公电话" :label-width="'120px'">
              <el-input v-model="organEditTemp.organPhone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="机构负责人" :label-width="'120px'">
              <el-input v-model="organEditTemp.organLeader"></el-input>
            </el-form-item>
            <el-form-item label="负责人电话" :label-width="'120px'">
              <el-input v-model="organEditTemp.organLeaderPhone"></el-input>
            </el-form-item>
            <el-form-item label="成立时间" :label-width="'120px'">
              <el-date-picker
                  v-model="organEditTemp.organTime"
                  type="datetime"
                  placeholder="选择日期时间">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="所属村委" :label-width="'120px'">
              <el-select
                  v-model="organEditTemp.organVillageId"
                  filterable
                  remote
                  clearable
                  reserve-keyword
                  placeholder="请输入村委名称"
                  :remote-method="selectVillage">
<!--                  :loading="loading"-->
                <el-option
                    v-for="item in villageList"
                    :key="item.villageId"
                    :label="item.villageName"
                    :value="item.villageId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditOrgan">取 消</el-button>
        <el-button type="primary" @click="ensureOrgan">确 定</el-button>
      </div>
    </el-dialog>

    <!--  弹框  -->
    <el-dialog title="机构信息" :visible.sync="organNewDialogShow">
      <el-row>
        <el-col :span="20">
          <el-form :model="organNewTemp">
            <el-form-item label="机构名称" :label-width="'120px'">
              <el-input v-model="organNewTemp.organName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="机构职责" :label-width="'120px'">
              <el-input v-model="organNewTemp.organDuty" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="办公电话" :label-width="'120px'">
              <el-input v-model="organNewTemp.organPhone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="机构负责人" :label-width="'120px'">
              <el-input v-model="organNewTemp.organLeader"></el-input>
            </el-form-item>
            <el-form-item label="负责人电话" :label-width="'120px'">
              <el-input v-model="organNewTemp.organLeaderPhone"></el-input>
            </el-form-item>
            <el-form-item label="成立时间" :label-width="'120px'">
              <el-date-picker
                  v-model="organNewTemp.organTime"
                  type="datetime"
                  placeholder="选择日期时间">
              </el-date-picker>
            </el-form-item>
            <el-form-item label="所属村委" :label-width="'120px'">
              <el-select
                  v-model="organNewTemp.organVillageId"
                  filterable
                  remote
                  clearable
                  reserve-keyword
                  placeholder="请输入村委名称"
                  :remote-method="selectVillage">
<!--                  :loading="loading"-->
                <el-option
                    v-for="item in villageList"
                    :key="item.villageId"
                    :label="item.villageName"
                    :value="item.villageId">
                </el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditOrgan">取 消</el-button>
        <el-button type="primary" @click="ensureAddOrgan">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {OrganManager} from "@/api/organ";
import {getAllVillage} from "@/api/village";
import {selectActivityPage} from "@/api/activity";
import htmlToExcel from "@/utils/htmlToExcel";

export default {
  name: "index",
  data() {
    return {
      organList: [],
      villageList: [],
      pageInfo: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      organInfo: {
        organName: '',
        organDuty: '',
        organLeader: '',
        organPhone: '',
        organLeaderPhone: '',
        organTime: '',
        organVillageId: ''
      },
      organEditTemp: {
        organName: '',
        organDuty: '',
        organLeader: '',
        organPhone: '',
        organLeaderPhone: '',
        organTime: '',
        organVillageId: ''
      },
      organNewTemp: {
        organName: '',
        organDuty: '',
        organLeader: '',
        organPhone: '',
        organLeaderPhone: '',
        organTime: '',
        organVillageId: ''
      },
      organDialogShow: false,
      organNewDialogShow: false,

      selectData:[],
      selectVillageData:[],
      selectWindow:false,
    }
  },

  created() {
    this.initOrganList();
    this.getOrganList();
  },
  methods: {
    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','机构信息')
    },
    exportExcelSelect(){
      this.selectWindow = true;
    },
    async getOrganList(){
      const { data: res } = await this.$http.post("getOrganList");
      console.log(res);
      this.selectData=res.data.organList;// 将返回数据赋值

    },

    //获取村委信息
    selectVillage(villageName){
      getAllVillage({villageName}).then(res => {
        if (res.data.code === "SUCCESS") {
          this.villageList = res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },
    //初始化数据
    initOrganList() {
      let condition = Object.assign({}, this.organInfo)
      let organPageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      OrganManager.getAllOrganList(organPageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          this.organList = res.data.data.list
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
    search(){
      this.pageInfo.pageNum = 1
      this.initOrganList()
    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      this.pageInfo.pageSize = val
      this.initOrganList()
      console.log(`每页 ${val} 条`);
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      this.pageInfo.pageNum = val
      this.initOrganList()
      console.log(`当前页: ${val}`);
    },
    //修改机构信息
    editOrgan(organ){
      this.organEditTemp = Object.assign({},organ)
      this.organDialogShow = true
    },
    //取消修改
    cancelEditOrgan() {
      this.organEditTemp = {
        organName: '',
        organDuty: '',
        organLeader: '',
        organPhone: '',
        organLeaderPhone: '',
        organTime: ''
      }
      this.organNewTemp = {
        organName: '',
        organDuty: '',
        organLeader: '',
        organPhone: '',
        organLeaderPhone: '',
        organTime: ''
      }
      this.organDialogShow = false
      this.organNewDialogShow = false
    },
    //确定修改
    ensureOrgan(){
      OrganManager.updateOrgan(this.organEditTemp).then(res => {
        if (res.data.code === "SUCCESS") {
          this.$message.success("修改成功")
          this.organDialogShow = false
          this.initOrganList()
        } else {
          this.organDialogShow = false
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
        this.organDialogShow = false
      })
    },
    deleteOrgan(organ){
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        OrganManager.deleteOrgan(organ.organId).then(res => {
          if (res.data.code === "SUCCESS"){
            this.$message.success("删除成功")
            this.cancelEditOrgan()
            this.initOrganList()
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
    addOrgan(){
      this.cancelEditOrgan()
      this.organNewDialogShow = true
    },
    ensureAddOrgan(){
      OrganManager.addOrgan(this.organNewTemp).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("添加成功")
          this.initOrganList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.organNewDialogShow = false
    }
  }
}
</script>

<style scoped>
.btn-add{
  margin-bottom: 10px;
  text-align: center;
}
</style>
