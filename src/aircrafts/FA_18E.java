package aircrafts;

public class FA_18E extends FA_18 {
	
	public FA_18E(String name,String mission,String type,int nEngine,boolean weaponized) {
		super(name,mission,type,nEngine,weaponized);
		setName("F/A-18E");
		setIntFuel(14480);
		}

}
