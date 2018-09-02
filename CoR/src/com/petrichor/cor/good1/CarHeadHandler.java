package com.petrichor.cor.good1;

public class CarHeadHandler extends CarHandler{

	// 实现类需要做自己的工作，然后去触发下一环节的处理
	public void HandlerCar() {
        //处理请求
		System.out.println("组装车头");
		if(this.carHandler != null) {
            //转发请求
			this.carHandler.HandlerCar();
		}
	}

}
