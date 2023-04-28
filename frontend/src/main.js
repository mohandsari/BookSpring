// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Keycloak from 'keycloak-js'
Vue.config.productionTip = false

/* eslint-disable no-new */

let initOptions = {
  url: 'http://localhost:8080/',
  realm: 'SpringBootKeycloak',
  clientId: 'login-app',
  onLoad: 'login-required'
}

let keycloak = new Keycloak(initOptions)

keycloak.init({onLoad: initOptions.onLoad}).then(() => {
  new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>'
  })
})
