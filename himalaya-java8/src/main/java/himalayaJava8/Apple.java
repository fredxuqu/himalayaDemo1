package himalayaJava8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

	public Apple(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}
	
	private String color;
	private Double weight;
}
