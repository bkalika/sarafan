import Vue from 'vue'
import Vuetify from 'vuetify'
import '@babel/polyfill'
import 'js/apiapi/resource'
import router from 'js/router/router'
import App from 'js/pages/App.vue'
import store from 'js/store/store'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'

if (frontendData.profile) {
    connect()
}

Vue.use(Vuetify)

new Vue({
    el: '#app',
    store,
    router,
    render: a => a(App)
})
