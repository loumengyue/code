<template>
  <div>

    <br/>
    <el-row>
      <el-form ref="form" :model="populationInfo" label-width="100px">
        <el-col :span="6" :offset="1">
          <el-form-item label="人口编号">
            <el-input
                clearable
                placeholder="请输入人口编号"
                size="large"
                v-model="populationInfo.populationId">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="姓名">
            <el-input
                clearable
                placeholder="请输入姓名"
                size="large"
                v-model="populationInfo.populationName">
            </el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="2" :offset="17" class="btn-add">
        <el-button type="primary" icon="el-icon-search" size="small" @click="initPopulationList">搜索</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" icon="el-icon-plus" size="small" @click="addPopulation">新增</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="22" :offset="1">
        <el-table
            :data="populationList"
            border
            style="width: 100%">
          <el-table-column
              prop="populationId"
              label="人口编号"
              width="100">
          </el-table-column>
          <el-table-column
              prop="populationName"
              label="人口姓名"
              width="100">
          </el-table-column>
          <el-table-column
              prop="populationAge"
              label="人口年龄"
              width="80">
          </el-table-column>
          <el-table-column
              prop="populationAddress"
              label="人口所在地"
              width="240">
          </el-table-column>
          <el-table-column
              prop="populationType"
              label="人口类型"
              width="100">
            <template slot-scope="{row}">
              {{row.populationType ? '外地' : '本地'}}
            </template>
          </el-table-column>
          <el-table-column
              prop="populationLocalType"
              label="常住类型"
              width="100">
            <template slot-scope="{row}">
              {{row.populationLocalType ? '外出' : '常住'}}
            </template>
          </el-table-column>
          <el-table-column
              prop="village.villageName"
              label="所属村落"
              width="100">
          </el-table-column>
          <el-table-column
              prop="village.villageLeading"
              label="所属村委"
              width="100">
          </el-table-column>
          <el-table-column
              prop="village.villagePhone"
              label="所属村委联系方式"
              width="140">
          </el-table-column>
          <el-table-column
              label="操作"
              width="250">
            <template slot-scope="{row}">
              <el-button type="primary" size="mini" @click="editPopulation(row)">编辑</el-button>
              <el-button type="danger" danger size="mini" @click="deletePopulation(row)">删除</el-button>
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
            layout="total, prev, pager, next"
            :total="pageInfo.total">
        </el-pagination>
      </el-col>
    </el-row>
    <br/>

    <!--  弹框打印  -->
    <el-dialog title="表格保存预览" width="70%" :visible.sync="selectWindow">
      <el-table :data="selectData" id="selectTable" height="380px">
        <el-table-column prop="populationId" label="人口编号" width="100"></el-table-column>
        <el-table-column prop="populationName" label="人口姓名" width="100"></el-table-column>
        <el-table-column prop="populationAge" label="人口年龄" width="80"></el-table-column>
        <el-table-column prop="populationAddress" label="人口所在地" width="250"></el-table-column>
        <el-table-column prop="populationType" label="人口类型" width="120">
          <template slot-scope="{row}">
            {{row.populationType ? '外地' : '本地'}}
          </template>
        </el-table-column>
        <el-table-column prop="populationLocalType" label="常住类型" width="120">
          <template slot-scope="{row}">
            {{row.populationLocalType ? '外出' : '常住'}}
          </template>
        </el-table-column>
        <el-table-column prop="village.villageName" label="所属村落" width="140"></el-table-column>
        <el-table-column prop="village.villageLeading" label="所属村委" width="140"></el-table-column>
        <el-table-column prop="village.villagePhone" label="所属村委联系方式" width="140"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exportExcel">确定保存</el-button>
      </div>
    </el-dialog>

    <!-- 修改     弹框  -->
    <el-dialog title="人口信息" :visible.sync="populationDialogShow">
      <el-form :model="populationEditTemp">
        <el-form-item label="人口编号" :label-width="'120px'">
          <el-input disabled v-model="populationEditTemp.populationId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="人口姓名" :label-width="'120px'">
          <el-input v-model="populationEditTemp.populationName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="人口年龄" :label-width="'120px'">
          <el-input v-model="populationEditTemp.populationAge"></el-input>
        </el-form-item>
        <el-form-item label="人口所在地" :label-width="'120px'">
          <el-input v-model="populationEditTemp.populationAddress"></el-input>
        </el-form-item>
        <el-form-item label="人口类型" :label-width="'120px'">
          <el-select v-model="populationEditTemp.populationType">
            <el-option :label="item.label" :value="item.value" v-for="item in populationOptions " :key="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否常住" :label-width="'120px'">
          <el-select v-model="populationEditTemp.populationLocalType">
            <el-option :label="item.label" :value="item.value" v-for="item in localOptions " :key="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属村落" :label-width="'120px'">
          <el-select
              v-model="populationEditTemp.populationVillageId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入村落名称"
              :remote-method="selectVillage">
            <!--              :loading="loading"-->
            <el-option
                v-for="item in villageList"
                :key="item.villageId"
                :label="item.villageName"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属村委" :label-width="'120px'">
          <el-select
              v-model="populationEditTemp.populationVillageId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入村委名称"
              :remote-method="selectVillage">
            <!--              :loading="loading"-->
            <el-option
                v-for="item in villageList"
                :key="item.villageId"
                :label="item.villageLeading"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="村委联系方式" :label-width="'120px'">
          <el-select
              v-model="populationEditTemp.populationVillageId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入村委名称"
              :remote-method="selectVillage">
            <!--              :loading="loading"-->
            <el-option
                v-for="item in villageList"
                :key="item.villageId"
                :label="item.villagePhone"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditPopulation">取 消</el-button>
        <el-button type="primary" @click="ensurePopulation">确 定</el-button>
      </div>
    </el-dialog>

    <!--添加      弹框  -->
    <el-dialog title="人口信息" :visible.sync="populationNewDialogShow">
      <el-form :model="populationNew">
        <el-form-item label="人口编号" :label-width="'120px'">
          <el-input v-model="populationNew.populationId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="人口姓名" :label-width="'120px'">
          <el-input v-model="populationNew.populationName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="人口年龄" :label-width="'120px'">
          <el-input v-model="populationNew.populationAge"></el-input>
        </el-form-item>
        <el-form-item label="人口所在地" :label-width="'120px'">
          <el-input v-model="populationNew.populationAddress"></el-input>
        </el-form-item>
        <el-form-item label="人口类型" :label-width="'120px'">
          <el-select v-model="populationNew.populationType">
            <el-option :label="item.label" :value="item.value" v-for="item in populationOptions " :key="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否常住" :label-width="'120px'">
          <el-select v-model="populationNew.populationLocalType">
            <el-option :label="item.label" :value="item.value" v-for="item in localOptions " :key="item.value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所属村落" :label-width="'120px'">
          <el-select
              v-model="populationNew.populationVillageId"
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
        <el-form-item label="所属村委" :label-width="'120px'">
          <el-select
              v-model="populationNew.populationVillageId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入村委名称"
              :remote-method="selectVillage">
            <!--              :loading="loading"-->
            <el-option
                v-for="item in villageList"
                :key="item.villageId"
                :label="item.villageLeading"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="村委联系方式" :label-width="'120px'">
          <el-select
              v-model="populationNew.populationVillageId"
              filterable
              remote
              clearable
              reserve-keyword
              placeholder="请输入村委联系方式"
              :remote-method="selectVillage">
            <!--              :loading="loading"-->
            <el-option
                v-for="item in villageList"
                :key="item.villageId"
                :label="item.villagePhone"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditPopulation">取 消</el-button>
        <el-button type="primary" @click="ensureAddPopulation">确 定</el-button>
      </div>
    </el-dialog>



  </div>
