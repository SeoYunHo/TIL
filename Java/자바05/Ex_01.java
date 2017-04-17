package �ڹ�05;

import java.util.*;

public class Ex_01 {
	public static void main(String[] args) {
		Car myCar=null;
		
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
		
		switch(key){
			case 1:
				myCar=new CompactCar();
				System.out.println("������ ���õǾ����ϴ�.");
				break;
			case 2:
				myCar=new Sedan();
				System.out.println("���ܰ� ���õǾ����ϴ�.");
				break;
			case 3:
				myCar=new SportsCar();
				System.out.println("�������� ���õǾ����ϴ�.");
				break;
		}
		
		int currentSpeed=myCar.speedUP();	//�� �ڵ�� �ȹٲ�
		
		System.out.println("�����Ͻ� �ڵ����� ���� �ӵ��� "+currentSpeed+"�Դϴ�. ");
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

