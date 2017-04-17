package �ڹ�11_��������;

import java.util.*;

public class Ex_01 {
	public static void main(String[] args) {
		//������ü ����
		Member original=new Member("ȫ�浿", 25, new int[] {90,90}, new Car("�ҳ�Ÿ"));
		
		//���� ��ü�� ���� �Ŀ� ���� ��ü�� ���� ����
		Member cloned=original.getMember();
		cloned.scores[0]=100;
		cloned.car.model="�׷���";
		
		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println("name: "+cloned.name);
		System.out.println("age: "+cloned.age);
		System.out.print("scores: {");
		for(int i=0;i<cloned.scores.length;i++){
			System.out.print(cloned.scores[i]);
			System.out.print((i==(cloned.scores.length-1))?"":",");
		}
		System.out.println("}");
		System.out.println("car: "+cloned.car.model);
		
		System.out.println();
		
		System.out.println("[���� ��ü�� �ʵ尪]");
		System.out.println("name: "+original.name);
		System.out.println("age: "+original.age);
		System.out.print("scores: {");
		for(int i=0;i<original.scores.length;i++){
			System.out.print(original.scores[i]);
			System.out.print((i==(original.scores.length-1))?"":",");
		}
		System.out.println("}");
		System.out.println("car: "+original.car.model);
	}
}

class Car{
	public String model;
	
	public Car(String model){
		this.model=model;
	}
}

class Member implements Cloneable{
	public String name;
	public int age;
	public int[] scores;
	public Car car;
	
	public Member(String name,int age,int[] scores,Car car){
		this.name=name;
		this.age=age;
		this.scores=scores;
		this.car=car;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//���� ���� ���縦 �ؼ� name, age�� �����Ѵ�.
		Member cloned=(Member) super.clone();
		//scores�� �����Ѵ�.
		cloned.scores=Arrays.copyOf(this.scores, this.scores.length);
		//car�� �����Ѵ�.
		cloned.car=new Car(this.car.model);
		//���� ����� Member ��ü�� ����
		return cloned;
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
