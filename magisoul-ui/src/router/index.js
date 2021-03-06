import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  },
  //系统管理 二级菜单
  {
    path: '/admin/system',
    component: Layout,
    name: '系统管理',
    meta: {title: '系统管理'},
    children: [
      {path: 'user/list',component: () => import('@/views/system/user/list'),name: 'UserList',
       meta: {title:'用户管理'}},
      {path: 'user/add',component: () => import('@/views/system/user/add'),name: 'AddUser',
       meta: {title:'用户新增',noCache: true},hidden: true},
      {path: 'user/edit',component: () => import('@/views/system/user/edit'),name: 'EditUser',
       meta: {title:'用户编辑',noCache: true},hidden: true},
      {path: 'dept/list',component: () => import('@/views/system/dept/list'),name: 'DeptList',
        meta: {title:'部门管理'}},
      {path: 'dept/add',component: () => import('@/views/system/dept/add'),name: 'AddDept',
        meta: {title:'部门新增',noCache: true},hidden: true},
      {path: 'dept/edit',component: () => import('@/views/system/dept/edit'),name: 'EditDept',
        meta: {title:'部门编辑',noCache: true},hidden: true},
    ]
  },
  //代码生成
  {
    path: '/admin/gcode',
    component: Layout,
    name: '代码机器人',
    meta: {title: '代码机器人'},
    children: [
      {path: 'dbConfig/list',component: () => import('@/views/gcode/dbConfig/list'),name: 'DbConfigList',
        meta: {title:'数据源管理'}},
      {path: 'dbConfig/add',component: () => import('@/views/gcode/dbConfig/add'),name: 'AddDbConfig',
        meta: {title:'新增数据源',noCache: true},hidden: true},
      {path: 'dbConfig/edit',component: () => import('@/views/gcode/dbConfig/edit'),name: 'EditDbConfig',
        meta: {title:'编辑数据源',noCache: true},hidden: true},
      {path: 'job/list',component: () => import('@/views/gcode/job/list'),name: 'JobList',
        meta: {title:'任务管理'}},
      {path: 'job/add',component: () => import('@/views/gcode/job/add'),name: 'AddJob',
        meta: {title:'新增任务',noCache: true},hidden: true},
      {path: 'job/edit',component: () => import('@/views/gcode/job/edit'),name: 'EditJob',
        meta: {title:'编辑任务',noCache: true},hidden: true},
      {path: 'module/list',component: () => import('@/views/gcode/module/list'),name: 'ModuleList',
        meta: {title:'模块管理'}},
      {path: 'module/add',component: () => import('@/views/gcode/module/add'),name: 'AddModule',
        meta: {title:'新增模块',noCache: true},hidden: true},
      {path: 'module/edit',component: () => import('@/views/gcode/module/edit'),name: 'EditModule',
        meta: {title:'编辑模块',noCache: true},hidden: true},
      {path: 'table/list',component: () => import('@/views/gcode/table/list'),name: 'TableList',
        meta: {title:'表信息管理'}},
      {path: 'table/edit',component: () => import('@/views/gcode/table/edit'),name: 'EditTable',
        meta: {title:'编辑表信息',noCache: true},hidden: true},
    ]
  },
  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: { title: 'Example', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/table/index'),
        meta: { title: 'Table', icon: 'table' }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: () => import('@/views/tree/index'),
        meta: { title: 'Tree', icon: 'tree' }
      }
    ]
  },

  {
    path: '/form',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Form',
        component: () => import('@/views/form/index'),
        meta: { title: 'Form', icon: 'form' }
      }
    ]
  },

  {
    path: '/nested',
    component: Layout,
    redirect: '/nested/menu1',
    name: 'Nested',
    meta: {
      title: 'Nested',
      icon: 'nested'
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/nested/menu1/index'), // Parent router-view
        name: 'Menu1',
        meta: { title: 'Menu1' },
        children: [
          {
            path: 'menu1-1',
            component: () => import('@/views/nested/menu1/menu1-1'),
            name: 'Menu1-1',
            meta: { title: 'Menu1-1' }
          },
          {
            path: 'menu1-2',
            component: () => import('@/views/nested/menu1/menu1-2'),
            name: 'Menu1-2',
            meta: { title: 'Menu1-2' },
            children: [
              {
                path: 'menu1-2-1',
                component: () => import('@/views/nested/menu1/menu1-2/menu1-2-1'),
                name: 'Menu1-2-1',
                meta: { title: 'Menu1-2-1' }
              },
              {
                path: 'menu1-2-2',
                component: () => import('@/views/nested/menu1/menu1-2/menu1-2-2'),
                name: 'Menu1-2-2',
                meta: { title: 'Menu1-2-2' }
              }
            ]
          },
          {
            path: 'menu1-3',
            component: () => import('@/views/nested/menu1/menu1-3'),
            name: 'Menu1-3',
            meta: { title: 'Menu1-3' }
          }
        ]
      },
      {
        path: 'menu2',
        component: () => import('@/views/nested/menu2/index'),
        name: 'Menu2',
        meta: { title: 'menu2' }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://panjiachen.github.io/vue-element-admin-site/#/',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
