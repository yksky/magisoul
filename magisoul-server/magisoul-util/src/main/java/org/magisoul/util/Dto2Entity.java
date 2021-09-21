package org.magisoul.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Dto2Entity {

    /**
     * 将dto与entity之间的属性进行相互转化
     * @param src
     * @param target
     * @return
     */
    public static Object populate(Object src,Object target) throws Exception{
        Method[] srcMethods = src.getClass().getMethods();
        Method[] targetMethods = target.getClass().getMethods();

        Map<String,Object> srcMap = new HashMap<String,Object>();
        for(Method m:srcMethods) {
            String srcName = m.getName();
            if(srcName.startsWith("get")) {
                String name = srcName.substring(3, srcName.length());
                Object result = m.invoke(src);
                srcMap.put(name, result);
            }
        }
        for(Method mm:targetMethods) {
            String targetName = mm.getName();
            if(targetName.startsWith("set")) {
                String tname = targetName.substring(3, targetName.length());
                if(srcMap.containsKey(tname)) {
                    Object result = srcMap.get(tname);
                    mm.invoke(target, result);
                }
            }
        }
        return target ;
    }

}
