public class bubblesortmin{
	public static void main(String[] args){
		int[] sort = {95,12,14,86,3,2};
		for(int i=0;i<sort.length;i++){
			int min = sort[i];
			for(int j=i;j<sort.length;j++){
				if(min>sort[j]){
					int k = min;
					min = sort[j];
					sort[j] = k;
				}
			}
			sort[i] = min;
		}
		for(int i=0;i<sort.length;i++)
			System.out.print(sort[i]+",");
	}
}