package �ڹ�06;

import java.lang.reflect.*;
import java.security.Provider.*;

public class Ex_02 {
	public static void main(String[] args) {
		//Ex_01 Ŭ�����κ��� �޼ҵ� ������ ����
		Method[] declaredMethods=Ex_01.class.getDeclaredMethods();
		
		//method ��ü�� �ϳ���ó��
		for(Method method:declaredMethods){
			//PrintAnnotation�� ����Ǿ����� Ȯ��
			if(method.isAnnotationPresent(PrintAnnotation.class)){
				//PrintAnnotation ��ü���
				PrintAnnotation printAnnotation=method.getAnnotation(PrintAnnotation.class);
				
				//�޼ҵ� �̸� ���
				System.out.println("["+method.getName()+"]");
				//���м� ���
				for(int i=0;i<printAnnotation.number();i++){
					System.out.print(printAnnotation.value());
				}
				System.out.println();
				
				try{
					//�޼ҵ� ȣ��
					method.invoke(new Ex_01());
				}catch(Exception e){
					System.out.println();
				}
			}
		}
	}
}
