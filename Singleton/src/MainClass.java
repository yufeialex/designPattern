
public class MainClass {
	public static void main(String[] args) {
		Person2 per = Person2.getPerson();
		Person2 per2 = Person2.getPerson();
		per.setName("zhangsan");
		per2.setName("lisi");
		//per.person.setName("ss");
		per.getPerson().setName("ss");
		
		System.out.println(per.getName());
		System.out.println(per2.getName());
		
		Person person = Person.getPerson();
		Person person1 = Person.getPerson();
		person.setName("yufei");
		person1.setName("yusssfei");
		person.person.setName("ss");
		
		System.out.println(person.getName());		
		System.out.println(person1.getName());		
	}
}
