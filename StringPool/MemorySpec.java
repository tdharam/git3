package StringPool;

import Practice1.Employee;
// java 7 {this class shows memory specification of variables. which variable goes where in memory. }
public class MemorySpec {

	//Run time constant Pool
	static final int CAPACITY = 16;
	
	//method Area
	static int size = 10;
	
	//string pool which is part of Run time constant Pool 
	String name = "dharam";
	 
	//heap
	String comapny = new String("cybage");
	
	//heap
	int value;
	
	

	void execute() {
		int i ;//Stack (in Thread's frame for this method )
		 
		//string pool which is part of Run time constant Pool(every frame has reffrence to run time contant pool)
		String myName = "dharam";
		System.out.println(name==myName);//ture
		
		//heap
		String myAddress = new String("d-909");

	}

}
//http://javarevisited.blogspot.in/2013/01/difference-between-stack-and-heap-java.html

/*/Each frame has its own 
array of local variables ,
operand stack  and 
a reference to the runtime constant pool (§2.5.5) of the class of the current method.*/
