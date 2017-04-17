package 자바03;

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
		System.out.println("단팥빵의 가격: "+Bread.DANPAT.getPrice());
		System.out.println("슈크림빵의 가격: "+Bread.CREAMPUFF.getPrice());
		System.out.println("소보로빵의 가격: "+Bread.SOBORO.getPrice());
		
		Bread.DANPAT.setPrice(600);
		System.out.println("단팥빵의 가격이 올랐습니다.");
		System.out.println("단팥빵의 가격: "+Bread.DANPAT.getPrice());
		
		//열거형은 정의부 이외의 영역에서 새로운 인스턴스를 생성하지는 못하지만 새로운 참조 변수를 선언하는 것은 문제가 없다 
		Bread newBread=Bread.CHOCO;
		System.out.println("새로 만든 빵: "+newBread);
		System.out.println("새로 만든 빵의 가격: "+newBread.getPrice());
	}
}
