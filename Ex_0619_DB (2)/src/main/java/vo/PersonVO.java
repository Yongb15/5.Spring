package vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonVO {

	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "PersonVO [name="+name+", age="+age+"]";
	}
}
