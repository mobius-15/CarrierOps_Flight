package aircrafts;

import java.util.Random;
import java.util.Scanner;
public class FA_18 extends Aircrafts{	

		private int extFuel;
		private double remainingFuel;
		int a_bThrust;
		int totalFuel;
		int[][]FP;
		
		Random random=new Random();
		Scanner scanner=new Scanner(System.in);
 FA_18(String name,String type,int nEngine,boolean weaponized) {
			setName("F/A-18C");
			setType("multiRole");
			setNEngine(2);
			setCruiseSpeed(480);
			setCeilingAlt(50000);
//			setModex(modex);
			setIntfuel(10800);
			setSfc(0.81);
			setMilThrust(11000);
			setEmptyWeight(25100);
			setFullWeight(50200);
			this.a_bThrust=17700;
			weaponized=true;
		

		}
		public int rateOfClimb(int ceilingAlt) {
			return ceilingAlt/60;
		}
		public void angleOfAttack() {
			
		}
		public void engine(int enginePower) {
			
		}
		public void afterBurner(int a_bPower) {
			setSfc(1.74);
		}
		public void flightControl() {
			
		}
		public void reloadFlight() {
			
		}
		public void launch(String name) {
			System.out.println(name+"を発艦");
			System.out.println("カタパルトを使用");
	}
		public int getExtFuel() {
			return extFuel;
		}
		public void setExtFuel(int extFuel) {
			this.extFuel = extFuel;
		}
		public void calculateFuelUsage(Aircrafts aircraft,int nTank) {
		    int totalFuel = aircraft.getIntFuel()+(this.extFuel*nTank); // 燃料を取得


		    System.out.println("初期搭載燃料: " + totalFuel + " lb");
//		for(int i=0;i<FlightPlan.getFpList().size();i++){
							
		    for (int[] point : FlightPlan2.getFpList()) {wpCount++;
		    	System.out.println("WP "+wpCount+" Status?");
		    	String status=scanner.nextLine().toLowerCase();
		        double timeHours =(double) point[2] / point[1]; // 時間 (時単位)
		        double fuelUsed;
		        
 
		        if(status.contains("climb")){System.out.println("Climbing");
		        			setMilThrust(11000);
		        				fuelUsed=(fuel()*timeHours)+(climbingFF()*timeHours);}
		        
		        else if(status.contains("cruis")){System.out.println("Cruising");
		        	if(getFullWeight()>=40000){setMilThrust((int)(getMilThrust()*0.5));
		        	}else {setMilThrust((int)(getMilThrust()*0.3));}
		        		fuelUsed=fuel()*timeHours;}
		        
		        else{fuelUsed=fuel()*timeHours;}
		        	
		        totalFuel -=fuelUsed;	 // 残燃料を更新
	        
		        System.out.println("WP "+wpCount+" での燃料消費量: " +(int) fuelUsed + " lb");
		        if (totalFuel < 0) {
		            System.err.println("Low Fuel: Divert or Request Tanker");
		            break;}
		        System.out.println("残燃料: " + totalFuel + " lb");}

//	     }
//	 }             		    		    
}   
		public double climbingFF() {
				double abflow=getSfc()*this.a_bThrust*getnEngine()*random.nextDouble(0.05);
				return abflow;

	}
		public double fuel() {
			double fuel=getFuelFlow()*getnEngine();
			return fuel;
		}
}
