package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysRoleInfoApi;
import org.magisoul.system.model.dto.SysRoleInfoDto;
import org.magisoul.system.model.query.QuerySysRoleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system/role")
public class SysRoleInfoController {

    @Autowired
    private ISysRoleInfoApi sysRoleInfoApi ;

    @PostMapping("/merge")
    public String merge(@RequestBody SysRoleInfoDto sysRoleInfoDto){
        RespData<String> resp = this.sysRoleInfoApi.mergeForm(sysRoleInfoDto);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/getById")
    public String getById(Long id){
        RespData<SysRoleInfoDto> resp = this.sysRoleInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/pageList")
    public String pageList(QuerySysRoleInfoVo querySysRoleInfoVo){
        RespData<Pagination<SysRoleInfoDto>> resp = this.sysRoleInfoApi.pageList(querySysRoleInfoVo);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/enable")
    public String enable(@RequestBody SysRoleInfoDto sysRoleInfoDto){
        RespData<String> resp = this.sysRoleInfoApi.enable(sysRoleInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/disable")
    public String disable(@RequestBody SysRoleInfoDto sysRoleInfoDto){
        RespData<String> resp = this.sysRoleInfoApi.disable(sysRoleInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/deleteById")
    public String deleteById(Long id){
        SysRoleInfoDto sysRoleInfoDto = new SysRoleInfoDto();
        sysRoleInfoDto.setId(id);
        RespData<String> resp = this.sysRoleInfoApi.mergeForm(sysRoleInfoDto);
        return JSON.toJSONString(resp);
    }
}
