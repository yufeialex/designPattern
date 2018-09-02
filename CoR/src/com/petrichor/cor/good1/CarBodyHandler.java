package com.petrichor.cor.good1;

public class CarBodyHandler extends CarHandler {

	public void HandlerCar() {
		System.out.println("组装车身");
		if(this.carHandler != null) {
			this.carHandler.HandlerCar();
		}
	}

}
