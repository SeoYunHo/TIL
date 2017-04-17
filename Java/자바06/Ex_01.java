package 자바06;

public class Ex_01 {
	@PrintAnnotation
	public void method1(){
		System.out.println("실험 내용1");
	}
	
	@PrintAnnotation("*")
	public void method2(){
		System.out.println("실험 내용2");
	}
		
	@PrintAnnotation(value="#",number=20)
	public void method3(){
		System.out.println("실험 내용3");
	}
}
