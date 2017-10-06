import java.util.Scanner;
class Calculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
		String res="";
        if (args[0].contains("+")){
            String b5=a[0].replace("+","-");
			String[] b6=b5.split(" ");
            for (int i=0;i<b6.length;i++ ) {
                if (b6[i]==" "){
                    b6[i]="";
                }
            }
            for (int i=0;i<b6.length;i++ ) {
                res+=b6[i];
            }
            String b[]=res.split("-");
            int j=b[0].length();
            int k=b[1].length();
            int b1=Integer.parseInt(b[0].substring(1,j));
            int b2=Integer.parseInt(b[1].substring(0,k-1));
            System.out.println((b[0].substring(1,j))+" "+"+"+" "+(b[1].substring(0,k-1))+" "+"="+" "+(b1+b2));
		}else if (a.contains("*")){
			String b5=a.replace("*","-");
			String[] b6=b5.split(" ");
            for (int i=0;i<b6.length;i++ ) {
                if (b6[i]==" "){
                    b6[i]="";
                }
            }
            for (int i=0;i<b6.length;i++ ) {
                res+=b6[i];
            }
            String b[]=res.split("-");
            int j=b[0].length();
            int k=b[1].length();
            int b1=Integer.parseInt(b[0].substring(1,j));
            int b2=Integer.parseInt(b[1].substring(0,k-1));
            System.out.println((b[0].substring(1,j))+" "+"*"+" "+(b[1].substring(0,k-1))+" "+"="+" "+(b1*b2));
			
		}else if (a.contains("-")){
			String[] b6=a.split(" ");
            for (int i=0;i<b6.length;i++ ) {
                if (b6[i]==" "){
                    b6[i]="";
                }
            }
            for (int i=0;i<b6.length;i++ ) {
                res+=b6[i];
            }
			String b[]=res.split("-");
            int j=b[0].length();
            int k=b[1].length();
            int b1=Integer.parseInt(b[0].substring(1,j));
            int b2=Integer.parseInt(b[1].substring(0,k-1));
            System.out.println((b[0].substring(1,j))+" "+"-"+" "+(b[1].substring(0,k-1))+" "+"="+" "+(b1-b2));
		}else if (a.contains("/")){
			String[] b6=a.split(" ");
            for (int i=0;i<b6.length;i++ ) {
                if (b6[i]==" "){
                    b6[i]="";
                }
            }
            for (int i=0;i<b6.length;i++ ) {
                res+=b6[i];
            }
			String b[]=res.split("/");
            int j=b[0].length();
            int k=b[1].length();
            int b1=Integer.parseInt(b[0].substring(1,j));
            int b2=Integer.parseInt(b[1].substring(0,k-1));
            System.out.println((b[0].substring(1,j))+" "+"/"+" "+(b[1].substring(0,k-1))+" "+"="+" "+((double)b1/b2));
		}
	}
}