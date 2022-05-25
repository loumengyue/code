<template>
  <div>
    <br/>
    <el-row>
      <el-form ref="form" :model="userInfo" label-width="100px">
        <el-col :span="6" :offset="1">
          <el-form-item label="人员名称：">
            <el-input
                clearable
                placeholder="请输入人员名称"
                size="small"
                v-model="userInfo.nickName">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="手机号：">
            <el-input
                clearable
                placeholder="请输入手机号"
                size="small"
                v-model="userInfo.userPhone">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="1">
          <el-form-item label="岗位：">
            <el-input
                clearable
                placeholder="请输入岗位"
                size="small"
                v-model="userInfo.userPost">
            </el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="2" :offset="17" class="btn-add">
        <el-button type="primary" icon="el-icon-search" size="mini" @click="search">搜索</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" size="small"@click="exportExcelSelect">导出Excel</el-button>
      </el-col>
      <el-col :span="2" class="btn-add">
        <el-button type="primary" icon="el-icon-plus" size="small" @click="addUser">新增</el-button>
      </el-col>
<!--      <el-col :span="2" class="btn-add">-->
<!--        <el-button type="warning" size="mini">申请辞职</el-button>-->
<!--      </el-col>-->
    </el-row>
    <el-row>
      <el-col :span="22" :offset="1">
        <el-table
            :data="users"
            border
            style="width: 100%">
          <el-table-column
              prop="userName"
              label="人员账号"
              width="140">
          </el-table-column>
          <el-table-column
              prop="nickName"
              label="人员姓名"
              width="140">
          </el-table-column>
          <el-table-column
              prop="gender"
              label="性别"
              width="100">
          </el-table-column>
           <el-table-column
              prop="role.roleName"
              label="角色"
              width="140">
            <template slot-scope="{row}">
              {{ row.role.roleName }}
            </template>
          </el-table-column>
          <el-table-column
              label="所属村委"
              width="140">
            <template slot-scope="{row}">
              {{ row.village.villageName }}
            </template>
          </el-table-column>
          <el-table-column
              prop="userPost"
              label="岗位"
              width="140">
          </el-table-column>

          <el-table-column
              prop="userPhone"
              label="电话"
              width="140">
          </el-table-column>
          <el-table-column label="状态" prop="state">
            <!-- scope.row 就是当前行的信息 -->
            <template slot-scope="scope">
              <el-switch v-model="scope.row.state"></el-switch>
            </template>
          </el-table-column>
          <el-table-column
              label="操作"
              width="150">
            <template slot-scope="{row}">
              <el-button type="primary" size="mini" @click="editUser(row)">编辑</el-button>
              <el-button type="danger" danger size="mini" @click="deleteUser(row)">删除</el-button>
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
        <el-table-column prop="userName" label="人员账号" width="150"></el-table-column>
        <el-table-column prop="nickName" label="人员姓名" width="140"></el-table-column>
        <el-table-column prop="gender" label="性别" width="100"></el-table-column>
        <el-table-column prop="role.roleName" label="角色"></el-table-column>
        <el-table-column prop="village.villageName" label="所属村委"></el-table-column>
        <el-table-column prop="userPost" label="岗位" width="100"></el-table-column>
        <el-table-column prop="userPhone" label="电话"></el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="exportExcel">确定保存</el-button>
      </div>
    </el-dialog>


    <!-- 修改 弹框  -->
    <el-dialog title="村委人事" :visible.sync="userDialogShow">
      <el-form :model="userEditTemp">
        <el-form-item label="账号" :label-width="'120px'">
          <el-input v-model="userEditTemp.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="姓名" :label-width="'120px'">
          <el-input v-model="userEditTemp.nickName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="手机号" :label-width="'120px'">
          <el-input v-model="userEditTemp.userPhone" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="'120px'">
          <el-select v-model="userEditTemp.gender" autocomplete="off">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="村委名称" :label-width="'120px'">
          <el-select
              v-model="userEditTemp.userVillageId"
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
                :label="item.villageName"
                :value="item.villageId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="职务" :label-width="'120px'">
          <el-input v-model="userEditTemp.userPost"></el-input>
        </el-form-item>
        <el-form-item label="角色" :label-width="'120px'">
          <el-select v-model="userEditTemp.userRoleId">
            <el-option v-for="(role,index) in roleList" :label="role.roleName" :value="role.roleId"
                       :key="index"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" :label-width="'120px'">
          <el-input v-model="userEditTemp.userStatus"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditUser">取 消</el-button>
        <el-button type="primary" @click="ensureUser">确 定</el-button>
      </div>
    </el-dialog>


    <!--  添加弹框  -->
    <el-dialog title="村委人事" :visible.sync="userNewDialogShow">
      <el-row>
        <el-col :span="18">
          <el-form :model="userNewTemp">
            <el-form-item label="账号" :label-width="'120px'">
              <el-input v-model="userNewTemp.userName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" :label-width="'120px'">
              <el-input v-model="userNewTemp.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="姓名" :label-width="'120px'">
              <el-input v-model="userNewTemp.nickName" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="手机号" :label-width="'120px'">
              <el-input v-model="userNewTemp.userPhone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" :label-width="'120px'">
              <el-select v-model="userNewTemp.gender" autocomplete="off">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="村委名称" :label-width="'120px'">
              <el-select
                  v-model="userNewTemp.userVillageId"
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
            <el-form-item label="职务" :label-width="'120px'">
              <el-input v-model="userNewTemp.userPost"></el-input>
            </el-form-item>
            <el-form-item label="角色" :label-width="'120px'">
              <el-select v-model="userNewTemp.userRoleId">
                <el-option v-for="(role,index) in roleList" :label="role.roleName" :value="role.roleId"
                           :key="index"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="状态" :label-width="'120px'">
              <el-select v-model="userNewTemp.userStatus">
                <el-option label="离职" value="leave"></el-option>
                <el-option label="在职" value="alive"></el-option>
              </el-select>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelAddUser">取 消</el-button>
        <el-button type="primary" @click="ensureAddUser">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import {UserManager, getRoleList} from "@/api/user"
