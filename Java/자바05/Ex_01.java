package 자바05;

import java.util.*;

public class Ex_01 {
	public static void main(String[] args) {
		Car myCar=null;
		
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
		
		switch(key){
			case 1:
				myCar=new CompactCar();
				System.out.println("경차가 선택되었습니다.");
				break;
			case 2:
				myCar=new Sedan();
				System.out.println("세단가 선택되었습니다.");
				break;
			case 3:
				myCar=new SportsCar();
				System.out.println("스포츠가 선택되었습니다.");
				break;
		}
		
		int currentSpeed=myCar.speedUP();	//이 코드는 안바뀜
		
		System.out.println("선택하신 자동차의 선택 속도는 "+currentSpeed+"입니다. ");
	}
}

class Car{
	int speed=0;
	
	public int speedUP(){
		return speed;
	}
}

class CompactCar extends Car{
	public int speedUP(){
		return speed+10;
	}
}

class Sedan extends Car{
	public int speedUP(){
		return speed+20;
	}
}

class SportsCar extends Car{
	public int speedUP(){
		return speed+30;
	}
}

