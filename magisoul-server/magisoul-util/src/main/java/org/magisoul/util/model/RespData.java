package org.magisoul.util.model;

import org.magisoul.util.enums.RespCodeEnum;

import java.io.Serializable;

public class RespData<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public RespData() {

    }

    public RespData(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static RespData<String> success() {
        return new RespData<String>(RespCodeEnum.SUCCESS.getCode(), RespCodeEnum.SUCCESS.getMessage(), "");
    }

    public static <T> RespData<T> success(String message, T data) {
        return new RespData<T>(RespCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> RespData<T> success(T data) {
        return new RespData<T>(RespCodeEnum.SUCCESS.getCode(), RespCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> RespData<T> fail(String code, String message, T data) {
        return new RespData<T>(code, message, data);
    }

    public static RespData<String> fail(RespCodeEnum respCodeEnum){
        return new RespData<String>(respCodeEnum.getCode(),respCodeEnum.getMessage(),"");
    }

    /**
     * 针对数据库insert和update操作,有返回受影响的记录行数.</p>
     * 如果受影响的记录行数大于0,说明操作成功;否则操作失败
     * @param affectRowNum
     * @return
     */
    public  RespData getByAffectRowNum(Integer affectRowNum){
        if(affectRowNum.intValue()>0){
            this.setCode(RespCodeEnum.SUCCESS.getCode());
            this.setMessage(RespCodeEnum.SUCCESS.getMessage());
        }else{
            this.setCode(RespCodeEnum.ERROR.getCode());
            this.setMessage(RespCodeEnum.ERROR.getMessage());
        }
        return this ;
    }

    public RespData buildSuccess(T data){
        this.setCode(RespCodeEnum.SUCCESS.getCode());
        this.setMessage(RespCodeEnum.SUCCESS.getMessage());
        this.setData(data);
        return this ;
    }

    public RespData clone(RespData resp){
        this.setMessage(resp.getMessage());
        this.setCode(resp.getCode());
        return this ;
    }

    /**
     * 判断当前RespData是否操作成功.如果操作成功,返回true;否则返回false
     * @return
     */
    public Boolean isSuccess(){
        if(this.getCode().trim().equals(RespCodeEnum.SUCCESS.getCode())){
            return true ;
        }else{
            return false ;
        }
    }

    public RespData<T> build(RespCodeEnum respCodeEnum){
        this.setMessage(respCodeEnum.getMessage());
        this.setCode(respCodeEnum.getCode());
        return this ;
    }

    public static RespData<String> error(){
        return new RespData<String>(RespCodeEnum.ERROR.getCode(), RespCodeEnum.ERROR.getMessage(), "");
    }

    public static RespData<String> error(String message){
        return new RespData<String>(RespCodeEnum.ERROR.getCode(), message, "");
    }

    public static RespData<String> fail(String code,String message){
        return new RespData<String>(code,message,"");
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
