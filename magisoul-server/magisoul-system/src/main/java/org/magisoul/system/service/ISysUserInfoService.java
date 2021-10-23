package org.magisoul.system.service;

import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysUserInfoService {

    public RespData<String> add(SysUserInfoDto sysUserInfoDto);

    public RespData<String> updateForm(SysUserInfoDto sysUserInfoDto);

    public RespData<String> updateById(SysUserInfoDto sysUserInfoDto);

    public RespData<SysUserInfoDto> getById(Long id);

    public RespData<SysUserInfoDto> getByToken(String token);

    public RespData<String> refreshToken(String token);

    public RespData<List<SysUserInfoDto>> list(QuerySysUserInfoVo querySysUserInfoVo);

    public RespData<Pagination<SysUserInfoDto>> pageList(QuerySysUserInfoVo querySysUserInfoVo);

    public RespData<String> login(String username,String password);

    public RespData<String> enable(SysUserInfoDto sysUserInfoDto);

    public RespData<String> disable(SysUserInfoDto sysUserInfoDto);

    public RespData<String> deleteById(SysUserInfoDto sysUserInfoDto);

}
