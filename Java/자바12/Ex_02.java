package 자바12;

class Electronic1{
	String name="전자 제품";
	String status;
	
	Electronic1(String status) {
		this.status=status;
	}
	
	public void currentState(){
		System.out.println(name+" "+status+" 입니다.");
	}
}

class Food1{
	String name="식품";
	String status;
	
	Food1(String status){
		this.status=status;
	}
	
	public void currentState(){
		System.out.println(name+" "+status+" 입니다.");
	}
}

class EleShip{
	Electronic1 goods;
	
	public void boxing(Electronic1 goods){
		this.goods=goods;
	}
	
	public Object unBoxing(){
		return goods;
	}
}

class FoodShip{
	Food1 goods;
	
	public void boxing(Food1 goods){
		this.goods=goods;
	}
	
	public Object unBoxing(){
		return goods;
	}
}

public class Ex_02 {
	public static void main(String[] args) {
		EleShip gs1=new EleShip();
		gs1.boxing(new Electronic1("배송시작"));
		Electronic e1=(Electronic)gs1.unBoxing();
		e1.currentState();
		
		FoodShip gs2=new FoodShip();
		//gs2.boxing("식품");
		Food f1=(Food)gs2.unBoxing();
		f1.currentState();
	}
}
