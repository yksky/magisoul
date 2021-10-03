package org.magisoul.system.service;

import org.magisoul.system.model.dto.SysResourceInfoDto;
import org.magisoul.system.model.query.QuerySysResourceInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysResourceInfoService {

    public RespData<String> add(SysResourceInfoDto sysResourceInfoDto);

    public RespData<String> updateForm(SysResourceInfoDto sysResourceInfoDto);

    public RespData<String> updateById(SysResourceInfoDto sysResourceInfoDto);

    public RespData<SysResourceInfoDto> getById(Long id);

    public RespData<List<SysResourceInfoDto>> list(QuerySysResourceInfoVo querySysResourceInfoVo);

    public RespData<Pagination<SysResourceInfoDto>> pageList(QuerySysResourceInfoVo querySysResourceInfoVo);

}
