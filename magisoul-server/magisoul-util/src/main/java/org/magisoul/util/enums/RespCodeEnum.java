package org.magisoul.util.enums;

public enum RespCodeEnum {
    //成功代码
    SUCCESS("200","操作成功"),
    FAIL("500","内部错误"),
    TIP("300", "提示异常"),
    ERROR("400","系统异常"),
    NOT_PASS("999","校验没有通过"),

    //定义参数错误值 从100开始到149
    PARAM_REQUEST_ERROR_CODE("101","请求参数错误"),
    PARAM_EMPTY_ERROR_CODE("102","不能为空"),
    PARAM_LENGTH_ERROR_CODE("103","长度不正确"),
    PARAM_ONLY_NUMBER_CODE("104","只能是数字"),
    PARAM_FORMAT_ERROR_CODE("105","格式不正确"),
    PARAM_RANGE_ERROR_CODE("106","范围不正确"),
    PARAM_TYPE_ERROR_CODE("107","未定义的类型"),
    PARAM_ONLY_DECIMAL_CODE("108","只能是浮点类型"),
    PARAM_ONLY_DATE_CODE("109","只能是精确到天的日期"),
    PARAM_ONLY_TIME_CODE("110","只能是精确到秒的日期"),
    PARAM_ONLY_STIME_CODE("111","只能是时分秒的时间"),
    PARAM_LENGTH_DECIMAL_PLACES_CODE("112","小数点后位数超出限制"),

    //公共错误值 从150-199
    OBJECT_NOT_EXIST("150","对象不存在"),
    OBJECT_DELETED("151","对象已经删除"),
    OBJECT_REPEAT("152","对象重复"),

    //session超时
    SESSION_TIMEOUT("900","登录超时"),

    //用户部分提示  暂定范围在1000-1100 之间
    USER_NOT_EXIST("1001","该用户不存在"),
    USER_DELETED("1002","该用户已经删除"),
    USER_DISABLE("1003","该用户已被禁用"),
    USER_NAME_EMPTY("1004","用户名不能为空,请重新输入"),
    USER_PWD_EMPTY("1005","密码不能为空,请重新输入"),
    USER_RECORD_MORE("1006","该用户名存在多条记录,请重新输入"),
    USER_PWD_NOT_CORRECT("1007","登录用户名或者密码不正确,请重新输入"),

    //角色部分提示 1100-1200
    ROLE_NOT_EXIST("1101","该角色不存在"),
    ROLE_DELETED("1102","该角色已被删除"),
    ROLE_DISABLE("1103","该角色已被禁用"),

    //申请状态
    IN_APPLY_STATUS("2001","申请中"),
    PASS_APPLY_STATUS("2002","申请通过"),
    NOT_PASS_APPLY_STATUS("2003","申请没有通过"),

    //使用状态
    ENABLE_STATUS("2101","该记录目前状态为使用中,不能被重复更新成使用中,请重新输入"),
    DISABLE_STATUS("2102","该记录目前状态为禁用,不能再次被禁用,请重新输入");


    private String code ;
    private String message ;

    private RespCodeEnum() {

    }

    private RespCodeEnum(String code,String message) {
        this.code = code ;
        this.message = message ;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
