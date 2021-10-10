package org.magisoul.system.api;

import org.magisoul.system.model.dto.SysDictInfoDto;
import org.magisoul.system.model.query.QuerySysDictInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysDictInfoApi {

    public RespData<String> mergeForm(SysDictInfoDto sysDictInfoDto);

    public RespData<String> updateById(SysDictInfoDto sysDictInfoDto);

    public RespData<SysDictInfoDto> getById(Long id);

    public RespData<List<SysDictInfoDto>> list(QuerySysDictInfoVo querySysDictInfoVo);

    public RespData<Pagination<SysDictInfoDto>> pageList(QuerySysDictInfoVo querySysDictInfoVo);

    public RespData<String> enable(SysDictInfoDto sysDictInfoDto);

    public RespData<String> disable(SysDictInfoDto sysDictInfoDto);

    public RespData<String> deleteById(SysDictInfoDto sysDictInfoDto);

}
