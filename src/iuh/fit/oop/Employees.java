package iuh.fit.oop;

public class Employees {
	private String id;
	private String name;
	private Role role;
	private Gender gender;
	
	public Employees() {
	}

	public Employees(String id, String name, Role role, Gender gender) {
		setId(id);
		setName(name);
		setRole(role);
		setGender(gender);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id == null || id.isEmpty()) {
			throw new IllegalArgumentException("Product's id must not be empty");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name must not be empty");
		}
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		if(role == null) {
			throw new IllegalArgumentException("Invalid role");
		}
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		if(gender == null) {
			throw new IllegalArgumentException("Invalid gender");
		}
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("| %s10 | %s20 | %f10 | %d10 | %s10 |",
				id,
				name,
				role,
				gender);
	}
	
	
}
