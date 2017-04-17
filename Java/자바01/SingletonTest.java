package ÀÚ¹Ù01;

public class SingletonTest {
	private static SingletonTest sgt=new SingletonTest();
	private int cnt=0;
	private SingletonTest(){}
	
	public static SingletonTest getInstance(){
		return sgt;
	}
	public int getNextInt(){
		return cnt+=1;
	}
}
