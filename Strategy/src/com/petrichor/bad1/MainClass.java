package com.ibeifeng.bad1;

public class MainClass {
	public static void main(String[] args) {
//		com.ibeifeng.bad1.Strategy stra = new com.ibeifeng.bad1.MDSStrategy();
//		stra.encrypt();
		Context context = new Context(new MDSStrategy());
		context.encrypt();
	}
}
