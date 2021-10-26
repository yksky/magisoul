package org.magisoul.gcode.api;

import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.query.QueryGcJobInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcJobInfoApi {

    public RespData<String> mergeForm(GcJobInfoDto gcJobInfoDto);

    public RespData<String> updateById(GcJobInfoDto gcJobInfoDto);

    public RespData<GcJobInfoDto> getById(Long id);

    public RespData<List<GcJobInfoDto>> list(QueryGcJobInfoVo queryGcJobInfoVo);

    public RespData<Pagination<GcJobInfoDto>> pageList(QueryGcJobInfoVo queryGcJobInfoVo);

}
