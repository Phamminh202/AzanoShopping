<template>
  <body>
  <div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">
      <nav class="navbar header-navbar pcoded-header">
        <div class="navbar-wrapper">

          <div class="navbar-logo">
            <a class="mobile-menu" id="mobile-collapse" href="#!">
              <i class="ti-menu"></i>
            </a>
            <a class="mobile-search morphsearch-search" href="#">
              <i class="ti-search"></i>
            </a>
            <a href="/admin/customers/create">
              <img class="img-fluid" src="${pageContext.request.contextPath}/resource/images/logo.png" alt="Theme-Logo"/>
            </a>
            <a class="mobile-options">
              <i class="ti-more"></i>
            </a>
          </div>

          <div class="navbar-container container-fluid">
            <ul class="nav-left">
              <li>
                <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a></div>
              </li>

              <li>
                <a href="#!" onclick="javascript:toggleFullScreen()">
                  <i class="ti-fullscreen"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="pcoded-main-container">
        <div class="pcoded-wrapper">
          <nav class="pcoded-navbar">
            <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
            <div class="pcoded-inner-navbar main-menu">
              <div class="pcoded-search">
                <span class="searchbar-toggle">  </span>
                <div class="pcoded-search-box ">
                  <input type="text" placeholder="Search">
                  <span class="search-icon"><i class="ti-search" aria-hidden="true"></i></span>
                </div>
              </div>
              <div class="pcoded-navigatio-lavel" data-i18n="nav.category.navigation">Layout</div>
              <ul class="pcoded-item pcoded-left-item">
                <li class="">
                  <a href="index.html">
                    <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.dash.main">Home</span>
                    <span class="pcoded-mcaret"></span>
                  </a>
                </li>
                <li class="pcoded-hasmenu">
                  <a href="javascript:void(0)">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext" data-i18n="nav.basic-components.main">Customer</span>
                    <span class="pcoded-mcaret"></span>
                  </a>
                  <ul class="pcoded-submenu">
                    <li class=" ">
                      <a href="/admin/customers/create">
                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                        <span class="pcoded-mtext"
                              data-i18n="nav.basic-components.alert">Create customer</span>
                        <span class="pcoded-mcaret"></span>
                      </a>
                    </li>
                    <li class=" ">
                      <a href="/admin/customers/list">
                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                        <span class="pcoded-mtext"
                              data-i18n="nav.basic-components.breadcrumbs">List customer</span>
                        <span class="pcoded-mcaret"></span>
                      </a>
                    </li>
                  </ul>
                </li>
                <li class="pcoded-hasmenu">
                  <a href="javascript:void(0)">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext" data-i18n="nav.basic-components.main">Product</span>
                    <span class="pcoded-mcaret"></span>
                  </a>
                  <ul class="pcoded-submenu">
                    <li class=" ">
                      <a href="/admin/products/create">
                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                        <span class="pcoded-mtext"
                              data-i18n="nav.basic-components.alert">Create product</span>
                        <span class="pcoded-mcaret"></span>
                      </a>
                    </li>
                    <li class=" ">
                      <a href="/admin/products/list">
                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                        <span class="pcoded-mtext"
                              data-i18n="nav.basic-components.breadcrumbs">List pproduct</span>
                        <span class="pcoded-mcaret"></span>
                      </a>
                    </li>
                  </ul>
                </li>
                <li class="pcoded-hasmenu">
                  <a href="javascript:void(0)">
                    <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                    <span class="pcoded-mtext" data-i18n="nav.basic-components.main">Account</span>
                    <span class="pcoded-mcaret"></span>
                  </a>
                  <ul class="pcoded-submenu">
                    <li class=" ">
                      <a href="/admin/accounts/list">
                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                        <span class="pcoded-mtext"
                              data-i18n="nav.basic-components.alert">List Account</span>
                        <span class="pcoded-mcaret"></span>
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </nav>
          <div class="pcoded-content">
            <div class="pcoded-inner-content">
              <!-- Main-body start -->
              <div class="main-body">
                <div class="page-wrapper">
                  <!-- Page-header start -->
                  <div class="page-body">
                    <div class="row">
                      <div class="col-sm-12">
                        <!-- Basic Form Inputs card start -->
                        <div class="card">
                          <h1>List product</h1>
                          <div class="pcoded-search">
                            <div class="col-sm-3">
                              <span class="searchbar-toggle"></span>
                              <div class="pcoded-search-box ">
                                <input type="text" placeholder="Search">
                                <span class="search-icon"><i class="ti-search"
                                                             aria-hidden="true"></i></span>
                              </div>
                            </div>
                          </div>
                          <a class="col-sm-3" href="/admin/products/create">Create new product</a>
                          <div class="card-block table-border-style">
                            <div class="table-responsive">
                              <table class="table">
                                <thead>
                                <tr>
                                  <th>id</th>
                                  <th>Full name</th>
                                  <th>Thumbnailages</th>
                                  <th>Price</th>
                                  <th>Status</th>
                                  <th>Action</th>
                                </tr>
                                </thead>
                                <ta>
                                  <tr :class="{ active: index === currentIndex }" v-for="(product, index) in products"  v-bind:key="index">
                                    <td v-text="product.id"></td>
                                    <td v-text="product.name"></td>
                                    <td class="product-image"><img :src="product.thumbnails" alt="" width="50"></td>
                                    <td v-text="product.price"></td>
                                    <td v-text="product.status"></td>
                                    <td>Actions </td>
<!--                                    <td>-->
<!--                                      <a href="/admin/products/detail?id=<%=st.getId()%>"><i-->
<!--                                          class="fa-solid fa-circle-info"></i></a>-->
<!--                                      <a href="/admin/products/edit?id=<%=st.getId()%>"><i-->
<!--                                          class="fa-solid fa-pen-to-square"></i></a>-->
<!--                                      <a href="/admin/products/delete?id=<%=st.getId()%>"-->
<!--                                         onclick="confirm('Are you sure?')"><i class="fa-solid fa-trash"></i></a>-->
<!--                                    </td>-->
                                  </tr>
                                </ta>
                              </table>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
export default {
  name: "ListProduct"
}
</script>

<style scoped>

</style>