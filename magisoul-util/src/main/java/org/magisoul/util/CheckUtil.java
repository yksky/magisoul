package org.magisoul.util;

import org.magisoul.util.enums.RespCodeEnum;
import org.magisoul.util.model.CheckParamVo;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckUtil {

    private static DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Map<String,Object> checkParamData(List<CheckParamVo> paramList){
        Map<String,Object> checkMap = new HashMap<String,Object>();
        for(int i=0;i<paramList.size();i++) {
            CheckParamVo vo = paramList.get(i);
            Map<String,Object> cmap = checkParam(vo);
            if(cmap==null) {
                checkMap.put("code", RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                checkMap.put("message", "字段["+vo.getFieldName()+"]["+vo.getCnFieldName()+"]不在指定数据范围内,请重新输入");
                return checkMap ;
            }else {
                String code = String.valueOf(cmap.get("code"));
                if(!code.trim().equals(RespCodeEnum.SUCCESS.getCode())) {
                    checkMap.put("code", code);
                    checkMap.put("message", String.valueOf(cmap.get("message")));
                    return checkMap ;
                }
            }
        }

        checkMap.put("code", RespCodeEnum.SUCCESS.getCode());
        checkMap.put("message", RespCodeEnum.SUCCESS.getMessage());
        return checkMap ;
    }

    private static Map<String,Object> checkParam(CheckParamVo checkParamVo){
        String fieldType = checkParamVo.getFieldType();
        if(fieldType.trim().equals("string")) {
            return checkStringParam(checkParamVo);
        }
        if(fieldType.trim().equals("int") || fieldType.trim().equals("integer")) {
            return checkIntParam(checkParamVo);
        }
        if(fieldType.trim().equals("bigdecimal")) {
            return checkBigDecimalParam(checkParamVo);
        }
        if(fieldType.trim().equals("time") || fieldType.trim().equals("date")) {
            return checkTimeParam(checkParamVo);
        }
        return null ;
    }

    /**
     * 校验参数为string类型的值
     * @param checkParamVo 校验参数
     * @return Map<String,Object> key:code,message<p>
     *   如果校验通过,code为200;否则值为500,message为未通过信息
     */
    private static Map<String, Object> checkStringParam(CheckParamVo checkParamVo){
        Map<String, Object> checkMap = new HashMap<String,Object>();

        Object fieldValue = checkParamVo.getFieldValue();
        String cnFieldName = checkParamVo.getCnFieldName();
        String fieldName = checkParamVo.getFieldName();

        //不能为空
        if(checkParamVo.getIsNull()==false) {
            if(fieldValue==null || String.valueOf(fieldValue).trim().equals("")) {
                checkMap.put("code", RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
                checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]不能为空,请重新输入");
                return checkMap ;
            }
        }

        //校验长度
        if(checkParamVo.getIsCheckLength()==true) {
            if(fieldValue!=null) {
                if(String.valueOf(fieldValue).trim().length()>checkParamVo.getLength()) {
                    checkMap.put("code", RespCodeEnum.PARAM_LENGTH_ERROR_CODE.getCode());
                    checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]的值超过"+checkParamVo.getLength()+",请重新输入");
                    return checkMap ;
                }
            }
        }

        checkMap.put("code", "200");
        checkMap.put("message", "success");
        return checkMap ;
    }

    /**
     * 检测参数为int的值
     * @param checkParamVo 校验参数
     * @return Map<String,Object>
     */
    private static Map<String, Object> checkIntParam(CheckParamVo checkParamVo){
        Map<String, Object> checkMap = new HashMap<String,Object>();

        Object fieldValue = checkParamVo.getFieldValue();
        String cnFieldName = checkParamVo.getCnFieldName();
        String fieldName = checkParamVo.getFieldName();

        if(checkParamVo.getIsNull()==false) {
            if(fieldValue==null) {
                checkMap.put("code", RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
                checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]不能为空,请重新输入");
                return checkMap ;
            }
        }

        if(fieldValue!=null) {
            if(ObjectUtil.isInt(fieldValue)==false) {
                checkMap.put("code", RespCodeEnum.PARAM_ONLY_NUMBER_CODE.getCode());
                checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]不是数字类型,请重新输入");
                return checkMap ;
            }
            Integer intValue = Integer.parseInt(String.valueOf(fieldValue));

            //检测intValue的值是否超过最大值
            if(checkParamVo.getIsCheckMax()==true) {
                if(ObjectUtil.isInt(checkParamVo.getMaxValue())==false) {
                    checkMap.put("code", RespCodeEnum.PARAM_ONLY_NUMBER_CODE.getCode());
                    checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]的最大值不是数字类型,请重新输入");
                    return checkMap ;
                }
                Integer maxValue = Integer.parseInt(checkParamVo.getMaxValue());
                if(intValue>maxValue.intValue()) {
                    checkMap.put("code",RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                    checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]的值["+intValue+"]不能超过最大值["+maxValue+"],请重新输入");
                    return checkMap ;
                }
            }

            //检测intValue的值是否小于最低值
            if(checkParamVo.getIsCheckMin()==true) {
                if(ObjectUtil.isInt(checkParamVo.getMinValue())==false) {
                    checkMap.put("code", RespCodeEnum.PARAM_ONLY_NUMBER_CODE.getCode());
                    checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]的最小值不是数字类型,请重新输入");
                    return checkMap ;
                }
                Integer minValue = Integer.parseInt(checkParamVo.getMinValue());
                if(intValue<minValue.intValue()) {
                    checkMap.put("code",RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                    checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]的值["+intValue+"]不能小于最小值["+minValue+"],请重新输入");
                    return checkMap ;
                }
            }
        }

        checkMap.put("code", "200");
        checkMap.put("message", "success");
        return checkMap ;
    }

    /**
     * 校验浮点数据类型
     * @param checkParamVo 校验参数
     * @return Map<String,Object>
     */
    private static Map<String,Object> checkBigDecimalParam(CheckParamVo checkParamVo){
        Map<String,Object> checkMap = new HashMap<String,Object>();

        Object fieldValue = checkParamVo.getFieldValue();
        String cnFieldName = checkParamVo.getCnFieldName();
        String fieldName = checkParamVo.getFieldName();

        if(checkParamVo.getIsNull()==false) {
            if(fieldValue==null) {
                checkMap.put("code", RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
                checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]为空,请重新输入");
                return checkMap ;
            }
        }

        if(fieldValue!=null) {
            if(ObjectUtil.isBigDecimal(fieldValue)==false) {
                checkMap.put("code", RespCodeEnum.PARAM_ONLY_DECIMAL_CODE.getCode());
                checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]不是浮点类型,请重新输入");
                return checkMap ;
            }
            String fv = String.valueOf(fieldValue);

            //判断小数点位数
            int index = fv.indexOf(".");
            if(index!=-1) {
                int len = fv.substring(index+1, fv.length()).length();
                if(len>checkParamVo.getPoint()) {
                    checkMap.put("code",RespCodeEnum.PARAM_LENGTH_DECIMAL_PLACES_CODE.getCode());
                    checkMap.put("message","字段["+fieldName+"]["+cnFieldName+"]最多只能有"+checkParamVo.getPoint()+"位小数");
                    return checkMap ;
                }
            }

            //判断最大最小值
            BigDecimal bd = new BigDecimal(fv);
            if(checkParamVo.getIsCheckMax()==true) {
                BigDecimal maxBd = new BigDecimal(checkParamVo.getMaxValue());
                int ctb = bd.compareTo(maxBd);
                if(ctb==1) {
                    checkMap.put("code",RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                    checkMap.put("message","字段["+fieldName+"]["+cnFieldName+"]的值["+fieldValue+"]不能大于值["+checkParamVo.getMaxValue()+"],请重新输入");
                    return checkMap ;
                }
            }
            if(checkParamVo.getIsCheckMin()==true) {
                BigDecimal minBd = new BigDecimal(checkParamVo.getMinValue());
                int ctb = bd.compareTo(minBd);
                if(ctb==-1) {
                    checkMap.put("code",RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                    checkMap.put("message","字段["+fieldName+"]["+cnFieldName+"]的值["+fieldValue+"]不能小于值["+checkParamVo.getMinValue()+"],请重新输入");
                    return checkMap ;
                }
            }
        }

        checkMap.put("code", "200");
        checkMap.put("message", "success");
        return checkMap ;
    }

    /**
     * 检测时间(yyyy-MM-dd HH:mm:ss)的数据
     * @param checkParamVo 校验参数
     * @return Map<String,Object>
     */
    private static Map<String,Object> checkTimeParam(CheckParamVo checkParamVo){
        Map<String,Object> checkMap = new HashMap<String,Object>();

        Object fieldValue = checkParamVo.getFieldValue();
        String cnFieldName = checkParamVo.getCnFieldName();
        String fieldName = checkParamVo.getFieldName();

        if(checkParamVo.getIsNull()==false) {
            if(fieldValue==null || String.valueOf(fieldValue).trim().equals("")) {
                checkMap.put("code", RespCodeEnum.PARAM_EMPTY_ERROR_CODE.getCode());
                checkMap.put("message", "字段["+fieldName+"]["+cnFieldName+"]为空,请重新输入");
                return checkMap ;
            }
        }

        if(fieldValue!=null && !String.valueOf(fieldValue).trim().equals("")) {
            String fieldType = checkParamVo.getFieldType();

            Map<String,Object> checkTimeMap = new HashMap<String,Object>();
            String message = "";
            String messageMax = "";
            String messageMin = "";
            String formatType = "";
            if(fieldType.trim().equals("time")) {
                formatType = "02";
                checkTimeMap = ObjectUtil.isDate(timeFormat, fieldValue, "02");
                message = "字段["+fieldName+"]["+cnFieldName+"]的值["+fieldValue+"]不是精确到秒的时间类型[yyyy-MM-dd HH:mm:ss]";
                messageMax = "字段["+fieldName+"]["+cnFieldName+"]的最大值["+fieldValue+"]不是精确到秒的时间类型[yyyy-MM-dd HH:mm:ss]";
                messageMin = "字段["+fieldName+"]["+cnFieldName+"]的最小值["+fieldValue+"]不是精确到秒的时间类型[yyyy-MM-dd HH:mm:ss]";
            }else if(fieldType.trim().equals("date")) {
                formatType = "01";
                checkTimeMap = ObjectUtil.isDate(dateFormat, fieldValue, "01");
                message = "字段["+fieldName+"]["+cnFieldName+"]的值["+fieldValue+"]不是精确到天的时间类型[yyyy-MM-dd]";
                messageMax = "字段["+fieldName+"]["+cnFieldName+"]的最大值["+fieldValue+"]不是精确到天的时间类型[yyyy-MM-dd]";
                messageMin = "字段["+fieldName+"]["+cnFieldName+"]的最小值["+fieldValue+"]不是精确到天的时间类型[yyyy-MM-dd]";
            }

            if(!String.valueOf(checkTimeMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())) {
                checkMap.put("message", message);
                checkMap.put("code", String.valueOf(checkTimeMap.get("code")));
                return checkMap ;
            }

            Date d = (Date)checkTimeMap.get("data");
            if(checkParamVo.getIsCheckMax()==true) {
                Map<String,Object> checkMaxTimeMap = new HashMap<String,Object>();
                if(formatType.trim().equals("01")) {
                    checkMaxTimeMap = ObjectUtil.isDate(dateFormat, checkParamVo.getMaxValue(), "01");
                }else {
                    checkMaxTimeMap = ObjectUtil.isDate(timeFormat, checkParamVo.getMaxValue(), "02");
                }
                if(!String.valueOf(checkMaxTimeMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())) {
                    checkMap.put("code", String.valueOf(checkMaxTimeMap.get("code")));
                    checkMap.put("message", messageMax);
                    return checkMap ;
                }
                Date maxTime = (Date)checkMaxTimeMap.get("data");
                if(d.getTime()>maxTime.getTime()) {
                    checkMap.put("code",RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                    checkMap.put("message","字段["+fieldName+"]["+cnFieldName+"]的值["+fieldValue+"]不能大于最大值["+
                            checkParamVo.getMaxValue()+"],请重新输入");
                    return checkMap ;
                }
            }

            if(checkParamVo.getIsCheckMin()==true) {
                Map<String,Object> checkMinTimeMap = new HashMap<String,Object>();
                if(formatType.trim().equals("01")) {
                    checkMinTimeMap = ObjectUtil.isDate(dateFormat, checkParamVo.getMinValue(), "01");
                }else {
                    checkMinTimeMap = ObjectUtil.isDate(timeFormat, checkParamVo.getMinValue(), "02");
                }
                if(!String.valueOf(checkMinTimeMap.get("code")).trim().equals(RespCodeEnum.SUCCESS.getCode())) {
                    checkMap.put("code", String.valueOf(checkMinTimeMap.get("code")));
                    checkMap.put("message", messageMin);
                    return checkMap ;
                }
                Date minTime = (Date)checkMinTimeMap.get("data");
                if(d.getTime()<minTime.getTime()) {
                    checkMap.put("code",RespCodeEnum.PARAM_RANGE_ERROR_CODE.getCode());
                    checkMap.put("message","字段["+fieldName+"]["+cnFieldName+"]的值["+fieldValue+"]不能小于最小值["+
                            checkParamVo.getMinValue()+"],请重新输入");
                    return checkMap ;
                }
            }
        }

        return checkMap ;
    }

}
