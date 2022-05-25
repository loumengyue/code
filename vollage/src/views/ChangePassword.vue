<template>
  <div>
    <el-card>
      <el-row :gutter="25">  <!--间隙 -->
        <span class="fontTitle">修改密码</span>
      </el-row>
    </el-card>
    <el-row>
      <el-col :span="24" >
        <el-card>
          <el-alert
              title="警告提示"
              type="warning"
              description="修改完密码后需要重新登录"
              show-icon>
          </el-alert>
          <br>
          <el-row :gutter="25">  <!--间隙 -->
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px">
              <el-form-item label="当前密码:" prop="age":label-width="'200px'" class="font">
                <el-col :span="16">
                  <el-input v-model.number="ruleForm.userPassword"></el-input>
                </el-col>
              </el-form-item>
              <el-form-item label="密码:" prop="pass":label-width="'200px'" class="font">
                <el-col :span="16">
                  <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
                </el-col>

              </el-form-item>
              <el-form-item label="新密码确认:" prop="checkPass":label-width="'200px'" class="font">
                <el-col :span="16">
                  <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
                </el-col>

              </el-form-item>
              <br></br>

              <el-form-item :label-width="'200px'" class="font">
                <el-col :span="16">
                  <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                  <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-col>

              </el-form-item>
              <br></br>
            </el-form>
          </el-row>
        </el-card>
      </el-col>
    </el-row>

  </div>

</template>

<script>
import {UserManager} from "@/api/user";
import ls from "@/assets/js/ls";

export default {
  data() {
    var checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('当前密码不能为空'));
      }

    };

    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
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
      ruleForm: {
        pass: '',
        checkPass: '',
        userPassword: ''
      },
      rules: {


        pass: [
          { validator: validatePass, trigger: 'blur',required: true },
          { min: 6, max: 8, message: "密码为 6~8 位", trigger: "blur" }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur',required: true }
        ],
        userPassword: [
          { validator: checkAge, trigger: 'blur' ,required: true },
          { required: true, message: "请输入当前密码", trigger: "blur" },
        ]
      }
    };
  },
  created() {
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
          this.userInfo= res.data.data

        } else {
          this.$message.error(res.data.msg)
        }
      }).catch(error => {
        console.log(error)
        this.$message.error("服务器连接失败")
      })
    },
    /*登录方法*/
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

          console.log(this.ruleForm.userPassword)/*222222*/
          console.log(this.ruleForm.pass)/*111111*/
          console.log(this.ruleForm.checkPass)/*111111*/

          console.log(this.userInfo.password)/*222222*/
          if(this.ruleForm.userPassword==this.userInfo.password){
            this.userInfo.password=this.ruleForm.pass
            console.log(this.userInfo.password)/*222222*/
            UserManager.updateUser(this.userInfo).then(res => {
              if (res.data.code === "SUCCESS") {
                this.$message.success("修改密码成功")
                this.getUser()
              } else {
                this.$message.error(res.data.msg)
              }
            }).catch(error => {
              console.log(error)
              this.$message.error("服务器连接失败")
            })
            /*重新登录*/
              ls.clear();
              /* window.sessionStorage.clear();                                                   //清除session*/
              this.$router.push("/beforeLogin");                                                     //回到首页

          }else {this.$message.error("当前密码输入错误")}

        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },



};
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

</style>