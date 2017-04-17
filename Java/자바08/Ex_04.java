package �ڹ�08;

class Person{
	void wake(){
		System.out.println("7�ÿ� �Ͼ�ϴ�.");
	}
}

class Anonymous{
	//�ʵ� �ʱⰪ���� ����
	Person field=new Person(){
		void work(){
			System.out.println("����մϴ�.");
		}
		@Override
		void wake(){
			System.out.println("6�ÿ� �Ͼ�ϴ�.");
			work();
		}
	};
	
	void method1(){
		//���ú��� ������ ����
		Person localVar=new Person(){
			void walk(){
				System.out.println("��å�մϴ�.");
			}
			@Override
			void wake() {
				// TODO Auto-generated method stub
				System.out.println("7�ÿ� �Ͼ�ϴ�.");
				walk();
			}
		};
		//���ú��� ���
		localVar.wake();
	}
	void method2(Person person){
		person.wake();
	}
}

public class Ex_04 {
	public static void main(String[] args) {
		Anonymous anony=new Anonymous();
		//�͸� ��ü �ʵ� ���
		anony.field.wake();
		//�͸� ��ü ���ú��� ���
		anony.method1();
		//�͸� ��ü �Ű��� ���
		anony.method2(
			new Person(){
				void study(){
					System.out.println("�����մϴ�.");
				}
				@Override
				void wake() {
					// TODO Auto-generated method stub
					System.out.println("8�ÿ� �Ͼ�ϴ�.");
					study();
				}
			}
		);
	}
}
