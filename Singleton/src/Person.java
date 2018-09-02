
public class Person {
	public static final Person person = new Person(); //线程安全，一开始就载入，比较浪费资源
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//构造函数私有化
	private Person() {
	}
	
	//提供一个全局的静态方法
	public static Person getPerson() {
		return person;
	}
}
