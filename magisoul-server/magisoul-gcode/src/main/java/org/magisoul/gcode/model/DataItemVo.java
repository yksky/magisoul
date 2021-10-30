package org.magisoul.gcode.model;

import java.util.List;

public class DataItemVo {
	
	//字段名称
	private String fieldName ;
	//类型:01,数据库取值;02,常量值
	private String dataDictType ;
	//常量取值的List
	private List<ItemVo> itemList ;
    //关键字名称
	private String keyName ;
	//关键字值名称
	private String valueName ;
	//list变量名称,用于在for循环中处理
	private String dataName ;
	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getDataDictType() {
		return dataDictType;
	}
	public void setDataDictType(String dataDictType) {
		this.dataDictType = dataDictType;
	}
	public List<ItemVo> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemVo> itemList) {
		this.itemList = itemList;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

}
