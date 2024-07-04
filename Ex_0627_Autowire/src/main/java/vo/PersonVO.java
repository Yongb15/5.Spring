package vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonVO {
	private String name, addr;
	private int age;
	
	@Override
	public String toString() {
		return "Person[name="+name+", age="+age+", addr="+addr+"]";
	}
}
