package org.magisoul.system.api;

import org.magisoul.system.model.dto.SysDictItemInfoDto;
import org.magisoul.system.model.query.QuerySysDictItemInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysDictItemInfoApi {

    public RespData<String> mergeForm(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<String> updateById(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<SysDictItemInfoDto> getById(Long id);

    public RespData<List<SysDictItemInfoDto>> list(QuerySysDictItemInfoVo querySysDictItemInfoVo);

    public RespData<Pagination<SysDictItemInfoDto>> pageList(QuerySysDictItemInfoVo querySysDictItemInfoVo);

    public RespData<String> enable(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<String> disable(SysDictItemInfoDto sysDictItemInfoDto);

    public RespData<String> deleteById(SysDictItemInfoDto sysDictItemInfoDto);

}
