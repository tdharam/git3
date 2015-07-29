package Pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Practice1.EmployeeFactory;

public interface ObjectPool {

	void loadPool();

	void returnThisObjectIntoPool(Employee e);

	Object getInstace();

	boolean poolFullOrEmpty();
}

/*
 * class EmpPoolSibgleton {
 * 
 * private static EmpPoolSibgleton instance = null;
 * 
 * private EmpPoolSibgleton() {
 * 
 * }
 * 
 * static EmpPoolSibgleton getMyInstance() {
 * 
 * if (instance == null) { synchronized (EmpPoolSibgleton.class) {
 * 
 * if (instance == null) {
 * 
 * instance = new EmpPoolSibgleton(); } } } return instance; }
 * 
 * }
 */
// droping this idea of extending EmpPoolSibgleton beacuse it has private
// contructor so cant extend singlton class
class EmployeePool implements ObjectPool {

	int MAXSIZE = 10;
	Set pool = new HashSet<Employee>();

	private static EmployeePool instance = null;

	private EmployeePool() {

	}
   //if EmployeePool class will be sibleton than we can give emplyee class the facility to return used object. 
	//and implement poolable interface
	static EmployeePool getMyInstance() {

		if (instance == null) {
			synchronized (EmployeePool.class) {

				if (instance == null) {

					instance = new EmployeePool();
				}
			}
		}
		return instance;
	}

	@Override
	public Employee getInstace() {

		Employee rEmp = null;
		if (!poolFullOrEmpty()) {
			Iterator<Employee> itr = pool.iterator();
			synchronized (this) {
				if (itr.hasNext()) {
					rEmp = (Employee) itr.next();
					System.out.println("byGetInstance:" + rEmp.getEmpname());
					itr.remove();
				}
			}
		}

		if (rEmp == null) {
			throw new MyPoolFullEmptyException();
		}

		return rEmp;
	}

	@Override
	public void returnThisObjectIntoPool(Employee e) {
		Employee e1 = null;

		pool.add(e);

		Iterator<Employee> itr = pool.iterator();
		if (itr.hasNext()) {
			e1 = (Employee) itr.next();
			System.out.println("AfterReturning" + e1.getEmpname());
		}

	}

	@Override
	public void loadPool() {

		for (int i = 1; i <= 10; i++) {
			Employee e = new Employee();
			e.setEmpId(i);
			e.setEmpname("dharam" + i);
			if (pool.size() <= MAXSIZE)
				pool.add(e);
			else
				System.out.println("Pool is full");

			System.out.println("Load Status:" + e.getEmpname());
		}

	}

	void printCurrentPool() {
		if (poolFullOrEmpty())
			return;
		Iterator<Employee> itr = pool.iterator();
		while (itr.hasNext()) {

			Employee e = (Employee) itr.next();
			System.out.println("Print" + e.getEmpname());
		}
	}

	public boolean poolFullOrEmpty() {

		if (poolSize() < 1 || poolSize() > 10)
			return true;
		else
			return false;

	}

	int poolSize() {
		return pool == null ? 0 : pool.size();
	}

}
