import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/axios'
import './plugins/element.js'
import './assets/css/global.css'//添加全局样式
import './assets/font/iconfont.css'//导入iconfront


import axios from 'axios'// 导入axios

Vue.prototype.$http = axios//挂载axios 到Vue的原型prototype的$http

axios.defaults.baseURL = "http://localhost:8080"// 设置请求的根路径

Vue.config.productionTip = false

//vue修改浏览器的标题title
const defaultTitle = '乡镇信息服务平台'
router.beforeEach((to, from, next) => {
  document.title = to.meta.title ? to.meta.title : defaultTitle

  next()

})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