</template>

<script>
import {getAllPopulation, getMyPopulationList, PopulationManager} from "@/api/population";
import {getAllVillage} from "@/api/village";
import {selectActivityPage} from "@/api/activity";
import htmlToExcel from "@/utils/htmlToExcel";
import ls from "@/assets/js/ls";

export default {
  name: "index",
  data(){
    return {
      villageList: [],
      populationList: [],
      pageInfo: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      populationInfo: {
        populationId: '',
        populationName: '',
        populationAge: '',
        populationAddress: '',
        populationType: '',
        populationLocalType: '',
        populationVillageId: ''
      },
      populationEditTemp: {
        populationId: '',
        populationName: '',
        populationAge: '',
        populationAddress: '',
        populationType: '',
        populationLocalType: '',
        populationVillageId: ''
      },
      populationNew: {
        populationId: '',
        populationName: '',
        populationAge: '',
        populationAddress: '',
        populationType: '',
        populationLocalType: '',
        populationVillageId: ''
      },
      populationDialogShow: false,
      populationNewDialogShow: false,
      populationOptions: [
        {
          label: '本地',
          value: 0
        },
        {
          label: '外地',
          value: 1
        }
      ],
      localOptions: [
        {
          label: '常住',
          value: 0
        },
        {
          label: '外出',
          value: 1
        }
      ],

      selectData:[],
      selectWindow:false,

    }
  },
  created() {
    this.initPopulationList();
    //this.getMyPopulationList();
    this.getPopulationList();
  },
  methods: {
    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','常住人口信息')
    },
    exportExcelSelect(){
      this.getPopulationList();
      this.selectWindow = true;
    },
    //获取个人信息
    getPopulationList(){
      this.populationInfo.populationVillageId=ls.getItem('userVillageId');
      getMyPopulationList(this.populationInfo.populationVillageId).then(res => {
        if (res.data.code === "SUCCESS") {
          console.log(res)
          this.selectData=res.data.data
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
    initPopulationList() {
      this.populationInfo.populationVillageId=ls.getItem('userVillageId');

      let condition = Object.assign({}, this.populationInfo)
      let populationPageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      PopulationManager.getMyAllPopulation(populationPageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          console.log(res)
          this.populationList = res.data.data.list
          console.log(this.populationList)
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
      this.initPopulationList()
    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageInfo.pageSize = val
      this.initPopulationList()
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageInfo.pageNum = val
      this.initPopulationList()
    },
    //修改村委信息
    editPopulation(population) {
      this.populationEditTemp = Object.assign({}, population)
      this.populationDialogShow = true
    },
    //取消修改
    cancelEditPopulation() {
      this.populationEditTemp = {
        populationId: '',
        populationName: '',
        populationAge: '',
        populationAddress: '',
        populationType: '',
        populationLocalType: '',
        populationVillageId: ''
      }
      this.populationNew = {
        populationId: '',
        populationName: '',
        populationAge: '',
        populationAddress: '',
        populationType: '',
        populationLocalType: '',
        populationVillageId: ''
      }
      this.populationDialogShow = false
      this.populationNewDialogShow = false
    },
    //确定修改
    ensurePopulation() {
      PopulationManager.updatePopulation(this.populationEditTemp).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("修改成功")
          this.initPopulationList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
      })
      this.populationDialogShow = false
    },
    deletePopulation(population) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        PopulationManager.deletePopulation(population.populationId).then(res => {
          if (res.data.code === "SUCCESS"){
            this.$message.success("删除成功")
            this.cancelEditPopulation()
            this.initPopulationList()
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
    addPopulation() {
      this.populationNewDialogShow = true
    },
    ensureAddPopulation(){
      PopulationManager.addPopulation(this.populationNew).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("添加成功")
          this.initPopulationList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.populationNewDialogShow = false
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