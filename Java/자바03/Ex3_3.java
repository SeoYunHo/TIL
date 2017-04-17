package ÀÚ¹Ù03;

public class Ex3_3 {
	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 10, 12, 14, 16 };
		int[] b = { 1, 1, 2, 3, 4, 8, 13, 21 };
		
		for(int i=0;i<a.length;i++){
			int num=a.length-1-i;
			System.out.print(a[i]+b[num]+" ");
		}
		System.out.println();
	}
}
