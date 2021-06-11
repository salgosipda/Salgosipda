package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;
import kr.ac.hansung.dao.MartDao;
import kr.ac.hansung.model.Mart;
import kr.ac.hansung.model.Estate;

@Service
public class MartService {

	@Autowired
	private MartDao martDao;

	public List<Mart> getCurrent() {
		return martDao.getMart();
	}

	// 가장 가까운 인프라의 거리에 따라 매물에 점수를 부여하는 메소드
	public void setEstateScore(double martPoint, double maxX, double maxY, double minX, double minY,
			ArrayList<Estate> availableEstates) {

		double maxDis = 1700.0;
		List<Mart> martList = this.getCurrent();
		ArrayList<Mart> availableMartList = new ArrayList<Mart>();
		for (Mart mart : martList) {
			if ((mart.getLongitude()) < maxX + 0.02
					&& (mart.getLatitude()) < maxY + 0.02
					&& (mart.getLongitude()) > minX - 0.02
					&& (mart.getLatitude()) > minY - 0.02) {
				availableMartList.add(mart);
			}
		}

		for (Estate estate : availableEstates) {
			Double minDis = null;
			for (Mart mart : availableMartList) {
				double dis = DistanceCalc.distance(Double.parseDouble(estate.getLatitude()),
						Double.parseDouble(estate.getLongitude()), (mart.getLatitude()),
						(mart.getLongitude()), "meter");

				if (minDis == null && dis < maxDis) {
					minDis = dis;
				} else if (dis < maxDis && dis < minDis) {
					minDis = dis;
				}
			}
			if (minDis == null) {
				continue;
			} else {
				estate.setScore(estate.getScore() + (int)((Math.pow(minDis-1700, 2)/57800) * martPoint));
				// 마트 ?��권�? ?���? 10분인 700m�? �??��?���?�? 1km까�? ?��?���? �??��?��?��.
				// 700m?��?�� 50?��까�? �??��?���? ?��?�� 1km까�? 0?��?���? 급격?�� ?��?��?��?��.
			}
		}
	}

	// 사용자가 선택한 부동산 매물에 가장 적합한 인프라의 이름, 거리, 도보 예상 시간을 리턴하는 메소드
	public String getAvailableInfra(double latitude, double longitude, double maxX, double maxY,
			double minX, double minY) {
		double maxDis = 1700.0;
		List<Mart> martList = this.getCurrent();
		ArrayList<Mart> availableMartList = new ArrayList<Mart>();
		Double minDis = null;
		//Mart AvailableMart = null;
		int distance = 0;
		int time = 0;
		String name;
		String info = null;
		for (Mart mart : martList) {
			if ((mart.getLongitude()) < maxX + 0.02
					&& (mart.getLatitude()) < maxY + 0.02
					&& (mart.getLongitude()) > minX - 0.02
					&& (mart.getLatitude()) > minY - 0.02) {
				availableMartList.add(mart);
			}
		}
		for (Mart mart : availableMartList) {
			double dis = DistanceCalc.distance(latitude,
					longitude, (mart.getLatitude()),
					(mart.getLongitude()), "meter");

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
				else if(900 <= distance && distance < 1000) {
					time = 20;
				}
				else if(1000 <= distance && distance < 1100) {
					time = 22;
				}
				else if(1100 <= distance && distance < 1200) {
					time = 23;
				}
				else if(1200 <= distance && distance < 1300) {
					time = 15;
				}
				else if(1300 <= distance && distance < 1400) {
					time = 27;
				}
				else if(1400 <= distance && distance < 1500) {
					time = 30;
				}
				else if(1500 <= distance && distance < 1600) {
					time = 32;
				}
				else {
					time = 33;
				}
				name = mart.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailableMart = mart;
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
				else if(900 <= distance && distance < 1000) {
					time = 20;
				}
				else if(1000 <= distance && distance < 1100) {
					time = 22;
				}
				else if(1100 <= distance && distance < 1200) {
					time = 23;
				}
				else if(1200 <= distance && distance < 1300) {
					time = 15;
				}
				else if(1300 <= distance && distance < 1400) {
					time = 27;
				}
				else if(1400 <= distance && distance < 1500) {
					time = 30;
				}
				else if(1500 <= distance && distance < 1600) {
					time = 32;
				}
				else {
					time = 33;
				}
				name = mart.getName();
				info = name + "<br>" + "거리▸" + distance + "m" + " 도보▸" + time + "분 이내";
				//AvailableMart = mart;
			}
		}
		if (minDis == null) {
			return null;
		} else {
			return info;
		}
	}
}