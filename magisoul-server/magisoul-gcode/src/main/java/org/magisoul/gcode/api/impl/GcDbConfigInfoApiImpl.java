package org.magisoul.gcode.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcDbConfigInfoApi;
import org.magisoul.gcode.model.dto.GcDbConfigInfoDto;
import org.magisoul.gcode.model.query.QueryGcDbConfigInfoVo;
import org.magisoul.gcode.service.IGcDbConfigInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gcDbConfigInfoApi")
public class GcDbConfigInfoApiImpl implements IGcDbConfigInfoApi {

    @Autowired
    private IGcDbConfigInfoService gcDbConfigInfoService ;

    Logger logger = LoggerFactory.getLogger(GcDbConfigInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(GcDbConfigInfoDto gcDbConfigInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            if(gcDbConfigInfoDto.getId()==null){
                resp = this.gcDbConfigInfoService.add(gcDbConfigInfoDto);
            }else{
                resp = this.gcDbConfigInfoService.updateForm(gcDbConfigInfoDto);
            }
            logger.info("类名:{},方法名:{},参数:[gcDbConfigInfoDto:{}],编辑数据源信息正常,结果信息:{}",
                    "GcDbConfigInfoApiImpl","mergeForm", JSON.toJSONString(gcDbConfigInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcDbConfigInfoDto:{}],编辑数据源信息异常,异常信息:{}",
                    "GcDbConfigInfoApiImpl","mergeForm", JSON.toJSONString(gcDbConfigInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> updateById(GcDbConfigInfoDto gcDbConfigInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.gcDbConfigInfoService.updateById(gcDbConfigInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcDbConfigInfoDto:{}],根据Id更新数据源信息正常,结果信息:{}",
                    "GcDbConfigInfoApiImpl","updateById", JSON.toJSONString(gcDbConfigInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcDbConfigInfoDto:{}],根据Id更新数据源信息异常,异常信息:{}",
                    "GcDbConfigInfoApiImpl","updateById", JSON.toJSONString(gcDbConfigInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<GcDbConfigInfoDto> getById(Long id) {
        RespData<GcDbConfigInfoDto> resp = new RespData<>();
        try{
            resp = this.gcDbConfigInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取数据源信息正常,结果信息:{}",
                    "GcDbConfigInfoApiImpl","getById", id,JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取数据源信息异常,异常信息:{}",
                    "GcDbConfigInfoApiImpl","getById", id,e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<GcDbConfigInfoDto>> list(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo) {
        RespData<List<GcDbConfigInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcDbConfigInfoService.list(queryGcDbConfigInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcDbConfigInfoVo:{}],根据条件获取数据源不分页信息正常,结果信息:{}",
                    "GcDbConfigInfoApiImpl","list", JSON.toJSONString(queryGcDbConfigInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcDbConfigInfoVo:{}],根据条件获取数据源不分页信息异常,异常信息:{}",
                    "GcDbConfigInfoApiImpl","list", JSON.toJSONString(queryGcDbConfigInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<Pagination<GcDbConfigInfoDto>> pageList(QueryGcDbConfigInfoVo queryGcDbConfigInfoVo) {
        RespData<Pagination<GcDbConfigInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcDbConfigInfoService.pageList(queryGcDbConfigInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcDbConfigInfoVo:{}],根据条件获取数据源分页信息正常,结果信息:{}",
                    "GcDbConfigInfoApiImpl","pageList", JSON.toJSONString(queryGcDbConfigInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcDbConfigInfoVo:{}],根据条件获取数据源分页信息异常,异常信息:{}",
                    "GcDbConfigInfoApiImpl","pageList", JSON.toJSONString(queryGcDbConfigInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }
}
