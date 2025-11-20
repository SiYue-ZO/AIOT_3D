import Vue from 'vue'
import Router from 'vue-router'
import mainView from "@/components/main-view";
import login from "@/components/login";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/main',
      name: 'mainView',
      component: mainView,
    },
    {
      path: '/',
      name: 'login',
      component: login,
    },
  ]
})

