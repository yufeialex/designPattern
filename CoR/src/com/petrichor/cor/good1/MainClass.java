package com.petrichor.cor.good1;

/**
 * 职责链未必每一个环节都会处理目标，可能只有某一个处理（排他）；也可能有某几个共同处理（合作），特例就是全都处理。
 */
public class MainClass {
	public static void main(String[] args) {
		CarHandler headH = new CarHeadHandler();
		CarHandler bodyH = new CarBodyHandler();
		CarHandler tailH = new CarTailHandler();

		// 1，对象链的组织。需要将某任务的所有职责执行对象以链的形式加以组织。
		//组装顺序预先设定好,顺序是车头-->车身-->车尾
		headH.setNextHandler(bodyH);
		bodyH.setNextHandler(tailH);
		
		//调用职责链的链头来完成操作
		headH.HandlerCar();
		
		System.out.println("---------------");
		
		//顺序改变，希望是车身-->车头--车尾
		bodyH.setNextHandler(headH);
		headH.setNextHandler(tailH);
		bodyH.HandlerCar();

        System.out.println("---------------");
        //简便操作
        // 和链式调用的区别：链式调用的所有执行者都是自己，职责链上的每一环都是一个单独的对象
		bodyH.setNextHandler(headH).setNextHandler(tailH);
		bodyH.HandlerCar();
		
		
	}
}
