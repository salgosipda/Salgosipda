package kr.ac.hansung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.common.DistanceCalc;
import kr.ac.hansung.dao.CrimeDao;
import kr.ac.hansung.model.Crime;
import kr.ac.hansung.model.Estate;

@Service
public class CrimeService {

	@Autowired
	private CrimeDao crimeDao;

	public List<Crime> getCurrent() {
		return crimeDao.getCrime();
	}

	public Crime getCrimeByName(String name) {
		List<Crime> crimeList = this.getCurrent();
		for (Crime crime : crimeList) {
			if (crime.getName().equals(name)) {
				return crime;
			}
		}
		return null;
	}

	// 부동산 매물이 위치하는 동 정보를 이용하여 해당하는 동의 범죄율을 점수로 부여하는 메소드
	public void setEstateScore(double crimePoint, ArrayList<Estate> availableEstates) {
		//서울에서 가장 범죄율이 높은 구의 범죄율을 기준으로 점수를 매긴다.
		int maxCrimeRate = 712;
		Crime crime = new Crime();
		for (Estate estate : availableEstates) {
			if (estate.getAddress().contains("상월곡동") || estate.getAddress().contains("석관동")
					|| estate.getAddress().contains("장위동") || estate.getAddress().contains("하월곡동")
					|| estate.getAddress().contains("길음제2동") || estate.getAddress().contains("종암동")) {
				crime = this.getCrimeByName("종암");
			} else {
				crime = this.getCrimeByName("성북");
			}
			if(crime != null) {
				estate.setScore(estate.getScore() + (int) ((maxCrimeRate-crime.getCrimeRate())/(maxCrimeRate/50) * crimePoint));
			}
			else {
				continue;
			}
		}
	}

	// 사용자가 선택한 부동산 매물이 위치한 동을 관할하는 경찰서와 해당 경찰서의 범죄율을 리턴하는 메소드
	public String getAvailableInfra(Estate estate) {
		Crime availableCrime = null;
		String info = null;
		if (estate.getAddress().contains("상월곡동") || estate.getAddress().contains("석관동")
				|| estate.getAddress().contains("장위동") || estate.getAddress().contains("하월곡동")
				|| estate.getAddress().contains("길음제2동") || estate.getAddress().contains("종암동")) {
			availableCrime = this.getCrimeByName("종암");
		} else {
			availableCrime = this.getCrimeByName("성북");
		}
		info = availableCrime.getName() + "경찰서" + "<br>" + "범죄율▸" + availableCrime.getCrimeRate();
		return info;
	}
}
