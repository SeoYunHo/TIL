package �ڹ�03;

enum Bread {
	//
	DANPAT(500), CREAMPUFF(800), SOBORO(500), CHOCO(600);

	private int price;

	Bread(int p) {
		price = p;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int p) {
		price = p;
	}
}

public class Ex3_6 {
	public static void main(String[] args) {
		System.out.println("���ϻ��� ����: "+Bread.DANPAT.getPrice());
		System.out.println("��ũ������ ����: "+Bread.CREAMPUFF.getPrice());
		System.out.println("�Һ��λ��� ����: "+Bread.SOBORO.getPrice());
		
		Bread.DANPAT.setPrice(600);
		System.out.println("���ϻ��� ������ �ö����ϴ�.");
		System.out.println("���ϻ��� ����: "+Bread.DANPAT.getPrice());
		
		//�������� ���Ǻ� �̿��� �������� ���ο� �ν��Ͻ��� ���������� �������� ���ο� ���� ������ �����ϴ� ���� ������ ���� 
		Bread newBread=Bread.CHOCO;
		System.out.println("���� ���� ��: "+newBread);
		System.out.println("���� ���� ���� ����: "+newBread.getPrice());
	}
}
