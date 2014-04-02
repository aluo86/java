package com.github.aluo86.multithread;
/**
 * 
 * A bank with a number of bank account.
 * @version 1.30 
 * @author Andrew Luo
 */		
public class Bank {
	private final double[] accounts;
	
	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
	}
	/**
	 * Transfer money from one account to another.
	 * @param from the account to transfer from
	 * @param to the account to transfer to
	 * @param amount the amount to transfer
	 */
	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n" , getTotalBalance());
	}
	
	/**
	 * Get the sum of all account balances
	 * @return the total balance
	 */
	public double getTotalBalance() {
		double sum = 0;
		
		for (double a : accounts) {
			sum += a;
		}
		
		return sum;
	}
	
	/**
	 * Gets the number of accounts in the bank
	 * @return the number of accounts
	 */
	public int size() {
		return accounts.length;
	}
	

}
