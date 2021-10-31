package org.magisoul.gcode.api;

import org.magisoul.gcode.model.dto.GcFieldInfoDto;
import org.magisoul.gcode.model.query.QueryGcFieldInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcFieldInfoApi {

    public RespData<String> updateForm(GcFieldInfoDto gcFieldInfoDto);

    public RespData<String> updateById(GcFieldInfoDto gcFieldInfoDto);

    public RespData<GcFieldInfoDto> getById(Long id);

    public RespData<List<GcFieldInfoDto>> list(QueryGcFieldInfoVo queryGcFieldInfoVo);

    public RespData<Pagination<GcFieldInfoDto>> pageList(QueryGcFieldInfoVo queryGcFieldInfoVo);

}
