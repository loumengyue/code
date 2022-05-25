import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Index from "@/views/Index";
import Welcome from "@/views/Welcome";
import News from "@/views/News";
import Activity from "@/views/Activity";
import Helper from "@/views/Helper";
import Population from "@/views/Population";
import HouseApply from "@/views/HouseApply";
import HouseManage from "@/views/HouseManage";
import Agency from "@/views/Agency";
import BeforeLogin from "@/views/BeforeLogin";
import ChangePassword from "@/views/ChangePassword";
import Village from "@/views/Village";
import VillageManager from "@/views/VillageManager";
import Resignation from "@/views/Resignation";
import Information from "@/views/Information";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/beforeLogin',   /*访问根路径，默认直接跳转到login*/
  },
  {
    path: '/beforeLogin',
   component:BeforeLogin,
  },
  {
    path: '/index',
    component:Index,
    redirect: '/welcome',/*重定向 进入首页，默认显示welcome页面*/
    children:[
      {
        path:'/welcome',
        name: '首页',
        component: Welcome,
        meta: {
          title: '首页',
        }
      },
      {
        path: '/news',
        name: '通知通告',
        component:News,
        meta: {
          title: '通知通告',
        }
      },
      {
        path: '/activity',
        name: '活动查看',
        component:Activity,
        meta: {
          title: '活动查看',
        }
      },
      {
        path: '/helper',
        name: '特殊人员管理',
        component:Helper,
        meta: {
          title: '特殊人员管理',
        }
      },
      {
        path: '/population',
        name: '常住人口管理',
        component:Population,
        meta: {
          title: '常住人口管理',
        }
      },
      {
        path: '/houseApply',
        name: '宅基地申请',
        component:HouseApply,
        meta: {
          title: '宅基地申请',
        }
      },
      {
        path: '/houseManager',
        name: '宅基地管理',
        component:HouseManage,
        meta: {
          title: '宅基地管理',
        }
      },
      {
        path: '/village',
        name: '村委人事',
        component:Village,
        meta: {
          title: '村委人事',
        }
      },
      {
        path: '/villageManager',
        name: '村委人事管理',
        component:VillageManager,
        meta: {
          title: '村委人事管理',
        }
      },
      {
        path: '/resignation',
        name: '人事变更',
        component:Resignation,
        meta: {
          title: '人事变更',
        }
      },
      {
        path: '/information',
        name: '个人信息',
        component:Information,
        meta: {
          title: '个人信息',
        }
      },
      {
        path: '/agency',
        name: '机构信息',
        component:Agency,
        meta: {
          title: '机构信息',
        }
      },
      {
        path: '/changePassword',
        component:ChangePassword,
      },


    ]
  },


  {
    path: '/login',
    component:Login,
  },

]

const router = new VueRouter({
  routes
})

//挂载路由导航守卫
/*router.beforeEach((to ,from,next)=>{
  //to将要访问
  //from从哪里访问
  //next接着访问next（url）重定向到url上，next()继续访问to路径
  if (to.path == '/login') return next();// 访问路径为登录
  //获取user
  const userFlag=window.sessionStorage.getItem("userName");//获取当前用户
  const userFlag1=window.sessionStorage.getItem("role");//获取当前用户-新改lmy
  if(!userFlag) return next('/login');//无值，返回登录页
  if(!userFlag1) return next('/login');//无值，返回登录页   //获取当前用户-新改lmy
  next();//符合要求，放行！

})*/

export default router
