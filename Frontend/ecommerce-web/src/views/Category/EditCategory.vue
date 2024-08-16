<template>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h4 class="pt-3">EDIT CATEGORY</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <form v-if="category">
                    <div class="form-group">
                        <label>Category Name</label>
                        <input type="text" class="form-control" v-model="category.cateName" required/>
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" class="form-control" v-model="category.cateDescription" required/>
                    </div>
                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" class="form-control" v-model="category.cateImg" required/>
                    </div>
                    <button type="button" class="btn btn-primary" @click="editCategory">Submit</button>
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
        data() {
            return {
                category: null,
                cateId: null
            }
        },
        props: ["baseURL", "categories"],
        methods: {
            async editCategory() {
                await axios.put(`${this.baseURL}category/${this.cateId}`, this.category )
                .then(() => {
                    // Sau khi update nó lấy data mới để thế vào data cũ luôn 
                    this.$emit("fetchData") 
                    this.$router.push({name: 'AllCategory'})
                    swal({
                        text: "Category has been updated succesfully",
                        icon: "success"
                    })
                }).catch(err => console.log('err', err))
            }
        },
        async mounted() {
            if (!this.categories) {
                await this.$nextTick(); // Đợi cho props categories được gán
            }
            this.cateId = this.$route.params.cateId;
            this.category = this.categories.find(category => category.cateId == this.cateId)
        }
    }
</script>