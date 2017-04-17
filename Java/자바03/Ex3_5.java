package 자바03;

enum Week{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY}

public class Ex3_5 {
	public static void main(String[] args) {
		Week today=Week.SUNDAY;
		String name=today.name();//열거객체가 가지고 있는 문자열 리턴
		System.out.println(name);
		
		int ordinal=today.ordinal();//전체 열거 객체 중 몇 번째 열거 객체인지
		System.out.println(ordinal);
		
		Week day1=Week.MONDAY;
		Week day2=Week.WEDNESDAY;
		int result1=day1.compareTo(day2);//매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번째 위치
		int result2=day2.compareTo(day1);//열거 객체가 매개값의 열거 객체보다 순번이 빠르다면 음수, 순번이 늦으면 양수 리턴
		System.out.println(result1);
		System.out.println(result2);
		
		if(args.length==1){
			String strDay= args[0];
			Week weekDay=Week.valueOf(strDay);
			if(weekDay==Week.SATURDAY||weekDay==Week.SUNDAY){
				System.out.println("놀자!!!!");
			}
			else{
				System.out.println("공부하자!!");
			}
		}
		for(Week day:Week.values()){
			System.out.println(day);
		}
	}
}
