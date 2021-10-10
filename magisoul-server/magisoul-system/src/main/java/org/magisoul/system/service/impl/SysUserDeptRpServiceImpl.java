package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysUserDeptRp;
import org.magisoul.system.mapper.ISysUserDeptRpMapper;
import org.magisoul.system.service.ISysUserDeptRpService;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDeptRpService")
public class SysUserDeptRpServiceImpl implements ISysUserDeptRpService {

    @Autowired
    private ISysUserDeptRpMapper sysUserDeptRpMapper ;

    @Override
    public RespData<String> add(SysUserDeptRp sysUserDeptRp) {
        return null;
    }

    @Override
    public RespData<String> delete(SysUserDeptRp sysUserDeptRp) {
        return null;
    }

    @Override
    public RespData<List<SysUserDeptRp>> list(Long userId, Long deptId) {
        return null;
    }

}
