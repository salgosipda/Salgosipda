package kr.ac.hansung.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class InfraController {

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
	private BankService bankService;
	@Autowired
	private PharmacyService pharmacyService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private GymService gymService;
	@Autowired
	private CrimeService crimeService;

	// 사용자가 선택한 매물에서 가장 적합한 인프라 정보를 응답하는 메소드
	@RequestMapping(value = "/cvs/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveCvs(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Cvs");

		return new ResponseEntity<String>(cvsService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/laundry/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveLaundry(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Laundry");

		return new ResponseEntity<String>(laundryService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/mart/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveMart(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Mart");

		return new ResponseEntity<String>(martService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/safetybox/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveSafetybox(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Safetybox");

		return new ResponseEntity<String>(
				safetyboxService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY), HttpStatus.OK);
	}

	@RequestMapping(value = "/subway/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveSubway(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Subway");

		return new ResponseEntity<String>(subwayService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/bank/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveBank(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Bank");

		return new ResponseEntity<String>(bankService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/pharmacy/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrievePharmacy(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Pharmacy");

		return new ResponseEntity<String>(
				pharmacyService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY), HttpStatus.OK);
	}

	@RequestMapping(value = "/hospital/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveHospital(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Hospital");

		return new ResponseEntity<String>(
				hospitalService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY), HttpStatus.OK);
	}

	@RequestMapping(value = "/gym/{latitude}/{longitude}/{maxX}/{maxY}/{minX}/{minY}", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveGym(@PathVariable double latitude, @PathVariable double longitude,
			@PathVariable double maxX, @PathVariable double maxY, @PathVariable double minX, @PathVariable double minY,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Gym");

		return new ResponseEntity<String>(gymService.getAvailableInfra(latitude, longitude, maxX, maxY, minX, minY),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{latitude}/{longitude}/crime", produces = "application/text;charset=utf-8", method = {
			RequestMethod.GET })
	public ResponseEntity<?> retrieveCrime(@PathVariable String latitude, @PathVariable String longitude,
			HttpServletResponse response) throws ServletException, IOException {

		response.addHeader("Data-Type", "Crime");
		;

		Estate estate = estateService.getEstateByLatLon(latitude, longitude);
		if (estate == null) {
			System.out.println(latitude + " " + longitude);
		}
		return new ResponseEntity<String>(crimeService.getAvailableInfra(estate), HttpStatus.OK);
	}
}
