<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAdd()">新增</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="dataList" border>
      <el-table-column label="序号" align="center" type="index" :index='indexMethod' width="70px" />
      <el-table-column label="用户名" align="center" prop="username" min-width="15%" />
      <el-table-column label="姓名" align="center" prop="realname" min-width="8%" />
      <el-table-column label="电话" align="center" prop="phone" min-width="8%" />
      <el-table-column label="邮件地址" align="center" prop="email" min-width="15%" />
      <el-table-column label="用户类型" align="center" prop="userType" min-width="20%" />
      <el-table-column label="使用状态" align="center" prop="enableStatus" min-width="20%" />
      <el-table-column label="创建时间" align="center" prop="createTime" min-width="12%" :formatter="dateFormat" />
      <el-table-column label="修改时间" align="center" prop="updateTime" min-width="12%" :formatter="dateFormat" />
      <el-table-column align="center" label="操作" min-width="15%">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  </div>
</template>

<script>
import {pageList, getById} from "@/api/system/user";
import moment from 'moment'

export default {
  name: "Data",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 字典表格数据
      dataList: [],
      // 默认字典类型
      defaultDictType: "",
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态数据字典
      statusOptions: [],
      // 类型数据字典
      typeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10
      },
      form: {}
    }
  },
  created() {
    this.getList();
  },
  methods: {
    getList() {
      this.loading = true ;
      pageList().then(response => {
        this.dataList = response.data.list ;
        this.total = response.data.totalNum ;

        this.loading = false ;
      })
    },
    indexMethod(index){
      let pageNo = this.queryParams.pageNum;
      let pageSize = this.queryParams.pageSize;
      return index+1+(pageNo-1)*pageSize;
    },
    handleAdd(){
      this.$router.push({ path: '/admin/user/add/'})
    },
    handleUpdate(row){
      this.$router.push({ name: 'EditUser', params:{id:row.id}})
    },
    handleDelete(row){

    },
    dateFormat(row,column){
      var date = row[column.property];
      if(date ==undefined){return ''};
      return moment(date).format("YYYY-MM-DD HH:mm:ss")
    }
  }
}
</script>
