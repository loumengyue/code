<template>
    <div>
      <br/>
      <el-row>
        <el-form ref="form" :model="houseInfo" label-width="100px">
          <el-col :span="6" :offset="1">
            <el-form-item label="宅基地地址">
              <el-input
                  clearable
                  placeholder="请输入地址"
                  size="large"
                  v-model="houseInfo.houseAddress">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" :offset="1">
            <el-form-item label="申请人">
              <el-select
                  v-model="houseInfo.housePopulationId"
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
            </el-form-item>
<!--            <el-form-item label="申请人">
              <el-input
                  placeholder="请输入申请人"
                  size="large"
                  v-model="houseInfo.housePopulationId">
              </el-input>
            </el-form-item>-->
          </el-col>
          <el-col :span="6" :offset="1">
            <el-form-item label="状态">
              <el-input
                  clearable
                  placeholder="1:申请中/2:已批准/3:已拒绝"
                  size="large"
                  v-model="houseInfo.houseStatus">
              </el-input>
            </el-form-item>
          </el-col>
<!--          <el-col :span="6" :offset="1">
            <el-form-item label="状态">
              <el-select
                  clearable
                  placeholder="状态"
                  size="large"
                  v-model="houseInfo.houseStatus">
                <el-option label="申请中" value="1" ></el-option>
                <el-option label="已批准" value="2" ></el-option>
                <el-option label="已拒绝" value="3" ></el-option>
              </el-select>
            </el-form-item>
          </el-col>-->
        </el-form>
      </el-row>
      <el-row :gutter="10">
        <el-col :span="2" :offset="17" class="btn-add">
          <el-button type="primary" icon="el-icon-search" size="small" @click="initHouseList">搜索</el-button>
        </el-col>
        <el-col :span="2" class="btn-add">
          <el-button type="primary" icon="el-icon-plus" size="small" @click="addHouse">新增</el-button>
        </el-col>
        <el-col :span="2" class="btn-add">
          <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
        </el-col>
      </el-row>

      <el-row>
        <el-col :span="22" :offset="1">
          <el-table
              :data="houseList"
              border
              style="width: 100%">
            <el-table-column
                prop="houseAddress"
                label="宅基地地址"
                width="240">
            </el-table-column>
           <el-table-column
                prop="housePopulationId"
                label="申请人ID"
                width="120">
            </el-table-column>
            <el-table-column
                prop="population.populationName"
                label="申请人"
                width="120">
            </el-table-column>
            <el-table-column
                prop="houseArea"
                label="宅基地面积(㎡)"
                width="120">
            </el-table-column>
            <el-table-column
                prop="houseApplyTime"
                label="宅基地申请时间"
                width="180">
            </el-table-column>
         <el-table-column
                prop="houseDesc"
                label="申请说明"
                width="200">
           <template slot-scope="{ row }">
             <el-tooltip class="item" effect="dark" placement="top">
               <div slot="content">
                 {{ row.houseDesc.substring(0, 40) }}<br/>
                 {{ row.houseDesc.substring(40, 80) }}<br/>
                 {{ row.houseDesc.substring(80, 120) }}<br/>
                 {{ row.houseDesc.substring(120, 160) }}<br/>
                 {{ row.houseDesc.substring(160, 200) }}<br/>
                 {{ row.houseDesc.substring(200, 240) }}<br/>
                 {{ row.houseDesc.substring(240, 280) }}<br/>

               </div>
               <span>{{ changeNewsContentSize(row.houseDesc) }}</span>
             </el-tooltip>
           </template>
            </el-table-column>
            <el-table-column
                prop="houseStatus"
                label="所处状态">
              <template slot-scope="{row}">
                <span v-if="row.houseStatus == 1">申请中</span>
                <span v-if="row.houseStatus == 2">已批准</span>
                <span v-if="row.houseStatus == 3">已拒绝</span>
              </template>
            </el-table-column>
            <el-table-column
                prop="village.villageName"
                label="所属村委"
                width="100">
            </el-table-column>
            <el-table-column
                label="操作"
                width="150">
              <template slot-scope="{row}">
                <el-button type="primary" size="mini" @click="editHouse(row)">编辑</el-button>
                <el-button type="danger" danger size="mini" @click="deleteHouse(row)">删除</el-button>
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
          <el-table-column prop="houseAddress" label="宅基地地址" width="250"></el-table-column>
          <el-table-column prop="housePopulationId" label="申请人ID" width="110"></el-table-column>
          <el-table-column prop="population.populationName" label="申请人" width="150"></el-table-column>
          <el-table-column prop="houseArea" label="宅基地面积(㎡)" width="100"></el-table-column>
          <el-table-column prop="houseApplyTime" label="宅基地申请时间" width="180"></el-table-column>
          <el-table-column
              prop="houseStatus"
              label="所处状态">
            <template slot-scope="{row}">
              <span v-if="row.houseStatus == 1">申请中</span>
              <span v-if="row.houseStatus == 2">已批准</span>
              <span v-if="row.houseStatus == 3">已拒绝</span>
            </template>
          </el-table-column>
          <el-table-column prop="village.villageName" label="所属村委" width="100"></el-table-column>
        </el-table>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="exportExcel">确定保存</el-button>
        </div>
      </el-dialog>

      <!--修改  弹框  -->
      <el-dialog title="宅基地信息" :visible.sync="houseDialogShow">
        <el-form :model="houseEditTemp">
          <el-form-item label="地址" :label-width="'120px'">
            <el-input disabled v-model="houseEditTemp.houseAddress" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="申请人" :label-width="'120px'">
            <el-select
                disabled
                v-model="houseEditTemp.housePopulationId"
                filterable
                remote
                clearable
                reserve-keyword
                placeholder="请输入申请对象"
                :remote-method="selectPopulation">
              <el-option
                  v-for="item in populationList"
                  :key="item.populationId"
                  :label="item.populationName+' 身份证号'+item.populationId"
                  :value="item.populationId">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="申请时间" :label-width="'120px'">
            <el-date-picker
                v-model="houseEditTemp.houseApplyTime"
                type="datetime"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="选择日期时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="所处状态" :label-width="'120px'">
            <el-select
                placeholder="状态"
                size="small"
                v-model="houseEditTemp.houseStatus">
              <el-option label="申请中" value="1" ></el-option>
              <el-option label="已批准" value="2" ></el-option>
              <el-option label="已拒绝" value="3" ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="面积" :label-width="'120px'">
            <el-input disabled v-model="houseEditTemp.houseArea" autocomplete="off"></el-input>
          </el-form-item>
         <el-form-item label="申请说明" :label-width="'120px'">
            <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" disabled v-model="houseEditTemp.houseDesc"></el-input>
          </el-form-item>
          <el-form-item label="所属村落" :label-width="'120px'">
            <el-select
                v-model="houseEditTemp.houseVillageId"
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
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelEditHouse">取 消</el-button>
          <el-button type="primary" @click="ensureHouse">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 添加 弹框  -->
      <el-dialog title="宅基地信息" :visible.sync="houseNewDialogShow">
        <el-form :model="houseNew">
