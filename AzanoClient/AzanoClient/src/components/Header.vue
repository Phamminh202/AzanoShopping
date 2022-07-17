<template>
  <!-- header -->
  <div class="top-header-area" id="sticker">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-sm-12 text-center">
          <div class="main-menu-wrap">
            <!-- logo -->
            <div class="site-logo">
              <a href="/">
                <img src="assets/img/logo.png" alt="">
              </a>
            </div>
            <!-- logo -->

            <!-- menu start -->
            <nav class="main-menu">
              <ul>
                <li class="current-list-item">
                  <a href="/">Home</a>
                </li>
                <li><a href="/about">About</a></li>
                <li><a href="#">Pages</a>
                  <ul class="sub-menu">
                    <li><a href="404.html">404 page</a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="/cart">Cart</a></li>
                    <li><a href="checkout.html">Check Out</a></li>
                    <li><a href="contact.html">Contact</a></li>
                    <li><a href="news.html">News</a></li>
                    <li><a href="shop.html">Shop</a></li>
                  </ul>
                </li>
                <li><a href="news.html">News</a>
                  <ul class="sub-menu">
                    <li><a href="news.html">News</a></li>
                    <li><a href="single-news.html">Single News</a></li>
                  </ul>
                </li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/shop">Shop</a>
                  <ul class="sub-menu">
                    <li><a href="/shop">Shop</a></li>
                    <li><a href="/checkout">Check Out</a></li>
                    <li><a href="/single-product">Single Product</a></li>
                    <li><a href="/orders">Cart</a></li>
                  </ul>
                </li>
                <li class="current-list-item">
                  <a><i class="fas fa-user-circle u-s-m-r-6"></i>
                    <span>Account</span></a>
                  <ul class="sub-menu" style="width: 130px">
                    <div class="header-icons" v-if="this.loggedIn">
                      <li>
                        <a class="shopping-cart" href="/orders"><i class="fas fa-shopping-cart"></i>
                          <span>Cart</span></a>
                      </li>
                      <li>
                        <a href="/" @click="logout"><i class="fas fa-lock-open u-s-m-r-6"></i>
                          <span>Logout</span></a>
                      </li>
                    </div>
                    <div class="header-icons" v-else>
                      <li>
                        <a href="/login"><i class="fas fa-lock u-s-m-r-6"></i>
                          <span>Login</span></a>
                      </li>
                      <li>
                        <a href="/register" ><i class="fas fa-user-plus u-s-m-r-6"></i>
                          <span>Register</span></a>
                      </li>
                    </div>
                  </ul>
                </li>
              </ul>
            </nav>
            <a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
            <div class="mobile-menu"></div>
            <!-- menu end -->
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end header -->
  <!-- search area -->
  <div class="search-area">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <span class="close-btn"><i class="fas fa-window-close"></i></span>
          <div class="search-bar">
            <div class="search-bar-tablecell">
              <h3>Search For:</h3>
              <input type="text" placeholder="Keywords">
              <button type="submit">Search <i class="fas fa-search"></i></button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end search area -->


</template>

<script>
export default {
  name: "HeaderLayout",
  methods: {
      // checkAccount(){
      //   this.localStorage.getItem("account")
      // },
    logout(){
        this.$store.dispatch("auth/logout")
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
}
</script>

<style scoped>

</style>