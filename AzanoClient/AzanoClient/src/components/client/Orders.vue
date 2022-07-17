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

  <div class="breadcrumb-section breadcrumb-bg">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 offset-lg-2 text-center">
          <div class="breadcrumb-text">
            <p>Fresh and Organic</p>
            <h1>Cart</h1>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end breadcrumb section -->

  <!-- cart -->
  <div class="cart-section mt-150 mb-150">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-12">
          <div class="cart-table-wrap">
            <table class="cart-table">
              <thead class="cart-table-head">
              <tr class="table-head-row">
                <th class="product-image">Product Image</th>
                <th class="product-name">Name</th>
                <th class="product-price">Price</th>
                <th class="product-total">Action</th>
              </tr>
              </thead>
              <tbody>
                <tr class="table-body-row" :class="{ active: index === currentIndex }"
                    v-for="(order, index) in orders" v-bind:key="index">
                  <td class="product-image"><img :src="order.image" alt=""></td>
                  <td class="product-name">{{order.name}}</td>
                  <td class="product-price">{{order.price}} VND</td>
                  <td @click="removeFromCart(index)"><button>Remove</button></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

        <div class="col-lg-4">
          <div class="total-section">
            <table class="total-table">
              <thead class="total-table-head">
              <tr class="table-total-row">
              </tr>
              </thead>
              <tbody>
              <tr class="total-data">
                <label for="">Username: </label>
                <input type="text" name="userName" v-model="order.userName">
              </tr>
              </tbody>
            </table>
            <div class="cart-buttons">
              <button class="boxed-btn black" @click="checkout">Check out</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end cart -->

  <!-- logo carousel -->
  <!-- end logo carousel -->

  <!-- footer -->
  <div class="footer-area">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="footer-box about-widget">
            <h2 class="widget-title">About us</h2>
            <p>Ut enim ad minim veniam perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae.</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="footer-box get-in-touch">
            <h2 class="widget-title">Get in Touch</h2>
            <ul>
              <li>34/8, East Hukupara, Gifirtok, Sadan.</li>
              <li>support@fruitkha.com</li>
              <li>+00 111 222 3333</li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="footer-box pages">
            <h2 class="widget-title">Pages</h2>
            <ul>
              <li><a href="index.html">Home</a></li>
              <li><a href="about.html">About</a></li>
              <li><a href="services.html">Shop</a></li>
              <li><a href="news.html">News</a></li>
              <li><a href="contact.html">Contact</a></li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="footer-box subscribe">
            <h2 class="widget-title">Subscribe</h2>
            <p>Subscribe to our mailing list to get the latest updates.</p>
            <form action="index.html">
              <input type="email" placeholder="Email">
              <button type="submit"><i class="fas fa-paper-plane"></i></button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end footer -->

  <!-- copyright -->
  <div class="copyright">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-12">
          <p>Copyrights &copy; 2019 - <a href="https://imransdesign.com/">Imran Hossain</a>,  All Rights Reserved.<br>
            Distributed By - <a href="https://themewagon.com/">Themewagon</a>
          </p>
        </div>
        <div class="col-lg-6 text-right col-md-12">
          <div class="social-icons">
            <ul>
              <li><a href="#" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-twitter"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-instagram"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-linkedin"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-dribbble"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- footer -->
  <div class="footer-area">
    <div class="container">
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="footer-box about-widget">
            <h2 class="widget-title">About us</h2>
            <p>Ut enim ad minim veniam perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae.</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="footer-box get-in-touch">
            <h2 class="widget-title">Get in Touch</h2>
            <ul>
              <li>34/8, East Hukupara, Gifirtok, Sadan.</li>
              <li>support@fruitkha.com</li>
              <li>+00 111 222 3333</li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="footer-box pages">
            <h2 class="widget-title">Pages</h2>
            <ul>
              <li><a href="index.html">Home</a></li>
              <li><a href="about.html">About</a></li>
              <li><a href="services.html">Shop</a></li>
              <li><a href="news.html">News</a></li>
              <li><a href="contact.html">Contact</a></li>
            </ul>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="footer-box subscribe">
            <h2 class="widget-title">Subscribe</h2>
            <p>Subscribe to our mailing list to get the latest updates.</p>
            <form action="index.html">
              <input type="email" placeholder="Email">
              <button type="submit"><i class="fas fa-paper-plane"></i></button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end footer -->

  <!-- copyright -->
  <div class="copyright">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-12">
          <p>Copyrights &copy; 2019 - <a href="https://imransdesign.com/">Imran Hossain</a>,  All Rights Reserved.<br>
            Distributed By - <a href="https://themewagon.com/">Themewagon</a>
          </p>
        </div>
        <div class="col-lg-6 text-right col-md-12">
          <div class="social-icons">
            <ul>
              <li><a href="#" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-twitter"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-instagram"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-linkedin"></i></a></li>
              <li><a href="#" target="_blank"><i class="fab fa-dribbble"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end copyright -->
</template>

<script>
import OrderDataService from "@/service/OrderDataService";

export default {
  name: "AddOrders",
  data() {
    return {
      orders: [],
      currentIndex: -1,
      order:
          {
            userName: "",
            published: true
          },
      submitted: false,
    };
    },
  methods: {
    getCart() {

    },
    logout(){
      this.$store.dispatch("auth/logout")
    },
    removeFromCart() {

    },
    checkout() {
      this.orders = JSON.parse(localStorage.getItem("orders"));
      var data = {
        userName: this.order.userName,
        items: this.orders
      };
      OrderDataService.checkout(data)
          .then(response => {
            this.orders.id = response.data.id;
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
      if (this.submitted == true){
        localStorage.removeItem('orders')
        alert("Orders success")
        this.$router.push("/")
      }
    }
  },
  beforeMount() {
    this.getCart();
  },
  }
</script>

<style scoped>

</style>