package org.magisoul.system.service;

import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysDeptInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysDeptInfoService {

    public RespData<String> add(SysDeptInfoDto sysDeptInfoDto);

    public RespData<String> updateForm(SysDeptInfoDto sysDeptInfoDto);

    public RespData<String> updateById(SysDeptInfoDto sysDeptInfoDto);

    public RespData<SysDeptInfoDto> getById(Long id);

    public RespData<List<SysDeptInfoDto>> list(QuerySysDeptInfoVo querySysDeptInfoVo);

    public RespData<Pagination<SysDeptInfoDto>> pageList(QuerySysDeptInfoVo querySysDeptInfoVo);

    public RespData<String> enable(SysDeptInfoDto sysDeptInfoDto);

    public RespData<String> disable(SysDeptInfoDto sysDeptInfoDto);

    public RespData<String> deleteById(SysDeptInfoDto sysDeptInfoDto);

}
