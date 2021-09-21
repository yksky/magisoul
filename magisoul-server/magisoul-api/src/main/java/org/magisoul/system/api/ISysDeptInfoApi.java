package org.magisoul.system.api;

import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.util.model.RespData;

public interface ISysDeptInfoApi {
	
	public RespData<String> addSysDeptInfo(SysDeptInfoDto sysDeptInfoDto);
	
	public RespData<String> updateSysDeptInfoForm(SysDeptInfoDto sysDeptInfoDto);
	
	public RespData<String> updateSysDeptInfoById(SysDeptInfoDto sysDeptInfoDto);

}