import {getAllVillage} from "@/api/village";
import htmlToExcel from "@/utils/htmlToExcel";

export default {
  name: "index",
  data() {
    return {
      roleList: [],
      villageList: [],
      users: [],
      pageInfo: {
        total: 100,
        pageNum: 1,
        pageSize: 10
      },
      userInfo: {
        userName: '',
        password:'',
        gender: '',
        userPhone: '',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: '',
        userPost: ''
      },
      userEditTemp: {
        userName: '',
        gender: '',
        userPhone: '',
        password:'',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: '',
        userPost: ''
      },
      userNewTemp: {
        userName: '',
        gender: '',
        userPhone: '',
        password:'',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: 'alive',
        userPost: ''
      },
      userDialogShow: false,
      userNewDialogShow: false,

      selectData:[],
      selectWindow:false,
    }
  },

  created() {
    this.initRoleList()
    this.initUserList()
    this.getUserList()

  },
  methods: {
    //打印
    exportExcel() {
      htmlToExcel.getExcel('#selectTable','村委人事信息')
    },
    exportExcelSelect(){
      this.getUserList();
      this.selectWindow = true;
    },
    async getUserList(){
      const { data: res } = await this.$http.post("getUserList");
      console.log(res);
      this.selectData=res.data;// 将返回数据赋值
    },

    //获取村委信息
    selectVillage(villageName) {
      console.log(villageName)
      getAllVillage({villageName}).then(res => {
        if (res.data.code === "SUCCESS") {
          this.villageList = res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },
    //获取角色信息
    initRoleList() {
      getRoleList().then(res => {
        if (res.data.code === "SUCCESS") {
          this.roleList = res.data.data
        } else {
          this.$message.error(res.data.msg)
        }
      })
    },
    initUserList() {
      let condition = Object.assign({}, this.userInfo)
      let userPageArgs = {
        condition,
        pageNum: this.pageInfo.pageNum,
        pageSize: this.pageInfo.pageSize
      }
      UserManager.getAllUserList(userPageArgs).then(res => {
        if (res.data.code === "SUCCESS") {
          this.users = res.data.data.list
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
    search() {
      this.pageInfo.pageNum = 1
      this.pageInfo.pageSize = 20
      this.initUserList()
    },
    //处理每页条数改变事件
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageInfo.pageSize = val
      this.initUserList()
    },
    //处理当前页改变事件
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageInfo.pageNum = val
      this.initUserList()
    },
    //修改信息
    editUser(user) {
      this.userEditTemp = Object.assign({}, user)
      this.userDialogShow = true
    },
    //取消修改
    cancelEditUser() {
      this.userEditTemp = {
        userName: '',
        gender: '',
        userPhone: '',
        userRole: '',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: '',
        userPost: ''
      }
      this.userNewTemp = {
        userName: '',
        gender: '',
        userPhone: '',
        userRole: '',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: '',
        userPost: ''
      }
      this.userDialogShow = false
      this.userNewDialogShow = false
    },
    //确定修改
    ensureUser() {
      UserManager.updateUser(this.userEditTemp).then(res => {
        if (res.data.code === "SUCCESS") {
          this.$message.success("修改成功")
          this.userDialogShow = false
          this.initUserList()
        } else {
          this.userDialogShow = false
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
        this.userDialogShow = false
      })
    },
    deleteUser(user) {
      this.$confirm('此操作将永久删除, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        UserManager.deleteUser(user.userId).then(res => {
          if (res.data.code === "SUCCESS") {
            this.$message.success("删除成功")
            this.cancelEditUser()
            this.initUserList()
          } else {
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
    addUser() {
      this.cancelEditUser()
      this.userNewDialogShow = true
    },
    cancelAddUser() {
      this.cancelEditUser()
      this.userNewDialogShow = false
    },
    ensureAddUser() {
      UserManager.addUser(this.userNewTemp).then(res => {
        if (res.data.code === "SUCCESS") {
          this.$message.success("添加成功")
          this.initUserList()
        } else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
      this.userNewDialogShow = false
    },
    reset() {
      this.villageInfo = {}
      this.pageInfo.pageNum = 1
      this.initUserList()
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
