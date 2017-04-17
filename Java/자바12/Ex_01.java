package 자바12;

class Electronic{
	String name="전자 제품";
	String status;
	
	Electronic(String status) {
		this.status=status;
	}
	
	public void currentState(){
		System.out.println(name+" "+status+" 입니다.");
	}
}

class Food{
	String name="식품";
	String status;
	
	Food(String status){
		this.status=status;
	}
	
	public void currentState(){
		System.out.println(name+" "+status+" 입니다.");
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
		gs1.boxing(new Electronic("배송시작"));
		Electronic e1=(Electronic)gs1.unBoxing();
		e1.currentState();
		
		GoodsShip gs2=new GoodsShip();
		gs2.boxing("식품");
		Food f1=(Food)gs2.unBoxing();
		f1.currentState();
	}
}
