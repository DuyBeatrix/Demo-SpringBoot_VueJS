<template>
    <div class="card w-100 h-100" style="margin-top: 10px;">
        <div class="embed-responsive embed-responsive-16by9">
            <!-- <img :src="category.cateImg" class="card-img-top"> -->
            <img :src="require(`@/assets/${category.cateImg}`)" class="card-img-top embed-responsive-item">
        </div>
        <div class="card-body">
          <router-link :to="{name: 'ListProduct', params: {cateId: category.cateId}}">
            <h5 class="card-title">{{ category.cateName }}</h5>
          </router-link>
          <p class="card-text">{{ category.cateDescription }}</p>
          <router-link :to="{name: 'EditCategory',  params: {cateId: category.cateId}}" v-show="$route.name=='AllCategory'">
            <a href="#" class="btn btn-primary">Edit</a>
          </router-link>
        </div>
    </div>
</template>

<script>
    export default {
        props:["category"],
        methods: {},
    }
</script>

<style scoped>
    .card-img-top {
        object-fit: cover;
    }
</style>