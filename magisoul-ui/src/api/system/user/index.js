import request from '@/utils/request'

export function pageList(params){
  return request({
    url: '/admin/system/user/pageList',
    method: 'get',
    data: params
  })
}

export function getById(id){
  return request({
    url: '/admin/system/user/getById?id='+id,
    method: 'get'
  })
}

export function add(data){
  return request({
    url: '/admin/system/user/merge',
    method: 'post',
    data: data
  })
}

export function edit(data){
  return request({
    url: '/admin/system/user/merge',
    method: 'post',
    data: data
  })
}

export function enable(id){
  return request({
    url:'/admin/system/user/enable?id='+id,
    method: 'get'
  })
}

export function disable(id){
  return request({
    url:'/admin/system/user/disable?id='+id,
    method: 'get'
  })
}

export function deleteById(id){
  return request({
    url:'/admin/system/user/deleteById?id='+id,
    method: 'get'
  })
}

