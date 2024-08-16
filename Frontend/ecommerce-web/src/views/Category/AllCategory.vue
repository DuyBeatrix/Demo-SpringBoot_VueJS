<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pb-3 mt-5">OUR CATEGORY</h3>
                <router-link to="/admin/category/add">
                    <button class="btn" style="float: right">ADD CATEGORY</button>
                </router-link>
            </div>
            <div class="row col-12">
                    <div v-for="category of categories" :key="category.cateId" class="col-md-6 col-xl-4 col-12 pt-3 justify-content-around d-flex">
                        <CategoryBox :category="category"></CategoryBox>
                    </div>
            </div>
        </div>
    </div>
</template>

<script>
    const axios = require("axios");
    import CategoryBox from '@/components/Category/CategoryBox.vue';
    export default {
        components: {
            CategoryBox
        },
        data() {
            return {
                baseUrl: "http://localhost:8081",
                categories: []
            };
        },
        methods: {
            async getCategories() {
                await axios.get(`${this.baseUrl}/category`)
                .then(res => this.categories = res.data.result)
                .catch(err => console.log(err))
            }
        },
        mounted() {
            this.getCategories()
        }
    }
</script>

<style scoped>

</style>