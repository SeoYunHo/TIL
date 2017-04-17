package �ڹ�03;

enum Week{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY}

public class Ex3_5 {
	public static void main(String[] args) {
		Week today=Week.SUNDAY;
		String name=today.name();//���Ű�ü�� ������ �ִ� ���ڿ� ����
		System.out.println(name);
		
		int ordinal=today.ordinal();//��ü ���� ��ü �� �� ��° ���� ��ü����
		System.out.println(ordinal);
		
		Week day1=Week.MONDAY;
		Week day2=Week.WEDNESDAY;
		int result1=day1.compareTo(day2);//�Ű������� �־��� ���� ��ü�� �������� ���ķ� �� ��° ��ġ
		int result2=day2.compareTo(day1);//���� ��ü�� �Ű����� ���� ��ü���� ������ �����ٸ� ����, ������ ������ ��� ����
		System.out.println(result1);
		System.out.println(result2);
		
		if(args.length==1){
			String strDay= args[0];
			Week weekDay=Week.valueOf(strDay);
			if(weekDay==Week.SATURDAY||weekDay==Week.SUNDAY){
				System.out.println("����!!!!");
			}
			else{
				System.out.println("��������!!");
			}
		}
		for(Week day:Week.values()){
			System.out.println(day);
		}
	}
}
