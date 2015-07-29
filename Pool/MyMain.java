package Pool;

public class MyMain {

	public static void main(String[] args) {

		// Pool Intialization
		EmployeePool empPool = EmployeePool.getMyInstance();//EmployeePool is singleton object
		empPool.loadPool();
		Employee ep=null;
		
		try {
			ep= empPool.getInstace();
			ep.processEmployee();
			ep.returnThisObjectIntoPool();
			
			ep=empPool.getInstace();
			ep.processEmployee();
			ep.returnThisObjectIntoPool();
			
			ep=empPool.getInstace();
			ep.processEmployee();
			ep.returnThisObjectIntoPool();
			
			
			ep=empPool.getInstace();
			ep.processEmployee();
			ep.returnThisObjectIntoPool();
			
			
			ep=empPool.getInstace();
			ep.processEmployee();
			ep.returnThisObjectIntoPool();
			
			
		} catch (MyPoolFullEmptyException e) {
			System.out.println("Employee Pool is full or empty ");

		}

		empPool.returnThisObjectIntoPool(ep);

		empPool.printCurrentPool();

	}

}
