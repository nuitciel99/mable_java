package mable;

import java.util.List;
import java.util.Random;

// 초기 금액
// 시작 지점을 돌아갔을 때 받는 급여 
public class Player {
	
	Integer playerNo;
	int pos;
	int doubleCount;
	int money = 200; 
	
//	List<Area> areas;
	
	public Player(Integer playerNo) {
		this.playerNo = playerNo;
	}

	void roll() {
		
		
		
		
		int dice = new Random().nextInt(6) + 1; // 1-6
		int dice2 = new Random().nextInt(6) + 1; // 1-6
		int result = dice + dice2;
		System.out.printf("주사위1 : %d, 주사위2 : %d, 합계 : %d%n", dice, dice2, result);
		if(dice == dice2) {
			doubleCount++;
		}
		else {
			doubleCount = 0;
		}
		pos += result;
//		pos %= 32;
		if(pos >= 32) {
			money += 20;
			System.out.println("20만원을 받았습니다.");
			pos %= 32;
		}
	}
}
