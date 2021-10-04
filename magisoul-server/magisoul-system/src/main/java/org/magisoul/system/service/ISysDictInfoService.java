package org.magisoul.system.service;

import org.magisoul.system.model.dto.SysDictInfoDto;
import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysDictInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysDictInfoService {

    public RespData<String> add(SysDictInfoDto sysDictInfoDto);

    public RespData<String> updateForm(SysDictInfoDto sysDictInfoDto);

    public RespData<String> updateById(SysDictInfoDto sysDictInfoDto);

    public RespData<SysDictInfoDto> getById(Long id);

    public RespData<List<SysDictInfoDto>> list(QuerySysDictInfoVo querySysDictInfoVo);

    public RespData<Pagination<SysDictInfoDto>> pageList(QuerySysDictInfoVo querySysDictInfoVo);

}
