package com.ibeifeng.news;

public class RunCar implements Car {

	public void run() {
		System.out.println("可以跑");
	}

	public void show() {
		this.run();
	}

}
