package org.magisoul.util;

import org.magisoul.util.enums.RespCodeEnum;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ObjectUtil {
    /**
     * 判断一个obj是否是一个Integer类型的值
     * @param obj Object
     * @return 如果能转化成Integer,返回true;否则,返回false
     */
    public static Boolean isInt(Object obj) {
        try {
            Integer.parseInt(String.valueOf(obj));
            return true ;
        }catch(Exception e) {
            return false ;
        }
    }

    /**
     * 判断一个obj是否能转化成一个BigDecimal类型的值
     * @param obj Object
     * @return 如果能转化成BigDecimal,返回true;否则,返回false
     */
    public static Boolean isBigDecimal(Object obj) {
        try {
            new BigDecimal(String.valueOf(obj));
            return true ;
        }catch(Exception e) {
            return false ;
        }
    }

    /**
     * 判断一个object是否能转化成df格式的时间
     * @param df DateFormat
     * @param obj Object
     * @param formatType 01 天  02秒  03只有时分秒
     * @return 如果能转化,那么data就对应转化后的值
     */
    public static Map<String, Object> isDate(DateFormat df, Object obj, String formatType){
        Map<String, Object> checkMap = new HashMap<String,Object>();
        try {
            Date d = df.parse(String.valueOf(obj));
            checkMap.put("code", RespCodeEnum.SUCCESS.getCode());
            checkMap.put("data", d);
        }catch(Exception e) {
            if(formatType.trim().equals("01")) {
                checkMap.put("code", RespCodeEnum.PARAM_ONLY_DATE_CODE.getCode());
            }else if(formatType.trim().equals("02")) {
                checkMap.put("code", RespCodeEnum.PARAM_ONLY_TIME_CODE.getCode());
            }else if(formatType.trim().equals("03")){
                checkMap.put("code", RespCodeEnum.PARAM_ONLY_STIME_CODE.getCode());
            }else {
                checkMap.put("code", RespCodeEnum.FAIL.getCode());
            }
        }
        return checkMap ;
    }

    public static Boolean isEmpty(Object obj){
        if(obj==null){
            return true ;
        }
        if(obj instanceof String){
            String str = String.valueOf(obj);
            if(str.trim().equals("")){
                return true ;
            }
        }
        return false ;
    }

    public static String getTraceId(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
