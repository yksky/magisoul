package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysResourceInfoApi;
import org.magisoul.system.model.dto.SysResourceInfoDto;
import org.magisoul.system.model.query.QuerySysResourceInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system/resource")
public class SysResourceInfoController {

    @Autowired
    private ISysResourceInfoApi sysResourceInfoApi ;

    @PostMapping("/merge")
    public String merge(@RequestBody SysResourceInfoDto sysResourceInfoDto){
        RespData<String> resp = this.sysResourceInfoApi.mergeForm(sysResourceInfoDto);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/getById")
    public String getById(Long id){
        RespData<SysResourceInfoDto> resp = this.sysResourceInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/pageList")
    public String pageList(QuerySysResourceInfoVo querySysResourceInfoVo){
        RespData<Pagination<SysResourceInfoDto>> resp = this.sysResourceInfoApi.pageList(querySysResourceInfoVo);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/enable")
    public String enable(SysResourceInfoDto sysResourceInfoDto){
        RespData<String> resp = this.sysResourceInfoApi.enable(sysResourceInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/disable")
    public String disable(SysResourceInfoDto sysResourceInfoDto){
        RespData<String> resp = this.sysResourceInfoApi.disable(sysResourceInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/deleteById")
    public String deleteById(Long id){
        SysResourceInfoDto sysResourceInfoDto = new SysResourceInfoDto();
        sysResourceInfoDto.setId(id);
        RespData<String> resp = this.sysResourceInfoApi.enable(sysResourceInfoDto);
        return JSON.toJSONString(resp);
    }
}
