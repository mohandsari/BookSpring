import Vue from 'vue'
import Router from 'vue-router'
import BookCrud from '../components/BookCrud.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'BookSpring',
      component: BookCrud
    }
  ]
})
