package org.magisoul.gcode.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.gcode.entity.GcDictConfigInfo;
import org.magisoul.gcode.model.query.QueryGcDictConfigInfoVo;

import java.util.List;

public interface IGcDictConfigInfoMapper {

    public Integer add(GcDictConfigInfo gcDictConfigInfo);

    public Integer updateForm(GcDictConfigInfo gcDictConfigInfo);

    public Integer updateById(GcDictConfigInfo gcDictConfigInfo);

    public GcDictConfigInfo getById(@Param("id")Long id);

    public List<GcDictConfigInfo> list(QueryGcDictConfigInfoVo queryGcDictConfigInfoVo);

    public Long count(QueryGcDictConfigInfoVo queryGcDictConfigInfoVo);

    public List<GcDictConfigInfo> getExistByName(@Param("id")Long id,@Param("dictName")String dictName);

}
