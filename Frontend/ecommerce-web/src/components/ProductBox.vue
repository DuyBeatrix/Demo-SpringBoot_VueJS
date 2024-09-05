<template>
    <div class="card w-100 h-100" style="margin-top: 10px;">
        <div class="embed-responsive embed-responsive-16by9">
            <img class="card-img-top embed-responsive-item" :src="require(`@/assets/${product.productImg}`)"/>
        </div>
        <div class="card-body">
            <router-link :to="{name: 'ShowDetails', params: {productId: product.productId}}">
              <h5 class="card-title">{{ product.productName }}</h5>
            </router-link>
            <p class="card-text">{{ product.productDescription }}</p>
            <h5 class="card-title">{{ product.productPrice }}</h5>
            <router-link :to="{name: 'EditProduct', params: {productId: product.productId}}">
                <a href="#" class="btn btn-primary">Edit</a>
            </router-link>
        </div>
    </div>
</template>

<script>
    export default {
        props:["product"],
    }
</script>

<style scoped>
    .card-img-top {
        object-fit: cover;
    }
    a {
      text-decoration: none;
    }
</style>