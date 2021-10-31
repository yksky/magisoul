import request from '@/utils/request'

export function pageList(params){
  return request({
    url: '/admin/gcode/module/pageList',
    method: 'get',
    data: params
  })
}

export function getById(id){
  return request({
    url: '/admin/gcode/module/getById?id='+id,
    method: 'get'
  })
}

export function add(data){
  return request({
    url: '/admin/gcode/module/merge',
    method: 'post',
    data: data
  })
}

export function edit(data){
  return request({
    url: '/admin/gcode/module/merge',
    method: 'post',
    data: data
  })
}

export function deleteById(id){
  return request({
    url:'/admin/gcode/module/deleteById?id='+id,
    method: 'get'
  })
}
