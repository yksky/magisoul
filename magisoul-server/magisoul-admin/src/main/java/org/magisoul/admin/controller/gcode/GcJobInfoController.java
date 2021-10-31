package org.magisoul.admin.controller.gcode;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcJobInfoApi;
import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.query.QueryGcJobInfoVo;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/gcode/job")
public class GcJobInfoController {

    @Autowired
    private IGcJobInfoApi gcJobInfoApi ;

    @RequestMapping("/merge")
    public String merge(@RequestBody GcJobInfoDto gcJobInfoDto){
        RespData<String> resp = this.gcJobInfoApi.mergeForm(gcJobInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/updateById")
    public String updateById(@RequestBody GcJobInfoDto gcJobInfoDto){
        RespData<String> resp = this.gcJobInfoApi.updateById(gcJobInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/getById")
    public String getById(Long id){
        RespData<GcJobInfoDto> resp = this.gcJobInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/list")
    public String list(QueryGcJobInfoVo queryGcJobInfoVo){
        RespData<List<GcJobInfoDto>> resp = this.gcJobInfoApi.list(queryGcJobInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/pageList")
    public String pageList(QueryGcJobInfoVo queryGcJobInfoVo){
        RespData<Pagination<GcJobInfoDto>> resp = this.gcJobInfoApi.pageList(queryGcJobInfoVo);
        return JSON.toJSONString(resp);
    }
 }
