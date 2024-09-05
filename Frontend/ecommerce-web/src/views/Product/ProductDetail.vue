<template>
  <div class="container">
    <div class="row pt-5">
      <div class="col-md-1"></div>
      <!-- Display img -->
      <div class="col-md-4 col-12">
        <!-- Use computed image source -->
        <img :src="productImageSrc" alt=""/>
      </div>
      <!-- Display product detail -->
      <div class="col-md-6 col-12 pt-3 pt-md-0">
        <h4>{{this.product.productName}}</h4>
        <h6 class="category font-italic">{{this.category.cateName}}</h6>
        <h6 class="font-weight-bold">{{this.product.productPrice}} VND</h6>
        <p>
          {{this.product.productDescription}}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      product: {},
      category: {}
    }
  },
  props: ["baseURL", "products", "categories"],
  computed: {
    productImageSrc() {
      if (this.product && this.product.productImg) {
        try {
          return require(`@/assets/${this.product.productImg}`);
        } catch (error) {
          console.error(`Image not found: ${this.product.productImg}`);
          return ''; // Fallback or placeholder image
        }
      }
      return ''; // Fallback or placeholder image
    }
  },
  async mounted() {
    if(!this.products) {
      await this.$nextTick();
    }
    this.productId = this.$route.params.productId;
    this.product = this.products.find(product => product.productId == this.productId);
    this.category = this.categories.find(category => category.cateId == this.product.cateId)

    console.log(this.productId);
    console.log(this.products);
    console.log(this.product && this.product.productImg);
  }
}
</script>
