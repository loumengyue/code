<template>
  <!--页面整体基础布局-->
  <el-container class="home-container">
    <!--头部布局-->
    <el-header>
      <div>
       <img src="../assets/images/img1.jpg" alt class="logo_img" />
        <span class="title">乡镇服务信息化平台</span>
      </div>
      <el-dropdown class="menuList">
        <span class="el-dropdown-link">
          <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
        </span>
        <el-dropdown-menu slot="dropdown" >
          <el-dropdown-item >
            <el-avatar
                src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png">
            </el-avatar>
            {{nickName}}
          </el-dropdown-item>
          <el-dropdown-item icon="el-icon-user" @click.native="toInfor">用户信息</el-dropdown-item>
          <el-dropdown-item icon="el-icon-edit"@click.native="toChangePass">修改密码</el-dropdown-item>
          <el-dropdown-item >
            <el-button type="text" @click="logout"><i class="iconfont icondingbudaohang-zhangh"></i>安全退出</el-button></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <h5>{{nickName}}</h5>

    </el-header>
    <el-container>
      <!--侧边布局-->
      <el-aside :width="isCollapse ?'64px':'200px'">
        <!--伸缩栏-->
        <div class="toggle-button" @click="toggleCollapase">|||</div>
        <el-menu
            router
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            unique-opened :collapse="isCollapse"
            :collapse-transition="false">
          <el-menu-item index="welcome">
            <i class="el-icon-menu"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-user-solid"></i>
              <span>个人中心</span>
            </template>
            <el-menu-item index="information">个人资料</el-menu-item>
<!--            <el-menu-item index="testFore">人事变更</el-menu-item>-->
            <el-menu-item index="changePassword">修改密码</el-menu-item>
          </el-submenu>
          <el-menu-item index="activity">
            <i class="el-icon-s-flag"></i>
            <span slot="title">活动查看</span>
          </el-menu-item>
          <el-menu-item index="news">
            <i class="el-icon-s-comment"></i>
            <span slot="title">通知通告</span>
          </el-menu-item>
          <el-menu-item index="agency">
            <i class="el-icon-s-home"></i>
            <span slot="title">机构信息</span>
          </el-menu-item>
          <el-menu-item index="population">
            <i class="el-icon-location"></i>
            <span slot="title">常住人口管理</span>
          </el-menu-item>
          <el-menu-item index="helper">
            <i class="el-icon-s-help"></i>
            <span slot="title">特殊人员管理</span>
          </el-menu-item>
          <el-submenu index="8">
            <template slot="title">
              <i class="el-icon-s-home"></i>
              <span>宅基地管理</span>
            </template>
            <el-menu-item index="houseApply">宅基地申请</el-menu-item>
            <el-menu-item index="houseManager">宅基地管理</el-menu-item>
          </el-submenu>
          <el-submenu index="9">
            <template slot="title">
              <i class="el-icon-user-solid"></i>
              <span>村委人事</span>
            </template>
            <el-menu-item index="village">村委信息</el-menu-item>
            <el-menu-item index="villageManager">村委信息管理</el-menu-item>
            <el-menu-item index="resignation">人事变更</el-menu-item>
          </el-submenu>
        </el-menu>

      </el-aside>
      <!--主体布局-->
      <el-main>
        <!--路由占位符-->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>
<script>
import ls from '../assets/js/ls.js'
export default {
  data() {
    return {
      nickName:"大张伟",
      isCollapse:false,
      // 左侧菜单列表
      /*menuList: [],*/
    }
  },
  /*类似onload  初始化加载*/
  created() {
    this.getNickName();
   /* this.getMenuList();*/
  },
  methods: {
    /*安全退出*/
    logout() {
      ls.clear();
     /* window.sessionStorage.clear();                                                   //清除session*/
      this.$router.push("/beforeLogin");                                                     //回到首页
    },
    // 切换菜单折叠与展开
    toggleCollapase(){
      this.isCollapse = !this.isCollapse;
    },
    toInfor(){
      this.$router.push({ path: "/information"});                                             //页面跳转
    },
    toChangePass(){
      this.$router.push({ path: "/changePassword"});                                             //页面跳转
    },


    getNickName()
    {
      console.log( this.nickName)
      console.log(ls.getItem('nickName'));
      this.nickName=ls.getItem('nickName')
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },

  }
};
</script>
<style lang="less" scoped>
.button{
  width: 200px;
  height: 40px;
  background-color: rgba(255,255,255,0.3);//前三个参数是颜色，后一个是透明度，效果为白色背景透明。
  color: #4A5064;
  border-radius: 15px;    /*输入框圆角值*/

}

.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}

//布局器样式
.home-container {
  height: 100%;
}
.menuList{
  margin-right: -350px;
}
//头样式
.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;// 左右贴边
  padding-left: 0%;// 左边界
  align-items: center;// 水平
  color: #fff;
  font-size: 20px;//字体大小
  > div { //左侧div加布局
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}
//侧边栏样式
.el-aside {
  background-color: #333744;
  .el-menu{
    border-right: none;// 对其右边框
  }
}
//主体main样式
.el-main {
  /*background-color: #eaedf1;*/

  background-color: #eeeeee;
}
.logo_img {
  width: 19.5%;//16.7%;
  height: 100%;
}
.iconfont{
  margin-right: 10px;
}
//|||伸缩按钮样式
.toggle-button{
  background-color:#4A5064;
  font-size: 10px;
  line-height: 24px;
  color:#fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;// 显示鼠标指针为：小手
}
//title样式
.title {
  font-size: 25px;//设置字号大小
  color: #eee;
  left: 200px;
  text-align: center;//文本水平对齐方式：
  font-weight: bold;
  position: absolute;
  letter-spacing:5px;//字符间距：normal[默认]length[长度单位]
  font-family: "Arial Black"//设置字体*/

}
</style>
