package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cvs {
	private String Id;
	private String address;
	private String name;
	private String type;
	private double longitude;
	private double latitude;
}
