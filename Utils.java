package mable;

import java.util.Scanner;

public class Utils {
		private static Scanner scanner = new Scanner(System.in);
		
		public static String nextLine(String msg) { // 인스턴스 변수는 클래스 메소드에서 호출이 불가
			System.out.println(msg);		 // 따라서 6line에서 static 선언 
			return scanner.nextLine();
		}
		public static int nextInt(String msg) {
	//		System.out.println(msg);
			return Integer.parseInt(nextLine(msg));   // 
		}
		public static String[] initLandNames() {
			String str = "시작 > "
	                + "방콕 > "
	                + "보너스게임(동전던지기) > " 
	                + "베이징 > " 
	                + "포츈카드 > "
	                + "독도 > "
	                + "두바이 > "
	                + "카이로 > "
	                + "무인도 > "
	                + "발리 > "
	                + "도쿄 > "
	                + "시드니 > "
	                + "포츈카드 > "
	                + "퀘백 > "
	                + "하와이 > "
	                + "상파울루 > "
	                + "올림픽 > "
	                + "프라하 > "
	                + "푸켓 > "
	                + "베를린 > "
	                + "포츈카드 > "
	                + "모스크바 > "
	                + "제네바 > "
	                + "로마 > "
	                + "세계여행 > "
	                + "타히티 > "
	                + "런던 > "
	                + "파리 > "
	                + "포츈카드 > "
	                + "뉴욕 > "
	                + "국세청 > "
	                + "서울";
			String[] areasArr = str.split(" > ");
			return areasArr;
		}
}
