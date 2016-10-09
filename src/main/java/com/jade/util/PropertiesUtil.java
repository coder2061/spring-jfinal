package com.jade.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**   
 * 配置文件操作
 * @author jiangyf   
 * @since 2016年10月9日 下午12:03:20 
 * @version V1.0   
 */
public class PropertiesUtil {
	private static Map<String, String> map = null;
	
	/**  
	* 获取配置文件信息
	* @param popName
	* @return Map<String, String>
	*/
	public static Map<String, String> propertiesToMap(String propName) {
		InputStream is = new PropertiesUtil().getClass()
				.getClassLoader().getResourceAsStream(propName);  
        Properties props = new Properties();
        if (map == null) {
        	map = new HashMap<String, String>();
		}
        try {  
            props.load(is);  
            Enumeration<Object> en = props.keys();  
            while (en.hasMoreElements()) {  
                String key = en.nextElement().toString();  
                String val = props.getProperty(key);  
                map.put(key, val);  
            }  
            is.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        return map;
	}
	
	/**  
	* 获取配置文件信息
	* @param popName
	* @param hashMap
	* @return Map<String, String>
	*/
	public static Map<String, String> propertiesToMap(String propName, 
			Map<String, String> hashMap) {
		map = hashMap;
        return propertiesToMap(propName);
	}

}
