package kr.ac.hansung.model;

import lombok.Getter;  
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pharmacy {
	private String Id;
	private String name;
	private String address;
	private double latitude;
	private double longitude;
}
