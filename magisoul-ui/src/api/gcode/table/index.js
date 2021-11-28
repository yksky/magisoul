import request from '@/utils/request'

export function pageList(params){
  return request({
    url: '/admin/gcode/table/pageList',
    method: 'get',
    data: params
  })
}

export function getById(id){
  return request({
    url: '/admin/gcode/table/getById?id='+id,
    method: 'get'
  })
}

export function add(data){
  return request({
    url: '/admin/gcode/table/merge',
    method: 'post',
    data: data
  })
}

export function edit(data){
  return request({
    url: '/admin/gcode/table/merge',
    method: 'post',
    data: data
  })
}

export function deleteById(id){
  return request({
    url:'/admin/gcode/table/deleteById?id='+id,
    method: 'get'
  })
}
