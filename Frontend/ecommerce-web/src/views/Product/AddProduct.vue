<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h3 class="pb-3 mt-5">ADD PRODUCT</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form>
                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-control" v-model="cateId" required>
                            <option value="" disabled selected>Select category</option>
                            <option 
                                v-for="category in categories" :key="category.cateId"
                                :value="category.cateId"
                            >
                                {{ category.cateName}}
                            </option>
                        </select>
                    </div>
                    <div class="form-group"> 
                        <label>Product Name</label>
                        <input type="text" class="form-control" v-model="productName"/>
                    </div>
                    <div class="form-group"> 
                        <label>Product Description</label>
                        <textarea type="text" class="form-control" v-model="productDesciption"></textarea>
                    </div>  
                    <div class="form-group"> 
                        <label>Product Image</label>
                        <input type="text" class="form-control" v-model="productImage"/>
                    </div>
                    <div class="form-group"> 
                        <label>Product Price</label>
                        <input type="text" class="form-control" v-model="productPrice"/>
                    </div>
                    <button type="button" class="btn btn-primary" @click="addProdcut">Submit</button>
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
        props: ["baseURL", "categories"],
        data() {
            return {
                productName: null,
                productDesciption: null,
                productImage: null,
                productPrice: null,
                cateId: null
            }
        },
        methods: {
            addProdcut() {
                const newProduct = {
                    productName: this.productName,
                    productDescription: this.productDesciption,
                    productImg: this.productImage,
                    productPrice: this.productPrice,
                    cateId: this.cateId
                };  

                const baseUrl = "http://localhost:8081";

                axios({
                    method: "post",
                    url: `${baseUrl}/product`,
                    data: JSON.stringify(newProduct),
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                .then(() => {
                    this.$emit("getProducts") 
                    this.$router.push({name: 'AllProduct'})
                    sweetalert ({
                        text: "Product added seccesfully",
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