package �ڹ�09;

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
			System.out.println("���ڷ� ��ȯ�� �� �����ϴ�.");
		}finally{
			System.out.println("�ٽ� �����ϼ���.");
		}
	}
}
