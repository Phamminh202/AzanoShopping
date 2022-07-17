import { createApp } from 'vue'
import App from './App.vue'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import router from "./router";
import Antd from "ant-design-vue";
import "ant-design-vue/dist/antd.css"
import store from "./store/index";
import { FontAwesomeIcon } from './plugins/font-awesome'

import '../public/assets/css/all.min.css'
import '../public/assets/bootstrap/css/bootstrap.min.css'
import '../public/assets/css/owl.carousel.css'
import '../public/assets/css/magnific-popup.css'
import '../public/assets/css/animate.css'
import '../public/assets/css/meanmenu.min.css'
import '../public/assets/css/main.css'
import '../public/assets/css/responsive.css'

// import '../public/admin-assets/css/bootstrap/css/bootstrap.min.css'
// import '../public/admin-assets/css/animate.css/css/animate.css'
// import '../public/admin-assets/css/morris.js/css/morris.css'


createApp(App).use(router).use(Antd).use(store).component("font-awesome-icon", FontAwesomeIcon).mount('#app')

let account = localStorage.getItem('account');
if( account ){
    window.axios = require('axios')
    window.axios.defaults.headers.common['Authorization'] = 'Bearer ' + account;
}
