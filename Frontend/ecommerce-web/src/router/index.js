import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import AddCategory from '@/views/Category/AddCategory.vue'
import AllCategory from '@/views/Category/AllCategory.vue'
import EditCategory from '@/views/Category/EditCategory.vue'
import AdminView from '@/views/AdminView.vue'
import AllProduct from '@/views/Product/AllProduct.vue'
import AddProduct from '@/views/Product/AddProduct.vue'
import EditProduct from '@/views/Product/EditProduct.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/admin/category/add',
    component: AddCategory
  },
  {
    path: '/admin/product/add',
    name: 'AddProduct',
    component: AddProduct
  },
  {
    path: '/admin/category/edit/:cateId',
    component: EditCategory,
    name: 'EditCategory',
    props: true
  },
  {
    path: '/admin/product/edit/:productId',
    component: EditProduct,
    name: 'EditProduct',
    props: true
  },
  {
    path: '/admin/category',
    name: 'AllCategory',
    component: AllCategory
  },
  {
    path: '/admin/product',
    name: 'AllProduct',
    component: AllProduct
  },
  {
    path: '/admin',
    name: 'AdminView',
    component: AdminView
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
