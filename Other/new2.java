import java.util.*;
class new2{
	public static void main(String[] args){
		GregorianCalendar d=new GregorianCalendar();
		System.out.printf("%d:%d:%d\n",d.get(GregorianCalendar.YEAR),d.get(d.MONTH),d.get(d.DAY_OF_MONTH));
		d.setTimeInMillis(1235567898541L);
		System.out.printf("%d:%d:%d",d.get(GregorianCalendar.YEAR),d.get(d.MONTH),d.get(d.DAY_OF_MONTH));
		
	}
	
	
}