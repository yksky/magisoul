package org.magisoul.admin.controller.gcode;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcTableInfoApi;
import org.magisoul.gcode.model.dto.GcTableInfoDto;
import org.magisoul.gcode.model.query.QueryGcTableInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/gcode/table")
public class GcTableInfoController {

    @Autowired
    private IGcTableInfoApi gcTableInfoApi ;

    @RequestMapping("/updateForm")
    public String updateForm(@RequestBody GcTableInfoDto gcTableInfoDto){
        RespData<String> resp = this.gcTableInfoApi.updateForm(gcTableInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/getById")
    public String getById(Long id){
        RespData<GcTableInfoDto> resp = this.gcTableInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/list")
    public String list(QueryGcTableInfoVo queryGcTableInfoVo){
        RespData<List<GcTableInfoDto>> resp = this.gcTableInfoApi.list(queryGcTableInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/pageList")
    public String pageList(QueryGcTableInfoVo queryGcTableInfoVo){
        RespData<Pagination<GcTableInfoDto>> resp = this.gcTableInfoApi.pageList(queryGcTableInfoVo);
        return JSON.toJSONString(resp);
    }
}
