import Vue from 'vue'
// import Vee-Validate from 'vee-validate'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import RegisterPage from '@/views/stockMember/RegisterPage.vue'
import LoginPage from '@/views/stockMember/LoginPage.vue'
import AwesomeSwiperPage from '@/views/ui/AwesomeSwiperPage.vue'

// Vue.use(VeeValidate)
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/stock/register',
    name: 'RegisterPage',
    components: {
      default: RegisterPage
    }
  },
  {
    path: '/stock/login',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/awesomeSwiper',
    name: 'AwesomeSwiperPage',
    components: {
      default: AwesomeSwiperPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
