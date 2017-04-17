package 자바11;

public class Ex_04 {
	public static void main(String[] args) {
		Integer i=new Integer(10);			//Boxing
		Integer j=Integer.valueOf(1000);	//Boxing
		Double d=new Double(10.1);			//Boxing
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(d);
		
		i=new Integer(i.intValue()+20);		//UnBoxing 후 Boxing
		d=new Double(d.doubleValue()+0.4);	//UnBoxing 후 Boxing
		
		System.out.println(i);
		System.out.println(d);
	}
}
