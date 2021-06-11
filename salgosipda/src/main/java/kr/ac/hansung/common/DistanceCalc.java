package kr.ac.hansung.common;

public class DistanceCalc {

	// 경도와 위도로 두 지점간의 거리 계산
	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		if (unit == "kilometer") {
			dist = dist * 1.609344;
		} else if (unit == "meter") {
			dist = dist * 1609.344;
		}

		return (dist);
	}

	// 십진 수 각도를 절대 각도로 변환
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// 절대 각도를 십진수 각도로 변환
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
