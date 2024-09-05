<template>
  <NavbarComponent></NavbarComponent>
  <router-view  
    :baseURL="baseURL" 
    :categories="categories"
    :products="products"
    @fetchData="fetchData "
  >
  </router-view>
  <FooterComponent/>
</template>

<script>
  import axios from 'axios';
  import NavbarComponent from './components/NavbarComponent.vue';
  import FooterComponent from "./components/FooterComponent.vue";
  export default {
    components: {NavbarComponent, FooterComponent},
    data() {
      return {
        baseURL: "http://localhost:8081/",
        products: [],
        categories: []
      }
    },
    methods: {
      async fetchData() {
        // API call to get all theo categories
        await axios.get(this.baseURL + "category")
        .then(res => {this.categories = res.data.result}).catch((err) => console.log('err', err));
        // api call to get the products
        await axios.get(this.baseURL + "product")
        .then(res => {
          this.products = res.data.result
        }).catch((err) => console.log('err', err));
      }
    },
    mounted() {
      this.fetchData();
    }
  }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

  #nav {
    padding: 30px;
  }

  #nav a {
    font-weight: bold;
    color: #2c3e50;
  }

  #nav a.router-link-exact-active {
    color: #42b983;
  }
</style>
