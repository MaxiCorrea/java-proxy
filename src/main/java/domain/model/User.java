package domain.model;

public class User {

	private final String id;
	private final Role role;
	
	public User(
			final String id,
			final Role role) {
		this.id = id;
		this.role = role;
	}

	public String getId() {
		return id;
	}
	
	public Role getRole() {
		return role;
	}
	
}
