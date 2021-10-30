package org.magisoul.gcode.util;


import org.magisoul.gcode.entity.GcFieldInfo;
import org.magisoul.gcode.model.FieldStatVo;
import org.magisoul.util.StringUtil;

import java.util.*;

public class FieldStatUtil {
	
	public static FieldStatVo getFieldStatVo(List<GcFieldInfo> fieldInfoList) {
		FieldStatVo fieldStatVo = new FieldStatVo();
		
		//申明变量
		//主键信息
		StringBuffer strParamPrimaryFieldInfoBuffer = new StringBuffer();
		StringBuffer strPrimaryFieldInfoBuffer = new StringBuffer();
		
		StringBuffer strFieldInfoBuffer = new StringBuffer();
		StringBuffer strRegexFieldInfoBuffer = new StringBuffer();
		List<GcFieldInfo> addFieldList = new ArrayList<GcFieldInfo>();
		
		//插入字段
		StringBuffer strInsertFieldInfoBuffer = new StringBuffer();
		StringBuffer strMybatisInsertFieldInfoBuffer = new StringBuffer();
		List<GcFieldInfo> insertFieldList = new ArrayList<GcFieldInfo>();
		List<GcFieldInfo> updateFieldList = new ArrayList<GcFieldInfo>();
		List<GcFieldInfo> uniqueFieldList = new ArrayList<GcFieldInfo>();
		
		//查询字段
		List<GcFieldInfo> queryFieldList = new ArrayList<GcFieldInfo>();
		
		//列表查询字段
		List<GcFieldInfo> viewQueryFieldList = new ArrayList<GcFieldInfo>();
		Set<String> querySet = new HashSet<String>();
		
		//列表显示字段
		List<GcFieldInfo> viewFieldList = new ArrayList<GcFieldInfo>();
		
		//明细查看字段
		List<GcFieldInfo> readFieldList = new ArrayList<GcFieldInfo>();
		
		//在实体类申明中引入的Date,BigDecimal等类型
		Set<String> set = new HashSet<String>();
		List<String> strImportList = new ArrayList<String>();
		
		String hasMultiSelect2 = "N";
		
		for(int i=0;i<fieldInfoList.size();i++) {
			GcFieldInfo fieldInfo = fieldInfoList.get(i);
			String dbFieldName = fieldInfo.getDbFieldName();
			String fieldValueName = fieldInfo.getFieldEntityName();
			String fieldImport = fieldInfo.getFieldImport();
			String fieldType = fieldInfo.getFieldType();
			String fieldName = fieldInfo.getFieldClassName();

			strFieldInfoBuffer.append(dbFieldName + ",");

			//判断主键信息
			String isPrimaryField = fieldInfo.getIsPrimaryField();
			if (StringUtil.isEqualStr(isPrimaryField, "Y")) {
				//是主键
				fieldStatVo.setPrimaryFieldInfo(fieldInfo);

				//判断主键类型,如果主键为自增长类型
				String primaryType = fieldInfo.getPrimaryType();
				if (primaryType.trim().equals("01")) {
					//自增长,那么在插入的sql中,不带此列
					//todo
					strParamPrimaryFieldInfoBuffer.append("@Param(\"" + fieldValueName + "\") " + fieldType + " " + fieldValueName);
					strPrimaryFieldInfoBuffer.append(fieldType + " " + fieldValueName + ",");
				} else {
					//否则,带入此列
					strRegexFieldInfoBuffer.append("?,");
					strInsertFieldInfoBuffer.append(dbFieldName + ",");
					strMybatisInsertFieldInfoBuffer.append("#{" + fieldValueName + "},");
					strParamPrimaryFieldInfoBuffer.append("@Param(\"" + fieldValueName + "\") " + fieldType + " " + fieldValueName);
					strPrimaryFieldInfoBuffer.append(fieldType + " " + fieldValueName + ",");
					addFieldList.add(fieldInfo);
				}
			} else {
				strRegexFieldInfoBuffer.append("?,");
				strInsertFieldInfoBuffer.append(dbFieldName + ",");
				strMybatisInsertFieldInfoBuffer.append("#{" + fieldValueName + "},");
				addFieldList.add(fieldInfo);
			}

			if (StringUtil.isNotEmpty(fieldImport)) {
				if (set.contains(fieldImport)) {
					//去重
				} else {
					set.add(fieldImport);
					strImportList.add(fieldImport);
				}
			}

			//判断编辑字段
			String isEditField = fieldInfo.getIsEditField();
			if (isEditField != null && isEditField.trim().equals("Y")) {
				insertFieldList.add(fieldInfo);
				updateFieldList.add(fieldInfo);

				//是否字段唯一,即此列的值在该表中必须唯一,不能重复
				String isInsertUnique = fieldInfo.getIsEditUnique();
				if (StringUtil.isNotEmpty(isInsertUnique)) {
					uniqueFieldList.add(fieldInfo);
				}

				//插入类型
				String insertType = fieldInfo.getEditType();
				if (insertType != null && insertType.trim().equals("023")) {
					hasMultiSelect2 = "Y";
				}
			}

			//是否删除字段
			String isDeleteField = fieldInfo.getIsDeleteField();
			if (StringUtil.isEqualStr(isDeleteField, "Y")) {
				fieldStatVo.setDeleteFieldInfo(fieldInfo);
				if (querySet.contains(fieldInfo.getDbFieldName())) {
					//略过
				} else {
					querySet.add(fieldInfo.getDbFieldName());
					queryFieldList.add(fieldInfo);
				}
			}

			//是否查询字段
			String isQueryField = fieldInfo.getIsQueryField();
			if (StringUtil.isEqualStr(isQueryField, "Y")) {
				if (querySet.contains(fieldInfo.getDbFieldName())) {
					//略过
				} else {
					queryFieldList.add(fieldInfo);
					querySet.add(fieldInfo.getDbFieldName());
				}
			}
		}
		
		//获取所有的字段,用于select后面的字段
		String strFieldInfo = strFieldInfoBuffer.toString();
		strFieldInfo = strFieldInfo.substring(0, strFieldInfo.length()-1);
		fieldStatVo.setStrFieldInfo(strFieldInfo);
		
		//新增用于jdbcTemplate模板
		String strRegexFieldInfo = strRegexFieldInfoBuffer.toString();
		strRegexFieldInfo = strRegexFieldInfo.substring(0, strRegexFieldInfo.length()-1);
		fieldStatVo.setStrRegexFieldInfo(strRegexFieldInfo);
		
		//获取注解中的关键字str申明
		String strParamPrimaryFieldInfo = strParamPrimaryFieldInfoBuffer.toString();
		strParamPrimaryFieldInfo = strParamPrimaryFieldInfo.substring(0, strParamPrimaryFieldInfo.length()-1);
		fieldStatVo.setStrParamPrimaryFieldInfo(strParamPrimaryFieldInfo);
		
		//获取其他方法中主键变量的申明
		String strPrimaryFieldInfo = strPrimaryFieldInfoBuffer.toString();
		strPrimaryFieldInfo = strPrimaryFieldInfo.substring(0, strPrimaryFieldInfo.length()-1);
		fieldStatVo.setStrPrimaryFieldInfo(strPrimaryFieldInfo);
		
		//获取insert语句中的字段
		String strInsertFieldInfo = strInsertFieldInfoBuffer.toString();
		strInsertFieldInfo = strInsertFieldInfo.substring(0, strInsertFieldInfo.length()-1);
		fieldStatVo.setStrInsertFieldInfo(strInsertFieldInfo);
		
		//获取insert语句中待插入值的部分
		String strMybatisInsertFieldInfo = strMybatisInsertFieldInfoBuffer.toString();
		strMybatisInsertFieldInfo = strMybatisInsertFieldInfo.substring(0, strMybatisInsertFieldInfo.length()-1);
		fieldStatVo.setStrMybatisInsertFieldInfo(strMybatisInsertFieldInfo);
		
		fieldStatVo.setEditFieldInfoList(insertFieldList);
		fieldStatVo.setUpdateFieldInfoList(updateFieldList);
		fieldStatVo.setUniqueFieldInfoList(uniqueFieldList);
		fieldStatVo.setStrImportList(strImportList);
		fieldStatVo.setQueryFieldInfoList(queryFieldList);
		fieldStatVo.setViewQueryFieldInfoList(viewQueryFieldList);
		fieldStatVo.setViewFieldInfoList(viewFieldList);
		fieldStatVo.setReadFieldInfoList(readFieldList);
		fieldStatVo.setFieldInfoList(fieldInfoList);
		fieldStatVo.setAddFieldInfoList(addFieldList);
		return fieldStatVo;
	}

}
