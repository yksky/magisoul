package org.magisoul.system.api.impl;

import org.magisoul.system.api.ISysUserInfoApi;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.system.service.ISysUserInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserInfoApi")
public class SysUserInfoApiImpl implements ISysUserInfoApi {

    @Autowired
    private ISysUserInfoService sysUserInfoService ;

    /**
     * 页面表单的编辑功能(这里合并新增以及修改)
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> mergeForm(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    /**
     * 根据Id修改用户信息
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> updateById(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    /**
     * 根据id获取用户记录
     *
     * @param id
     * @return
     */
    @Override
    public RespData<SysUserInfoDto> getById(Long id) {
        return null;
    }

    /**
     * 不分页查询
     *
     * @param querySysUserInfoVo
     * @return
     */
    @Override
    public RespData<List<SysUserInfoDto>> list(QuerySysUserInfoVo querySysUserInfoVo) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param querySysUserInfoVo
     * @return
     */
    @Override
    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysUserInfoVo querySysUserInfoVo) {
        return null;
    }

    /**
     * 重置密码
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> resetPwd(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    /**
     * 将用户状态标记为可用
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> enable(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    /**
     * 将用户状态标记为不可用
     *
     * @param sysUserInfoDto
     * @return
     */
    @Override
    public RespData<String> disable(SysUserInfoDto sysUserInfoDto) {
        return null;
    }

    /**
     * 删除该用户
     *
     * @param id
     * @return
     */
    @Override
    public RespData<String> deleteById(Long id) {
        return null;
    }
}
