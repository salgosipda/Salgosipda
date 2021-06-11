package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;
import kr.ac.hansung.dao.CvsDao;
import kr.ac.hansung.model.Cvs;
import kr.ac.hansung.model.Estate;

@Service
public class CvsService {

	@Autowired
	private CvsDao cvsDao;

	public List<Cvs> getCurrent() {
		return cvsDao.getCvs();
	}
	
	// 가장 가까운 인프라의 거리에 따라 매물에 점수를 부여하는 메소드
	public void setEstateScore(double cvsPoint, double maxX, double maxY, double minX, double minY,
			ArrayList<Estate> availableEstates) {

		double maxDis = 600.0;
		List<Cvs> cvsList = this.getCurrent();
		ArrayList<Cvs> availableCvsList = new ArrayList<Cvs>();
		for (Cvs cvs : cvsList) {
			if ((cvs.getLongitude()) < maxX + 0.01
					&& (cvs.getLatitude()) < maxY + 0.01
					&& (cvs.getLongitude()) > minX - 0.01
					&& (cvs.getLatitude()) > minY - 0.01) {
				availableCvsList.add(cvs);
			}
		}

		for (Estate estate : availableEstates) {
			Double minDis = null;
			for (Cvs cvs : availableCvsList) {
				double dis = DistanceCalc.distance(Double.parseDouble(estate.getLatitude()),
						Double.parseDouble(estate.getLongitude()), (cvs.getLatitude()),
						(cvs.getLongitude()), "meter");

				if (minDis == null && dis < maxDis) {
					minDis = dis;
				} else if (dis < maxDis && dis < minDis) {
					minDis = dis;
				}
			}
			if (minDis == null) {
				continue;
			} else {
				estate.setScore(estate.getScore() + (int)((Math.pow(minDis-600, 2)/7200) * cvsPoint));
				// ?��?��?��?? ?���? 3분거리인 300m까�? �??��?��?��.
				// 최�?100?��?��?�� 최소 0?��까�? �??��
			}
		}
	}

	// 사용자가 선택한 부동산 매물에 가장 적합한 인프라의 이름, 거리, 도보 예상 시간을 리턴하는 메소드
	public String getAvailableInfra(double latitude, double longitude, double maxX, double maxY, double minX, double minY) {
		double maxDis = 600.0;
		List<Cvs> cvsList = this.getCurrent();
		ArrayList<Cvs> availableCvsList = new ArrayList<Cvs>();
		Double minDis = null;
		//Cvs AvailableCvs = null;
		int distance = 0;
		int time = 0;
		String name;
		String info = null;
		for (Cvs cvs : cvsList) {
			if ((cvs.getLongitude()) < maxX + 0.01
					&& (cvs.getLatitude()) < maxY + 0.01
					&& (cvs.getLongitude()) > minX - 0.01
					&& (cvs.getLatitude()) > minY - 0.01) {
				availableCvsList.add(cvs);
			}
		}
		for (Cvs cvs : availableCvsList) {
			double dis = DistanceCalc.distance(latitude,
					longitude, (cvs.getLatitude()),
					(cvs.getLongitude()), "meter");

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
				name = cvs.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//System.out.println(info);
				//AvailableCvs = cvs;
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
				name = cvs.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//System.out.println(info);
				//AvailableCvs = cvs;
			}
		}
		if (minDis == null) {
			return null;
		} else {
			return info;
		}
	}
}