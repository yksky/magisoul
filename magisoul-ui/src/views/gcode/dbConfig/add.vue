<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-row>
        <el-col :span="24">
          <el-form-item label="数据源名称" prop="dbAppName" label-width="100px">
            <el-input v-model="form.dbAppName" placeholder="数据源名称" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="Schema" prop="dbSchema" label-width="100px">
            <el-input v-model="form.dbSchema" placeholder="Schema" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="数据源类型" prop="dbType" label-width="100px">
            <el-select v-model="form.dbType" placeholder="请选择数据源类型" style="display: block;">
              <el-option label="MySql" value="mysql" />
              <el-option label="SqlServer" value="sqlserver" />
              <el-option label="Oracle" value="oracle" />
              <el-option label="PostgreSql" value="postgresql" />
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="URL" prop="dbUrl" label-width="100px">
            <el-input v-model="form.dbUrl" placeholder="URL" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="驱动" prop="dbDriver" label-width="100px">
            <el-input v-model="form.dbDriver" placeholder="dbDriver" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="用户名" prop="dbUsername" label-width="100px">
            <el-input v-model="form.dbUsername" placeholder="用户名" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="密码" prop="dbPassword" label-width="100px">
            <el-input v-model="form.dbPassword" placeholder="密码" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="使用状态" prop="enableStatus" label-width="100px">
            <el-select v-model="form.enableStatus" placeholder="使用状态" style="display: block;">
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
import {add} from '@/api/gcode/dbConfig'

export default {
  name: "Data",
  data() {
    return {
      form: {}
    }
  },
  methods: {
    submitForm(){
      add(this.form).then(response => {
        if(response.code=='200'){
          alert('操作成功');
          //回到列表页
          this.$router.push({ path: '/admin/gcode/dbConfig/index'})
        }
      })
    },
    cancel(){

    }
  }

}
</script>
