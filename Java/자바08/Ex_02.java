package ÀÚ¹Ù08;

public class Ex_02 {
	int field1;
	void method1(){}
	
	static int field2;
	static void method2(){}
	
	class B{
		void method(){
			field1=10;
			method1();
			
			field2=10;
			method2();
		}
	}
	
	static class C{
		void method(){
			//field1=10;
			//method1();
			
			field2=10;
			method2();
		}
	}
	
	public void method2(int arg){
		int localVariable=1;
		//arg=100;
		//localVariable=10;
		class Inner{
			public void method(){
				int result=arg+localVariable;
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
