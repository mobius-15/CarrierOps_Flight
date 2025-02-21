package aircrafts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FlightPlan2 extends Aircrafts{
	int distance;
	int altitude;
	int wayPoint;
//	int wpCount;
	int[][]FP;
	private static List<int[]>fpList=new ArrayList<>();
	private final Scanner scanner = new Scanner(System.in); 
    private static final String URL
= "jdbc:mysql://localhost:3306/standard_atmosphere?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root"; 
    private static final String PASSWORD = "qq3g9yp"; 
	
	public FlightPlan2() {

		Scanner scanner=new Scanner(System.in);
		try {
		System.out.println("Mission(飛行目的)を入力");
		String missionType=scanner.nextLine();
		System.out.println("WP数を入力");
		wayPoint=getValidIntInput(scanner,"WP(整数):");
		if(wayPoint>25) {wayPoint=25;}
		
		FP=this.specify(wayPoint);
		}catch (Exception e) {
			System.err.println("エラー " + e.getMessage());
		}

	}
	public static  Connection getConnection() throws SQLException  {

		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	public int[][]specify (int wayPoint){
		int[][]sa=new int[wayPoint][3];//
		
		
		try(Connection conn=getConnection()) {
	
	for(int s=0;s<sa.length;s++){super.wpCount++;
		
		System.out.println("WP"+super.wpCount+"の高度を入力");
		sa[s][0]= getValidIntInput(scanner,"Altitude(整数):");
		 sa[s][0]=Math.max(100, Math.min(50000, sa[s][0]));
			
		System.out.println("WP"+super.wpCount+"の速度を入力");
		double ρ_ρ0=getDataBase(conn,sa[s][0]);
		int cas=getValidIntInput(scanner,"knots(整数):");
			cas=Math.max(130, Math.min(1000,cas));
		sa[s][1]
		=(int)(cas*(1/Math.sqrt(ρ_ρ0)));
		
		System.out.println("次WPとの距離を入力");		
		sa[s][2]= getValidIntInput(scanner,"nm(整数):");
		sa[s][2]=Math.max(5, Math.min(300, sa[s][2]));
		}
	}catch(SQLException e) {
			
			System.err.println("SQLError: " + e.getMessage());			
		}
		return sa;
	}
	private double getDataBase(Connection conn,int altitude)throws SQLException {
		String sql="SELECT density_ratio FROM altitude LEFT JOIN density ON altitude.id=density.id "
		+ "WHERE feet = (SELECT feet FROM altitude WHERE feet <= ? ORDER BY ABS(feet - ?) LIMIT 1) ";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1,altitude);
			pstmt.setInt(2,altitude);
			ResultSet rs=pstmt.executeQuery();
		
			if(rs.next()){return rs.getDouble("density_ratio");
			}else {	System.err.println("取得できず"); 
			return 0.5;}
		}
		
	}
		
    private int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("入力は整数のみ");
                scanner.nextLine(); }// バッファをクリア
        	}
        
        }
    private double getValidDoubleInput(Scanner scanner, String prompt) {
        while (true) {			//燃料用
            try {
                System.out.print(prompt + " ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("入力は数値のみ");
                scanner.nextLine();
            }
        }
    
//	public int[][] getFlightPlan() {
////		return FP;
	}
	public void gconvertAndAdd(int[][]FP) {
        for (int[] point : FP) {
            fpList.add(point);
        }
	}
	 public void displayFlightPlans() {
	        if (fpList == null) {
	            System.err.println("No ArrayList");
	            return;
	        }	    	
	        for (int[] point : fpList){
	        	System.out.println("Altitude (ft)\tTAS Speed (kt)\tDistance (nm)\"");
	            System.out.println(point[0] + "ft\t\t" + point[1] + "kt\t\t" + point[2] + "nm");
	        	if(point[0]>0) {int second=(point[2]*3600/point[1]);
	        	System.out.println("目標通過時間は"+second/60+"分"+second%60+"秒(nm/kt)");

	        	System.out.println("飛行距離は"+(this.distance+=point[2])+"nm");
	        	
	        	}else { System.err.println("無効");}
	    	}
		
	    }
	 
	public static List<int[]> getFpList() {
		return fpList;
	}
}	
	
//	public void displayFuelInfo() {
//	    for (int[] point : fpList) {
//	        double distanceNM = point[2];
//	        double timeHours = distanceNM / point[1]; // 時間 (時単位)
//	        double fuelUsed = (super.fuelFlow * timeHours * 3600 )*2.205;// 燃料使用量 (kg)
//	        System.out.println("WPでの燃料消費量: " + fuelUsed + " lb");
//	        System.out.println("TSFC: " +/* calculateTSFC()*/ getSfc()+ " (lb/s/N)");
//	    }
	    
	    

//	}
//}

	
