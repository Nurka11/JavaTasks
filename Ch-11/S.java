import java.util.ArrayList;
public class S{
	public static ArrayList<Integer> shuffle(ArrayList arr){
		ArrayList <Integer> A = new ArrayList<>();
		int j=0;
		for(int i=0;i<arr.size();i++){
			if(i==arr.size()-1){
				j=-1;
			}
			A.add((int)arr.get(j+1));
			j++;
		}
		return A;
	}
	public static void main(String args[]){
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(5);
		arr.add(76);
		arr.add(78888);
		arr.add(567);
		arr.add(123);
		System.out.println(shuffle(arr));
	}
}//shuffle