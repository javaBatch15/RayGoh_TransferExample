package com.java.service;

public interface AccountService {

	public boolean transferMoney(String account1, String account2, float money);

	public boolean withdrawMoney(String account, float money);

	public boolean depositMoney(String account, float money);
}
