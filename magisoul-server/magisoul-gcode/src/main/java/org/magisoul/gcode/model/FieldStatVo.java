package org.magisoul.gcode.model;

import org.magisoul.gcode.entity.GcFieldInfo;

import java.util.List;

/**
 * 生成具体内容的字段信息
 * @author yangguan
 *
 */
public class FieldStatVo {
	
	//用在实体层的引入,如:Date,BigDecimal
	List<String> strImportList ;
	
	//主键信息
	private GcFieldInfo primaryFieldInfo ;
	//mapper层带注解的主键信息
	private String strParamPrimaryFieldInfo ;
	//service层不带注解的主键信息
	private String strPrimaryFieldInfo ;
	
	//插入字段信息
	//  这里主要考虑如下几种应用场景:
	//  1.insert语句的字段信息以及值信息
	//  2.页面布局中各个输入文本域
	private List<GcFieldInfo> editFieldInfoList ;
	private String strInsertFieldInfo ;
	private String strMybatisInsertFieldInfo ;
	//插入值唯一
	private List<GcFieldInfo> uniqueFieldInfoList ;

	//更新字段信息
	private List<GcFieldInfo> updateFieldInfoList ;
	
	//查询字段信息 sql语句中的where条件
	private List<GcFieldInfo> queryFieldInfoList ;
	//列表页中的查询字段信息,用于文本域输入
	private List<GcFieldInfo> viewQueryFieldInfoList ;
	
	//数据库字段信息
	private List<GcFieldInfo> fieldInfoList ;
	private String strFieldInfo ;
	
	//新增字段,主要用于jdbcTemplate插入值时的问号占位符,形成诸如?,?,?这样的字符串
	//yangguan  2020-12-21 add  在批量入库时需要用到
	private String strRegexFieldInfo ;
	private List<GcFieldInfo> addFieldInfoList ;
	
	//列表页显示字段
	private List<GcFieldInfo> viewFieldInfoList ;
	//明细页显示字段
	private List<GcFieldInfo> readFieldInfoList ;
	
	//删除字段信息
	private GcFieldInfo deleteFieldInfo ;

	public List<String> getStrImportList() {
		return strImportList;
	}

	public void setStrImportList(List<String> strImportList) {
		this.strImportList = strImportList;
	}

	public GcFieldInfo getPrimaryFieldInfo() {
		return primaryFieldInfo;
	}

	public void setPrimaryFieldInfo(GcFieldInfo primaryFieldInfo) {
		this.primaryFieldInfo = primaryFieldInfo;
	}

	public String getStrParamPrimaryFieldInfo() {
		return strParamPrimaryFieldInfo;
	}

	public void setStrParamPrimaryFieldInfo(String strParamPrimaryFieldInfo) {
		this.strParamPrimaryFieldInfo = strParamPrimaryFieldInfo;
	}

	public String getStrPrimaryFieldInfo() {
		return strPrimaryFieldInfo;
	}

	public void setStrPrimaryFieldInfo(String strPrimaryFieldInfo) {
		this.strPrimaryFieldInfo = strPrimaryFieldInfo;
	}

	public List<GcFieldInfo> getEditFieldInfoList() {
		return editFieldInfoList;
	}

	public void setEditFieldInfoList(List<GcFieldInfo> editFieldInfoList) {
		this.editFieldInfoList = editFieldInfoList;
	}

	public String getStrInsertFieldInfo() {
		return strInsertFieldInfo;
	}

	public void setStrInsertFieldInfo(String strInsertFieldInfo) {
		this.strInsertFieldInfo = strInsertFieldInfo;
	}

	public String getStrMybatisInsertFieldInfo() {
		return strMybatisInsertFieldInfo;
	}

	public void setStrMybatisInsertFieldInfo(String strMybatisInsertFieldInfo) {
		this.strMybatisInsertFieldInfo = strMybatisInsertFieldInfo;
	}

	public List<GcFieldInfo> getUniqueFieldInfoList() {
		return uniqueFieldInfoList;
	}

	public void setUniqueFieldInfoList(List<GcFieldInfo> uniqueFieldInfoList) {
		this.uniqueFieldInfoList = uniqueFieldInfoList;
	}

	public List<GcFieldInfo> getUpdateFieldInfoList() {
		return updateFieldInfoList;
	}

	public void setUpdateFieldInfoList(List<GcFieldInfo> updateFieldInfoList) {
		this.updateFieldInfoList = updateFieldInfoList;
	}

	public List<GcFieldInfo> getQueryFieldInfoList() {
		return queryFieldInfoList;
	}

	public void setQueryFieldInfoList(List<GcFieldInfo> queryFieldInfoList) {
		this.queryFieldInfoList = queryFieldInfoList;
	}

	public List<GcFieldInfo> getViewQueryFieldInfoList() {
		return viewQueryFieldInfoList;
	}

	public void setViewQueryFieldInfoList(List<GcFieldInfo> viewQueryFieldInfoList) {
		this.viewQueryFieldInfoList = viewQueryFieldInfoList;
	}

	public List<GcFieldInfo> getFieldInfoList() {
		return fieldInfoList;
	}

	public void setFieldInfoList(List<GcFieldInfo> fieldInfoList) {
		this.fieldInfoList = fieldInfoList;
	}

	public String getStrFieldInfo() {
		return strFieldInfo;
	}

	public void setStrFieldInfo(String strFieldInfo) {
		this.strFieldInfo = strFieldInfo;
	}

	public String getStrRegexFieldInfo() {
		return strRegexFieldInfo;
	}

	public void setStrRegexFieldInfo(String strRegexFieldInfo) {
		this.strRegexFieldInfo = strRegexFieldInfo;
	}

	public List<GcFieldInfo> getAddFieldInfoList() {
		return addFieldInfoList;
	}

	public void setAddFieldInfoList(List<GcFieldInfo> addFieldInfoList) {
		this.addFieldInfoList = addFieldInfoList;
	}

	public List<GcFieldInfo> getViewFieldInfoList() {
		return viewFieldInfoList;
	}

	public void setViewFieldInfoList(List<GcFieldInfo> viewFieldInfoList) {
		this.viewFieldInfoList = viewFieldInfoList;
	}

	public List<GcFieldInfo> getReadFieldInfoList() {
		return readFieldInfoList;
	}

	public void setReadFieldInfoList(List<GcFieldInfo> readFieldInfoList) {
		this.readFieldInfoList = readFieldInfoList;
	}

	public GcFieldInfo getDeleteFieldInfo() {
		return deleteFieldInfo;
	}

	public void setDeleteFieldInfo(GcFieldInfo deleteFieldInfo) {
		this.deleteFieldInfo = deleteFieldInfo;
	}
}
