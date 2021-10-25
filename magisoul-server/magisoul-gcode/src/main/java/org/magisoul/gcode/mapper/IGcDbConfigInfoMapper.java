package org.magisoul.gcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.entity.GcDbConfigInfo;
import org.magisoul.gcode.model.query.QueryGcDbConfigInfoVo;

import java.util.List;

public interface IGcDbConfigInfoMapper {

    public Integer add(GcDbConfigInfo gcDbConfigInfo);

    public Integer updateForm(GcDbConfigInfo gcDbConfigInfo);

    public Integer updateById(GcDbConfigInfo gcDbConfigInfo);

    public GcDbConfigInfo getById(@Param("id")Long id);

    public List<GcDbConfigInfo> list(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo);

    public Long count(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo);

    public List<GcDbConfigInfo> getExistByName(@Param("id")Long id,@Param("dbAppName")String dbAppName);
}
