package aircrafts;
import java.util.List;
import java.util.Random;

import carrierOps.CVN;
import carrierOps.Fleet;
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Random random=new Random();
		CVN cvn73 =new CVN(Fleet.cvn());//艦番号はMainで指定
		List<String> vfa102ModexList = Hanger.vfa102();
		List<String>vfa147ModexList=Hanger.vfa147();
		List<String>vfa27ModexList=Hanger.vfa27();
		List<String>vfa195ModexList=Hanger.vfa195();
//        List<String> randomModexList1 = Hanger.getRandomModexList(vfa102ModexList, 2);
//        List<String> randomModexList2 = Hanger.getRandomModexList(vfa147ModexList, 2);
//        List<String> randomModexList3 = Hanger.getRandomModexList(vfa27ModexList, 2);
//        List<String> randomModexList4 = Hanger.getRandomModexList(vfa195ModexList, 2);
		CVW cvw5 
		=new CVW(vfa102ModexList,vfa147ModexList,vfa27ModexList,vfa195ModexList);//航空団名もMainで指定
//				(randomModexList1,randomModexList2,randomModexList3,randomModexList4);
		cvw5.tailcode="NF";
		System.out.println("\n");
			FA_18F dback11 = new FA_18F("F/A-18F",vfa102ModexList.get(random.nextInt(11)),"multiRole",2,true);
			System.out.println(dback11.getName()+":"+dback11.getModex());
			Aircrafts dback12=dback11;
			FlightPlan dplan11 = new FlightPlan();
			
			dplan11.gconvertAndAdd(dplan11.FP);
			dplan11.displayFlightPlans();
			
			dback11.calculateFuelUsage(dback11,2);
////			Aircrafts hornet21 = new FA_18E(,"multiRole",2,true);
////			FlightPlan hplan21 = new FlightPlan();
////			
//
////			
////			F_35C lightning21 = new F_35C("Anti_Ship_Strike","multiRole",1,true);
////			Aircrafts lightning22=lightning21;
////			FlightPlan lplan21 = new FlightPlan();
//			
////			Aircrafts colt01 =(FA_18E) hornet21;
//			System.out.println(cvn73.getBasicPlacement()+"t");
//			Aircrafts[]sPackage=new Aircrafts[3];
//			sPackage[0]=new FA_18("CAP","multiRole",2,true);
//			sPackage[1]=new FA_18E("SEAD","multiRole",2,true);
//			sPackage[2]=new F_35C("Anti_Ship_Strike","multiRole",1,true);
//			for(Aircrafts a:sPackage) {a.launch(cvn73.getName());}
//			Aircrafts cvw=new CVW();
//			Hanger.vfa102();
//			
////			Aircrafts lightning11 = new F_35B("Ground_Strike","multiRole",1,true);
////			FlightPlan lplan11 = new FlightPlan();
//		
			
		}
	
}