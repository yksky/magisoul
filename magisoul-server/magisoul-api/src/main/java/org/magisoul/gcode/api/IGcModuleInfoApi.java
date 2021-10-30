package org.magisoul.gcode.api;

import org.magisoul.gcode.model.dto.GcModuleInfoDto;
import org.magisoul.gcode.model.query.QueryGcModuleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcModuleInfoApi {

    public RespData<String> merge(GcModuleInfoDto gcModuleInfoDto);

    public RespData<String> updateById(GcModuleInfoDto gcModuleInfoDto);

    public RespData<GcModuleInfoDto> getById(Long id);

    public RespData<List<GcModuleInfoDto>> list(QueryGcModuleInfoVo queryGcModuleInfoVo);

    public RespData<Pagination<GcModuleInfoDto>> pageList(QueryGcModuleInfoVo queryGcModuleInfoVo);

}
