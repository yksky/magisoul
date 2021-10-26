package org.magisoul.gcode.service;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.query.QueryGcJobInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface IGcJobInfoService {

    public RespData<String> add(GcJobInfoDto gcJobInfoDto);

    public RespData<String> updateForm(GcJobInfoDto gcJobInfoDto);

    public RespData<String> updateById(GcJobInfoDto gcJobInfoDto);

    public RespData<GcJobInfoDto> getById(@Param("id")Long id);

    public RespData<List<GcJobInfoDto>> list(QueryGcJobInfoVo queryGcJobInfoVo);

    public RespData<Pagination<GcJobInfoDto>> pageList(QueryGcJobInfoVo queryGcJobInfoVo);

    public RespData<String> deleteById(GcJobInfoDto gcJobInfoDto);

}
