<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="80px">
      <el-row>
        <el-col :span="24">
          <el-form-item label="任务名称" prop="jobName">
            <el-input v-model="form.jobName" placeholder="任务名称" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="项目名称" prop="projectName">
            <el-input v-model="form.projectName" placeholder="项目名称" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="代码路径" prop="gcPath">
            <el-input v-model="form.gcPath" placeholder="生成代码路径" />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="数据库" prop="dbConfigId">
            <el-select v-model="form.dbConfigId" placeholder="请选择数据库" clearable size="small" style="display: block;">
              <el-option
                v-for="dict in dbConfigOption"
                  :key="dict.id"
                  :label="dict.dbAppName"
                  :value="dict.id"
              />
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否分离" prop="gcType">
            <el-select v-model="form.gcType" placeholder="请选择是否前后端分离" style="display: block;">
              <el-option label="是" value="01" />
              <el-option label="否" value="02" />
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="UI类型" prop="uiType">
            <el-select v-model="form.uiType" placeholder="请选择UI类型" style="display: block;">
              <el-option label="VUE" value="01"/>
              <el-option label="Antd" value="02"/>
              <el-option label="AdminLTE" value="03"/>
              <el-option label="Inspinia" value="04"/>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="技术类型" prop="techType">
            <el-select v-model="form.techType" placeholder="请选择技术类型" style="display: block;">
              <el-option label="SpringBoot" value="01" />
              <el-option label="SpringCloud" value="02" />
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="GroupId" prop="groupId">
            <el-input v-model="form.groupId" placeholder="Maven的GroupId" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="ArtifactId" prop="artifactId">
            <el-input v-model="form.artifactId" placeholder="Maven的ArtifactId" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="Version" prop="version">
            <el-input v-model="form.version" placeholder="Maven的Version" />
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="使用状态" prop="enableStatus">
            <el-select v-model="form.enableStatus" placeholder="请选择使用状态" style="display: block;">
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
import {merge} from '@/api/gcode/job'
import {listDefault} from '@/api/gcode/dbConfig'

export default {
  name: "Data",
  data() {
    return {
      form: {},
      // 类型数据字典
      dbConfigOption: [],
    }
  },
  created() {
    listDefault().then(response => {
      this.dbConfigOption = response.data
    })
  },
  methods: {
    submitForm(){
      merge(this.form).then(response => {
        if(response.code=='200'){
          alert('操作成功');
          //回到列表页
          this.$router.push({ path: '/admin/gcode/job/index'})
        }
      })
    },
    cancel(){

    }
  }

}
</script>
