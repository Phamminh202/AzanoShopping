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
  <body>
  <!-- features list section -->
  <div class="list-section pt-80 pb-80">
    <div class="container">

      <div class="row">
        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
          <div class="list-box d-flex align-items-center">
            <div class="list-icon">
              <i class="fas fa-shipping-fast"></i>
            </div>
            <div class="content">
              <h3>Free Shipping</h3>
              <p>When order over $75</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
          <div class="list-box d-flex align-items-center">
            <div class="list-icon">
              <i class="fas fa-phone-volume"></i>
            </div>
            <div class="content">
              <h3>24/7 Support</h3>
              <p>Get support all day</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-md-6">
          <div class="list-box d-flex justify-content-start align-items-center">
            <div class="list-icon">
              <i class="fas fa-sync"></i>
            </div>
            <div class="content">
              <h3>Refund</h3>
              <p>Get refund within 3 days!</p>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  <!-- end features list section -->

  <!-- product section -->
  <div class="product-section mt-150 mb-150">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 offset-lg-2 text-center">
          <div class="section-title">
            <h3><span class="orange-text">Our</span> Products</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, fuga quas itaque eveniet beatae
              optio.</p>
          </div>
        </div>
      </div>

      <div>
        <div class="row">
          <div class="col-lg-4 col-md-6 text-center" :class="{ active: index === currentIndex }"
               v-for="(product, index) in products" v-bind:key="index">
            <div class="single-product-item">
              <div class="product-image">
                <img :src="product.thumbnails" alt="" width="120">
              </div>
              <h3>{{ product.name }}</h3>
              <p class="product-price">{{ product.price }}</p>
              <button @click="addToCart(product.productId)">Add to cart</button>
            </div>
          </div>
        </div>
      </div>
      <div class="overflow-auto">
        <a-pagination
            :current="page"
            :page-size="limit"
            :total="totalItems"
            @change="handelClick"
            size="sm"
        ></a-pagination>
      </div>
    </div>
  </div>
  <!-- advertisement section -->
  <div class="abt-section mb-150">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-12">
          <div class="abt-bg">
            <a href="https://www.youtube.com/watch?v=DBLlFWYcIGQ" class="video-play-btn popup-youtube"><i
                class="fas fa-play"></i></a>
          </div>
        </div>
        <div class="col-lg-6 col-md-12">
          <div class="abt-text">
            <p class="top-sub">Since Year 1999</p>
            <h2>We are <span class="orange-text">Fruitkha</span></h2>
            <p>Etiam vulputate ut augue vel sodales. In sollicitudin neque et massa porttitor vestibulum ac vel nisi.
              Vestibulum placerat eget dolor sit amet posuere. In ut dolor aliquet, aliquet sapien sed, interdum velit.
              Nam eu molestie lorem.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente facilis illo repellat veritatis minus,
              et labore minima mollitia qui ducimus.</p>
            <a href="about.html" class="boxed-btn mt-4">know more</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- end advertisement section -->

  <!-- latest news -->
  <div class="latest-news pt-150 pb-150">
    <div class="container">

      <div class="row">
        <div class="col-lg-8 offset-lg-2 text-center">
          <div class="section-title">
            <h3><span class="orange-text">Our</span> News</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, fuga quas itaque eveniet beatae
              optio.</p>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-lg-4 col-md-6">
          <div class="single-latest-news">
            <a href="single-news.html">
              <div class="latest-news-bg news-bg-1"></div>
            </a>
            <div class="news-text-box">
              <h3><a href="single-news.html">You will vainly look for fruit on it in autumn.</a></h3>
              <p class="blog-meta">
                <span class="author"><i class="fas fa-user"></i> Admin</span>
                <span class="date"><i class="fas fa-calendar"></i> 27 December, 2019</span>
              </p>
              <p class="excerpt">Vivamus lacus enim, pulvinar vel nulla sed, scelerisque rhoncus nisi. Praesent vitae
                mattis nunc, egestas viverra eros.</p>
              <a href="single-news.html" class="read-more-btn">read more <i class="fas fa-angle-right"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-md-6">
          <div class="single-latest-news">
            <a href="single-news.html">
              <div class="latest-news-bg news-bg-2"></div>
            </a>
            <div class="news-text-box">
              <h3><a href="single-news.html">A man's worth has its season, like tomato.</a></h3>
              <p class="blog-meta">
                <span class="author"><i class="fas fa-user"></i> Admin</span>
                <span class="date"><i class="fas fa-calendar"></i> 27 December, 2019</span>
              </p>
              <p class="excerpt">Vivamus lacus enim, pulvinar vel nulla sed, scelerisque rhoncus nisi. Praesent vitae
                mattis nunc, egestas viverra eros.</p>
              <a href="single-news.html" class="read-more-btn">read more <i class="fas fa-angle-right"></i></a>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-md-6 offset-md-3 offset-lg-0">
          <div class="single-latest-news">
            <a href="single-news.html">
              <div class="latest-news-bg news-bg-3"></div>
            </a>
            <div class="news-text-box">
              <h3><a href="single-news.html">Good thoughts bear good fresh juicy fruit.</a></h3>
              <p class="blog-meta">
                <span class="author"><i class="fas fa-user"></i> Admin</span>
                <span class="date"><i class="fas fa-calendar"></i> 27 December, 2019</span>
              </p>
              <p class="excerpt">Vivamus lacus enim, pulvinar vel nulla sed, scelerisque rhoncus nisi. Praesent vitae
                mattis nunc, egestas viverra eros.</p>
              <a href="single-news.html" class="read-more-btn">read more <i class="fas fa-angle-right"></i></a>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12 text-center">
          <a href="news.html" class="boxed-btn">More News</a>
        </div>
      </div>
    </div>
  </div>
  <!-- end latest news -->

  <!-- logo carousel -->
  </body>

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

