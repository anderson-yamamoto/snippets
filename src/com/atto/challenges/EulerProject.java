package com.atto.challenges;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EulerProject {
	public static void main(String[] args) {

		System.out.println(getPathsOn20x20Grid());

	}

	// https://projecteuler.net/problem=1
	public static int multiples3and5() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		return sum;
	}

	// https://projecteuler.net/problem=6
	public static long getDifferenceSquareSumAndSumSquare(int lastNumber) {
		long sum = (1 + lastNumber) * lastNumber / 2;
		long difference = 0;
		for (int i = 1; i <= lastNumber; i++) {
			difference += (sum - i) * i;
		}
		return difference;
	}

	// https://projecteuler.net/problem=13
	public static String getFirst10DigitsSum100numbersWith50Digits(String filename) {
		StringBuffer digits = new StringBuffer();
		List<String> data = new ArrayList<String>();
		try (Scanner scanner = new Scanner(new File(filename))) {

			while (scanner.hasNext()) {
				data.add(scanner.nextLine());
			}
		} catch (Exception e) {
		}

		int sum = 0, rest = 0;
		for (int i = 49; i > -1; i--) {
			sum = 0;
			for (String ss : data) {
				sum += (ss.charAt(i) - '0');
			}
			sum += rest;
			System.out.println(sum);
			rest = (sum / 10);
			digits.append(String.valueOf(sum % 10));
		}
		String sumString = String.valueOf(sum);
		for (int i = sumString.length() - 2; i > -1; i--) {
			digits.append(sumString.charAt(i));
		}
		return digits.reverse().substring(0, 10);
	}

	// https://projecteuler.net/problem=15
	public static long getPathsOn20x20Grid() {
		long[][] calc = new long[20][20];
		for (int i = 0; i < 20; i++) {
			calc[0][i] = i + 2;
			calc[i][0] = i + 2;
		}

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				calc[i][j] = calc[i - 1][j] + calc[i][j - 1];
				System.out.print(calc[i][j] + " ");
			}
			System.out.println();
		}
		return calc[19][19];
	}

	// https://projecteuler.net/problem=38
	public static int pandigital() {
		int biggest = 0, biggestIntGenerated = 0;
		String biggestPandigital = "";
		for (int i = 9999; i > 1; i--) {
			StringBuilder pandigital = new StringBuilder();
			int multiplier = 1;
			pandigital.append(i * multiplier);
			while (pandigital.length() < 9) {
				multiplier++;
				pandigital.append(i * multiplier);
			}
			if (pandigital.length() == 9 && !checkValidPandigital1to9(pandigital)) {
				System.out.println(pandigital + "-" + i);
				int p = Integer.parseInt(pandigital.toString());
				if (p > biggest) {
					biggest = p;
					biggestIntGenerated = i;
					biggestPandigital = pandigital.toString();
				}
			}
		}
		System.out.println(biggestPandigital + "-" + biggestIntGenerated);
		return biggest;
	}

	private static boolean checkValidPandigital1to9(StringBuilder pandigital) {
		for (int i = 0; i < pandigital.length(); i++) {
			if (pandigital.charAt(i) == '0')
				return true;
			for (int j = i + 1; j < pandigital.length(); j++) {
				if (pandigital.charAt(i) == pandigital.charAt(j))
					return true;
			}
		}
		return false;
	}
}
