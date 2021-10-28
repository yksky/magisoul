package org.magisoul.gcode.service;

import org.magisoul.gcode.model.dto.GcModuleInfoDto;
import org.magisoul.gcode.model.query.QueryGcModuleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcModuleInfoService {

    public RespData<String> add(GcModuleInfoDto gcModuleInfoDto);

    public RespData<String> updateForm(GcModuleInfoDto gcModuleInfoDto);

    public RespData<String> updateById(GcModuleInfoDto gcModuleInfoDto);

    public RespData<GcModuleInfoDto> getById(Long id);

    public RespData<List<GcModuleInfoDto>> list(QueryGcModuleInfoVo queryGcModuleInfoVo);

    public RespData<Pagination<GcModuleInfoDto>> pageList(QueryGcModuleInfoVo queryGcModuleInfoVo);

}
