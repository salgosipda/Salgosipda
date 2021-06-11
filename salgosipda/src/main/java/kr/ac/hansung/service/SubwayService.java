package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;
import kr.ac.hansung.dao.SubwayDao;
import kr.ac.hansung.model.Subway;
import kr.ac.hansung.model.Estate;

@Service
public class SubwayService {

	@Autowired
	private SubwayDao subwayDao;

	public List<Subway> getCurrent() {
		return subwayDao.getSubway();
	}
	
	// 가장 가까운 인프라의 거리에 따라 매물에 점수를 부여하는 메소드
	public void setEstateScore(double subwayPoint, double maxX, double maxY, double minX, double minY,
			ArrayList<Estate> availableEstates) {
		double maxDis = 1000.0;
		List<Subway> subwayList = this.getCurrent();
		ArrayList<Subway> availableSubwayList = new ArrayList<Subway>();
		for (Subway subway : subwayList) {
			if ((subway.getLongitude()) < maxX + 0.01
					&& (subway.getLatitude()) < maxY + 0.01
					&& (subway.getLongitude()) > minX - 0.01
					&& (subway.getLatitude()) > minY - 0.01) {
				availableSubwayList.add(subway);
			}
		}

		for (Estate estate : availableEstates) {
			Double minDis = null;
			for (Subway subway : availableSubwayList) {
				double dis = DistanceCalc.distance(Double.parseDouble(estate.getLatitude()),
						Double.parseDouble(estate.getLongitude()), (subway.getLatitude()),
						(subway.getLongitude()), "meter");

				if (minDis == null && dis < maxDis) {
					minDis = dis;
				} else if (dis < maxDis && dis < minDis) {
					minDis = dis;
				}
			}
			if (minDis == null) {
				continue;
			} else {
				estate.setScore(estate.getScore() + (int)((Math.pow(minDis-1000, 2)/20000) * subwayPoint));
				// ?���? 10분인 700m�?근에?�� 50?�� ?��?�� 급격?�� ?��?��?��?�� 최소 20?�� �??��
				// 철도?��?�� 발전 기본�? �? ?��?�� 철도법에 ?��?�� 1차역?��권�? 250m 2차역?��권�? 500m
			}
		}
	}

	// 사용자가 선택한 부동산 매물에 가장 적합한 인프라의 이름, 거리, 도보 예상 시간을 리턴하는 메소드
	public String getAvailableInfra(double latitude, double longitude, double maxX, double maxY,
			double minX, double minY) {
		double maxDis = 1000.0;
		List<Subway> subwayList = this.getCurrent();
		ArrayList<Subway> availableSubwayList = new ArrayList<Subway>();
		Double minDis = null;
		//Subway AvailableSubway = null;
		int distance = 0;
		int time = 0;
		String line;
		String station;
		String info = null;
		for (Subway subway : subwayList) {
			if ((subway.getLongitude()) < maxX + 0.01
					&& (subway.getLatitude()) < maxY + 0.01
					&& (subway.getLongitude()) > minX - 0.01
					&& (subway.getLatitude()) > minY - 0.01) {
				availableSubwayList.add(subway);
			}
		}
		for (Subway subway : availableSubwayList) {
			double dis = DistanceCalc.distance(latitude,
					longitude, (subway.getLatitude()),
					(subway.getLongitude()), "meter");

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
				else if(800 <= distance && distance < 900) {
					time = 17;
				}
				else {
					time = 20;
				}
				line = subway.getLine();
				station = subway.getStation();
				info = line + " " + station + "<br>" + "거리▸" + distance + " 도보▸" + time + "분 이내";
				//AvailableSubway = subway;
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
				else if(800 <= distance && distance < 900) {
					time = 17;
				}
				else {
					time = 20;
				}
				line = subway.getLine();
				station = subway.getStation();
				info = line + " " + station + "<br>" + "거리▸" + distance + " 도보▸" + time + "분 이내";
				//AvailableSubway = subway;
			}
		}
		if (minDis == null) {
			return null;
		} else {
			return info;
		}
	}
}