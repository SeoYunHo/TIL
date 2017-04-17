package 자바07;

interface Storage{
	void connetion();
	void useTransaction();
	void save();
}

class Oracle_1 implements Storage{
	public void connetion(){
		System.out.println("오라클에 접속");
	}
	public void useTransaction(){
		System.out.println("오라클 사용");
	}
	public void save(){
		System.out.println("오라클 저장");
	}
}

class DB2_1 implements Storage{
	public void connetion(){
		System.out.println("DB2에 접속");
	}
	public void useTransaction(){
		System.out.println("DB2 사용");
	}
	public void save(){
		System.out.println("DB2 저장");
	}
} 
public class Ex_02_interface {
	public static void main(String[] args) {
		Storage user=new Oracle_1();
		//Storage user=new DB2_1();
		
		user.connetion();
		user.useTransaction();
		user.save();
	}
}