package �ڹ�03;

enum Parents{FATHER, MOTHER}

public class Ex3_4 {
	public static void printParents(Parents p){
		System.out.println(p);
	}
	public static void print(Parents d){
		switch(d){
		case FATHER: System.out.println("�ƺ�");break;
		case MOTHER: System.out.println("����");break;
		default:System.out.println("�θ�� �� �Ѻи�!!");
		}
	}
	public static void main(String[] args) {
		printParents(Parents.MOTHER);
		print(Parents.FATHER);
		print(Parents.MOTHER);
		//print(Parents.BROTHER);
		
		for(Parents p:Parents.values()){
			System.out.println("enum ���� ������ : "+p);
		}
	}
}
