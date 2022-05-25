<template>
  <div class="login_container">

    <div class="login_box">
      <div class="title-container">
        <h3 class="title">乡  镇  信  息  化  网  上  办  事  服  务  大  厅</h3>
        <h5 class="subtitle">Township   information   online   service   hall</h5>
      </div>
      <el-row>
        <el-button class="button" @click="toLogin">登录 Login</el-button>
      </el-row>

    </div>

  </div>
</template>

<script>
export default {
  methods: {
    toLogin(){
      this.$router.push({ path: "/login"});                                             //页面跳转
    }
  }



}
</script>

<style lang="less" scoped>

/*跟节点样式*/
.login_container {
  /*background-color: #2b4b6b;*/
  height: 100%;
  background-image: url(../assets/images/img1.jpg);
}

.title {
  font-size: 40px;//设置字号大小
  color: #eeeeee;
  text-align: center;//文本水平对齐方式：
  font-weight: bold;
  margin-top:0px;//离上边距离*!
  position: absolute;
  left:440px;
  top:200px;
  letter-spacing:2px;//字符间距：normal[默认]length[长度单位]
}

.subtitle{
  font-size: 15px;//设置字号大小
  color: #eee;
  text-align: center;//文本水平对齐方式：
  font-weight: bold;
  margin-top:0px;//离上边距离*!
  position: absolute;//绝对定位
  left:565px;//右
  top:265px;//上
  font-style:italic;//设置字体样式：normal[正常]italic[斜体]
  letter-spacing:2px;//字符间距：normal[默认]length[长度单位]
  word-spacing:8px;// 单词间距：normal[默认]length[长度单位]
  font-family: "Cambria Math";//设置字体*/
}
.button{
  position: absolute;//绝对定位
  left:650px;
  top:330px;
  width: 200px;
  height: 45px;
  background-color: rgba(255,255,255,0.3);//前三个参数是颜色，后一个是透明度，效果为白色背景透明。
  color: white;
  /*background: cornflowerblue;*/
  /*height: 40px;*/

}

</style>