package ÀÚ¹Ù06;

import java.lang.reflect.*;

public class ToStringHelper {
	public static String toString(Object obj){
		StringBuffer sb=new StringBuffer();
		Class clazz=obj.getClass();
		for(Field field :clazz.getDeclaredFields()){
			if(field.isAnnotationPresent(PrintToString.class)){
				String fieldName=field.getName();
				fieldName="get"+ fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
				Method method=null;
			
					try{
						method=clazz.getMethod(fieldName, null);
					}catch(NoSuchMethodException | SecurityException e){
						e.printStackTrace();
					}
				Object value=null;
					try{
						value=method.invoke(obj);
					}catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
						e.printStackTrace();
					}
				sb.append(field.getName()).append("=").append(value);
			}
		}
		return sb.toString();
	}
}
