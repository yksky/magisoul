package org.magisoul.admin.context;

import org.magisoul.system.model.dto.SysUserInfoDto;

public class UserContext {

    private static ThreadLocal<SysUserInfoDto> localThread = new ThreadLocal<>();

    public static void setUser(SysUserInfoDto sysUserInfoDto){
        localThread.set(sysUserInfoDto);
    }

    public static SysUserInfoDto getUser(){
        return localThread.get();
    }

}
