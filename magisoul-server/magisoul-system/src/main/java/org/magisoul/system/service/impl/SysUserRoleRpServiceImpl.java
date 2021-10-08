package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysRoleInfo;
import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.mapper.ISysRoleInfoMapper;
import org.magisoul.system.mapper.ISysUserInfoMapper;
import org.magisoul.system.mapper.ISysUserRoleRpMapper;
import org.magisoul.system.service.ISysUserRoleRpService;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserRoleRpService")
public class SysUserRoleRpServiceImpl implements ISysUserRoleRpService {

    @Autowired
    private ISysUserRoleRpMapper sysUserRoleRpMapper ;
    @Autowired
    private ISysUserInfoMapper sysUserInfoMapper ;
    @Autowired
    private ISysRoleInfoMapper sysRoleInfoMapper ;

    @Override
    public RespData<String> updateByUserId(Long userId, List<Long> roleIdsList) {
        RespData<String> resp = new RespData<>();

        //检查用户Id
        RespData<String> check = this.checkByUserId(userId);
        if(!check.isSuccess()){
            resp.clone(check);
            return resp ;
        }

        //检查角色Id是否正确
        return null;
    }

    @Override
    public RespData<String> updateByRoleId(Long roleId, List<Long> userIdsList) {
        return null;
    }

    private RespData<String> checkByRoleId(Long roleId){
        RespData<String> resp = new RespData<>();

        if(roleId==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("角色Id不能为空");
            return resp ;
        }

        SysRoleInfo data = this.sysRoleInfoMapper.getById(roleId);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该角色不存在,请重新输入");
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该角色已经被删除,请重新输入");
            return resp ;
        }

        return resp.buildSuccess() ;
    }

    private RespData<String> checkByUserId(Long userId){
        RespData<String> resp = new RespData<>();

        if(userId==null){
            resp.setCode(RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
            resp.setMessage("用户Id不能为空,请重新输入");
            return resp ;
        }

        SysUserInfo data = this.sysUserInfoMapper.getById(userId);
        if(data==null){
            resp.setCode(RespCodeEnum.OBJECT_NOT_EXIST.getCode());
            resp.setMessage("该用户不存在,请重新输入");
            return resp ;
        }

        if(data.getIsDeleted().trim().equals("Y")){
            resp.setCode(RespCodeEnum.OBJECT_DELETED.getCode());
            resp.setMessage("该用户已经被删除,请重新输入");
            return resp ;
        }
        return resp.buildSuccess() ;
    }
}
