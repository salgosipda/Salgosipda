package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;

import kr.ac.hansung.dao.HospitalDao;
import kr.ac.hansung.model.Hospital;
import kr.ac.hansung.model.Estate;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	public List<Hospital> getCurrent() {
		return hospitalDao.getHospital();
	}
	
	// 가장 가까운 인프라의 거리에 따라 매물에 점수를 부여하는 메소드
	public void setEstateScore(double hospitalPoint, double maxX, double maxY, double minX, double minY,
			ArrayList<Estate> availableEstates) {

		double maxDis = 900.0;
		List<Hospital> hospitalList = this.getCurrent();
		ArrayList<Hospital> availableHospitalList = new ArrayList<Hospital>();
		for (Hospital hospital : hospitalList) {
			if ((hospital.getLongitude()) < maxX + 0.01
					&& (hospital.getLatitude()) < maxY + 0.01
					&& (hospital.getLongitude()) > minX - 0.01
					&& (hospital.getLatitude()) > minY - 0.01) {
				availableHospitalList.add(hospital);
			}
		}

		for (Estate estate : availableEstates) {
			Double minDis = null;
			for (Hospital hospital : availableHospitalList) {
				double dis = DistanceCalc.distance(Double.parseDouble(estate.getLatitude()),
						Double.parseDouble(estate.getLongitude()), (hospital.getLatitude()),
						(hospital.getLongitude()), "meter");

				if (minDis == null && dis < maxDis) {
					minDis = dis;
				} else if (dis < maxDis && dis < minDis) {
					minDis = dis;
				}
			}
			if (minDis == null) {
				continue;
			} else {
				estate.setScore(estate.getScore() + (int)((Math.pow(minDis-900, 2)/16200) * hospitalPoint));
				// ������ 1km���� �ο��ȴ�.
				// �ִ�100������ �ּ� 0������ �ο�
			}
		}
	}

	// 사용자가 선택한 부동산 매물에 가장 적합한 인프라의 이름, 거리, 도보 예상 시간을 리턴하는 메소드
	public String getAvailableInfra(double latitude, double longitude, double maxX, double maxY, double minX, double minY) {
		double maxDis = 900.0;
		List<Hospital> hospitalList = this.getCurrent();
		ArrayList<Hospital> availableHospitalList = new ArrayList<Hospital>();
		Double minDis = null;
		//Hospital AvailableHospital = null;
		int distance = 0;
		int time = 0;
		String name;
		String info = null;
		for (Hospital hospital : hospitalList) {
			if ((hospital.getLongitude()) < maxX + 0.01
					&& (hospital.getLatitude()) < maxY + 0.01
					&& (hospital.getLongitude()) > minX - 0.01
					&& (hospital.getLatitude()) > minY - 0.01) {
				availableHospitalList.add(hospital);
			}
		}
		for (Hospital hospital : availableHospitalList) {
			double dis = DistanceCalc.distance(latitude,
					longitude, (hospital.getLatitude()),
					(hospital.getLongitude()), "meter");

			if (minDis == null && dis < maxDis) {
				minDis = dis;
				distance = (int)Math.round(minDis);
				
				if(distance < 100) {
					time = 3;
				}
				else if(100 <= distance && distance < 200) {
					time = 4;
				}
				else if(200 <= distance && distance < 300){
					time = 5;
				}
				else if(300 <= distance && distance < 400) {
					time = 7;
				}
				else if(400 <= distance && distance < 500) {
					time = 10;
				}
				else if(500 <= distance && distance < 600) {
					time = 12;
				}
				else if(600 <= distance && distance < 700) {
					time = 13;
				}
				else if(700 <= distance && distance < 800) {
					time = 15;
				}
				else {
					time = 17;
				}
				name = hospital.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailableHospital = hospital;
			} else if (dis < maxDis && dis < minDis) {
				minDis = dis;
				distance = (int)Math.round(minDis);
				
				if(distance < 100) {
					time = 3;
				}
				else if(100 <= distance && distance < 200) {
					time = 4;
				}
				else if(200 <= distance && distance < 300){
					time = 5;
				}
				else if(300 <= distance && distance < 400) {
					time = 7;
				}
				else if(400 <= distance && distance < 500) {
					time = 10;
				}
				else if(500 <= distance && distance < 600) {
					time = 12;
				}
				else if(600 <= distance && distance < 700) {
					time = 13;
				}
				else if(700 <= distance && distance < 800) {
					time = 15;
				}
				else {
					time = 17;
				}
				name = hospital.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailableHospital = hospital;
			}
		}
		if (minDis == null) {
			return null;
		} else {
			return info;
		}
	}
}

