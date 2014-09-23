package springInAction.beans;

public class ClientService {
	private static ClientService service = new ClientService();

	public static ClientService createService() {
		System.out.println("Create Service by factory!");
		return service;
	}
}
