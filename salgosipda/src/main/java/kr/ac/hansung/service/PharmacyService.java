package kr.ac.hansung.service;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;
import kr.ac.hansung.dao.PharmacyDao;
import kr.ac.hansung.model.Pharmacy;
import kr.ac.hansung.model.Estate;

@Service
public class PharmacyService {

	@Autowired
	private PharmacyDao pharmacyDao;

	public List<Pharmacy> getCurrent() {
		return pharmacyDao.getPharmacy();
	}
	
	// 가장 가까운 인프라의 거리에 따라 매물에 점수를 부여하는 메소드
	public void setEstateScore(double pharmacyPoint, double maxX, double maxY, double minX, double minY,
			ArrayList<Estate> availableEstates) {

		double maxDis = 900.0;
		List<Pharmacy> pharmacyList = this.getCurrent();
		ArrayList<Pharmacy> availablePharmacyList = new ArrayList<Pharmacy>();
		for (Pharmacy pharmacy : pharmacyList) {
			if ((pharmacy.getLongitude()) < maxX + 0.01
					&& (pharmacy.getLatitude()) < maxY + 0.01
					&& (pharmacy.getLongitude()) > minX - 0.01
					&& (pharmacy.getLatitude()) > minY - 0.01) {
				availablePharmacyList.add(pharmacy);
			}
		}

		for (Estate estate : availableEstates) {
			Double minDis = null;
			for (Pharmacy pharmacy : availablePharmacyList) {
				double dis = DistanceCalc.distance(Double.parseDouble(estate.getLatitude()),
						Double.parseDouble(estate.getLongitude()), (pharmacy.getLatitude()),
						(pharmacy.getLongitude()), "meter");

				if (minDis == null && dis < maxDis) {
					minDis = dis;
				} else if (dis < maxDis && dis < minDis) {
					minDis = dis;
				}
			}
			if (minDis == null) {
				continue;
			} else {
				estate.setScore(estate.getScore() +(int)((Math.pow(minDis-900, 2)/16200) * pharmacyPoint));
				// �빟援��� �룄蹂� 3遺꾧굅由ъ씤 300m源뚯� 遺��뿬�맂�떎.
				// 理쒕�100�젏�뿉�꽌 理쒖냼 0�젏源뚯� 遺��뿬
			}
		}
	}

	// 사용자가 선택한 부동산 매물에 가장 적합한 인프라의 이름, 거리, 도보 예상 시간을 리턴하는 메소드
	public String getAvailableInfra(double latitude, double longitude, double maxX, double maxY, double minX, double minY) {
		double maxDis = 900.0;
		List<Pharmacy> pharmacyList = this.getCurrent();
		ArrayList<Pharmacy> availablePharmacyList = new ArrayList<Pharmacy>();
		Double minDis = null;
		//Pharmacy AvailablePharmacy = null;
		int distance = 0;
		int time = 0;
		String name;
		String info = null;
		for (Pharmacy pharmacy : pharmacyList) {
			if ((pharmacy.getLongitude()) < maxX + 0.01
					&& (pharmacy.getLatitude()) < maxY + 0.01
					&& (pharmacy.getLongitude()) > minX - 0.01
					&& (pharmacy.getLatitude()) > minY - 0.01) {
				availablePharmacyList.add(pharmacy);
			}
		}
		for (Pharmacy pharmacy : availablePharmacyList) {
			double dis = DistanceCalc.distance(latitude,
					longitude, (pharmacy.getLatitude()),
				(pharmacy.getLongitude()), "meter");

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
				name = pharmacy.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailablePharmacy = pharmacy;
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
				name = pharmacy.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailablePharmacy = pharmacy;
			}
		}
		if (minDis == null) {
			return null;
		} else {
			return info;
		}
	}
}