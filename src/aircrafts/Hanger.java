package aircrafts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Hanger extends Aircrafts{
	CVW tailcode;
	Aircrafts name;
	String squadron;
	
	public static List<String>vfa102() {
		
	List<String>vfa102=new ArrayList<String>();
	for(int nf=0;nf<11;nf++) {vfa102.add("NF"+(100+nf)+"");}


return vfa102;
	}
	public static List<String>vfa147(){
		
		List<String>vfa147=new ArrayList<String>();
	for(int nf2=0;nf2<11;nf2++) {vfa147.add("NF"+(300+nf2)+"");}

return vfa147;		
	}	
	public static List<String>vfa27() {
		
	List<String>vfa27=new ArrayList<String>();
	for(int nf3=0;nf3<11;nf3++) {vfa27.add("NF"+(200+nf3)+"");}

return vfa27;
	}
	public static List<String>vfa195() {
	
	List<String>vfa195=new ArrayList<String>();
	for(int nf4=0;nf4<11;nf4++) {vfa195.add("NF"+(400+nf4)+"");}

return vfa195;
}
	public static List<String> getRandomModexList(List<String> modexList, int count) {
		if(count>modexList.size()) {throw new IllegalArgumentException("無効な要素数");
		}
		Collections.shuffle(modexList); // リストをランダムにシャッフル
return new ArrayList<>(modexList.subList(0, count));
	}
}
