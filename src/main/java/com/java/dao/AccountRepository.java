package com.java.dao;

public interface AccountRepository {
	public void addAccount(String account);

	public boolean withdrawMoney(String account, float money);

	public boolean depositMoney(String account, float money);
}
