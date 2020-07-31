package com.java.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;

@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {
	@Autowired
	HibernateTemplate template;

	@Override
	public void addAccount(String account) {
		Account a = new Account();
		a.setAccountNumber(Integer.parseInt(account));
		template.save(a);
	}

	@Override
	public boolean withdrawMoney(String account, float money) {
		Account a = template.get(Account.class, Integer.parseInt(account));
		if (a != null) {
			a.setBalance(a.getBalance() - money);
			template.update(a);
			return true;
		} else {
			System.out.println("withdrowFail");
			return false;
		}
	}

	@Override
	public boolean depositMoney(String account, float money) {
		Account a = template.get(Account.class, Integer.parseInt(account));
		if (a != null) {
			a.setBalance(a.getBalance() + money);
			template.update(a);
			return true;
		} else {
			System.out.println("depositFail");
			return false;
		}
	}
}
