<template>
  <div>
    <el-card>
      <el-row :gutter="25">  <!--间隙 -->
        <span class="fontTitle">宅基地申请</span>
      </el-row>
    </el-card>
    <el-row>
      <el-col :span="24" >
        <el-card>
          <el-row :gutter="25">  <!--间隙 -->
            <el-form :model="houseNew" :rules="loginRules">
               <el-form-item label="宅基地地址:" :label-width="'200px'" ref="FormRef" class="font">
                <el-col :span="24">
                  <el-select
                      class="adressType"
                      v-model="houseNew.houseAddress"
                      clearable
                      placeholder="宅基地地址">
                    <el-option label="湖南省娄底市新化县维山乡维山村" value="湖南省娄底市新化县维山乡维山村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡双井村" value="湖南省娄底市新化县维山乡双井村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡林屋村" value="湖南省娄底市新化县维山乡林屋村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡芦家桥村" value="湖南省娄底市新化县维山乡芦家桥村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡水口村" value="湖南省娄底市新化县维山乡水口村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡石屋村" value="湖南省娄底市新化县维山乡石屋村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡碧水村" value="湖南省娄底市新化县维山乡碧水村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡三联洞村" value="湖南省娄底市新化县维山乡三联洞村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡茶园村" value="湖南省娄底市新化县维山乡茶园村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡青树村" value="湖南省娄底市新化县维山乡青树村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡四都村" value="湖南省娄底市新化县维山乡四都村" ></el-option>
                    <el-option label="湖南省娄底市新化县维山乡黄古村" value="湖南省娄底市新化县维山乡黄古村" ></el-option>
                  </el-select>
                </el-col>
              </el-form-item>
              <el-form-item label="面积(㎡):" :label-width="'200px'" class="font">
                <el-col :span="8">
                  <el-input v-model="houseNew.houseArea" autocomplete="off" ></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label="申请人:" :label-width="'200px'"class="font">
                <el-col :span="8">
                  <el-select
                      v-model="houseNew.housePopulationId"
                      filterable
                      remote
                      clearable
                      reserve-keyword
                      placeholder="请输入申请人"
                      :remote-method="selectPopulation">
                    <el-option
                        v-for="item in populationList"
                        :key="item.populationId"
                        :label="item.populationName+' 身份证号'+item.populationId"
                        :value="item.populationId">
                    </el-option>
                  </el-select>
                </el-col>
              </el-form-item>
              <el-form-item label="申请时间:" :label-width="'200px'"class="font">
                <el-col :span="8">
                  <el-date-picker
                      v-model="houseNew.houseApplyTime"
                      type="datetime"
                      value-format="yyyy-MM-dd HH:mm:ss"
                      placeholder="选择日期时间">
                  </el-date-picker>
                </el-col>
              </el-form-item>
              <el-form-item label="所处状态:" :label-width="'200px'"class="font">
                <el-col :span="8">
                  <el-select v-model="houseNew.houseStatus">
                    <el-option label="申请中" value="1" ></el-option>
                  </el-select>
                </el-col>
              </el-form-item>
              <el-form-item label="所属村落:" :label-width="'200px'"class="font">
                <el-col :span="8">
                  <el-select
                      v-model="houseNew.houseVillageId"
                      filterable
                      remote
                      clearable
                      reserve-keyword
                      placeholder="请输入村落名称"
                      :remote-method="selectVillage">
                    <el-option
                        v-for="item in villageList"
                        :key="item.villageId"
                        :label="item.villageName"
                        :value="item.villageId">
                    </el-option>
                  </el-select>
                </el-col>
              </el-form-item>
              <el-form-item label="申请说明:" :label-width="'200px'"class="font">
                <el-col :span="16">
                  <el-input
                      style="width: 100%"
                      type="textarea"
                      v-model="houseNew.houseDesc"
                      placeholder="请简要介绍家庭情况，输入申请说明"
                      maxlength="250"
                      :rows="7"
                      show-word-limit>

                  </el-input>
                </el-col>
              </el-form-item>
              <el-form-item :label-width="'200px'"class="font">
                <el-col :span="16">
                  <el-button  @click="cancelEditHouse">取 消</el-button>
                  <el-button type="primary" @click="ensureAddHouse">确 定</el-button>
                </el-col>

              </el-form-item>
            </el-form>
          </el-row>
        </el-card>
      </el-col>
    </el-row>


  </div>
