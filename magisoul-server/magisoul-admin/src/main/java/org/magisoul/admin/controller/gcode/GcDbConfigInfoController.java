package org.magisoul.admin.controller.gcode;

import com.alibaba.fastjson.JSON;
import org.magisoul.admin.context.UserContext;
import org.magisoul.gcode.api.IGcDbConfigInfoApi;
import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.query.QueryGcDbConfigInfoVo;
import org.magisoul.system.model.dto.SysUserInfoDto;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/gcode/dbConfig")
public class GcDbConfigInfoController {

    @Autowired
    private IGcDbConfigInfoApi gcDbConfigInfoApi ;

    @RequestMapping("/merge")
    public String merge(@RequestBody GcDbConfigInfoDto gcDbConfigInfoDto){
        SysUserInfoDto loginUserDto = UserContext.getUser();
        gcDbConfigInfoDto.setCreator(loginUserDto.getUsername());
        gcDbConfigInfoDto.setUpdator(loginUserDto.getUsername());
        RespData<String> resp = this.gcDbConfigInfoApi.mergeForm(gcDbConfigInfoDto);
        return JSON.toJSONString(resp) ;
    }

    @RequestMapping("/updateById")
    public String updateById(@RequestBody GcDbConfigInfoDto gcDbConfigInfoDto){
        SysUserInfoDto loginUserDto = UserContext.getUser();
        gcDbConfigInfoDto.setCreator(loginUserDto.getUsername());
        gcDbConfigInfoDto.setUpdator(loginUserDto.getUsername());
        RespData<String> resp = this.gcDbConfigInfoApi.updateById(gcDbConfigInfoDto);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/getById")
    public String getById(Long id){
        RespData<GcDbConfigInfoDto> resp = this.gcDbConfigInfoApi.getById(id);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/list")
    public String list(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo){
        RespData<List<GcDbConfigInfoDto>> resp = this.gcDbConfigInfoApi.list(queryGcDbConfigInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/listDefault")
    public String listDefault(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo){
        RespData<List<GcDbConfigInfoDto>> resp = this.gcDbConfigInfoApi.listDefault(queryGcDbConfigInfoVo);
        return JSON.toJSONString(resp);
    }

    @RequestMapping("/pageList")
    public String pageList(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo){
        RespData<Pagination<GcDbConfigInfoDto>> resp = this.gcDbConfigInfoApi.pageList(queryGcDbConfigInfoVo);
        return JSON.toJSONString(resp);
    }
}
