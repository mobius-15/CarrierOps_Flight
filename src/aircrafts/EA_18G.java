package aircrafts;

public class EA_18G extends FA_18F {
	public EA_18G(String name,String modex,String type,int nEngine,boolean weaponized) {
		super(name,modex,type,nEngine,weaponized);
		setName("EA-18G");
		setType("jammer");
	}
}
