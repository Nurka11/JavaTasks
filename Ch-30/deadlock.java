public class deadlock{
	static int i;
	public static void main(String[] args){
		Thread t=new Thread(new Runnable(){
			public void run(){
				while(i!=50){
					if(i<5)
						i++;
				}
			}
		});
		Thread t1=new Thread(new Runnable(){
			public void run(){
				while(i!=50){
					if(i>6)
						i++;
				}
			}
		});
		t.start();
		t1.start();
	}
}