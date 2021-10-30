package org.magisoul.gcode.service;

import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.query.QueryGcDbConfigInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcDbConfigInfoService {

    public RespData<String> add(GcDbConfigInfoDto gcDbConfigInfoDto);

    public RespData<String> updateForm(GcDbConfigInfoDto gcDbConfigInfoDto);

    public RespData<String> updateById(GcDbConfigInfoDto gcDbConfigInfoDto);

    public RespData<GcDbConfigInfoDto> getById(Long id);

    public RespData<List<GcDbConfigInfoDto>> list(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo);

    public RespData<Pagination<GcDbConfigInfoDto>> pageList(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo);

    public RespData<String> deleteById(GcDbConfigInfoDto gcDbConfigInfoDto);

}
