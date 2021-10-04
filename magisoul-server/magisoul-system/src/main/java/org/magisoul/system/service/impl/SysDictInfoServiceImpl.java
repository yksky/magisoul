package org.magisoul.system.service.impl;

import org.magisoul.system.mapper.ISysDictInfoMapper;
import org.magisoul.system.model.dto.SysDictInfoDto;
import org.magisoul.system.model.query.QuerySysDictInfoVo;
import org.magisoul.system.service.ISysDictInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDictInfoService")
public class SysDictInfoServiceImpl implements ISysDictInfoService {

    @Autowired
    private ISysDictInfoMapper sysDictInfoMapper ;

    @Override
    public RespData<String> add(SysDictInfoDto sysDictInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateForm(SysDictInfoDto sysDictInfoDto) {
        return null;
    }

    @Override
    public RespData<String> updateById(SysDictInfoDto sysDictInfoDto) {
        return null;
    }

    @Override
    public RespData<SysDictInfoDto> getById(Long id) {
        return null;
    }

    @Override
    public RespData<List<SysDictInfoDto>> list(QuerySysDictInfoVo querySysDictInfoVo) {
        return null;
    }

    @Override
    public RespData<Pagination<SysDictInfoDto>> pageList(QuerySysDictInfoVo querySysDictInfoVo) {
        return null;
    }
}
