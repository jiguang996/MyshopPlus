<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="头像">
        <el-input v-model="form.icon"></el-input>
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>

    import { info } from '@/api/profile'
    export default {
        name: "ProfileInfo" ,
        data() {
            return{
                form:{
                    icon: '',
                    username:''
                }
            }
        },
        created() {
            this.fetchData()
        },
        methods:{
            fetchData() {
                info(this.$store.getters.name).then(response => {
                    this.form = response.data
                })
            }
        }
    }
</script>

<style scoped>

</style>
