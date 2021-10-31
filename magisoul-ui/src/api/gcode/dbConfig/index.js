import request from '@/utils/request'

export function pageList(params){
  return request({
    url: '/admin/gcode/dbConfig/pageList',
    method: 'get',
    data: params
  })
}

export function listDefault(params){
  return request({
    url: '/admin/gcode/dbConfig/listDefault',
    method: 'get',
    data: params
  })
}

export function getById(id){
  return request({
    url: '/admin/gcode/dbConfig/getById?id='+id,
    method: 'get'
  })
}

export function add(data){
  return request({
    url: '/admin/gcode/dbConfig/merge',
    method: 'post',
    data: data
  })
}

export function edit(data){
  return request({
    url: '/admin/gcode/dbConfig/merge',
    method: 'post',
    data: data
  })
}

export function deleteById(id){
  return request({
    url:'/admin/gcode/dbConfig/deleteById?id='+id,
    method: 'get'
  })
}
