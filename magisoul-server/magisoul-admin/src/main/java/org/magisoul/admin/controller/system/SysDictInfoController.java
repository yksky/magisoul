package org.magisoul.admin.controller.system;

import com.alibaba.fastjson.JSON;
import org.magisoul.admin.context.UserContext;
import org.magisoul.system.api.ISysDictInfoApi;
import org.magisoul.system.model.dto.SysDictInfoDto;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.system.model.query.QuerySysDictInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/dict")
public class SysDictInfoController {

    @Autowired
    private ISysDictInfoApi sysDictInfoApi ;

    @PostMapping("/merge")
    public String merge(@RequestBody SysDictInfoDto sysDictInfoDto){
        SysUserInfoDto loginDto = UserContext.getUser();
        sysDictInfoDto.setCreator(loginDto.getUsername());
        sysDictInfoDto.setUpdator(loginDto.getUsername());
        RespData<String> resp = this.sysDictInfoApi.mergeForm(sysDictInfoDto);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/getById")
    public String getById(Long id){
        RespData<SysDictInfoDto> resp = this.sysDictInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/pageList")
    public String pageList(QuerySysDictInfoVo querySysDictInfoVo){
        RespData<Pagination<SysDictInfoDto>> resp = this.sysDictInfoApi.pageList(querySysDictInfoVo);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/enable")
    public String enable(@RequestBody SysDictInfoDto sysDictInfoDto){
        SysUserInfoDto loginDto = UserContext.getUser();
        sysDictInfoDto.setCreator(loginDto.getUsername());
        sysDictInfoDto.setUpdator(loginDto.getUsername());
        RespData<String> resp = this.sysDictInfoApi.enable(sysDictInfoDto);
        return JSON.toJSONString(resp);
    }

    @PostMapping("/disable")
    public String disable(@RequestBody SysDictInfoDto sysDictInfoDto){
        SysUserInfoDto loginDto = UserContext.getUser();
        sysDictInfoDto.setCreator(loginDto.getUsername());
        sysDictInfoDto.setUpdator(loginDto.getUsername());
        RespData<String> resp = this.sysDictInfoApi.disable(sysDictInfoDto);
        return JSON.toJSONString(resp);
    }

    @GetMapping("/deleteById")
    public String deleteById(Long id){
        SysDictInfoDto sysDictInfoDto = new SysDictInfoDto();
        sysDictInfoDto.setId(id);

        SysUserInfoDto loginDto = UserContext.getUser();
        sysDictInfoDto.setCreator(loginDto.getUsername());
        sysDictInfoDto.setUpdator(loginDto.getUsername());

        RespData<String> resp = this.sysDictInfoApi.deleteById(sysDictInfoDto);
        return JSON.toJSONString(resp);
    }
}
