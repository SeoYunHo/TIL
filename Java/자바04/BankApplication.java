package 자바04;

import java.util.*;

public class BankApplication {
	private static Account[] accounts=new Account[100];
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run=true;	//반복을 위한 로컬 변수
		while(run){
			System.out.println("----------------------------------------");
			System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
			System.out.println("----------------------------------------");
			System.out.print("선택> ");
			int selectNo=scanner.nextInt();
			if(selectNo==1){ createAccount(); }
			else if(selectNo==2){ accountList(); }
			else if(selectNo==3){ deposit(); }
			else if(selectNo==4){ withdraw(); }
			else if(selectNo==5){ run=false; }
		}
		System.out.println("프로그램 종료");
	}
	
	//계좌 생성하기
	private static void createAccount(){
		String ano;		
		String owner;	
		int balance;
		
		System.out.println();
		System.out.println("------------------");
		System.out.println("계좌생성");
		System.out.println("------------------");
		
		System.out.print("계좌번호> ");
		ano=scanner.next();
		
		System.out.print("계좌주> ");
		owner=scanner.next();
		
		System.out.print("잔고> ");
		balance=scanner.nextInt();
		
		Account account=new Account(ano,owner,balance);
		
		for(int i=0;i<accounts.length;i++){		//for~each문을 안쓴이유: 중간에 삭제될 수 있어서
			if(accounts[i]==null){
				accounts[i]=account;
				System.out.println("결과: 계좌가 생성되었습니다");
				break;
			}
		}
	}
	private static void accountList(){
		System.out.println();
		System.out.println("------------------");
		System.out.println("계좌목록");
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
		System.out.println("예금");
		System.out.println("------------------");
		
		System.out.print("계좌번호: ");
		String ano=scanner.next();
		Account account=findAccount(ano);
		if(account==null){ System.out.println("결과: 계좌가 없습니다.");return; }
		
		System.out.print("예금액: ");
		int money=scanner.nextInt();
		account.setBalance(account.getBalance()+money);
		
		System.out.println("결과: 예금이 성공되었습니다.");
	}
	private static void withdraw(){
		System.out.println();
		System.out.println("------------------");
		System.out.println("출금");
		System.out.println("------------------");
		
		System.out.print("계좌번호: ");
		String ano=scanner.next();
		Account account=findAccount(ano);
		if(account==null){ System.out.println("결과: 계좌가 없습니다."); return;}
		
		System.out.print("출금액: ");
		int money=scanner.nextInt();
		if(account.getBalance()-money<0){ System.out.println("결과: 잔액이 부족합니다"); return; }
		account.setBalance(account.getBalance()-money);
		
		System.out.println("결과: 출금이 성공되었습니다.");
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

class Account{				//하나의 계좌정보를 가지고 있는 클래스
	private String ano;		//계좌번호
	private String owner;	//계좌주;
	private int balance;	//잔고
	
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
