package aircrafts;

import java.util.List;

import carrierOps.Vessels;


public class CVW extends Hanger {
	Vessels name;
	Aircrafts getName;
	String tailcode;
	
	public CVW
	(List<String> vfa102modexList,List<String>vfa147modexList,List<String>vfa27modexList,List<String>vfa195modexList){
		
	Aircrafts[]cvw=new Aircrafts[4];//空母航空団の編成　一般的な編成
	cvw[0]=new FA_18E(getName(),vfa27modexList.get(5),getType(),2,true);
	cvw[1]=new F_35C(getName(),vfa147modexList.get(7),getType(),1,true);
	cvw[2]=new FA_18F(getName(),vfa102modexList.get(3),getType(),2,true);
	cvw[3]=new FA_18E(getName(),vfa195modexList.get(9),getType(),2,true);
	for(Aircrafts i:cvw) {System.out.println(i.getName()+":"+i.getModex());}
//	squadrons[0]= new VFA();
//	squadrons[1]= new VFA();
//	squadrons[2]= new VFA();
//	squadrons[3]= new VFA();
//	squadrons[4]= new vaq141();
//	squadrons[5]= new vaw125();
//	squadrons[6]= new vrc30();
//	squadrons[7]= new hsc12();
//	squadrons[8]= new hsm77();
	}
	public void deployment(Vessels name,Aircrafts[]squadron) {
		
	}
	public String toString() {
		return this.getName()+":"+this.squadron;
	}
}
