package mable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 상영관 하나 
// 영화 두개 
public class GameService {
	// players
	List<Player> players = new ArrayList<>();
	
	
	
	
	// areas
	
	List<Area> areas = new ArrayList<>(); // instance 변수, areas에 Arrays.asList(areasArr)이 들어있음
	{	// 지역 초기화
		String[] areasArr = Utils.initLandNames();
		for (int i = 0; i < areasArr.length; i++) {
			if(i % 4 == 0 || i == 2 || i == 30) {  // 이벤트 지역
				areas.add(new Area(i+1, areasArr[i]));
			}
			else {  // 구매 가능 지역
				areas.add(new Area(i+1, areasArr[i], true));
			}
		}
		
		// 플레이어 초기화
		int playerCount = Utils.nextInt("플레이할 인원수를 정하세요");
		
		for(int i = 0; i < playerCount; i++) {
			players.add(new Player(i + 1));
		}
//		areas.addAll(Arrays.asList(areasArr));
//		for(String s : areasArr) {
//			areas.add(s);
//		}
//		areas = Arrays.asList(areasArr);
	}
	void play(){
		for(int i = 0; players.size() > 1; i++) {
			int pNum = i % players.size();
			Player p = players.get(pNum);  // player 순환 : pos %= 32;와 같은 개념
			Utils.nextLine(pNum + 1 +  "player의 차례입니다. 엔터를 누르세요 > ");
			p.roll();
//			System.out.println("더블 여부 : " + (p.doubleCount > 0));
			Area area = areas.get(p.pos);
			System.out.println("현재 위치 : " + area );
			System.out.println("현재 머니 : " + p.money);
			
			// 내가 밟은 땅이 구매 가능한 땅
			if(area.buyable) {
				if(area.playerNo == null) {
					// 구매 의사 질문 후 처리(추후 예정) / 현재는 무조건 구매
					if(p.money >= 20) {
						area.playerNo = p.playerNo;
						p.money -= 20;
					}
					else {
						System.out.println("돈이 부족해서 못 삽니다");
					}
				}
				else { // 누군가가 소유함
					if(p.playerNo == area.playerNo){ // 내 땅
						System.out.println("건물 올리기 추후에 구현 예정");
					}
					else {
						if(p.money < 40) {
							System.out.println("파산");
							bankrupt(p.playerNo);
							// 진행 중인 게임의 플레이어들 목록에서 플레이어 제거
//							players.remove(i % players.size());
							players.remove(p);
						}
						else {
							System.out.println("지불");
//							area.playerNO 기반으로 해당 플레이어의 금액 + 40
							Player p2 = findPlayerBy(area.playerNo);
							p2.money += 40;
//							내 금액 - 40
							p.money -= 40;
						}
					}
				}
			}
			else { // 못 삼 (이벤트 땅)
				System.out.println("이벤트 발생 ~ 완료");
			}
			print(p.playerNo);
		}
		System.out.println("게임 종료");
	}
	Player findPlayerBy(int playerNo) {
		for(int j = 0; j < players.size(); j++) {
			if(playerNo == players.get(j).playerNo) {
				return players.get(j);
			}
		}
		return null;
	}
	void print(Integer playerNo){
		System.out.println(playerNo + "플레이어 정보");
		if(findPlayerBy(playerNo)== null) {
			System.out.println(playerNo + "플레이어는 파산하여 게임에서 나갑니다");
			System.out.println("남은 플레이어수 " + players.size());
			return;
		}
		System.out.println("현재 보유 금액 : " + findPlayerBy(playerNo).money);
		System.out.println("=============================================");
		for(Area a : areas) {
			if(a.playerNo == playerNo) {
				System.out.println(a);
			}
		}
	}
	void bankrupt(Integer playerNo){
		for(Area a : areas) {
			if(a.playerNo == playerNo) {
				a.playerNo = null;
			}
		}
	}
	
	
	{
//		players.get(0).roll();
	}
}
