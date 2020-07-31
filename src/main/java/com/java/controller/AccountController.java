package com.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.service.AccountService;

@Controller
@RequestMapping("/")
public class AccountController {
	@Autowired
	AccountService service;

	@PostMapping("transfer")
	public String transfer(@Valid @RequestParam String accFrom, @RequestParam String accTo, @RequestParam float amount) {
		boolean tfr = service.transferMoney(accFrom, accTo, amount);
		if (tfr) {
			return "success";
		} else {
			return "fail";
		}

	}

	@PostMapping("deposit")
	public String deposit(@Valid @RequestParam String accFrom, @RequestParam float value) {
		boolean tfr = service.depositMoney(accFrom, value);
		if (tfr) {
			return "success";
		} else {
			return "fail";
		}

	}

	@PostMapping("withdraw")
	public String transfer(@Valid @RequestParam String accFrom, @RequestParam float value) {
		boolean tfr = service.withdrawMoney(accFrom, value);
		if (tfr) {
			return "success";
		} else {
			return "fail";
		}
	}

	@GetMapping
	public String index(){
		return "index";
	}
}
