package �ڹ�07;

interface Storage{
	void connetion();
	void useTransaction();
	void save();
}

class Oracle_1 implements Storage{
	public void connetion(){
		System.out.println("����Ŭ�� ����");
	}
	public void useTransaction(){
		System.out.println("����Ŭ ���");
	}
	public void save(){
		System.out.println("����Ŭ ����");
	}
}

class DB2_1 implements Storage{
	public void connetion(){
		System.out.println("DB2�� ����");
	}
	public void useTransaction(){
		System.out.println("DB2 ���");
	}
	public void save(){
		System.out.println("DB2 ����");
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