<!--          <el-form-item label="申请人" :label-width="'120px'">
            <el-input v-model="houseNew.housePopulationId" autocomplete="off"></el-input>
          </el-form-item>-->
          <el-form-item label="地址" :label-width="'120px'">
            <el-input v-model="houseNew.houseAddress" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="面积" :label-width="'120px'">
            <el-input v-model="houseNew.houseArea" autocomplete="off" ></el-input>
          </el-form-item>
          <el-form-item label="申请人" :label-width="'120px'">
            <el-select
                v-model="houseNew.housePopulationId"
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
          <el-form-item label="申请说明" :label-width="'120px'">
            <el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" v-model="houseNew.houseDesc"></el-input>
          </el-form-item>
          <el-form-item label="申请时间" :label-width="'120px'">
            <el-date-picker
                v-model="houseNew.houseApplyTime"
                type="datetime"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="选择日期时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="所处状态" :label-width="'120px'">
            <el-select v-model="houseNew.houseStatus">
              <el-option label="申请中" value="1" ></el-option>
              <el-option label="已批准" value="2" ></el-option>
              <el-option label="已拒绝" value="3" ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="所属村落" :label-width="'120px'">
            <el-select
                v-model="houseNew.houseVillageId"
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
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelEditHouse">取 消</el-button>
          <el-button type="primary" @click="ensureAddHouse">确 定</el-button>
        </div>
      </el-dialog>

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
              houseEditTemp: {
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
        /*  async getHouseList(){
            const { data: res } = await this.$http.post("getHouseList");
            console.log(res);
            this.selectData=res.data.houseList;// 将返回数据赋值
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
          //修改村委信息
          editHouse(house) {
            this.houseEditTemp = Object.assign({}, house)
            this.houseDialogShow = true
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
          //确定修改
          ensureHouse() {
            HouseManager.updateHouse(this.houseEditTemp).then(res => {
              if (res.data.code === "SUCCESS"){
                this.$message.success("修改成功")
                this.initHouseList()
              }else {
                this.$message.error(res.data.msg)
              }
            }).catch(error => {
              console.log(error)
            })
            this.houseDialogShow = false
          },
          deleteHouse(house) {
            this.$confirm('此操作将永久删除, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              HouseManager.deleteHouse(house.houseId).then(res => {
                if (res.data.code === "SUCCESS"){
                  this.$message.success("删除成功")
                  this.cancelEditHouse()
                  this.initHouseList()
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
          changeNewsContentSize(content){
            if (content.length >= 18){
              console.log()
              return content.substring(0,18)+"……";
            }else {
              return content
            }
          },
        }
    }
</script>

<style scoped>
.btn-add {
  margin-bottom: 10px;
  text-align: center;
}
</style>
