package 자바10;

import java.util.*;

public class Ex_01 {
	public static void main(String[] args) {
		//Key 객체를 식별키로 사용해서String 값을 저장하는 Hashmap 객체생성
		HashMap<Key,String> hashMap= new HashMap<Key, String>();
		
		//식별키 "new Key(1)" 로 "홍길동"을 저장함
		//hashMap.put(new Key("1"), "홍길동");
		hashMap.put(new Key(1), "홍길동");
		
		//식별키 "new Key(1)" 로 "홍길동"을 불러옴
		//String value=hashMap.get(new Key("1"));
		String value=hashMap.get(new Key(1));
		System.out.println(value);
		
		Object obj=new Object();
		System.out.println(obj);
		System.out.println(obj.hashCode());
		
		Object obj1=new Object();
		//Date는 toString을 override함
		Date obj2=new Date();
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		
	}
}

class Key{
	public int number;
	
	public Key(int number){
		this.number=number;
	}
	
	@Override
	public boolean equals(Object obj){
		System.out.println("equals");
		if(obj instanceof Key){
			Key compareKey= (Key) obj;
			if(this.number==compareKey.number){
				return true;
			}
		}
	return false;
	}
	
	@Override
	public int hashCode(){
		System.out.println("hashCode:"+number);
		return number;
	}
}