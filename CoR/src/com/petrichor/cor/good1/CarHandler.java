package com.petrichor.cor.good1;

public abstract class CarHandler {
    // 访问控制
	protected CarHandler carHandler;

	public CarHandler setNextHandler(CarHandler carHandler) {
		this.carHandler = carHandler;
        //2，消息或请求的传递。将消息或请求沿着对象链传递，以让处于对象链中的对象得到处理机会。
		return this.carHandler;
	}

    // 3，处于对象链中的对象的职责分配。不同的对象完成不同的职责。
    public abstract void HandlerCar();
}
