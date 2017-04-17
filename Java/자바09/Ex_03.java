package 자바09;

public class Ex_03 {
	public static void main(String[] args) {
		String data1=null;
		String data2=null;
		
		try{
			System.out.println("data2 : "+data1.toString());
			System.out.println("data2 : "+data2.toString());
		}catch(NullPointerException e){
			System.out.println("java Ex_03 num1 num2");
		}
		
		try{
			System.out.println("data1 : "+data1.toString());
			System.out.println("data2 : "+data2.toString());
		}catch(NullPointerException e){
			System.out.println("숫자로 변환할 수 없습니다.");
		}finally{
			System.out.println("다시 실행하세요.");
		}
	}
}
