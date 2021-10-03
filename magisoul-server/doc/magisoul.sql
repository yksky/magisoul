/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : magisoul

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-10-03 10:22:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gc_db_config_info
-- ----------------------------
DROP TABLE IF EXISTS `gc_db_config_info`;
CREATE TABLE `gc_db_config_info` (
                                     `id` bigint NOT NULL COMMENT '主键,雪花id',
                                     `db_url` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '数据库配置',
                                     `db_password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '数据库密码',
                                     `db_driver` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '驱动',
                                     `db_username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
                                     `db_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据库类型',
                                     `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                     `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                     `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                     `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                     `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                     `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[表单与代码设计]数据库表配置';

-- ----------------------------
-- Table structure for gc_dict_config_info
-- ----------------------------
DROP TABLE IF EXISTS `gc_dict_config_info`;
CREATE TABLE `gc_dict_config_info` (
                                       `id` bigint NOT NULL COMMENT '主键,雪花id',
                                       `dict_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典配置信息',
                                       `dict_value` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典配置值,json格式值',
                                       `dict_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典配置类型',
                                       `query_str` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '查询字段',
                                       `table_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
                                       `key_field_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'key字段信息',
                                       `value_field_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'value信息',
                                       `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                       `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                       `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                       `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                       `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                       `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[表单与代码设计]字典配置信息';

-- ----------------------------
-- Table structure for gc_field_info
-- ----------------------------
DROP TABLE IF EXISTS `gc_field_info`;
CREATE TABLE `gc_field_info` (
                                 `id` bigint NOT NULL COMMENT '主键,雪花id',
                                 `job_id` bigint NOT NULL COMMENT '任务id',
                                 `table_id` bigint NOT NULL COMMENT '表id',
                                 `field_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字段名称',
                                 `field_comment` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字段备注',
                                 `field_desc` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字段备注',
                                 `field_class_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字段对象名称',
                                 `field_entity_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字段实体名称',
                                 `is_primary_field` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否主键',
                                 `primary_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主键生成类型',
                                 `is_add_field` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否添加字段',
                                 `is_edit_field` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否编辑字段',
                                 `is_query_field` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否查询字段',
                                 `is_list_field` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否列表展示字段',
                                 `is_delete_field` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除字段',
                                 `delete_value` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '删除值',
                                 `not_delete_value` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '非删除值',
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[表单与代码设计]字段配置信息';

-- ----------------------------
-- Table structure for gc_job_info
-- ----------------------------
DROP TABLE IF EXISTS `gc_job_info`;
CREATE TABLE `gc_job_info` (
                               `id` bigint NOT NULL COMMENT '主键,雪花id',
                               `db_config_id` bigint DEFAULT NULL COMMENT '数据库配置id',
                               `job_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '任务名称',
                               `project_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系统名称',
                               `ui_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'ui类型',
                               `tech_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '技术类型',
                               `gc_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用类型',
                               `gc_path` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生成代码路径',
                               `group_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'maven配置的groupId',
                               `artifact_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'maven配置的artifactId',
                               `version` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'maven配置的version',
                               `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                               `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                               `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                               `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                               `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                               `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[表单与代码设计]任务信息';

-- ----------------------------
-- Table structure for gc_module_info
-- ----------------------------
DROP TABLE IF EXISTS `gc_module_info`;
CREATE TABLE `gc_module_info` (
                                  `id` bigint NOT NULL COMMENT '主键,雪花id',
                                  `job_id` bigint DEFAULT NULL COMMENT '所属任务id',
                                  `module_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模块名称',
                                  `module_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模块代码',
                                  `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                  `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                  `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                  `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[表单与代码设计]模块信息表';

-- ----------------------------
-- Table structure for gc_table_info
-- ----------------------------
DROP TABLE IF EXISTS `gc_table_info`;
CREATE TABLE `gc_table_info` (
                                 `id` bigint NOT NULL COMMENT '主键,雪花id',
                                 `job_id` bigint NOT NULL COMMENT '任务id',
                                 `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '表名',
                                 `comment` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '表备注',
                                 `alias_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '别名',
                                 `class_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表对应的类名',
                                 `entity_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '实体名称',
                                 `primary_field_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主键',
                                 `is_nav` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否导航菜单',
                                 `module_id` bigint DEFAULT NULL COMMENT '所属模块id',
                                 `nav_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '导航菜单名称',
                                 `add_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '添加url地址',
                                 `edit_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编辑url地址',
                                 `delete_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '删除url地址',
                                 `list_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '列表查询url',
                                 `get_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '获取单条记录',
                                 `enable_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态更改url',
                                 `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `delete_type` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '删除方式:逻辑删除|物理删除|无删除',
                                 `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[表单与代码设计]表信息配置';

-- ----------------------------
-- Table structure for sync_ds_config_info
-- ----------------------------
DROP TABLE IF EXISTS `sync_ds_config_info`;
CREATE TABLE `sync_ds_config_info` (
                                       `id` bigint NOT NULL COMMENT '主键,雪花id',
                                       `ds_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据源名称',
                                       `ds_type` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据源类型',
                                       `ds_url` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据源地址',
                                       `ds_driver` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据源驱动',
                                       `ds_username` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据源用户名',
                                       `ds_password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据源密码',
                                       `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                       `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                       `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                       `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                       `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                       `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[数据同步]数据源配置';

-- ----------------------------
-- Table structure for sync_job_info
-- ----------------------------
DROP TABLE IF EXISTS `sync_job_info`;
CREATE TABLE `sync_job_info` (
                                 `id` bigint NOT NULL COMMENT '主键,雪花id',
                                 `reader_ds_config_id` bigint NOT NULL COMMENT '数据源读取id',
                                 `reader_json_param` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '读取参数配置',
                                 `reader_regex` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '读取表达式',
                                 `writer_ds_config_id` bigint DEFAULT NULL COMMENT '存储数据源配置',
                                 `writer_json_param` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储json配置',
                                 `writer_regex` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '存储表达式配置',
                                 `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                 `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[数据同步]任务管理';

-- ----------------------------
-- Table structure for sys_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info` (
                                 `id` bigint NOT NULL COMMENT '主键,雪花Id',
                                 `dept_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
                                 `parent_id` bigint NOT NULL COMMENT '父级Id',
                                 `dept_code` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门编号',
                                 `full_code_path` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编号全路径',
                                 `level` int NOT NULL COMMENT '层级',
                                 `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '使用状态',
                                 `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                 `desc` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]部门表';

-- ----------------------------
-- Table structure for sys_dict_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_info`;
CREATE TABLE `sys_dict_info` (
                                 `id` bigint NOT NULL COMMENT '主键,雪花Id',
                                 `dict_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典名称',
                                 `dict_type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典类型',
                                 `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                 `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]字典类型配置';

-- ----------------------------
-- Table structure for sys_dict_item_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item_info`;
CREATE TABLE `sys_dict_item_info` (
                                      `id` bigint NOT NULL COMMENT '主键,雪花Id',
                                      `dict_type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典类型',
                                      `item_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典明细名称',
                                      `item_value` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典明细值',
                                      `sort` int DEFAULT NULL COMMENT '排序',
                                      `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                      `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                      `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                      `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                      `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                      `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]字典明细信息';

-- ----------------------------
-- Table structure for sys_log_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_info`;
CREATE TABLE `sys_log_info` (
                                `id` bigint NOT NULL COMMENT '主键,雪花Id',
                                `sys_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '系统名称',
                                `module_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '模块名称',
                                `menu_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单名称',
                                `opt_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作类型',
                                `log_content` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志内容',
                                `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]系统日志表';

-- ----------------------------
-- Table structure for sys_resource_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_info`;
CREATE TABLE `sys_resource_info` (
                                     `id` bigint NOT NULL COMMENT '主键,雪花Id',
                                     `resource_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资源名称',
                                     `resource_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源编号',
                                     `level` int NOT NULL COMMENT '层级',
                                     `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类型:module|menu',
                                     `parent_id` bigint DEFAULT NULL COMMENT '父级Id',
                                     `request_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求地址',
                                     `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '使用状态',
                                     `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                     `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                     `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                     `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                     `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]资源表';

-- ----------------------------
-- Table structure for sys_role_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info` (
                                 `id` bigint NOT NULL COMMENT '主键,雪花Id',
                                 `role_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
                                 `role_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色类型',
                                 `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '使用状态',
                                 `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除',
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]角色信息';

-- ----------------------------
-- Table structure for sys_role_resource_rp
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource_rp`;
CREATE TABLE `sys_role_resource_rp` (
                                        `role_id` bigint DEFAULT NULL COMMENT '角色Id',
                                        `resource_id` bigint DEFAULT NULL COMMENT '资源id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]角色与资源关联';

-- ----------------------------
-- Table structure for sys_user_dept_rp
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept_rp`;
CREATE TABLE `sys_user_dept_rp` (
                                    `user_id` bigint NOT NULL COMMENT '用户id',
                                    `dept_id` bigint NOT NULL COMMENT '部门id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]用户与部门关联';

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
                                 `id` bigint NOT NULL COMMENT '主键id,雪花Id',
                                 `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名,唯一',
                                 `password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
                                 `realname` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
                                 `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
                                 `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱地址',
                                 `user_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户类型:平台用户|普通用户',
                                 `enable_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '使用状态:enable|disable',
                                 `is_deleted` varchar(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否删除:Y|N',
                                 `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
                                 `creator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
                                 `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                 `updator` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]系统用户表';

-- ----------------------------
-- Table structure for sys_user_role_rp
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rp`;
CREATE TABLE `sys_user_role_rp` (
                                    `user_id` bigint NOT NULL COMMENT '用户id',
                                    `role_id` bigint NOT NULL COMMENT '角色id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='[系统管理]用户与角色关联';
