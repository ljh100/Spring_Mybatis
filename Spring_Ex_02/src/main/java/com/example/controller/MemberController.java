package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.sample.HomeController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.MemberVO;
import com.example.service.MemberService;

@Controller
public class MemberController {
	
	 private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	 @Inject
	 private MemberService service;
	    
	    /**
	     * Simply selects the home view to render by returning its name.
	     */
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public String home(Locale locale, Model model) throws Exception{
	 
	        logger.info("home");
	        
	        List<MemberVO> memberList = service.selectMember();
	        
	        model.addAttribute("memberList", memberList);//merberList 를 memberList 란 이름으로 보냈으니 jsp 에서 사용할것
	 
	        return "home";
	  }
	 
	 @RequestMapping(value = "/read", method = RequestMethod.GET)	   
	   public String read(@RequestParam("id") String id, Model model) throws Exception {
		    logger.info("read....");
		    MemberVO memberList = service.read(id);
		    model.addAttribute("memberList",memberList);
		    return "read";
	   }

	 @RequestMapping(value = "/insert", method = RequestMethod.POST)
		public ResponseEntity<String> insertReply(@RequestBody MemberVO vo) {
		 
		 ResponseEntity<String> entity = null;
		 try {
			 service.insertReply(vo);
			 logger.info("OK....inserting" + vo.toString());
		 }catch(Exception e)
		 {
			 logger.info("Error.....");
			 e.printStackTrace();
			 entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		 }
		 
		 return entity;
	 
	 }

	/*@RequestMapping(value="/modify", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> update(@RequestBody Map<String,Object> params){
		Map<String,Object> resultMap = new HashMap<String,Object>();
			try{
				service.updateReply(resultMap);
			}catch(Exception e){
				 resultMap.put("message",e.getMessage());
				 return resultMap;
			}
				resultMap.put("message","정회원");
				return resultMap;

	}*/
}
