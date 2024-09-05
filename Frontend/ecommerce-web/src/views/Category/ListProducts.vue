<template>
  <div class="container">
    <div class="row">
      <div class="col-12 text-center">
        <h4 class="pt-3">{{category.cateName}}</h4>
      </div>
    </div>
    <div class="row">
      <div v-for="product of products" :key="product.productId" class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
        <ProductBox :product="product"></ProductBox>
      </div>
    </div>
  </div>
</template>

<script>
  import ProductBox from "@/components/ProductBox.vue";
  const axios = require("axios");
  export default {
    components: {ProductBox},
    data() {
      return {
        baseUrl: "http://localhost:8081",
        cateId: null,
        category: {},
        products: []
      }
    },
    props: ["categories"],
    methods: {
      async getCategories() {
        await axios.get(`${this.baseUrl}/product/${this.cateId}`)
            .then(res => this.products = res.data.result)
            .catch(err => console.log(err))
        console.log(this.products)
      }
    },
    mounted() {
      this.cateId = this.$route.params.cateId;
      this.category = this.categories.find(category => category.cateId == this.cateId)
      this.getCategories();
    }
  }
</script>