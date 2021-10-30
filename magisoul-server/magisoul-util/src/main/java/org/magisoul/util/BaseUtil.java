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
	 * 对于字段aa_bb_cc_dd的形式,使用驼峰法自动生成aaBbCcDd或者AaBbCcDd的格式,用于生成set,get以及字段声明等
	 * @param columnName 数据库中字段名称
	 * @param type 0,首字母不大写;1,首字母大写
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
					//将strName的第一个字母弄成大写的
					//将第一个字母替换成大写
					String regexStrName = strName.substring(0, 1);
					String lastRegexStrName = strName.substring(1,strName.length());
					sb.append(regexStrName.toUpperCase()+lastRegexStrName);
				}
			}
		}else if(type==1) {
			for(int i=0;i<arrayName.length;i++) {
				String strName = arrayName[i];
				//将strName的第一个字母弄成大写的
				//将第一个字母替换成大写
				String regexStrName = strName.substring(0, 1);
				String lastRegexStrName = strName.substring(1,strName.length());
				sb.append(regexStrName.toUpperCase()+lastRegexStrName);
			}
		}
		
		
		return sb.toString();
	}

	/**
	 * 从别名生产类名
	 * @param aliasName 别名
	 * @return
	 */
	public static Map<String,String> getClassName(String aliasName) {
		Map<String,String> map = new HashMap<String,String>();
		
		//注意:别名采取驼峰写法或者a_a这种写法都行
		//这里产生2个key:
		//  className 类名
		//  entityName 对象名
		//  如:别名为member 那么类名为Member 对象名为member
		
		String[] strArray = aliasName.split("_");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<strArray.length;i++) {
			String strName = strArray[i];
			//将strName的第一个字母弄成大写的
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
