package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Mart {
	private String Id;
	private String name;
	private String type;
	private String address;
	private double longitude;
	private double latitude;
}
