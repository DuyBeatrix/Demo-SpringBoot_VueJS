<template>
  <div class="home">
    <div id="background-div" class="page-holder bg-cover">
      <div class="container">
        <header class="text-left text-white py-5">
          <h3 class="mb-4 rounded" id="heading">
            <a href="#start-shopping" class="text-white px-2 py-2 rounded" style="background-color: orangered;"> Start Shopping</a>
          </h3>
        </header>
      </div>
    </div>
    <!-- Display category -->
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3"> TOP CATEGORIES</h2>
        </div>
      </div>
      <div class="row">
        <div v-for="index in this.categorySize" :key="index"
          class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
          <CategoryBox :category="categories[index-1]"></CategoryBox>
        </div>
      </div>
    </div>
    <!-- Display product -->
    <hr/>
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h2 class="pt-3"> TOP PRODUCTS</h2>
        </div>
      </div>
      <div class="row">
        <div v-for="index in this.productSize" :key="index"
             class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
          <ProductBox :product="products[index-1]"></ProductBox>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CategoryBox from '@/components/Category/CategoryBox.vue';
import ProductBox from "@/components/ProductBox.vue";
export default {
  name: "HomeView",
  components: {CategoryBox, ProductBox},
  props: ["categories", "products"],
  data() {
    return {
      categorySize: 0,
      productSize: 0
    }
  },
  mounted() {
    this.categorySize = Math.min(6, this.categories.length);
    this.productSize = Math.min(6, this.products.length);
  }
};
</script>

<style scoped>
  .page-holder {
    min-height: 50vh;
  } 
  .bg-cover {
    background-size: cover !important;
  }
  #background-div {
    background: url("../assets/hero-img-1.png");
  }
  #heading {
    font-weight: 400;
  }
</style>