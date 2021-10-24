package org.magisoul.system.service;

import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.util.model.RespData;

import java.awt.geom.RectangularShape;

public interface ITokenService {

    public RespData<SysUserInfoDto> checkToken(String token);

}
