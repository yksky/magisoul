package org.magisoul.gcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.entity.GcTableInfo;
import org.magisoul.gcode.model.query.QueryGcTableInfoVo;

import java.util.List;

public interface IGcTableInfoMapper {

    public Integer add(GcTableInfo gcTableInfo);

    public Integer updateForm(GcTableInfo gcTableInfo);

    public Integer updateById(GcTableInfo gcTableInfo);

    public GcTableInfo getById(@Param("id")Long id);

    public List<GcTableInfo> list(QueryGcTableInfoVo queryGcTableInfoVo);

    public Long count(QueryGcTableInfoVo queryGcTableInfoVo);

}
