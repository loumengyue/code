<template>
  <div class="login_container">
    <!--登录块-->
    <div class="login_box">
      <!--头像-->
<!--      <div class="avatar_box">
        <img src="../assets/logo.png" alt />
      </div>-->

      <div class="title-container">
        <h3 class="title">乡镇信息服务平台</h3>
      </div>
      <!--添加表单-->
      <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules" class="login_form" label-width="0px">
        <!--  用户名 -->
        <el-form-item prop="userName">
          <el-input v-model="loginForm.userName" prefix-icon="iconfont icondenglu"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" prefix-icon="iconfont iconzu" type="password"></el-input>
        </el-form-item>
        <!--  按钮 -->
        <el-form-item class="btns">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import ls from '../assets/js/ls.js'
export default {
  data() {
    return {
      loginForm: {
        userName: "admin",
        password: "123456"
      },
      loginRules: {//验证规则
        userName: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 5, max: 8, message: "长度在 5 到 8 个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 8, message: "密码为 6~8 位", trigger: "blur" }
        ]
      }

    };
  },
  methods: {
    /*重置表单内容*/
    resetLoginForm() {
      this.$refs.loginFormRef.resetFields();
    },
    /*登录方法*/
    login() {
      /*验证校验规则*/
      this.$refs.loginFormRef.validate(async valid => {
        console.log(valid);                                                                //验证表单是否成功  成功：true 失败false
        if (!valid) return;                                                                //验证失败
        const {data :res} = await this.$http.post("/login",this.loginForm);            //访问后台,userName,password和后台一一对应
        console.log(res);                                                                  //通过接口获取打印后端相应数据
        if (res.data.flag== "LoginOK" ) {
          this.$message.success("登陆成功！！！");                                       //信息提示
          ls.setItem("userName",res.data.userName);
          ls.setItem("role",res.data.role);
          ls.setItem("nickName",res.data.nickName);
          ls.setItem("userVillageId",res.data.userVillageId)
         /* window.sessionStorage.setItem("userName",res.data.userName);                         // session 放置,存储user
          window.sessionStorage.setItem("role",res.data.role);                         // session 放置,存储user  lmy*!/
          window.sessionStorage.setItem("nickName",res.data.nickName);                         // session 放置,存储user  lmy*!/*/
          if(res.data.role==2){
            this.$router.push({ path: "/index"});                                             //页面跳转  lmy  this.$router.push('/home');
          }
          if(res.data.role==1){
            this.$router.push({ path: "/indexManager"});                                             //页面跳转
          }

        }else{
          this.$message.error("登录失败！！！");
        }
      });
    },
  }
};
</script>

<style lang="less" scoped>

// 跟节点样式
.login_container {
  background-color: #2b4b6b;
  height: 100%;
  background-image: url(../assets/images/img1.jpg);
}
// 登录框
.login_box {
  width: 450px;
  height: 300px;
  /*background-color: #fff;*/
  background-color: rgba(255,255,255,0.4);//前三个参数是颜色，后一个是透明度，效果为白色背景透明。
  border-radius: 3px;// 圆角
  position: absolute;// 绝对定位
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);// 根据自己位置 以自己为长度位移
  .btns {
    display: flex;// 弹性布局
    justify-content: flex-end; // 尾部对齐
  }
  .login_form {
    position: absolute;
    bottom: 0%;
    width: 100%;
    padding: 0 10px;
    box-sizing: border-box;// 设置边框
  }
  /*.el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }*/
  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: #eee;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }
  /*.show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: #889aa4;
    cursor: pointer;
    user-select: none;
  }*/
}
</style>