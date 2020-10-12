package javasql_excercise;

import java.util.*;
import java.util.ArrayList;

public class Example {

	public static void main(String args[]) {
		String s = "bai tap java web 3, *Luu y: lam tu bai 1 den bai 5 va bai 11 den bai 15";
		char[] arrS = s.toCharArray();
		boolean result = false;

		// Bai 1: bai toan dao nguoc chuoi
		char[] newArr = new char[arrS.length];

		for (int i = 0; i < arrS.length; i++) {
			newArr[newArr.length - i - 1] = arrS[i];
		}
		System.out.println("Chuoi ban dau: " + s);
		System.out.println("KQ bai 1: " + String.valueOf(newArr));

		// Bai 2: kiểm tra chuỗi có bao gồm các kí tự duy nhất (xuất hiện 1 lần) hay
		// không
		char compareChar;
		for (int i = 0; i < arrS.length; i++) {
			compareChar = arrS[i];
			for (int j = i + 1; j < arrS.length; j++) {
				if (compareChar == arrS[j]) {
					result = true;
					break;
				}
			}
			if (result == true) {
				break;
			}
		}
		System.out.println("KQ bai 2: " + result);

		// Bai 3: kiểm tra xem chuỗi đó có phải là chuỗi được tạo ra bằng cách xoay các
		// từ trong chuỗi ban đầu
		result = true;
		String compareStr = "Luu y: lam tu bai 1 den bai 5 va bai 11 den bai 15, *bai tap java web 3";
		char[] arrCompStr = compareStr.toCharArray();
		boolean contiFlag = false;
		if (s.length() == compareStr.length()) {
			char checkChar;
			for (int i = 0; i < arrS.length; i++) {

				contiFlag = false;
				checkChar = arrS[i];
				for (int j = 0; j < arrCompStr.length; j++) {

					if (checkChar == arrCompStr[j]) {

						compareStr = compareStr.substring(0, j) + compareStr.substring(j + 1);
						arrCompStr = compareStr.toCharArray();
						contiFlag = true;
						break;
					}

				}
				if (contiFlag == false) {
					break;
				}
			}

		}
		if (contiFlag == false) {
			result = false;
		}
		System.out.println("KQ bai 3: " + result);

		// Bai4: Tìm các kí tự trùng nhau trong chuỗi và đếm số lần xuất hiện của kí tự
		// đó
		int count = 1;
		char checkChar;
		boolean notDuplicate = true;
		String checkStr = s;
		char[] checkArr = checkStr.toCharArray();
		System.out.println("KQ bai 4:");

		for (int i = 0; i < checkArr.length; i++) {
			checkChar = checkArr[i];
			for (int j = i + 1; j < checkArr.length; j++) {

				if (checkChar == checkArr[j]) {
					count++;
					checkStr = checkStr.substring(0, j) + checkStr.substring(j + 1);
					checkArr = checkStr.toCharArray();
					j--;
				}
			}
			if (count > 1) {
				notDuplicate = false;
				System.out.println("ky tu: " + checkChar + " So lan trung lap: " + count + " lan");
				count = 1;
			}
		}

		if (notDuplicate == true) {
			System.out.println("KQ bai 4: khong co ky tu nao trung lap!");
		}

		// Bai 5: Tìm kí tự đầu tiên không bị lặp trong chuỗi
		// int count = 1;
		char checkChar5;
		boolean duplicateFlag5 = false;
		String checkStr5 = s;
		char[] checkArr5 = checkStr5.toCharArray();

		for (int i = 0; i < checkArr5.length; i++) {
			duplicateFlag5 = false;
			checkChar5 = checkArr5[i];
			for (int j = i + 1; j < checkArr5.length; j++) {

				if (checkChar5 == checkArr5[j]) {

					duplicateFlag5 = true;
					checkStr5 = checkStr5.substring(0, j) + checkStr5.substring(j + 1);
					checkArr5 = checkStr5.toCharArray();
					break;
				}
			}
			if (duplicateFlag5 == false) {
				System.out.println("KQ bai 5: ki tu dau tien khong trung lap: " + checkChar5);
				break;
			}
		}
		if (duplicateFlag5 == true) {
			System.out.println("KQ bai 5: tat ca cac ki tu trong chuoi deu co su trung lap");
		}

		// Bai 11:tìm giá trị lớn nhất và nhỏ nhất trong mảng
		int[] arrInt = { 1, 3, 110, 23, 2, 0, 1, 110, 1000 };
		int min = arrInt[0];
		int max = arrInt[0];
		for (int i : arrInt) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}
		System.out.println("---------------------------------------");
		System.out.println("\nKQ bai 11:");
		System.out.print("Mang da cho: ");
		for (int i : arrInt) {
			System.out.print(i + " ");
		}
		System.out.println("KQ bai 11:");
		System.out.println("min of array: " + min);
		System.out.println("max of array: " + max);

