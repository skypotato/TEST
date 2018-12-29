package kr.or.skypotato.reservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.skypotato.reservation.service.PromotionService;


@Controller
public class ReservationController {
		@Autowired
		PromotionService reservationService;
		
		@GetMapping(path="/main")
		public String mainPage() {
			return "/htmls/mainpage.html";
		}
		
		@GetMapping(path="/detail")
		public String detailPage(@RequestParam(name="id", required=true) int id){
			return "/htmls/detail.html";
		}
		
		@GetMapping(path="/myreservation")
		public String myreservationPage(){
			return "/htmls/myreservation.html";
		}
}
