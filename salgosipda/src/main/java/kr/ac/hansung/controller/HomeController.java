package kr.ac.hansung.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.model.Cvs;
import kr.ac.hansung.model.Estate;
import kr.ac.hansung.service.EstateService;

@Controller
public class HomeController {

	@Autowired
	private EstateService estateService;

//	private double x_coord = 0;
//	private double y_coord = 0;
//	private double maxBoundX = 0;
//	private double maxBoundY = 0;
//	private double minBoundX = 0;
//	private double minBoundY = 0;
//	private int zoom;
//	private int i;

	List<Estate> estates;
	List<Cvs> cvsList;
	ArrayList<Estate> availableEstates;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) throws IOException, ParseException {

		return "home";
	}

	// 서버가 시작될때 부동산 매물 크롤링 수행
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) throws IOException, ParseException {
		//estateService.insert();
	}
}
