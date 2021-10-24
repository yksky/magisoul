<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-row>
        <el-col :span="24">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="form.username" placeholder="用户名" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="姓名" prop="realname">
            <el-input v-model="form.realname" placeholder="姓名" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="电话" prop="phone">
            <el-input v-model="form.phone" placeholder="电话" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.email" placeholder="邮箱" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="用户类型" prop="userType">
            <el-select v-model="form.userType" placeholder="请选择用户类型">
              <el-option label="平台用户" value="01"/>
              <el-option label="普通用户" value="02"/>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="使用状态" prop="enableStatus">
            <el-select v-model="form.enableStatus" placeholder="请选择使用状态">
              <el-option label="使用" value="enable"/>
              <el-option label="停用" value="disable"/>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script>
import {edit,getById } from '@/api/system/user'

export default {
  name: "Data",
  data() {
    return {
      form: {}
    }
  },
  created() {
    console.log(this.$route);
    this.getUserById();
  },
  methods: {
    submitForm(){
      edit(this.form).then(response => {
        if(response.code=='200'){
          alert('操作成功');
          //回到列表页
          this.$router.push({ path: '/admin/user/list'})
        }
      })
    },
    getUserById(){
      console.log(this.$route.params)
      var id = this.$route.params.id;
      getById(id).then(response => {
        this.form = response.data ;
      })
    },
    cancel(){

    }
  }

}
</script>
