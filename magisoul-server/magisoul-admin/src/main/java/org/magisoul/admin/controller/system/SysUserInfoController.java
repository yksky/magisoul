package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysUserInfoApi;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysUserInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class SysUserInfoController {

    @Autowired
    private ISysUserInfoApi sysUserInfoApi ;

    @PostMapping("/merge")
    public String merge(SysUserInfoDto sysUserInfoDto){
        RespData<String> resp = this.sysUserInfoApi.mergeForm(sysUserInfoDto);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/getById")
    public String getById(Long id){
        RespData<SysUserInfoDto> resp = this.sysUserInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/pageList")
    public String pageList(QuerySysUserInfoVo querySysUserInfoVo){
        RespData<Pagination<SysUserInfoDto>> resp = this.sysUserInfoApi.pageList(querySysUserInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/enable")
    public String enable(SysUserInfoDto sysUserInfoDto){
        RespData<String> resp = this.sysUserInfoApi.enable(sysUserInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/disable")
    public String disable(SysUserInfoDto sysUserInfoDto){
        RespData<String> resp = this.sysUserInfoApi.disable(sysUserInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/deleteById")
    public String deleteById(SysUserInfoDto sysUserInfoDto){
        RespData<String> resp = this.sysUserInfoApi.deleteById(sysUserInfoDto);
        return JSON.toJSONString(resp);
    }
}
