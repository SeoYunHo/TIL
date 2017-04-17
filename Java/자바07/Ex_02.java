package 자바07;

class Oracle{
	public void connetion(){
		System.out.println("오라클에 접속");
	}
	public void runTransaction(){
		System.out.println("오라클 사용");
	}
	public void commit(){
		System.out.println("오라클 저장");
	}
}

class DB2{
	public void login(){
		System.out.println("DB2에 접속");
	}
	public void useTransaction(){
		System.out.println("DB2 사용");
	}
	public void save(){
		System.out.println("DB2 저장");
	}
}

public class Ex_02 {
	public static void main(String[] args) {
		Oracle user=new Oracle();
		//DB2 user= new DB2();
		
		user.connetion();
		user.runTransaction();
		user.commit();
	}
}