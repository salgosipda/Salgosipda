package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Subway {
	private String Number;
	private String Station;
	private String Line;
	private double longitude;
	private double latitude;
}
