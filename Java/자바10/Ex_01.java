package �ڹ�10;

import java.util.*;

public class Ex_01 {
	public static void main(String[] args) {
		//Key ��ü�� �ĺ�Ű�� ����ؼ�String ���� �����ϴ� Hashmap ��ü����
		HashMap<Key,String> hashMap= new HashMap<Key, String>();
		
		//�ĺ�Ű "new Key(1)" �� "ȫ�浿"�� ������
		//hashMap.put(new Key("1"), "ȫ�浿");
		hashMap.put(new Key(1), "ȫ�浿");
		
		//�ĺ�Ű "new Key(1)" �� "ȫ�浿"�� �ҷ���
		//String value=hashMap.get(new Key("1"));
		String value=hashMap.get(new Key(1));
		System.out.println(value);
		
		Object obj=new Object();
		System.out.println(obj);
		System.out.println(obj.hashCode());
		
		Object obj1=new Object();
		//Date�� toString�� override��
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