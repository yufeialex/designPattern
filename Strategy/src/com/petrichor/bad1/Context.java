package com.petrichor.bad1;

public class Context {
	private Strategy strategy;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void encrypt() {
		this.strategy.encrypt();
	}
}