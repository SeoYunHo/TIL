package �ڹ�06;

import java.lang.annotation.*;
import java.lang.reflect.*;

@maker(id="111",num=1,name="Dominica")
public class Ex_03 {
	public static void main(String[] args) {
		for(Annotation a : Ex_03.class.getAnnotations()){
			System.out.println("   "+a);
		}
		
		System.out.println("String ������");
		for(Constructor c:String.class.getConstructors()){
			System.out.println(c);
		}
		
		System.out.println("String �޼���");
		for(Method m : String.class.getMethods()){
			System.out.println(m);
		}
		
		System.out.println("String �ʵ�");
		for(Field f:String.class.getFields()){
			System.out.println(f);
		}
	}
}
