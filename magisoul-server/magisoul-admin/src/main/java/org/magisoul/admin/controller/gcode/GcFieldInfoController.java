package org.magisoul.admin.controller.gcode;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcFieldInfoApi;
import org.magisoul.gcode.model.dto.GcFieldInfoDto;
import org.magisoul.gcode.model.query.QueryGcFieldInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/gcode/field")
public class GcFieldInfoController {

    @Autowired
    private IGcFieldInfoApi gcFieldInfoApi ;

    @RequestMapping("/updateForm")
    public String updateForm(@RequestBody GcFieldInfoDto gcFieldInfoDto){
        RespData<String> resp = this.gcFieldInfoApi.updateForm(gcFieldInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/getById")
    public String getById(Long id){
        RespData<GcFieldInfoDto> resp = this.gcFieldInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/list")
    public String list(QueryGcFieldInfoVo queryGcFieldInfoVo){
        RespData<List<GcFieldInfoDto>> resp = this.gcFieldInfoApi.list(queryGcFieldInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/pageList")
    public String pageList(QueryGcFieldInfoVo queryGcFieldInfoVo){
        RespData<Pagination<GcFieldInfoDto>> resp = this.gcFieldInfoApi.pageList(queryGcFieldInfoVo);
        return JSON.toJSONString(resp);
    }
}
