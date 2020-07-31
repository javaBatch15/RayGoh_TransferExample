package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.AccountRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository rep;

	@Override
	public boolean transferMoney(String account1, String account2, float money) {
		return withdrawMoney(account1, money) && depositMoney(account2, money);
	}

//	@Override
//	public boolean transferMoney(String account1, String account2, float money) {
//		boolean withdrawStatus = rep.withdrawMoney(account1, money);
//		System.out.println(withdrawStatus);
//		boolean depositStatus = rep.depositMoney(account2, money);
//		System.out.println(depositStatus);
//
//		return (withdrawStatus && depositStatus);
//	}

	@Override
	public boolean withdrawMoney(String account, float money) {
		// TODO Auto-generated method stub
		return rep.withdrawMoney(account, money);

	}

	@Override
	public boolean depositMoney(String account, float money) {
		// TODO Auto-generated method stub
		return rep.depositMoney(account, money);
	}

}
