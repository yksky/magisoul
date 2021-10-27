package org.magisoul.gcode.api.impl;

import com.alibaba.fastjson.JSON;
import org.magisoul.gcode.api.IGcTableInfoApi;
import org.magisoul.gcode.model.dto.GcJobInfoDto;
import org.magisoul.gcode.model.dto.GcTableInfoDto;
import org.magisoul.gcode.model.query.QueryGcTableInfoVo;
import org.magisoul.gcode.service.IGcTableInfoService;
import org.magisoul.util.model.Pagination;
import org.magisoul.util.model.RespData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gcTableInfoApi")
public class GcTableInfoApiImpl implements IGcTableInfoApi {

    @Autowired
    private IGcTableInfoService gcTableInfoService ;

    Logger logger = LoggerFactory.getLogger(GcTableInfoApiImpl.class);

    @Override
    public RespData<String> mergeForm(GcTableInfoDto gcTableInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.gcTableInfoService.updateForm(gcTableInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcTableInfoDto:{}],编辑Table信息正常,结果信息:{}",
                    "GcTableInfoApiImpl","mergeForm", JSON.toJSONString(gcTableInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcTableInfoDto:{}],编辑Table信息异常,异常信息:{}",
                    "GcTableInfoApiImpl","mergeForm", JSON.toJSONString(gcTableInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<String> updateById(GcTableInfoDto gcTableInfoDto) {
        RespData<String> resp = new RespData<>();
        try{
            resp = this.gcTableInfoService.updateById(gcTableInfoDto);
            logger.info("类名:{},方法名:{},参数:[gcJobInfoDto:{}],根据Id更新Table信息正常,结果信息:{}",
                    "GcTableInfoApiImpl","updateById", JSON.toJSONString(gcTableInfoDto),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[gcJobInfoDto:{}],根据Id更新Table信息异常,异常信息:{}",
                    "GcTableInfoApiImpl","updateById", JSON.toJSONString(gcTableInfoDto),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<GcTableInfoDto> getById(Long id) {
        RespData<GcTableInfoDto> resp = new RespData<>();
        try{
            resp = this.gcTableInfoService.getById(id);
            logger.info("类名:{},方法名:{},参数:[id:{}],根据Id获取Table信息正常,结果信息:{}",
                    "GcTableInfoApiImpl","getById", id,JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[id:{}],根据Id获取Table信息异常,异常信息:{}",
                    "GcTableInfoApiImpl","getById", id,e);
            resp.buildFail();
        }
        return resp;
    }

    @Override
    public RespData<List<GcTableInfoDto>> list(QueryGcTableInfoVo queryGcTableInfoVo) {
        RespData<List<GcTableInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcTableInfoService.list(queryGcTableInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcTableInfoVo:{}],根据条件获取Table不分页信息正常,结果信息:{}",
                    "GcTableInfoApiImpl","list", JSON.toJSONString(queryGcTableInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},参数:[queryGcTableInfoVo:{}],根据条件获取Table不分页信息异常,异常信息:{}",
                    "GcTableInfoApiImpl","list", JSON.toJSONString(queryGcTableInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }

    @Override
    public RespData<Pagination<GcTableInfoDto>> pageList(QueryGcTableInfoVo queryGcTableInfoVo) {
        RespData<Pagination<GcTableInfoDto>> resp = new RespData<>();
        try{
            resp = this.gcTableInfoService.pageList(queryGcTableInfoVo);
            logger.info("类名:{},方法名:{},参数:[queryGcTableInfoVo:{}],根据条件获取Table分页信息正常,结果信息:{}",
                    "GcTableInfoApiImpl","pageList", JSON.toJSONString(queryGcTableInfoVo),JSON.toJSONString(resp));
        }catch(Exception e){
            logger.error("类名:{},方法名:{},pageList:[queryGcTableInfoVo:{}],根据条件获取Table分页信息异常,异常信息:{}",
                    "GcTableInfoApiImpl","list", JSON.toJSONString(queryGcTableInfoVo),e);
            resp.buildFail();
        }
        return resp ;
    }
}
