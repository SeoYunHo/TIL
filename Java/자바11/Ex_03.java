package �ڹ�11;

public class Ex_03 {
	public static void main(String[] args) {
		//������ü ����
		Member original=new Member("blue", "ȫ�浿", "12345", 25, true);
		
		//���� ��ü�� ���� �Ŀ� �н����� ����
		Member cloned=original.getMember();
		cloned.password="67890";
		
		System.out.println("[���� ��ü�� �ʵ� ��]");
		System.out.println("id: "+cloned.id);
		System.out.println("name: "+cloned.name);
		System.out.println("password: "+cloned.password);
		System.out.println("age: "+cloned.age);
		System.out.println("adult: "+cloned.adult);
		
		System.out.println();
		
		System.out.println("[���� ��ü�� �ʵ� ��]");
		System.out.println("id: "+original.id);
		System.out.println("name: "+original.name);
		System.out.println("password: "+original.password);
		System.out.println("age: "+original.age);
		System.out.println("adult: "+original.adult);
	}
}

class Member implements Cloneable{
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;
	
	public Member(String id, String name, String password, int age, boolean adult){
		this.id=id;
		this.name=name;
		this.password=password;
		this.age=age;
		this.adult=adult;
	}
	
	public Member getMember(){
		Member cloned =null;
		try{
			cloned=(Member)clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return cloned;
	}
}
