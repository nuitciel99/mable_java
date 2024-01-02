package mable;

public class Area {
	
//	Player player;
	int areaNo;
	String name;
	boolean buyable;
	
	
	Integer playerNo;


	public Area(int areaNo, String name) {
		this.areaNo = areaNo;
		this.name = name;
	}


	public Area(int areaNo, String name, boolean buyable) {
		this.areaNo = areaNo;
		this.name = name;
		this.buyable = buyable;
	}


	@Override
	public String toString() {
		return areaNo + " 번 지역 / " + name;
	}
	
	

}
