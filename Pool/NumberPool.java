package Pool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class NumberPool {

 
	Set availbleList =  new HashSet<Integer>();
	Set occupiedList =  new HashSet<Integer>();
	
	private   Set availblePool = new HashSet<Integer>();
	
	
String getNumber(){
	
	
	return ""; 
		
	}

	public void createAvailablePool() {

		String n = "79999999";
		for (int i = 0; i < 100; i++) {
			String temp = "";
			if (i % 100 < 10) {
				temp = "0" + i;
			} else {
				temp = Integer.toString(i);
			}

			temp = n + temp;
			System.out.println(temp);
			if (availblePool.isEmpty())
				System.out.println(temp);
			availblePool.add(temp);

		}

	}




//-----------------------------------
	@SuppressWarnings("unchecked")
	void getVNumber() {

		if (availbleList.isEmpty() && occupiedList.isEmpty()) {
			Random rand = new Random(10);
			int i = rand.nextInt(10);
			availbleList.add(i);
		}

		Iterator it = availbleList.iterator();
		if (it.hasNext()) {
			int i = (Integer) it.next();
			occupiedList.add(i);
			availbleList.remove(i);
		}

	}
	
	void removeNumber(Integer number){
		occupiedList.remove(number);
		availbleList.add(number);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
 
}
