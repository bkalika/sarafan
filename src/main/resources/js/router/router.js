import Vue from 'vue'
import {createRouter, createWebHistory} from 'vue-router'
import MessagesList from 'js/pages/MessageList.vue'
import Auth from 'js/pages/Auth.vue'
import Profile from 'js/pages/Profile.vue'


Vue.use(VueRouter)

const routes = [
    {path: '/', component: MessagesList},
    {path: '/auth', component: Auth},
    {path: '/profile', component: Profile},
    {path: '*', component: MessagesList},
]

export default new createRouter({
    history: createWebHistory(),
    routes
})
