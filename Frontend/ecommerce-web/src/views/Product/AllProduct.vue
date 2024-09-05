<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pb-3 mt-5">OUR PRODUCT</h3>
                <router-link to="/admin/product/add">
                    <button class="btn" style="float: right">ADD PRODUCT</button>
                </router-link>
            </div>
            <div class="row col-12">
              <div v-for="product of products" :key="product.productId" class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
                <ProductBox :product="product"></ProductBox>
              </div>
            </div>
        </div>
    </div>
</template>

<script>
    const axios = require("axios");
    import ProductBox from "@/components/ProductBox.vue";
    export default {
        components: {
            ProductBox
        },
        data() {
            return {
                baseUrl: "http://localhost:8081",
                products: []
            };
        },
        methods: {
            async getProducts() {
                await axios.get(`${this.baseUrl}/product`)
                .then(res => this.products = res.data.result)
                .catch(err => console.log(err))
            }
        },
        mounted() {
            this.getProducts()
        }
    }
</script>

<style scoped>

</style>