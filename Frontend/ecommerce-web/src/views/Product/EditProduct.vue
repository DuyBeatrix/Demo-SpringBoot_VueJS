<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 class="pt-3">EDIT PRODUCT</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form v-if="product">
                    <div class="form-group">
                        <label>Category</label>
                        <select class="form-control" v-model="product.cateId" required>
                            <option 
                                v-for="category of categories" :key="category.cateId"
                                :value="category.cateId"
                            >
                                {{ category.cateName}}
                            </option>
                        </select>
                    </div>
                    <div class="form-group"> 
                        <label>Product Name</label>
                        <input type="text" class="form-control" v-model="product.productName"/>
                    </div>
                    <div class="form-group"> 
                        <label>Product Description</label>
                        <textarea type="text" class="form-control" v-model="product.productDescription"></textarea>
                    </div>  
                    <div class="form-group"> 
                        <label>Product Image</label>
                        <input type="text" class="form-control" v-model="product.productImg"/>
                    </div>
                    <div class="form-group"> 
                        <label>Product Price</label>
                        <input type="text" class="form-control" v-model="product.productPrice"/>
                    </div>
                    <button type="button" class="btn btn-primary" @click="editProduct">Submit</button>
                </form>
            </div>
            <div class="col-3"></div>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import swal from 'sweetalert';
    export default {
        props: ["baseURL", "products", "categories"],
        data() {
            return {
                product: null,
                productId: null
            }
        },
        methods: {
            async editProduct() {
                await axios.put(`${this.baseURL}product/${this.productId}`, this.product)
                .then(() => {
                    this.$emit("getProducts") 
                    this.$router.push({name: 'AllProduct'})
                    swal({
                        text: "Product has been updated succesfully",
                        icon: "success"
                    })
                }).catch(err => console.log('err', err))
            }
        },
        async mounted() {
            if(!this.products) {
                await this.$nextTick();
            }
            this.productId = this.$route.params.productId;
            this.product = this.products.find(product => product.productId == this.productId);
        }
    }
</script>