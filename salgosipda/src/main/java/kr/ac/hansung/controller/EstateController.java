package kr.ac.hansung.controller;

import java.io.BufferedReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kr.ac.hansung.model.Estate;
import kr.ac.hansung.service.BankService;
import kr.ac.hansung.service.CrimeService;
import kr.ac.hansung.service.CvsService;
import kr.ac.hansung.service.EstateService;
import kr.ac.hansung.service.GymService;
import kr.ac.hansung.service.HospitalService;
import kr.ac.hansung.service.LaundryService;
import kr.ac.hansung.service.MartService;
import kr.ac.hansung.service.PharmacyService;
import kr.ac.hansung.service.SafetyboxService;
import kr.ac.hansung.service.SubwayService;

@RestController
public class EstateController {

	@Autowired
	private EstateService estateService;
	@Autowired
	private CvsService cvsService;
	@Autowired
	private LaundryService laundryService;
	@Autowired
	private SafetyboxService safetyboxService;
	@Autowired
	private MartService martService;
	@Autowired
	private SubwayService subwayService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private BankService bankService;
	@Autowired
	private PharmacyService pharmacyService;
	@Autowired
	private GymService gymService;
	@Autowired
	private CrimeService crimeService;

	// 지도 화면 내부에 위치하는 매물 정보 응답
	@RequestMapping(value = "/availableEstates/{maxX}/{maxY}/{minX}/{minY}", method = { RequestMethod.GET })
	public ResponseEntity<?> retrieveEstates(@PathVariable double maxX, @PathVariable double maxY,
			@PathVariable double minX, @PathVariable double minY, HttpServletResponse response)
			throws ServletException, IOException {

		response.addHeader("Data-Type", "Estate");

		ArrayList<Estate> availableEstates = estateService.getAvailableEstates(maxX, maxY, minX, minY);

		return new ResponseEntity<List<Estate>>(availableEstates, HttpStatus.OK);
	}

	// 지도 화면 내부에 위치하는 매물들에 선택한 요소에 따른 점수 부여 후 응답
	@RequestMapping(value = "/estateScore", headers = { "X-HTTP-Method-Override=GET" })
	public ResponseEntity<?> retrieveEstates(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.addHeader("Data-Type", "Estate");

		int scailingCount = 0;

		StringBuffer stringBuffer = new StringBuffer();
		String line = null;

		try {
			BufferedReader bufferedReader = request.getReader();
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonElement element = JsonParser.parseString(stringBuffer.toString());

		double maxX = element.getAsJsonObject().get("maxX").getAsDouble();
		double maxY = element.getAsJsonObject().get("maxY").getAsDouble();
		double minX = element.getAsJsonObject().get("minX").getAsDouble();
		double minY = element.getAsJsonObject().get("minY").getAsDouble();
		double cvsPoint = element.getAsJsonObject().get("cvsPoint").getAsDouble();
		double laundryPoint = element.getAsJsonObject().get("laundryPoint").getAsDouble();
		double safetyboxPoint = element.getAsJsonObject().get("safetyboxPoint").getAsDouble();
		double martPoint = element.getAsJsonObject().get("martPoint").getAsDouble();
		double subwayPoint = element.getAsJsonObject().get("subwayPoint").getAsDouble();
		double bankPoint = element.getAsJsonObject().get("bankPoint").getAsDouble();
		double pharmacyPoint = element.getAsJsonObject().get("pharmacyPoint").getAsDouble();
		double hospitalPoint = element.getAsJsonObject().get("hospitalPoint").getAsDouble();
		double gymPoint = element.getAsJsonObject().get("gymPoint").getAsDouble();
		double crimePoint = element.getAsJsonObject().get("crimePoint").getAsDouble();

		ArrayList<Estate> availableEstates = estateService.getAvailableEstates(maxX, maxY, minX, minY);

		if (cvsPoint >= 1) {
			cvsService.setEstateScore(cvsPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (laundryPoint >= 1) {
			laundryService.setEstateScore(laundryPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (safetyboxPoint >= 1) {
			safetyboxService.setEstateScore(safetyboxPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (martPoint >= 1) {
			martService.setEstateScore(martPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (subwayPoint >= 1) {
			subwayService.setEstateScore(subwayPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (bankPoint >= 1) {
			bankService.setEstateScore(bankPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (pharmacyPoint >= 1) {
			pharmacyService.setEstateScore(pharmacyPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (hospitalPoint >= 1) {
			hospitalService.setEstateScore(hospitalPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (gymPoint >= 1) {
			gymService.setEstateScore(gymPoint, maxX, maxY, minX, minY, availableEstates);
			scailingCount++;
		}
		if (crimePoint >= 1) {
			crimeService.setEstateScore(crimePoint, availableEstates);
			scailingCount++;
		}

		if (scailingCount > 0) {
			for (Estate estate : availableEstates) {
				estate.setScore(estate.getScore() / scailingCount);
			}
		}

		return new ResponseEntity<List<Estate>>(availableEstates, HttpStatus.OK);
	}
}
