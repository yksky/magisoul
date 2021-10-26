package org.magisoul.gcode.api;

import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.query.QueryGcDbConfigInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcDbConfigInfoApi {

    public RespData<String> mergeForm(GcDbConfigInfoDto gcDbConfigInfoDto);

    public RespData<String> updateById(GcDbConfigInfoDto gcDbConfigInfoDto);

    public RespData<GcDbConfigInfoDto> getById(Long id);

    public RespData<List<GcDbConfigInfoDto>> list(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo);

    public RespData<Pagination<GcDbConfigInfoDto>> pageList(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo);
}
