<template>
  <div>
    <br/>
    <el-row>
      <el-form ref="form" :model="helperInfo" label-width="100px">
        <el-col :span="6" :offset="1">
          <el-form-item label="帮扶对象">
            <el-select
                v-model="helperInfo.helperPopulationId"
                filterable
                remote
                clearable
                reserve-keyword
                placeholder="请输入帮扶对象"
                :remote-method="selectPopulation">
              <el-option
                  v-for="item in populationList"
                  :key="item.populationId"
                  :label="item.populationName"
                  :value="item.populationId">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="帮扶原因">
            <el-input
                clearable
                placeholder="请输入帮扶原因"
                size="large"
                v-model="helperInfo.helperType">
            </el-input>
          </el-form-item>
        </el-col>
<!--        <el-col :span="6" :offset="1">
          <el-form-item label="帮扶状态">
            <el-select
                v-model="helperInfo.helperStatus"
                clearable
                placeholder="请输入帮扶状态">
              <el-option :label="item.label" :value="item.value" v-for="item in statusOptions " :key="item.value"></el-option>
            </el-select>
          </el-form-item>
        </el-col>-->
<!--       <el-col :span="6" :offset="1">
          <el-form-item label="帮扶执行者">
            <el-input
                placeholder="请输入执行者"
                size="small"
                v-model="helperInfo.helperExecuted">
            </el-input>
          </el-form-item>
        </el-col>-->
      </el-form>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="2" :offset="18" class="btn-add">
        <el-button type="primary" icon="el-icon-search" size="small" @click="search">搜索</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" icon="el-icon-plus" size="small" @click="addHelper">新增</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="22" :offset="1">
        <el-table
            :data="helperList"
            border
            style="width: 100%">
<!--          <el-table-column
              prop="helperPopulationId"
              label="帮扶对象"
              width="100">
            <template slot-scope="{row}">
              {{ row.population.populationName }}
            </template>
          </el-table-column>-->
          <el-table-column
              prop="population.populationName"
              label="帮扶对象"
              width="100">
          </el-table-column>
          <el-table-column
              prop="population.populationId"
              label="帮扶对象ID"
              width="100">
          </el-table-column>
          <el-table-column
              prop="helperType"
              label="帮扶原因">
          </el-table-column>
          <el-table-column
              prop="helperTime"
              label="帮扶时间"
              width="180">
          </el-table-column>
          <el-table-column
              prop="helperStatus"
              label="所处状态">
            <template slot-scope="{row}">
              <span v-if="row.helperStatus == 1">未帮扶</span>
              <span v-if="row.helperStatus == 2">帮扶中</span>
              <span v-if="row.helperStatus == 3">帮扶结束</span>
            </template>
          </el-table-column>
          <el-table-column
              prop="helperExecuted"
              label="执行者"
              width="100">
          </el-table-column>
