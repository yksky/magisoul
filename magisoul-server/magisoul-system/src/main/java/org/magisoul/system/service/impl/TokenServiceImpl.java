package org.magisoul.system.service.impl;

import org.magisoul.system.entity.SysToken;
import org.magisoul.system.entity.SysUserInfo;
import org.magisoul.system.mapper.ISysTokenMapper;
import org.magisoul.system.mapper.ISysUserInfoMapper;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.service.ITokenService;
import org.magisoul.util.Dto2Entity;
import org.magisoul.util.ObjectUtil;
import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tokenService")
public class TokenServiceImpl implements ITokenService {

    @Autowired
    private ISysTokenMapper sysTokenMapper ;
    @Autowired
    private ISysUserInfoMapper sysUserInfoMapper ;

    @Override
    public RespData<SysUserInfoDto> checkToken(String token) {
        RespData<SysUserInfoDto> resp = new RespData<>();

        if(ObjectUtil.isEmpty(token)){
            resp.build(RespCodeEnum.TOKEN_EMPTY);
            return resp ;
        }

        SysToken sysToken = this.sysTokenMapper.getByToken(token);
        if(ObjectUtil.isEmpty(sysToken)){
            resp.build(RespCodeEnum.TOKEN_INVALID);
            return resp ;
        }

        //检查是否超时
        long curTime = System.currentTimeMillis();
        if(curTime>sysToken.getExpireTime()){
            resp.build(RespCodeEnum.TOKEN_TTMEOUT);
            return resp ;
        }

        long userId = sysToken.getUserId();
        SysUserInfo data = this.sysUserInfoMapper.getById(userId);
        SysUserInfoDto dto = this.getSysUserInfoDto(data);

        return resp.buildSuccess(dto);
    }

    private SysUserInfoDto getSysUserInfoDto(SysUserInfo sysUserInfo){
        SysUserInfoDto dto = new SysUserInfoDto();
        try{
            Dto2Entity.populate(sysUserInfo,dto);
        }catch(Exception e){
            e.printStackTrace();
        }
        return dto ;
    }
}
