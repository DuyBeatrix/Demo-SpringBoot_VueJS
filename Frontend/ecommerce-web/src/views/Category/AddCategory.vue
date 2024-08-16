<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pb-3 mt-5">ADD CATEGORY</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form>
                    <div class="form-group">
                        <label>Category Name</label>
                        <input type="text" class="form-control" v-model="categoryName"/>
                    </div>
                    <div class="form-group">
                        <label>Category Description</label>
                        <textarea type="text" class="form-control" v-model="categoryDescription"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Category Image</label>
                        <input type="text" class="form-control" v-model="categoryImage"/>
                    </div>
                    <button type="button" class="btn btn-primary" @click="addCategory">Submit</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>

<script>
    const axios = require("axios");
    const sweetalert = require("sweetalert");
    export default {
        data() {
            return {
                categoryName: "",
                categoryDescription: "",
                categoryImage: ""
            };
        },
        methods: {
            addCategory() {
                const newCategory = {
                    cateName: this.categoryName,
                    cateDescription: this.categoryDescription,
                    cateImg: this.categoryImage
                };
                const baseUrl = "http://localhost:8081";

                axios({
                    method: "post",
                    url: `${baseUrl}/category`,
                    data: JSON.stringify(newCategory),
                    headers: {
                        "Content-Type": "application/json",
                    },
                })
                .then(() => {
                    this.$emit("fetchData") 
                    this.$router.push({name: 'AllCategory'})
                    sweetalert ({
                        text: "Category added seccesfully",
                        icon: "success"
                    });
                })
                .catch((err) => {
                    console.log(err);
                });
            }
        },
    }
</script>

<style scoped>

</style>