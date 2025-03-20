import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import zhuanzhenxinxi from '@/views/modules/zhuanzhenxinxi/list'
    import shenghuoyongpinxinxi from '@/views/modules/shenghuoyongpinxinxi/list'
    import shiwuxinxi from '@/views/modules/shiwuxinxi/list'
    import gongzuorenyuan from '@/views/modules/gongzuorenyuan/list'
    import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
    import yaopinxinxi from '@/views/modules/yaopinxinxi/list'
    import shenghuofuwu from '@/views/modules/shenghuofuwu/list'
    import weixiufuwu from '@/views/modules/weixiufuwu/list'
    import fuwujilu from '@/views/modules/fuwujilu/list'
    import dingdanshenqing from '@/views/modules/dingdanshenqing/list'
    import chat from '@/views/modules/chat/list'
    import laorenzhanghao from '@/views/modules/laorenzhanghao/list'
    import laorendangan from '@/views/modules/laorendangan/list'
    import jianchajianyanxiangmu from '@/views/modules/jianchajianyanxiangmu/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '通告资讯',
        component: news
      }
      ,{
	path: '/zhuanzhenxinxi',
        name: '转诊信息',
        component: zhuanzhenxinxi
      }
      ,{
	path: '/shenghuoyongpinxinxi',
        name: '生活用品信息',
        component: shenghuoyongpinxinxi
      }
      ,{
	path: '/shiwuxinxi',
        name: '食物信息',
        component: shiwuxinxi
      }
      ,{
	path: '/gongzuorenyuan',
        name: '工作人员',
        component: gongzuorenyuan
      }
      ,{
	path: '/dingdanxinxi',
        name: '订单信息',
        component: dingdanxinxi
      }
      ,{
	path: '/yaopinxinxi',
        name: '药品信息',
        component: yaopinxinxi
      }
      ,{
	path: '/shenghuofuwu',
        name: '生活服务',
        component: shenghuofuwu
      }
      ,{
	path: '/weixiufuwu',
        name: '维修服务',
        component: weixiufuwu
      }
      ,{
	path: '/fuwujilu',
        name: '服务记录',
        component: fuwujilu
      }
      ,{
	path: '/dingdanshenqing',
        name: '订单申请',
        component: dingdanshenqing
      }
      ,{
	path: '/chat',
        name: '客服咨询',
        component: chat
      }
      ,{
	path: '/laorenzhanghao',
        name: '老人账号',
        component: laorenzhanghao
      }
      ,{
	path: '/laorendangan',
        name: '老人档案',
        component: laorendangan
      }
      ,{
	path: '/jianchajianyanxiangmu',
        name: '检查检验项目',
        component: jianchajianyanxiangmu
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
