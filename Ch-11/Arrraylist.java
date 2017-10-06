import java.util.Scanner;
public class Arrraylist extends java.util.ArrayList<Object>{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        java.util.ArrayList<String> list=new java.util.ArrayList<>();
        java.util.ArrayList<String> list1=new java.util.ArrayList<>();
        StringBuilder str;
        for (int i=0; i < 5; i++) {
            String h=sc.nextLine();
            str=new StringBuilder(h);
            list.add(str.reverse()+"");
        }
        for (int i = list.size()-1; i >= 0; i--) {
            list1.add(list.get(i));
        }
        System.out.println(list1);
    } 
}//reverse