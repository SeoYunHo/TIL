package 자바01;

public class Singleton {
	public static void main(String[] args){
		Singleton s=new Singleton();
		s.methodX();
		s.methodY();
	}
	public void methodX(){
		SingletonTest st=SingletonTest.getInstance();
		int count=st.getNextInt();
		System.out.println("메소드x 호출 뒤"+count);
	}
	public void methodY(){
		SingletonTest st=SingletonTest.getInstance();
		int count=st.getNextInt();
		System.out.println("메소드Y 호출 뒤"+count);
	}
}
