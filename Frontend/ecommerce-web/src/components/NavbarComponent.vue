<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <router-link class="navbar-brand" :to="{ name: 'home' }">
            <img id="logo" src="../assets/logo.png" />
        </router-link>
        <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <!--      Search Bar-->
            <form class="form-inline ml-auto mr-auto">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" size="70">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="width: 100px;">Search</button>
            </form>
            <router-link class="mr-5" :to="{ name: 'AdminView' }"> <h3 class="">ADMIN</h3> </router-link>
        </div>
    </nav>
</template>

<style scoped>
    #logo {
        width: 100px;
        margin-left: 20px;
        margin-right: 20px;
    }
    a {
        color: white;
    }
</style>