package org.magisoul.util;

public class StringUtil {

    public static boolean isEqualStr(String target,String source){
        if(target==null || target.trim().equals("") || source==null || source.trim().equals("")){
            return false ;
        }

        if(target.trim().equals(source)){
            return true ;
        }

        return false ;
    }

    public static boolean isNotEmpty(String target){
        if(target==null || target.trim().equals("")){
            return false ;
        }

        return true ;
    }
}
