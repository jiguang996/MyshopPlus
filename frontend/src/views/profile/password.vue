<template>
  <div class="app-container">
    <el-form
      ref="form"
      v-loading="formLoading"
      :data="form"
      element-loading-text="加载中..."
      :model="form"
      label-width="120px"
    >
      <!--<el-input  label="账号" v-model="form.username" type="hidden" />-->
      <el-form-item label="账号">
        <el-input v-model="form.username" disabled />
      </el-form-item>
      <el-form-item label="旧密码">
        <el-input v-model="form.oldPassword" />
      </el-form-item>
      <el-form-item label="新密码">
        <el-input v-model="form.newPassword" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

    import { modifyPassword,info} from '@/api/profile'
    export default {
        name: "modifyPassword" ,
        data() {
            return{
                form:{
                    username: '',
                    newPassword: '',
                    oldPassword: ''
                }
            }
        },
        created() {
            this.fetchData()
        },
        methods:{
            fetchData() {
                info(this.$store.getters.name).then(response => {
                    this.form = response.data;
                    this.formLoading=false
                })
            },
            onSubmit(){
                this.formLoading=true;
                modifyPassword(this.form).then(response =>{
                    this.formLoading=false;
                    this.$message({
                        message: response.message,
                        type: 'success'
                    })
                }).catch(()=>{
                    this.formLoading=false
                })
            }
        }
    }
</script>

<style scoped>

</style>
