package �ڹ�07;

class Oracle{
	public void connetion(){
		System.out.println("����Ŭ�� ����");
	}
	public void runTransaction(){
		System.out.println("����Ŭ ���");
	}
	public void commit(){
		System.out.println("����Ŭ ����");
	}
}

class DB2{
	public void login(){
		System.out.println("DB2�� ����");
	}
	public void useTransaction(){
		System.out.println("DB2 ���");
	}
	public void save(){
		System.out.println("DB2 ����");
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