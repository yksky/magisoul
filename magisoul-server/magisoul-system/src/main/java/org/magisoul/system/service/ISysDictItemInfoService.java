package org.magisoul.system.service;

import org.magisoul.system.model.dto.SysDictItemInfoDto;
import org.magisoul.system.model.query.QuerySysDictItemInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysDictItemInfoService {

    public RespData<String> add(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<String> updateForm(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<String> updateById(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<SysDictItemInfoDto> getById(Long id);

    public RespData<List<SysDictItemInfoDto>> list(QuerySysDictItemInfoVo querySysDictItemInfoVo);

    public RespData<Pagination<SysDictItemInfoDto>> pageList(QuerySysDictItemInfoVo querySysDictItemInfoVo);

}
