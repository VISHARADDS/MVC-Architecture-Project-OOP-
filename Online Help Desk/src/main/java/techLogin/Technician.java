package techLogin;

public class Technician {
	 private int TID;
	 private String Name;
	 private String Email;
	 private String Phone;
	 private String Password;
	 private String Username;
	 private String Gender;
	 
	public Technician(int TID, String Name, String Email, String Phone, String Password, String Username,String Gender) {
		
		this.TID = TID;
		this.Name = Name;
		this.Email = Email;
		this.Phone = Phone;
		this.Password = Password;
		this.Username = Username;
		this.Gender=Gender;
	}

	public int getTID() {
		return TID;
	}

	public String getName() {
		return Name;
	}

	public String getEmail() {
		return Email;
	}

	public String getPhone() {
		return Phone;
	}

	public String getPassword() {
		return Password;
	}

	public String getUserName() {
		return Username;
	}
	public String getGender() {
		return Gender;
	}

}
