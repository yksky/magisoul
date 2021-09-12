package org.magisoul.util.model;

import java.io.Serializable;

public class CheckParamVo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 校验字段名称,对应实体类中的字段名称
	 */
	private String fieldName ; 
	/**
	 * 校验字段值
	 */
	private Object fieldValue ; 
	/**
	 * 校验字段中文名称
	 */
	private String cnFieldName ;  
	/**
	 * 字段类型<p>
	 *   string,int,decimal,time(精确到秒),date(精确到天)
	 */
	private String fieldType ; 
	/**
	 * 字段值是否可为空<p>
	 *   true:可以为空;false,不可为空
	 */
	private Boolean isNull ;  
	/**
	 * 是否检查长度<p>
	 *   true:检查长度;false,不检查长度
	 */
	private Boolean isCheckLength ;     
	/**
	 * 如果设置了必须检查字段长度,那么length就必须设置值,该值为字段的最大长度
	 */
	private Integer length ;            
	/**
	 * 对数字类型的值,是否检查最大值<p>
	 *   true:检查最大值;false,不检查最大值
	 */
	private Boolean isCheckMax ;   
	/**
	 * 数字类型的最大值
	 */
	private String maxValue ;           
	/**
	 * 最大值名称,提示时用到
	 */
	private String maxName ;            
	/**
	 * 对数字类型的值,是否检查最小值<p>
	 *   true:检查最小值;false,不检查最小值
	 */
	private Boolean isCheckMin ;   
	/**
	 * 数字类型的最小值
	 */
	private String minValue ;           
    /**
     * 最小值名称,提示时用到
     */
	private String minName ;            
	/**
	 * 小数点点位
	 */
	private Integer point ;
	
	public CheckParamVo() {
		
	}
	
	/**
	 * 校验字符串类型的构造方法
	 * @param fieldName      字段名称
	 * @param cnFieldName    字段中文名称
	 * @param fieldValue     字段值
	 * @param fieldType      字段类型,这里为string
	 * @param isNull         字段值是否可为空:true,可为空;false,不可为空
	 * @param isCheckLength  是否检验字段长度:true,校验;false,不校验
	 * @param length         字段长度
	 */
	public CheckParamVo(String fieldName,String cnFieldName,Object fieldValue,String fieldType,Boolean isNull,Boolean isCheckLength,Integer length) {
		this.fieldName = fieldName;
		this.cnFieldName = cnFieldName ;
		this.fieldValue = fieldValue ;
		this.fieldType = fieldType ;
		this.isNull = isNull ;
		this.isCheckLength = isCheckLength ;
		this.length = length ;
		this.isCheckMax = false ;
		this.isCheckMin = false ;
		this.point = null ;
	}
	
	/**
	 * 校验数字类型的构造方法
	 * @param fieldName         字段名称
	 * @param cnFieldName       字段中文名称
	 * @param fieldValue        字段值
	 * @param fieldType         字段类型,这里为decimal或者int
	 * @param isNull            是否可为空:true,可为空;false,不可为空
	 * @param isCheckLength     是否检查长度:true,检查;false,不检查
	 * @param length            长度
	 * @param isCheckMax        是否检测最大值:true,false
	 * @param maxValue          最大值
	 * @param maxName           最大值提示语
	 * @param isCheckMin        是否检测最小值:true,false
	 * @param minValue          最小值
	 * @param minName           最小值提示语
	 * @param point             小数点位数
	 */
	public CheckParamVo(String fieldName,String cnFieldName,Object fieldValue,String fieldType,Boolean isNull,Boolean isCheckLength,Integer length,
			Boolean isCheckMax,String maxValue,String maxName,Boolean isCheckMin,String minValue,String minName,Integer point) {
		this.fieldName = fieldName ;
		this.cnFieldName = cnFieldName ;
		this.fieldValue = fieldValue ;
		this.fieldType = fieldType ;
		this.isNull = isNull ;
		this.isCheckLength = isCheckLength ;
		this.length = length ;
		this.isCheckMax = isCheckMax ;
		this.maxValue = maxValue ;
		this.maxName = maxName ;
		this.isCheckMin = isCheckMin ;
		this.minValue = minValue ;
		this.minName = minName ;
		this.point = point ;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	public String getCnFieldName() {
		return cnFieldName;
	}
	public void setCnFieldName(String cnFieldName) {
		this.cnFieldName = cnFieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public Boolean getIsNull() {
		return isNull;
	}
	public void setIsNull(Boolean isNull) {
		this.isNull = isNull;
	}
	public Boolean getIsCheckLength() {
		return isCheckLength;
	}
	public void setIsCheckLength(Boolean isCheckLength) {
		this.isCheckLength = isCheckLength;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Boolean getIsCheckMax() {
		return isCheckMax;
	}
	public void setIsCheckMax(Boolean isCheckMax) {
		this.isCheckMax = isCheckMax;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
	public String getMaxName() {
		return maxName;
	}
	public void setMaxName(String maxName) {
		this.maxName = maxName;
	}
	public Boolean getIsCheckMin() {
		return isCheckMin;
	}
	public void setIsCheckMin(Boolean isCheckMin) {
		this.isCheckMin = isCheckMin;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMinName() {
		return minName;
	}
	public void setMinName(String minName) {
		this.minName = minName;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}             

}
