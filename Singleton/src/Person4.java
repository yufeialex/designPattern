
public class Person4 {
	private String name;
	private static Person4 person;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//构造函数私有化
	private Person4() {
	}
	
	//提供一个全局的静态方法
	// 为了效率，只在创建时候加锁，以后不需要锁定
	public static Person4 getPerson() {
		if(person == null) {
			synchronized (Person4.class) {
				if(person == null) { // 可能前两个线程都进来了，所以要再判断一遍；这里只会执行一遍；锁的粒度比较小；以后亦不会再用到这个锁了
					person = new Person4();
				}
			}
			
		}
		return person;
	}
}
