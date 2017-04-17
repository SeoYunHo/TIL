package 자바06;

import java.lang.reflect.*;
import java.security.Provider.*;

public class Ex_02 {
	public static void main(String[] args) {
		//Ex_01 클래스로부터 메소드 정보를 얻음
		Method[] declaredMethods=Ex_01.class.getDeclaredMethods();
		
		//method 객체를 하나씩처리
		for(Method method:declaredMethods){
			//PrintAnnotation이 적용되었는지 확인
			if(method.isAnnotationPresent(PrintAnnotation.class)){
				//PrintAnnotation 객체얻기
				PrintAnnotation printAnnotation=method.getAnnotation(PrintAnnotation.class);
				
				//메소드 이름 출력
				System.out.println("["+method.getName()+"]");
				//구분선 출력
				for(int i=0;i<printAnnotation.number();i++){
					System.out.print(printAnnotation.value());
				}
				System.out.println();
				
				try{
					//메소드 호출
					method.invoke(new Ex_01());
				}catch(Exception e){
					System.out.println();
				}
			}
		}
	}
}
