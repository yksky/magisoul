package org.magisoul.system.service;

import org.magisoul.system.entity.SysUserRoleRp;
import org.magisoul.util.model.RespData;

import java.util.List;

public interface ISysUserRoleRpService {

    /**
     * 从用户侧进行用户角色更新操作
     * @param userId 用户Id
     * @param roleIdsList 角色Id集合
     * @return
     */
    public RespData<String> updateByUserId(Long userId,List<Long> roleIdsList);

    /**
     * 从角色侧进行用户角色更新操作
     * @param roleId 角色Id
     * @param userIdsList 用户Id集合
     * @return
     */
    public RespData<String> updateByRoleId(Long roleId,List<Long> userIdsList);

}
