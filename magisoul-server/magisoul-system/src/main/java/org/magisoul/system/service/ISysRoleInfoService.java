package org.magisoul.system.service;

import org.magisoul.system.entity.SysRoleInfo;
import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysRoleInfoService {

    public RespData<String> add(SysRoleInfoDto sysRoleInfoDto);

    public RespData<String> updateForm(SysRoleInfoDto sysRoleInfoDto);

    public RespData<String> updateById(SysRoleInfoDto sysRoleInfoDto);

    public RespData<SysRoleInfoDto> getById(Long id);

    public RespData<List<SysRoleInfoDto>> list(QuerySysRoleInfoVo querySysRoleInfoVo);

    public RespData<Pagination<SysRoleInfoDto>> pageList(QuerySysRoleInfoVo querySysRoleInfoVo);

}
