package main;


public class User {
	private String name;
	private int age;
	private String email;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	User (String uName, int uAge, String uEmail) {
//		name = uName;
//		age = uAge;
//		email = uEmail;
//	}
//	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
	}

	public String getName(){
		return name;
	}
	public void setName(String uName){
		name = uName;
	}	
		
	public int getAge(){
		return age;
	}
	public void setAge(int uAge){
		age = uAge;
	}	
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String uEmail){
		email = uEmail;
	}

}
