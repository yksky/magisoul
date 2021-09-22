package org.magisoul.system.api;

import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysUserInfoApi {

    /**
     * 页面表单的编辑功能(这里合并新增以及修改)
     * @param sysUserInfoDto
     * @return
     */
    public RespData<String> mergeForm(SysUserInfoDto sysUserInfoDto);

    /**
     * 根据Id修改用户信息
     * @param sysUserInfoDto
     * @return
     */
    public RespData<String> updateById(SysUserInfoDto sysUserInfoDto);

    /**
     * 根据id获取用户记录
     * @param id
     * @return
     */
    public RespData<SysUserInfoDto> getById(Long id);

    /**
     * 不分页查询
     * @param querySysUserInfoVo
     * @return
     */
    public RespData<List<SysUserInfoDto>> list(QuerySysUserInfoVo querySysUserInfoVo);

    /**
     * 分页查询
     * @param querySysUserInfoVo
     * @return
     */
    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysUserInfoVo querySysUserInfoVo);

    /**
     * 重置密码
     * @param sysUserInfoDto
     * @return
     */
    public RespData<String> resetPwd(SysUserInfoDto sysUserInfoDto);

    /**
     * 将用户状态标记为可用
     * @param sysUserInfoDto
     * @return
     */
    public RespData<String> enable(SysUserInfoDto sysUserInfoDto);

    /**
     * 将用户状态标记为不可用
     * @param sysUserInfoDto
     * @return
     */
    public RespData<String> disable(SysUserInfoDto sysUserInfoDto);

    /**
     * 删除该用户
     * @param id
     * @return
     */
    public RespData<String> deleteById(Long id);

}
