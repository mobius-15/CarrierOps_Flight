package aircrafts;

public class F_35B extends STOVL {
	int runway=1000;
	public F_35B(String name,String modex,String type,int nEngine,boolean weaponized) {
		setName("F-35B");
		setType("multiRole");
		setNEngine(1);
		setModex(modex);
		setIntfuel(13100);
		weaponized=true;
		carrierops=true;
		boolean vtol=true;
		
		}

}