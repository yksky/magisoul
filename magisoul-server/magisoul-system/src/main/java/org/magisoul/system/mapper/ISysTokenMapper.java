package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysToken;

public interface ISysTokenMapper {

    public Integer add(SysToken sysToken);

    public Integer update(SysToken sysToken);

    public Integer deleteByToken(@Param("token")String token);

    public Integer deleteByUserId(@Param("userId")Long userId);

    public SysToken getByToken(@Param("token")String token);

}
