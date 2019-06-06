package com.example.demo.persist.controller;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.persist.dao.UserAccountRepository;
import com.example.demo.persist.model.UserAccount;


/**
 * 
 */
@RestController
@RequestMapping("/my")
public class MyRestController {

	public static final Logger logger = LoggerFactory.getLogger(MyRestController.class);

	public MyRestController() {
		logger.info("i was born!");
	}

	@Autowired
	private UserAccountRepository userAccountRepository;

	@PostMapping(produces = "application/json", consumes = "application/json")
	public String postUser(@RequestBody UserAccount userAccount, HttpServletRequest request) {
				
		userAccount = userAccountRepository.save(userAccount);
		
		logger.info(userAccount.toString());
		
		return userAccount.toString();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserAccount> get(@PathVariable String id, HttpServletRequest request) {
		
		UserAccount userAccount = userAccountRepository.getOne(Long.valueOf(id));
		
		String contentType = "application/json";

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.body(userAccount);
				//.body("Hello world!");
	}
}