package examen_jee_chanfi_elhadji.models;

import java.sql.Date;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	private String image_link;
	private Date employed_at;
	private String phone_number;
	private String role;
	
	public User(Integer id, String username, String password, String lastname, String firstname, String image_link,
			Date employed_at, String phone_number, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.image_link = image_link;
		this.employed_at = employed_at;
		this.phone_number = phone_number;
		this.role = role;
	}

	public User(String username, String password, String lastname, String firstname, String image_link,
			Date employed_at, String phone_number, String role) {
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.image_link = image_link;
		this.employed_at = employed_at;
		this.phone_number = phone_number;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public Date getEmployed_at() {
		return employed_at;
	}

	public void setEmployed_at(Date employed_at) {
		this.employed_at = employed_at;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
