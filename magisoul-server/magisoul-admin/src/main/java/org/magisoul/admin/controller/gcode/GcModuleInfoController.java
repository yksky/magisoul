package org.magisoul.admin.controller.gcode;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcModuleInfoApi;
import org.magisoul.gcode.model.dto.GcModuleInfoDto;
import org.magisoul.gcode.model.query.QueryGcModuleInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/gcode/module")
public class GcModuleInfoController {

    @Autowired
    private IGcModuleInfoApi gcModuleInfoApi ;

    @RequestMapping("/merge")
    public String merge(@RequestBody GcModuleInfoDto gcModuleInfoDto){
        RespData<String> resp = this.gcModuleInfoApi.merge(gcModuleInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/updateById")
    public String updateById(@RequestBody GcModuleInfoDto gcModuleInfoDto){
        RespData<String> resp = this.gcModuleInfoApi.updateById(gcModuleInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/getById")
    public String getById(Long id){
        RespData<GcModuleInfoDto> resp = this.gcModuleInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/list")
    public String list(QueryGcModuleInfoVo queryGcModuleInfoVo){
        RespData<List<GcModuleInfoDto>> resp = this.gcModuleInfoApi.list(queryGcModuleInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/pageList")
    public String pageList(QueryGcModuleInfoVo queryGcModuleInfoVo){
        RespData<Pagination<GcModuleInfoDto>> resp = this.gcModuleInfoApi.pageList(queryGcModuleInfoVo);
        return JSON.toJSONString(resp);
    }
}
