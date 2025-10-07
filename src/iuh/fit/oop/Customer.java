package iuh.fit.oop;

import java.time.LocalDate;

public class Customer {
	private String id;
	private String name;
	private Gender gender;
	private String phone;
	private LocalDate birthday;
	
	public Customer() {
	}

	public Customer(String id, String name, Gender gender, String phone, LocalDate birthday) {
		setId(id);
		setName(name);
		setGender(gender);
		setPhone(phone);
		setBirthday(birthday);
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		if(gender == null) {
			throw new IllegalArgumentException("Invalid gender");
		}
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if(phone == null | !phone.matches("^0\\d{9}$")) {
			throw new IllegalArgumentException("Phone number must have 10 digits,starting with 0");
		}
		this.phone = phone;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		if(birthday == null || birthday.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Invalid birthday");
		}
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return String.format("| %s10 | %s20 | %f10 | %d10 | %s10 |",
				id,
				name,
				gender,
				phone,
				birthday);
	}
	
	
}
