/**
 * This class makes a customer and stores their name and age 
 * @author Ojas
 *
 */
public class Customer {
	private String name;
	private int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Customer(Customer x) {
		this.name = x.name;
		this.age = x.age;
	}

	@Override
	public String toString() {
		return "Age: " + age + " Name: " + name;

	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int a) {
		age = a;
	}
}
