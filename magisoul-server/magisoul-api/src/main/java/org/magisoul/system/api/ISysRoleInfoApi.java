package org.magisoul.system.api;

import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysRoleInfoApi {

    public RespData<String> mergeForm(SysRoleInfoDto sysRoleInfoDto);

    public RespData<String> updateById(SysRoleInfoDto sysRoleInfoDto);

    public RespData<SysRoleInfoDto> getById(Long id);

    public RespData<List<SysRoleInfoDto>> list(QuerySysRoleInfoVo querySysRoleInfoVo);

    public RespData<Pagination<SysRoleInfoDto>> pageList(QuerySysRoleInfoVo querySysRoleInfoVo);

    public RespData<String> enable(SysRoleInfoDto sysRoleInfoDto);

    public RespData<String> disable(SysRoleInfoDto sysRoleInfoDto);

    public RespData<String> deleteById(SysRoleInfoDto sysRoleInfoDto);

}
