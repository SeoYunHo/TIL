package �ڹ�01;

public class Singleton {
	public static void main(String[] args){
		Singleton s=new Singleton();
		s.methodX();
		s.methodY();
	}
	public void methodX(){
		SingletonTest st=SingletonTest.getInstance();
		int count=st.getNextInt();
		System.out.println("�޼ҵ�x ȣ�� ��"+count);
	}
	public void methodY(){
		SingletonTest st=SingletonTest.getInstance();
		int count=st.getNextInt();
		System.out.println("�޼ҵ�Y ȣ�� ��"+count);
	}
}
