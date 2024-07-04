package emp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Emp {
	
	private final String empno;
	private final String ename;
	
	@Override
	public String toString() {
		return "Emp [empno="+empno+", ename="+ename+"]";
	}
	
}
