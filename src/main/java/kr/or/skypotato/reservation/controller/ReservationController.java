package kr.or.skypotato.reservation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReservationController {
		
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
