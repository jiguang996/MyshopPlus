import request from '@/utils/request'

/**
 * 获取个人信息
 * @param username
 */
export function info(username) {
  return request({
    url: 'profile/info/'+username,
    method: 'get',
  })
}

/**
 * 更新个人信息
 * @param username
 */
export function update(data) {
  return request({
    url: 'profile/update/',
    method: 'post',
    data
  })
}

/**
 * 修改密码
 * @param password
 */
export function modifyPassword(data) {
  return request({
    url: 'profile/modify/password',
    method: 'post',
    data
  })
}





/**
 * 更新头像
 * @param data
 */
export function modifyIcon(data) {
  return request({
    url: '/profile/modify/icon',
    method: 'post',
    data
  })
}
