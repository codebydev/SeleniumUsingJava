
public class InheritanceDemo {

	public static void main(String[] args) {

		Demo1 d1=new Demo1();
		d1.show();
		
		Demo2 d2=new Demo2();
		d2.show();

	}

}

class Demo1
{
	public void show()
	{
		System.out.println("Show method in Demo1 class");
	}
}

class Demo2 extends Demo1
{
	
}
