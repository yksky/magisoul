package org.magisoul.gcode.api;

import org.magisoul.gcode.model.dto.GcTableInfoDto;
import org.magisoul.gcode.model.query.QueryGcTableInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcTableInfoApi {

    public RespData<String> mergeForm(GcTableInfoDto gcTableInfoDto);

    public RespData<String> updateById(GcTableInfoDto gcTableInfoDto);

    public RespData<GcTableInfoDto> getById(Long id);

    public RespData<List<GcTableInfoDto>> list(QueryGcTableInfoVo queryGcTableInfoVo);

    public RespData<Pagination<GcTableInfoDto>> pageList(QueryGcTableInfoVo queryGcTableInfoVo);

}
