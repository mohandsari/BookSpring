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

keycloak.init({onLoad: initOptions.onLoad}).then(authenticated => {
  if (authenticated) {
    console.log('ok')
    const token = keycloak.token
    let d = new Date()
    d.setTime(d.getTime() + 121 * 60 * 1000)
    // let expires = 'expires=' + d.toUTCString()
    // 1 ) SessionStorage
    // sessionStorage.setItem('keycloakToken', token)
    // 2 ) Web Worker
    // Créer un nouveau worker
    const keycloakWorker = new Worker('WebWorker.js')
    // Envoyer le jeton Keycloak au worker
    keycloakWorker.postMessage({ type: 'SET_TOKEN', payload: token })

    // 3 ) Service Worker

    // Enregistrer le Service Worker
    /* if ('serviceWorker' in navigator) {
      navigator.serviceWorker.register('/worker.js', {
        scope: './' })
    }

    // Stocker le token de Keycloak dans le cache du Service Worker
    if ('serviceWorker' in navigator) {
      navigator.serviceWorker.ready.then(registration => {
        registration.active.postMessage({
          type: 'storeToken',
          token: token
        })
      })
    } */
    // 4 ) cookies
    // document.cookie = 'keycloakToken=' + token + ';expires=' + expires + ';path=/;HttpOnly;Secure;SameSite=Strict'
  } else {
    // document.cookie = 'keycloakToken=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/'
  }
  new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>',
    beforeCreate () {
      Vue.prototype.$keycloak = keycloak
    }

  })
})
