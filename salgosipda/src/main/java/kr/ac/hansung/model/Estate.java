package kr.ac.hansung.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Estate {
	private String Id;
	private String Name;
	private String Type;
	private String Price;
	private String Address;
	private String longitude;
	private String latitude;
	private String area;
	private String floor;
	private String sch_moving;
	private String construction_year;
	private String feature;
	private String direction;
	private String parking;
	private String manage_cost;
	private String manage_included;
	private String security;
	private String estatename;
	private String callnum;
	
	private int score = 0;

}