</template>

<script>
import {HouseManager} from "@/api/house";
import {getAllPopulation} from "@/api/population";
import htmlToExcel from "@/utils/htmlToExcel";
import ls from "@/assets/js/ls";
import {HelperManager} from "@/api/helper";
import {getAllVillage} from "@/api/village";

export default {
  name: "HouseManage",
  data() {
    return {
      populationList: [],
      villageList:[],
      houseList: [],
      pageInfo: {
        total: 0,
        pageNum: 1,
        pageSize: 10
      },
      houseInfo: {
        houseId: '',
        houseAddress: '',
        housePopulationId: '',
        houseApplyTime:'',
        houseArea: '',
        houseDesc: '',
        houseStatus: '',
        houseVillageId:'',
      },
      houseNew: {
        houseId: '',
        houseAddress: '',
        housePopulationId: '',
        houseApplyTime:'',
        houseArea: '',
        houseDesc: '',
        houseStatus: '',
        houseVillageId:'',
      },
      loginRules: {//验证规则
        houseAddress: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        housePopulationId: [
          { required: true, message: "请输入密码", trigger: "blur" },
        ],
        houseApplyTime: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        houseArea: [
          { required: true, message: "请输入密码", trigger: "blur" },
        ],
        houseDesc: [
          { required: true, message: '请填写活动形式', trigger: 'blur' }
        ],
        houseStatus: [
          { required: true, message: "请输入密码", trigger: "blur" },
        ],
        houseVillageId: [
          { required: true, message: "请输入密码", trigger: "blur" },
        ]
      },
      houseDialogShow: false,
      houseNewDialogShow: false,

      selectData:[],
      selectWindow:false,
    }
  },
  created() {
    this.initHouseList();
    this.getHouseList()
  },
  methods: {

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','宅基地信息')
    },
    exportExcelSelect(){
      this.getHouseList();
      this.selectWindow = true;
    },
    //获取个人信息
    getHouseList(){
      this.houseInfo.houseVillageId=ls.getItem('userVillageId');
      HouseManager.getMyHouseList(this.houseInfo.houseVillageId).then(res => {
        if (res.data.code === "SUCCESS") {
          console.log(res)
          this.selectData=res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },

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
    initHouseList() {
      this.houseInfo.houseVillageId=ls.getItem('userVillageId');

      let condition = Object.assign({}, this.houseInfo)
      let housePageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      HouseManager.getMyAllHouseList(housePageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          this.houseList = res.data.data.list
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
      this.initHouseList()
    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageInfo.pageSize = val
      this.initHouseList()
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageInfo.pageNum = val
      this.initHouseList()
    },
    addHouse() {
      this.houseNewDialogShow = true
    },
    ensureAddHouse(){
      HouseManager.addHouse(this.houseNew).then(res => {
        if (res.data.code === "SUCCESS"){
          this.$message.success("添加成功")
          this.initHouseList()
        }else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.houseNewDialogShow = false
    },
    //取消修改
    cancelEditHouse() {
      this.houseEditTemp = {
        houseId: '',
        houseAddress: '',
        housePopulationId: '',
        houseArea: '',
        houseDesc: '',
        houseStatus: ''
      }
      this.houseNew = {
        houseId: '',
        houseAddress: '',
        housePopulationId: '',
        houseArea: '',
        houseDesc: '',
        houseStatus: ''
      }
      this.houseDialogShow = false
      this.houseNewDialogShow = false
    },
  }
}
</script>

<style scoped>
.font{
  font-size: 15px;/*//设置字号大小*/
  color: #4A5064;
  font-family: "Arial Black";/*//设置字体*!*/
  letter-spacing:1px;/*//字符间距：normal[默认]length[长度单位]*/
  font-weight: bold;

}
.fontTitle{
  font-size: 15px;/*//设置字号大小*/
  color: #4A5064;
  font-family: "Arial Black";/*//设置字体*!*/
  letter-spacing:2px;/*//字符间距：normal[默认]length[长度单位]*/
  font-weight: bold;

}

.adressType{
  width: 400px;
}
.btn-add {
  margin-bottom: 10px;
  text-align: center;
}
</style>
