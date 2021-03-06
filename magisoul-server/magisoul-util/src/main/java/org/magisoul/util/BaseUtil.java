package org.magisoul.util;

import java.util.HashMap;
import java.util.Map;

public class BaseUtil {
	
	public static Map<String,String> getFieldType(String columnType,String dbType) {
		Map<String,String> fieldMap = new HashMap<String,String>();
		
		String fieldType = "";
		String strImport = "";
		if(dbType.toLowerCase().trim().equals("mysql")) {
			if(columnType.toLowerCase().trim().equals("int") || columnType.toLowerCase().trim().equals("tinyint")
					|| columnType.toLowerCase().trim().equals("smallint")) {
				fieldType = "Integer";	
			}
			if(columnType.toLowerCase().trim().equals("varchar") || columnType.toLowerCase().trim().equals("char")
					|| columnType.toLowerCase().trim().equals("text")) {
				fieldType = "String";
			}
			if(columnType.toLowerCase().trim().equals("date") || columnType.toLowerCase().trim().equals("timestamp")
					|| columnType.toLowerCase().trim().equals("datetime")) {
				fieldType = "Date";
				strImport = "import java.util.Date;";
			}
			if(columnType.toLowerCase().trim().equals("decimal") || columnType.toLowerCase().trim().equals("double")
					|| columnType.toLowerCase().trim().equals("float")) {
				fieldType = "BigDecimal";
				strImport = "import java.math.BigDecimal;";
			}
			if(columnType.toLowerCase().trim().equals("bigint") || columnType.toLowerCase().trim().equals("integer")) {
				fieldType = "Long";
			}
		}

		fieldMap.put("fieldType", fieldType);
		fieldMap.put("strImport", strImport);
		return fieldMap ;
	}
	
	public static String getColumnType(String columnType,String dbType) {
		String fieldType = "";
		if(dbType.toLowerCase().trim().equals("mysql")) {
			if(columnType.toLowerCase().trim().equals("int") || columnType.toLowerCase().trim().equals("tinyint")
					|| columnType.toLowerCase().trim().equals("smallint")) {
				fieldType = "Int";	
			}
			if(columnType.toLowerCase().trim().equals("varchar") || columnType.toLowerCase().trim().equals("char")
					|| columnType.toLowerCase().trim().equals("text")) {
				fieldType = "String";
			}
			if(columnType.toLowerCase().trim().equals("date") || columnType.toLowerCase().trim().equals("timestamp")
					|| columnType.toLowerCase().trim().equals("datetime")) {
				fieldType = "Date";
			}
			if(columnType.toLowerCase().trim().equals("decimal")) {
				fieldType = "BigDecimal";
			}
			if(columnType.toLowerCase().trim().equals("bigint") || columnType.toLowerCase().trim().equals("integer")) {
				fieldType = "Long";
			}
		}
		
		return fieldType ;
	}
	
	/**
	 * ????????????aa_bb_cc_dd?????????,???????????????????????????aaBbCcDd??????AaBbCcDd?????????,????????????set,get?????????????????????
	 * @param columnName ????????????????????????
	 * @param type 0,??????????????????;1,???????????????
	 * @return String
	 */
	public static String getFieldName(String columnName,int type) {
		StringBuffer sb = new StringBuffer();
		
		String[] arrayName = columnName.split("_");
		
		if(type==0) {
			for(int i=0;i<arrayName.length;i++) {
				String strName = arrayName[i];
				if(i==0) {
					sb.append(strName);
				}else {
					//???strName?????????????????????????????????
					//?????????????????????????????????
					String regexStrName = strName.substring(0, 1);
					String lastRegexStrName = strName.substring(1,strName.length());
					sb.append(regexStrName.toUpperCase()+lastRegexStrName);
				}
			}
		}else if(type==1) {
			for(int i=0;i<arrayName.length;i++) {
				String strName = arrayName[i];
				//???strName?????????????????????????????????
				//?????????????????????????????????
				String regexStrName = strName.substring(0, 1);
				String lastRegexStrName = strName.substring(1,strName.length());
				sb.append(regexStrName.toUpperCase()+lastRegexStrName);
			}
		}
		
		
		return sb.toString();
	}

	/**
	 * ?????????????????????
	 * @param aliasName ??????
	 * @return
	 */
	public static Map<String,String> getClassName(String aliasName) {
		Map<String,String> map = new HashMap<String,String>();
		
		//??????:??????????????????????????????a_a??????????????????
		//????????????2???key:
		//  className ??????
		//  entityName ?????????
		//  ???:?????????member ???????????????Member ????????????member
		
		String[] strArray = aliasName.split("_");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<strArray.length;i++) {
			String strName = strArray[i];
			//???strName?????????????????????????????????
			String regexStrName = strName.substring(0, 1);
			String lastRegexStrName = strName.substring(1,strName.length());
			sb.append(regexStrName.toUpperCase()+lastRegexStrName);
		}
		
		String className = sb.toString();
		String f1 = className.substring(0,1);
		String f2 = className.substring(1,className.length());
		map.put("className", className);
		map.put("entityName", f1.toLowerCase()+f2);
		
		return map ;
	}
	
	public static String getFilePath(String packageName,String filePath,String projectCode) {
		String[] array = packageName.split("\\.");
		StringBuffer sb = new StringBuffer();
		sb.append(filePath);
		sb.append("/");
		sb.append(projectCode);
		sb.append("/");
		for(int i=0;i<array.length-1;i++) {
			sb.append(array[i]);
			sb.append("/");
		}
		sb.append(array[array.length-1]);
		
		return sb.toString();
	}
}
