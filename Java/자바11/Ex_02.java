package �ڹ�11;

public class Ex_02 {
	public static void main(String[] args) {
		SmartPhone myPhone=new SmartPhone("����", "�ȵ���̵�");
		
		String strObj=myPhone.toString();
		System.out.println(strObj);
		
		System.out.println(myPhone);
	}
}

class SmartPhone{
	private String company;
	private String os;
	
	public SmartPhone(String company,String os){
		this.company=company;
		this.os=os;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return company+", "+os;
	}
	
	
}
