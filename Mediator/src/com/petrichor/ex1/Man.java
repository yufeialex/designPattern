package com.ibeifeng.ex1;

public class Man extends Person {

	public Man(String name, int condition) {
		super(name, condition);
	}

	public void getPartner(Person person) {
		if(person instanceof Man) {
			System.out.println("汗，我不是同性恋！");
		} else {
			if(this.getCondition() == person.getCondition()) {
				System.out.println(this.getName() + "和" + person.getName() + "绝配");
			} else {
				System.out.println(this.getName() + "和" + person.getName() + "不相配");
			}
		}
	}

}
