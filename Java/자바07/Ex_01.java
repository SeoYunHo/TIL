package �ڹ�07;

interface Afunction {
	void searchInform(String name, int phoneNum);

	void runService(int memberID, int request);
}

class AfunctionImp1 implements Afunction {
	@Override
	public void searchInform(String name, int phoneNum) {
		System.out.println(name + " ���� ������ ã�ҽ��ϴ�.");
	}

	@Override
	public void runService(int memberId, int request) {
		System.out.println(memberId + " ������ ��û�Ͻ� ���񽺸� �����մϴ�.");
	}
}

public class Ex_01 {
	public static void main(String[] args) {
		Afunction aref = new AfunctionImp1();

		aref.searchInform("������", 0101112222);
		aref.runService(100, 1);
	}
}