import ProductDataService from "../../service/ProductDataService";
import OrderDataService from "@/service/OrderDataService";

export default {
  name: "OrderProducts",
  data() {
    return {
      page: 1,
      limit: 5,
      totalItems: 0,
      currentPage: 1,
      products: [],
      currentIndex: -1,
      name: "",
      detail: "",
      cart: {
        // userId: "a3c79fa7-e8ef-46b2-ac0e-8f0ca2937d99",
        productId: "2"
      }
    };
  },
  methods: {
    getListProducts() {
      let urlParams = new URLSearchParams(window.location.search);
      if (urlParams.has("name")) {
        // if (this.keyword === ""){
        this.name = urlParams.get("name");
        ProductDataService.getAllByName(this.page, this.limit, this.name)
            .then(response => {
              this.products = response.data.content;
              this.page = response.data.currentPage;
              this.totalItems = response.data.totalItems;
              console.log(response.data);
            })
            .catch(e => {
              console.log(e);
            });
      } else {
        ProductDataService.getAllBy(this.page, this.limit)
            .then(response => {
              this.products = response.data.content;
              this.page = response.data.currentPage;
              this.totalItems = response.data.totalItems;
              console.log(response.data);

            })
            .catch(e => {
              console.log(e);
            });
      }
    },
    handelClick(val){
      this.page = val;
      this.getListProducts();
    },
    addToCart() {
      // if (this.loggedIn()) {
        // const item = this.products.find(({id}) => id === productId);
        var data = {
          // userId: this.cart.userId,
          productId: this.cart.productId,
          quantity: "1"
        };
        OrderDataService.addCart(data)
            .then(resp => {
              this.cart =resp.data
              console.log(resp.data)
            })
        alert("Order success")
      // }else {
      //   alert("Please login to add")
      //   this.$router.push("/login");
      // }
    },
    logout(){
      this.$store.dispatch("auth/logout")
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    this.getListProducts()
  }
}
</script>

<style scoped>

</style>