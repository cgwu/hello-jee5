package springInAction.beans;

public class GreetingServiceImpl implements GreetingService {
	private String greeting;

	@Override
	public void sayGreeting() {
		System.out.println(greeting);

	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