<!--          <el-table-column
              prop="helperVillageId"
              label="所属村委"
              width="100">
            <template slot-scope="{row}">
              {{ row.village.villageName }}
            </template>
          </el-table-column>-->
          <el-table-column
              prop="village.villageName"
              label="所属村委"
              width="100">
          </el-table-column>
          <el-table-column
              label="操作"
              width="150">
            <template slot-scope="{row}">
              <el-button type="primary" size="mini" @click="editHelper(row)">编辑</el-button>
              <el-button type="danger" danger size="mini" @click="deleteHelper(row)">删除</el-button>
            </template>
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
        <el-table-column prop="population.populationName" label="帮扶对象" width="100"></el-table-column>
        <el-table-column prop="population.populationId" label="帮扶对象ID" width="100"></el-table-column>
        <el-table-column prop="helperType" label="帮扶原因"></el-table-column>
        <el-table-column prop="helperTime" label="帮扶时间" width="180"></el-table-column>
        <el-table-column
            prop="helperStatus"
            label="所处状态">
          <template slot-scope="{row}">
            <span v-if="row.helperStatus == 1">未帮扶</span>
            <span v-if="row.helperStatus == 2">帮扶中</span>
            <span v-if="row.helperStatus == 3">帮扶结束</span>
          </template>
        </el-table-column>
        <el-table-column prop="helperExecuted" label="执行者" width="100"></el-table-column>
        <el-table-column prop="village.villageName" label="所属村委" width="100"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exportExcel">确定保存</el-button>
      </div>
    </el-dialog>
    <!-- 修改 弹框  -->
    <el-dialog title="帮扶信息" :visible.sync="helperDialogShow">
      <el-form :model="helperEditTemp">
        <el-form-item label="帮扶对象" :label-width="'120px'">
          <el-select
              disabled
              v-model="helperEditTemp.helperPopulationId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入帮扶对象"
              :remote-method="selectPopulation">
            <el-option
                v-for="item in populationList"
                :key="item.populationId"
                :label="item.populationName+' 身份证号'+item.populationId"
                :value="item.populationId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="帮扶原因" :label-width="'120px'">
          <el-input v-model="helperEditTemp.helperType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="帮扶时间" :label-width="'120px'">
          <el-date-picker
              v-model="helperEditTemp.helperTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="所处状态" :label-width="'120px'">
          <el-select v-model="helperEditTemp.helperStatus">
            <el-option label="未帮扶" value="1"></el-option>
            <el-option label="帮扶中" value="2"></el-option>
            <el-option label="帮扶结束" value="3"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="帮扶执行者" :label-width="'120px'">
          <el-input v-model="helperEditTemp.helperExecuted"></el-input>
        </el-form-item>
        <el-form-item label="所属村落" :label-width="'120px'">
          <el-select
              disabled
              v-model="helperEditTemp.helperVillageId"
              clearable
              placeholder="请输入村子名称">
            <el-option
                :label="helperEditTemp.helperPopulationId"
                :value="helperEditTemp.helperPopulationId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditHelper">取 消</el-button>
        <el-button type="primary" @click="ensureHelper">确 定</el-button>
      </div>
    </el-dialog>

    <!--  添加弹框  -->
    <el-dialog title="村委信息" :visible.sync="helperNewDialogShow">
      <el-form :model="helperNew">
        <el-form-item label="所属村落" :label-width="'120px'">
          <el-select
              v-model="helperNew.helperVillageId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入村落名称"
              :remote-method="selectVillage">
            <!--             :loading="loading"-->
            <el-option
                v-for="item in villageList"
                :key="item.villageId"
                :label="item.villageName"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="帮扶对象" :label-width="'120px'">
          <el-select
              v-model="helperNew.helperPopulationId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入帮扶对象"
              :remote-method="selectPopulation">
            <el-option
                v-for="item in populationList"
                :key="item.populationId"
                :label="item.populationName+' 身份证号'+item.populationId"
                :value="item.populationId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="帮扶原因" :label-width="'120px'">
          <el-input v-model="helperNew.helperType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="帮扶时间" :label-width="'120px'">
          <el-date-picker
              v-model="helperNew.helperTime"
              type="datetime"
              value-format="yyyy-MM-dd HH:mm:ss"
              placeholder="选择日期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="所处状态" :label-width="'120px'">
          <el-select v-model="helperNew.helperStatus">
            <el-option label="未帮扶" value="1"></el-option>
            <el-option label="帮扶中" value="2"></el-option>
            <el-option label="帮扶结束" value="3"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="帮扶执行者" :label-width="'120px'">
          <el-input v-model="helperNew.helperExecuted"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditHelper">取 消</el-button>
        <el-button type="primary" @click="ensureAddHelper">确 定</el-button>
      </div>
    </el-dialog>


  </div>

</template>

<script>
import {HelperManager} from "@/api/helper";
import {getAllPopulation, getMyPopulationList} from "@/api/population";
import htmlToExcel from "@/utils/htmlToExcel";
import {getAllVillage} from "@/api/village";
import ls from "@/assets/js/ls";

