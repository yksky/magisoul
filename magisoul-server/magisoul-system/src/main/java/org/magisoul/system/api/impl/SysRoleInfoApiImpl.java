package org.magisoul.system.api.impl;

import org.magisoul.system.api.ISysRoleInfoApi;
import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public class SysRoleInfoApiImpl implements ISysRoleInfoApi {
    @Override
    public RespData<String> mergeForm(SysRoleInfoDto sysRoleInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateById(SysRoleInfoDto sysDictInfoDto) {
        return null;
    }

    @Override
    public RespData<SysRoleInfoDto> getById(Long id) {
        return null;
    }

    @Override
    public RespData<List<SysRoleInfoDto>> list(QuerySysRoleInfoVo querySysRoleInfoVo) {
        return null;
    }

    @Override
    public RespData<Pagination<SysRoleInfoDto>> pageList(QuerySysRoleInfoVo querySysRoleInfoVo) {
        return null;
    }

    @Override
    public RespData<String> enable(SysRoleInfoDto sysRoleInfoDto) {
        return null;
    }

    @Override
    public RespData<String> disable(SysRoleInfoDto sysRoleInfoDto) {
        return null;
    }

    @Override
    public RespData<String> deleteById(SysRoleInfoDto sysRoleInfoDto) {
        return null;
    }
}
