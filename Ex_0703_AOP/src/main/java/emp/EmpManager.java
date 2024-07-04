package emp;

import java.util.ArrayList;
import java.util.List;

public class EmpManager {
	List<Emp> list = new ArrayList<Emp>();
	//사람을 리스트에 추가하는 기능
	public void setEmp(Emp e) {
		list.add(e);
	}
	public List<Emp> getAllEmps(){
		System.out.println("[Target Method] getAllEmps() called...");
		return list;
	}
}
