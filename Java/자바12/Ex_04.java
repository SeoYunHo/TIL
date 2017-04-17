package ÀÚ¹Ù12;

class Box<T>{
	private T t;
	public T get(){return t;}
	public void set(T t){this.t=t;}
}
class Util{
	public static <T> Box<T> boxing(T t){
		Box<T> box=new Box<>();
		box.set(t);
		return box;
	}
}
public class Ex_04 {
	public static void main(String[] args) {
		Box<Integer> box1=Util.<Integer>boxing(100);
		int intValue=box1.get();
		System.out.println(intValue);
		
		Box<String> box2=Util.boxing("È«±æµ¿");
		String strValue=box2.get();
		System.out.println(strValue);
	}
}
