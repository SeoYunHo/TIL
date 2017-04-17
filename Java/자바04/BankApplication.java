package �ڹ�04;

import java.util.*;

public class BankApplication {
	private static Account[] accounts=new Account[100];
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run=true;	//�ݺ��� ���� ���� ����
		while(run){
			System.out.println("----------------------------------------");
			System.out.println("1.���»���|2.���¸��|3.����|4.���|5.����");
			System.out.println("----------------------------------------");
			System.out.print("����> ");
			int selectNo=scanner.nextInt();
			if(selectNo==1){ createAccount(); }
			else if(selectNo==2){ accountList(); }
			else if(selectNo==3){ deposit(); }
			else if(selectNo==4){ withdraw(); }
			else if(selectNo==5){ run=false; }
		}
		System.out.println("���α׷� ����");
	}
	
	//���� �����ϱ�
	private static void createAccount(){
		String ano;		
		String owner;	
		int balance;
		
		System.out.println();
		System.out.println("------------------");
		System.out.println("���»���");
		System.out.println("------------------");
		
		System.out.print("���¹�ȣ> ");
		ano=scanner.next();
		
		System.out.print("������> ");
		owner=scanner.next();
		
		System.out.print("�ܰ�> ");
		balance=scanner.nextInt();
		
		Account account=new Account(ano,owner,balance);
		
		for(int i=0;i<accounts.length;i++){		//for~each���� �Ⱦ�����: �߰��� ������ �� �־
			if(accounts[i]==null){
				accounts[i]=account;
				System.out.println("���: ���°� �����Ǿ����ϴ�");
				break;
			}
		}
	}
	private static void accountList(){
		System.out.println();
		System.out.println("------------------");
		System.out.println("���¸��");
		System.out.println("------------------");
		
		for(int i=0;i<accounts.length;i++){
			Account account=accounts[i];
			if(account!=null){
				System.out.println(account.toString());
			}
		}
	}
	private static void deposit(){
		System.out.println();
		System.out.println("------------------");
		System.out.println("����");
		System.out.println("------------------");
		
		System.out.print("���¹�ȣ: ");
		String ano=scanner.next();
		Account account=findAccount(ano);
		if(account==null){ System.out.println("���: ���°� �����ϴ�.");return; }
		
		System.out.print("���ݾ�: ");
		int money=scanner.nextInt();
		account.setBalance(account.getBalance()+money);
		
		System.out.println("���: ������ �����Ǿ����ϴ�.");
	}
	private static void withdraw(){
		System.out.println();
		System.out.println("------------------");
		System.out.println("���");
		System.out.println("------------------");
		
		System.out.print("���¹�ȣ: ");
		String ano=scanner.next();
		Account account=findAccount(ano);
		if(account==null){ System.out.println("���: ���°� �����ϴ�."); return;}
		
		System.out.print("��ݾ�: ");
		int money=scanner.nextInt();
		if(account.getBalance()-money<0){ System.out.println("���: �ܾ��� �����մϴ�"); return; }
		account.setBalance(account.getBalance()-money);
		
		System.out.println("���: ����� �����Ǿ����ϴ�.");
	}
	private static Account findAccount(String ano){
		Account account=null;
		for(int i=0;i<accounts.length;i++){
			Account dbAno=accounts[i];
			if(dbAno.equals(ano)){
				account=accounts[i];
				break;
			}
		}
		return account;
	}
}

class Account{				//�ϳ��� ���������� ������ �ִ� Ŭ����
	private String ano;		//���¹�ȣ
	private String owner;	//������;
	private int balance;	//�ܰ�
	
	public Account(String ano,String owner,int balance){
		this.ano=ano;
		this.owner=owner;
		this.balance=balance;
	}
	public Account(){}

	public String getAno() { return ano; }
	public void setAno(String ano) { this.ano = ano; }
	public String getOwner() { return owner; }
	public void setOwner(String owner) { this.owner = owner; }
	public int getBalance() { return balance; }
	public void setBalance(int balance) { this.balance = balance; }
	
	public String toString(){
		return ano+"	"+owner+"	"+balance;
	}
}
