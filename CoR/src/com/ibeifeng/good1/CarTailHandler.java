package com.ibeifeng.good1;

public class CarTailHandler extends CarHandler{

	public void HandlerCar() {
		System.out.println("组装车尾");
		if(this.carHandler != null) {
			this.carHandler.HandlerCar();
		}
	}

}
