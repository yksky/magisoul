package org.magisoul.gcode.service.impl;

import org.magisoul.gcode.mapper.IGcFieldInfoMapper;
import org.magisoul.gcode.model.dto.GcFieldInfoDto;
import org.magisoul.gcode.model.query.QueryGcFieldInfoVo;
import org.magisoul.gcode.service.IGcFieldInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GcFieldInfoServiceImpl implements IGcFieldInfoService {

    @Autowired
    private IGcFieldInfoMapper gcFieldInfoMapper ;

    @Override
    public RespData<String> updateForm(GcFieldInfoDto gcFieldInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateById(GcFieldInfoDto gcFieldInfoDto) {
        return null;
    }

    @Override
    public RespData<GcFieldInfoDto> getById(Long id) {
        return null;
    }

    @Override
    public RespData<List<GcFieldInfoDto>> list(QueryGcFieldInfoVo queryGcFieldInfoVo) {
        return null;
    }

    @Override
    public RespData<Pagination<GcFieldInfoDto>> pageList(QueryGcFieldInfoVo queryGcFieldInfoVo) {
        return null;
    }
}
