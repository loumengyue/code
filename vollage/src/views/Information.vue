<template>
  <div>

    <el-card>
      <el-row :gutter="25">
        <span class="fontTitle">个人信息</span>
      </el-row>
    </el-card>
    <el-row>
        <el-card>
          <el-row :gutter="25">
            <el-form :model="userInfo" >
              <el-row>
                <el-col :span="8">
                  <el-form-item label="账号:" :label-width="'120px'"class="font">
                    <span>{{userInfo.userName}}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                </el-col>
                <el-col :span="4">
                  <el-form-item label="姓名:" :label-width="'120px'"class="font">
                    <span>{{userInfo.nickName}}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="性别:" :label-width="'120px'"class="font">
                    <span>{{userInfo.gender}}</span>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="手机号:" :label-width="'120px'"class="font">
                    <span>{{userInfo.userPhone}}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="职务:" :label-width="'120px'"class="font">
                    <span>{{userInfo.userPost}}</span>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row>
                <el-col :span="8">
                  <el-form-item label="角色:" :label-width="'120px'"class="font">
                    <span>{{userInfo.role.roleName}}</span>
                  </el-form-item>
                </el-col>

                <el-col :span="8">
                  <el-form-item label="任职状态:" :label-width="'120px'" class="font">
                    <span>{{userInfo.userStatus}}</span>
                  </el-form-item>
                </el-col>

              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-form-item label="家庭住址:" :label-width="'120px'"class="font">
                    <span>{{userInfo.village.villageAddress}}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="7">
                  <el-form-item label="管辖村庄:" :label-width="'120px'"class="font">
                    <span>{{userInfo.village.villageName}}</span>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label-width="'120px'"class="font">
                    <el-button type="primary" size="small" @click="editUser()">编辑</el-button>
                  </el-form-item>
                </el-col>

              </el-row>
              <el-row>
              </el-row>

            </el-form>

          </el-row>
        </el-card>
    </el-row>
<!--   <el-row :gutter="25">
      <el-row>
        <el-col :span="22" :offset="1">
         <span>{{ villageList }}</span>
          <span>{{ users }}</span>
         <span>{{ userInfo }}</span>
        </el-col>
      </el-row>
    </el-row>-->
    <br/>
    <br/>
    <!-- 修改 弹框  -->
    <el-dialog title="村委人事" :visible.sync="userDialogShow">
        <el-form :model="userInfo" >
          <el-row>
            <el-col :span="8">
              <el-form-item label="账号" :label-width="'120px'"class="font">
                <el-input disabled v-model="userInfo.userName" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="姓名" :label-width="'120px'"class="font">
                <el-input disabled v-model="userInfo.nickName" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="性别" :label-width="'120px'"class="font">
                <el-select v-model="userInfo.gender" autocomplete="off">
                  <el-option label="男" value="男"></el-option>
                  <el-option label="女" value="女"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="手机号" :label-width="'120px'"class="font">
                <el-input  v-model="userInfo.userPhone" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
          </el-row>


          <el-row>

            <el-col :span="16">
              <el-form-item label="职务" :label-width="'120px'"class="font">
                <el-input disabled v-model="userInfo.userPost"></el-input>
              </el-form-item>
            </el-col>

          </el-row>
          <el-row>
            <el-col :span="16">
              <el-form-item label="村委名称" :label-width="'120px'"class="font">
                <el-select
                    disabled
                    v-model="userInfo.userVillageId"
                    filterable
                    remote
                    clearable
                    reserve-keyword
                    placeholder="请输入村委名称"
                    :remote-method="selectVillage">
                  <el-option
                      v-for="item in villageList"
                      :key="item.villageId"
                      :label="item.villageName"
                      :value="item.villageId">

                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="角色" :label-width="'120px'"class="font">
                <el-select disabled v-model="userInfo.userRoleId">
                  <el-option v-for="(role,index) in roleList" :label="role.roleName" :value="role.roleId"
                             :key="index"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="状态"
                            :label-width="'120px'"
                            :rules="[ { required: true, trigger: 'blur' }]"
                            class="font">
                <el-select disabled v-model="userInfo.userStatus">
                  <el-option label="在职" value="alive"></el-option>
                  <el-option label="申请离职" value="apply"></el-option>
                </el-select>
              </el-form-item>
            </el-col>

          </el-row>


        </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancelEditUser">取 消</el-button>
        <el-button type="primary" @click="ensureUser">确 定</el-button>
      </div>
    </el-dialog>


</div>

</template>

<script>
import {UserManager, getRoleList, getUserByName} from "@/api/user"
import {getAllVillage} from "@/api/village";
import htmlToExcel from "@/utils/htmlToExcel";
import ls from "@/assets/js/ls";
import {getAllPopulation, getMyPopulationList} from "@/api/population";

export default {
  name: "index",
  data() {
    return {
      roleList: [],
      villageList: [],
      users: {},
      pageInfo: {
        total: 100,
        pageNum: 1,
        pageSize: 10
      },
      userInfo:[{
        userName: '',
        gender: '',
        userPhone: '',
        userRole: '',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: '',
        userPost: ''
      }],
      userEditTemp: {
        userName: '',
        gender: '',
        userPhone: '',
        userRole: '',
        nickName: '',
        userRoleId: '',
        userVillageId: '',
        userStatus: '',
        userPost: ''
      },
      userDialogShow: false,
      userNewDialogShow: false,





    }
  },

  created() {
    this.initRoleList()
    this.getUser()

  },
  methods: {
    //初始化
    getUser() {
      this.userInfo.userName=ls.getItem('userName')
      console.log( this.userInfo.userName)

      let condition = Object.assign({}, this.userInfo)
      UserManager.getUserByName(condition).then(res => {
        if (res.data.code === "SUCCESS") {
          console.log(res)
          this.userEditTemp=res.data.data
          this.users = res.data.data
          this.userInfo= res.data.data

        } else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
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
    //修改信息
    editUser() {
      this.userDialogShow = true
    },
    //取消修改
    cancelEditUser() {
      this.userDialogShow = false

    },
    //确定修改


    //确定修改
    ensureUser() {
      UserManager.updateUser(this.userInfo).then(res => {
        if (res.data.code === "SUCCESS") {
          this.$message.success("修改成功")
          this.userDialogShow = false
          this.getUser()
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
.form {
  white-space: nowrap;
}
.adressType{
  width: 400px;
}
.btn-add {
  margin-bottom: 10px;
  text-align: center;
}
.btn-add {
  margin-bottom: 10px;
  text-align: center;
}
</style>