export default {
  name: "index",
  data() {
    return {
      populationList: [],
      villageList:[],
      helperList: [],
      pageInfo: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      helperInfo: {
        helperPopulationId: '',
        helperType: '',
        helperTime: '',
        helperStatus: '',
        helperExecuted: '',
        helperVillageId: ''
      },
      helperEditTemp: {
        helperPopulationId: '',
        helperType: '',
        helperTime: '',
        helperStatus: '',
        helperExecuted: '',
        helperVillageId: ''
      },
      helperNew: {
        helperPopulationId: '',
        helperType: '',
        helperTime: '',
        helperStatus: '',
        helperExecuted: '',
        helperVillageId: ''
      },
      statusOptions: [
        {
          label: '未帮扶',
          value: 1
        },
        {
          label: '帮扶中',
          value: 2
        },
        {
          label: '帮扶结束',
          value: 3
        }
      ],
      helperDialogShow: false,
      helperNewDialogShow: false,

      selectData:[],
      selectWindow:false,
    }
  },
  created() {
    this.initHelperList()
    this.getHelperList()
  },
  methods: {

    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','帮扶信息')
    },
    exportExcelSelect(){
      this.getHelperList();
      this.selectWindow = true;
    },
    //获取个人信息
    getHelperList(){
      this.helperInfo.helperVillageId=ls.getItem('userVillageId');
      HelperManager.getMyHelperList( this.helperInfo.helperVillageId).then(res => {
        if (res.data.code === "SUCCESS") {
          console.log(res)
          this.selectData=res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },
   /* async getHelperList(){
      const { data: res } = await this.$http.post("getHelperList");
      console.log(res);
      this.selectData=res.data.helperList;// 将返回数据赋值
    },*/

    //获取人口信息
    selectPopulation(populationName){
      getAllPopulation(populationName).then(res => {
        if (res.data.code === "SUCCESS") {
          this.populationList = res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
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
    initHelperList() {
      this.helperInfo.helperVillageId =ls.getItem('userVillageId');
      console.log(this.helperInfo.helperVillageId+"ggggggg666666666666")
      let condition = Object.assign({}, this.helperInfo)
      let helperPageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      HelperManager.getMyAllHelperList(helperPageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          console.log(res);
          this.helperList = res.data.data.list
          this.pageInfo.pageNum = res.data.data.pageNum
          this.pageInfo.total = res.data.data.total
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
      this.pageInfo.pageSize = 20
      this.initHelperList()
    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageInfo.pageSize = val
      this.initHelperList()
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageInfo.pageNum = val
      this.initHelperList()
    },
    //修改村委信息
    editHelper(helper) {
      this.helperEditTemp = Object.assign({}, helper)
      this.helperDialogShow = true
    },
    //取消修改
    cancelEditHelper() {
      this.helperEditTemp = {
        helperName: '',
        helperAddress: '',
        helperLeading: '',
        helperPhone: '',
        helperNum: ''
      }
      this.helperNew = {
        helperName: '',
        helperAddress: '',
        helperLeading: '',
        helperPhone: '',
        helperNum: ''
      }
      this.helperDialogShow = false
      this.helperNewDialogShow = false
    },
    //确定修改
    ensureHelper() {
      HelperManager.updateHelper(this.helperEditTemp).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("修改成功")
          this.initHelperList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
      })
      this.helperDialogShow = false
    },
    deleteHelper(helper) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        HelperManager.deleteHelper(helper.helperId).then(res => {
          if (res.data.code === "SUCCESS"){
            this.$message.success("删除成功")
            this.cancelEditHelper()
            this.initHelperList()
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
    addHelper() {
      this.helperNewDialogShow = true
    },
    ensureAddHelper(){
      HelperManager.addHelper(this.helperNew).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("添加成功")
          this.initHelperList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.helperNewDialogShow = false
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