
public class ArraysDemo {

	public static void main(String[] args) {
		
		int x=10;
		// Reference type 
		// Array elements will share name name
		// same size
		// using Index
		// Index is zero based
		
		int[] arr=new int[5];
		
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		arr[4]=50;
		
		for(int i=0;i<5;i++)
			System.out.println(arr[i]);

	}

}
