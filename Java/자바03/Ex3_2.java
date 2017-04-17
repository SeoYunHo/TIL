package ÀÚ¹Ù03;

public class Ex3_2 {
	public static void main(String[] args) {
		int[] scores = { 83, 90, 87 };
		int sum1 = 0;

		for (int i = 0; i < scores.length; i++) {
			sum1 += scores[i];
		}
		System.out.println("ÃÑ ÇÕ: " + sum1);

		int sum2 = add(new int[] { 83, 90, 87 });
		System.out.println("ÃÑ ÇÕ: " + sum2);
	}

	public static int add(int[] scores) {
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		return sum;
	}
}
