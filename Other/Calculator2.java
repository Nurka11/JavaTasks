class Calculator2{
	public static void main(String[] args){
		String res="";
		if (args[0].contains("+")){
            String b5=args[0].replace("+","-");
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
			int b1=Integer.parseInt(b[0]);
            int b2=Integer.parseInt(b[1]);
            System.out.println((b[0])+" "+"+"+" "+(b[1])+" "+"="+" "+(b1+b2));
		}else if (args[0].contains("*")){
            String b5=args[0].replace("*","-");
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
			int b1=Integer.parseInt(b[0]);
            int b2=Integer.parseInt(b[1]);
            System.out.println((b[0])+" "+"*"+" "+(b[1])+" "+"="+" "+(b1*b2));
		}else if (args[0].contains("-")){
            String b5=args[0].replace("-","-");
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
			int b1=Integer.parseInt(b[0]);
            int b2=Integer.parseInt(b[1]);
            System.out.println((b[0])+" "+"-"+" "+(b[1])+" "+"="+" "+(b1-b2));
		}else if (args[0].contains("/")){
            String b5=args[0].replace("/","-");
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
			int b1=Integer.parseInt(b[0]);
            int b2=Integer.parseInt(b[1]);
            System.out.println((b[0])+" "+"/"+" "+(b[1])+" "+"="+" "+(b1/b2));
		}
	}
}