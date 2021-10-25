package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.system.api.ISysDictItemInfoApi;
import org.magisoul.system.model.dto.SysDictItemInfoDto;
import org.magisoul.system.model.query.QuerySysDictItemInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dictItem")
public class SysDictItemInfoController {

    @Autowired
    private ISysDictItemInfoApi sysDictItemInfoApi ;

    @RequestMapping("/merge")
    public String merge(@RequestBody SysDictItemInfoDto sysDictItemInfoDto){
        RespData<String> resp = this.sysDictItemInfoApi.mergeForm(sysDictItemInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/getById")
    public String getById(Long id){
        RespData<SysDictItemInfoDto> resp = this.sysDictItemInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/pageList")
    public String pageList(QuerySysDictItemInfoVo querySysDictItemInfoVo){
        RespData<Pagination<SysDictItemInfoDto>> resp = this.sysDictItemInfoApi.pageList(querySysDictItemInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/enable")
    public String enable(@RequestBody SysDictItemInfoDto sysDictItemInfoDto){
        RespData<String> resp = this.sysDictItemInfoApi.enable(sysDictItemInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/disable")
    public String disable(@RequestBody SysDictItemInfoDto sysDictItemInfoDto){
        RespData<String> resp = this.sysDictItemInfoApi.disable(sysDictItemInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/deleteById")
    public String deleteById(Long id){
        SysDictItemInfoDto sysDictItemInfoDto = new SysDictItemInfoDto();
        sysDictItemInfoDto.setId(id);
        RespData<String> resp = this.sysDictItemInfoApi.deleteById(sysDictItemInfoDto);
        return JSON.toJSONString(resp);
    }
}