		// Bai 12: tìm số bị thiếu trong mảng
		// Ví dụ: int[] array = {7,5,6,1,4,2} -> số bị thiếu: 3
		int[] array = { 9, 11, 7, 5, 6, 1, 4, 2, 13 };
		min = array[0];
		max = array[0];
		for (int i : array) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}
		int[] array2 = new int[max - min + 1];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = min + i;
		}
		System.out.println("---------------------------------------");
		System.out.println("KQ bai 12:");
		System.out.print("Mang da cho: ");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.print("\nso bi thieu la: ");
		boolean addElementFlg = true;
		for (int i : array2) {
			addElementFlg = true;
			for (int j : array) {
				if (i == j) {
					addElementFlg = false;
					break;
				}
			}
			if (addElementFlg == true) {
				System.out.print(i + " ");
			}
		}

		// Bai 13: Cho 1 mảng số nguyên, tìm số có giá trị lớn thứ 2 trong mảng
		// Ví dụ: [1,2,3,4,5,6] -> 5
		int[] array13 = { 9, 11, 13, 1, 7, 5, 6, 1, 4, 2, 13 };

		min = array13[0];
		max = array13[0];

		for (int i : array13) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}
		int max2 = min;
		int tempMax2 = 0;
		for (int i = 0; i < array13.length; i++) {

			if (array13[i] > min && array13[i] < max) {
				tempMax2 = array13[i];
			}
			if (tempMax2 > max2) {
				max2 = tempMax2;
			}
		}
		System.out.println("\n----------------------------------------------");
		System.out.print("mang da cho: ");
		for (int i : array13) {
			System.out.print(i + " ");
		}
		System.out.println("\nKQ bai 13: so lon thu hai: " + max2);

		// Bai 14: Tìm số có số lần xuất hiện là số lẻ
		// Cho mảng {20,40,50,20,40,50,50} -> kết quả: 50
		int[] array14 = { 20, 40, 50, 20, 40, 50, 50, 1, 1, 1 };
		int count14 = 1;
		boolean oddExist = false;
		System.out.println("\n----------------------------------------------");
		System.out.print("mang da cho: ");
		for (int i : array14) {
			System.out.print(i + " ");
		}
		System.out.print("\nKQ bai 14: so co so lan xuat hien le: ");
		ArrayList<Integer> checkedList = new ArrayList<Integer>();
		for (int i = 0; i < array14.length; i++) {

			count14 = 0;
			if (!checkedList.contains(array14[i])) {
				count14 = 1;
				for (int j = i + 1; j < array14.length; j++) {

					if (array14[i] == array14[j]) {
						count14++;
					}
				}
				checkedList.add(array14[i]);
				if (count14 % 2 != 0) {
					oddExist = true;
					System.out.print(array14[i] + " ");
				}
			}
		}
		if (oddExist == false) {
			System.out.println("khong co so nao!");
		}

//		Câu 15: Tìm 2 số bất kì trong mảng thỏa điều kiện tổng 2 số gần bằng 1 số cho trước 
//		(nhỏ hơn số cho trước)
//		Cho 1 mảng: {-40,-5,1,3,20,7,8,6} và số cho trước x = 5 -> 1 và 3
		int[] array15 = { -40, -5, -1, -3, -20, -7, -8, -6 };
		int x = 5;
		int minTotal = 2*array15[0];
		
		Hashtable<String, Integer> total_dic = new Hashtable<String, Integer>();
		System.out.println("\n----------------------------------------------");
		System.out.print("mang da cho: ");		
		for (int i : array15) {
			//nhan tien :tim so be nhat trong mang truoc roi gan minTotal = 2 x min
			System.out.print(i + " ");
			if(2*i<minTotal) {
				minTotal = 2*i;
			}
		}
		System.out.print("\nx: "+x+"\n");	
		
		for (int i = 0; i < array15.length; i++) {
			for (int j = i + 1; j < array15.length; j++)
				
				if (!total_dic.contains(String.valueOf(array15[i]) + " " + String.valueOf(array15[j]))) {
					
					total_dic.put((String.valueOf(array15[i]) + " " + String.valueOf(array15[j])),
							array15[i] + array15[j]);
				}		
		}
		
		for(int i: array15)
		
		for (Integer total : total_dic.values()) {
			if (total > minTotal && total < x) {
				minTotal = total;
			}
		}
		
		Set<String> keys = total_dic.keySet();

		// Obtaining iterator over set entries
		Iterator<String> itr = keys.iterator();
		String key;
		int val;
		while (itr.hasNext()) {
			// Getting Key
			key = itr.next();
			val = total_dic.get(key);
			if (val==minTotal) {
				System.out.println("KQ bai 15: 2 so thoa man la: "+ key);
			}
		}
	}
}
