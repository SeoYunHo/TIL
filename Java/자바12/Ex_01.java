package �ڹ�12;

class Electronic{
	String name="���� ��ǰ";
	String status;
	
	Electronic(String status) {
		this.status=status;
	}
	
	public void currentState(){
		System.out.println(name+" "+status+" �Դϴ�.");
	}
}

class Food{
	String name="��ǰ";
	String status;
	
	Food(String status){
		this.status=status;
	}
	
	public void currentState(){
		System.out.println(name+" "+status+" �Դϴ�.");
	}
}

class GoodsShip{
	Object goods;
	
	public void boxing(Object goods){
		this.goods=goods;
	}
	
	public Object unBoxing(){
		return goods;
	}
}

public class Ex_01 {
	public static void main(String[] args) {
		GoodsShip gs1=new GoodsShip();
		gs1.boxing(new Electronic("��۽���"));
		Electronic e1=(Electronic)gs1.unBoxing();
		e1.currentState();
		
		GoodsShip gs2=new GoodsShip();
		gs2.boxing("��ǰ");
		Food f1=(Food)gs2.unBoxing();
		f1.currentState();
	}
}
