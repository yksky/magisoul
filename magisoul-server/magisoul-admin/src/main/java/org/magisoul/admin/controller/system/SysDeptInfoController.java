package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysDeptInfoApi;
import org.magisoul.system.model.dto.SysDeptInfoDto;
import org.magisoul.system.model.query.QuerySysDeptInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dept")
public class SysDeptInfoController {

    @Autowired
    private ISysDeptInfoApi sysDeptInfoApi ;

    @PostMapping("/merge")
    public String merge(@RequestBody SysDeptInfoDto sysDeptInfoDto){
        RespData<String> resp = this.sysDeptInfoApi.mergeForm(sysDeptInfoDto);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/getById")
    public String getById(Long id){
        RespData<SysDeptInfoDto> resp = this.sysDeptInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/list")
    public String list(QuerySysDeptInfoVo querySysDeptInfoVo){
        RespData<List<SysDeptInfoDto>> resp = this.sysDeptInfoApi.list(querySysDeptInfoVo);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/pageList")
    public String pageList(QuerySysDeptInfoVo querySysDeptInfoVo){
        RespData<Pagination<SysDeptInfoDto>> resp = this.sysDeptInfoApi.pageList(querySysDeptInfoVo);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/enable")
    public String enable(SysDeptInfoDto sysDeptInfoDto){
        RespData<String> resp = this.sysDeptInfoApi.enable(sysDeptInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/disable")
    public String disable(SysDeptInfoDto sysDeptInfoDto){
        RespData<String> resp = this.sysDeptInfoApi.disable(sysDeptInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/deleteById")
    public String deleteById(SysDeptInfoDto sysDeptInfoDto){
        RespData<String> resp = this.sysDeptInfoApi.deleteById(sysDeptInfoDto);
        return JSON.toJSONString(resp);
    }
}
