package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Bank {
	private String Id;
	private String address;
	private String branch;
	private String bank;
	private double longitude;
	private double latitude;
}
