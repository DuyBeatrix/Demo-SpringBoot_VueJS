<template>
    <router-link :to="{name: 'AllCategory'}" >
        <button class="btn btn-primary btn-lg mt-5"> ADMIN CATEGORY</button>
    </router-link>
    <br />
    <router-link :to="{name: 'AllProduct'}" >
        <button class="btn btn-primary btn-lg"> ADMIN PRODUCT</button>
    </router-link>


</template>
<script>
export default {

}
</script>
<style>
    .btn {
        margin-bottom: 20px;
        width: 220px;
        text-align: center;
    }
</style>
