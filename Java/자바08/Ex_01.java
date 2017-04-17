package ÀÚ¹Ù08;

public class Ex_01 {
	String field ="Outter-field";
	void method(){
		System.out.println("Outter-method");
	}
	
	class  Nested{
		String field="Nested-field";
		void method(){
			System.out.println("Nested-method");
		}
		
		void print(){
			System.out.println(this.field);
			this.method();
			
			System.out.println(Ex_01.this.field);
			Ex_01.this.method();
		}
	}
}
