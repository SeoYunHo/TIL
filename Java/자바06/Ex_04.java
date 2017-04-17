package 자바06;

public class Ex_04 {
	public static void main(String[] args) {
		Person person=new Person();
		person.setName("길동씨");
		person.setAge(26);
		person.setRemark("오늘은 수요일이에요 장미한송이? ^.^");
		System.out.println(person.toStirng());
	}
}
