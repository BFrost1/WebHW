package web.model;

import java.util.Objects;

public class User {
	private int id;
	private String email;
	private String password;
	private String name;
	private String region;
	private String gender;
	private String comment;
	private boolean	agreement;
	
	public User() {

	}

	public User(String email, String password, String name, String region, String gender, String comment,
			boolean agreement) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.region = region;
		this.gender = gender;
		this.comment = comment;
		this.agreement = agreement;
	}

	public User(int id, String email, String password, String name, String region, String gender, String comment,
			boolean agreement) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.region = region;
		this.gender = gender;
		this.comment = comment;
		this.agreement = agreement;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", region="
				+ region + ", gender=" + gender + ", comment=" + comment + ", agreement=" + agreement + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, email, gender, id, name, password, region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(region, other.region);
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getRegion() {
		return region;
	}

	public String getGender() {
		return gender;
	}

	public String getComment() {
		return comment;
	}

	public boolean isAgreement() {
		return agreement;
	}
}
