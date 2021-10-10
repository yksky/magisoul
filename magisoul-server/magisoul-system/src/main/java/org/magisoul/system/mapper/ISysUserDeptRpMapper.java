package org.magisoul.system.mapper;

import org.apache.ibatis.annotations.Param;
import org.magisoul.system.entity.SysUserDeptRp;

import java.util.List;

public interface ISysUserDeptRpMapper {

    public Integer add(SysUserDeptRp sysUserDeptRp);

    public Integer delete(SysUserDeptRp sysUserDeptRp);

    public List<SysUserDeptRp> list(@Param("userId")Long userId,@Param("deptId")Long deptId);

}
