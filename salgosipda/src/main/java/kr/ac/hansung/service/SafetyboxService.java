package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;
import kr.ac.hansung.dao.SafetyboxDao;
import kr.ac.hansung.model.Safetybox;
import kr.ac.hansung.model.Estate;

@Service
public class SafetyboxService {

	@Autowired
	private SafetyboxDao safetyboxDao;

	public List<Safetybox> getCurrent() {
		return safetyboxDao.getSafetybox();
	}
	
	// 가장 가까운 인프라의 거리에 따라 매물에 점수를 부여하는 메소드
	public void setEstateScore(double safetyboxPoint, double maxX, double maxY, double minX, double minY,
			ArrayList<Estate> availableEstates) {
		double maxDis = 600.0;
		List<Safetybox> safetyboxList = this.getCurrent();
		ArrayList<Safetybox> availableSafetyboxList = new ArrayList<Safetybox>();
		for (Safetybox safetybox : safetyboxList) {
			if ((safetybox.getLongitude()) < maxX + 0.01
					&& (safetybox.getLatitude()) < maxY + 0.01
					&& (safetybox.getLongitude()) > minX - 0.01
					&& (safetybox.getLatitude()) > minY - 0.01) {
				availableSafetyboxList.add(safetybox);
			}
		}

		for (Estate estate : availableEstates) {
			Double minDis = null;
			for (Safetybox safetybox : availableSafetyboxList) {
				double dis = DistanceCalc.distance(Double.parseDouble(estate.getLatitude()),
						Double.parseDouble(estate.getLongitude()),(safetybox.getLatitude()),
						(safetybox.getLongitude()), "meter");

				if (minDis == null && dis < maxDis) {
					minDis = dis;
				} else if (dis < maxDis && dis < minDis) {
					minDis = dis;
				}
			}
			if (minDis == null) {
				continue;
			} else {
				estate.setScore(
						estate.getScore() + (int)((Math.pow(minDis-600, 2)/7200) * safetyboxPoint));
				// ?��?��?��?��?��배함?? ?��?��거리 ?��?��?�� ?��무�? �??�� 중요?��?��.
				// ?���? 5분거리인 400m까�? 최�? 100?��?��?�� 55?��?�� �??��?��?��.
				// ?��?��?�� 600m까�? �??��?��?�� 급격?�� ?��?��?��?��.
			}
		}
	}

	// 사용자가 선택한 부동산 매물에 가장 적합한 인프라의 이름, 거리, 도보 예상 시간을 리턴하는 메소드
	public String getAvailableInfra(double latitude, double longitude, double maxX, double maxY,
			double minX, double minY) {
		double maxDis = 600.0;
		List<Safetybox> safetyboxList = this.getCurrent();
		ArrayList<Safetybox> availableSafetyboxList = new ArrayList<Safetybox>();
		Double minDis = null;
		//Safetybox AvailableSafetybox = null;
		int distance = 0;
		int time = 0;
		String name;
		String info = null;
		for (Safetybox safetybox : safetyboxList) {
			if ((safetybox.getLongitude()) < maxX + 0.01
					&& (safetybox.getLatitude()) < maxY + 0.01
					&& (safetybox.getLongitude()) > minX - 0.01
					&& (safetybox.getLatitude()) > minY - 0.01) {
				availableSafetyboxList.add(safetybox);
			}
		}
		for (Safetybox safetybox : availableSafetyboxList) {
			double dis = DistanceCalc.distance(latitude,
					longitude,(safetybox.getLatitude()),
					(safetybox.getLongitude()), "meter");

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
				else {
					time = 12;
				}
				name = safetybox.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailableSafetybox = safetybox;
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
				else {
					time = 12;
				}
				name = safetybox.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailableSafetybox = safetybox;
			}
		}
		if (minDis == null) {
			return null;
		} else {
			return info;
		}
	}
}