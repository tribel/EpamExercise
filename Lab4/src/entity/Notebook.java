package entity;

import java.time.LocalDate;

/**
 * Entity class for notebook
 * 
 * @author Tribel
 *
 */
public class Notebook {
	
	private String surname;
	private String name;
	private String patronymic;
	private String nickname;
	private String comment;
	private Group group;
	private String homeTelephone;
	private String mobileTelephone;
	private String email;
	private String skype;
	private Address address;
	private LocalDate createDate;
	private LocalDate lastChangeDate;
	
	public Notebook() {
	}

	/**
	 * @return full name in "Surname N.P." format
	 */
	public String getFullName() {
		StringBuilder str = new StringBuilder(this.surname);
		str.append("  ").append(this.name.charAt(0)).append(". ").
						 append(this.patronymic.charAt(0)).append(".");
		
		return str.toString();
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
		lastChangeDate = LocalDate.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		lastChangeDate = LocalDate.now();
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
		lastChangeDate = LocalDate.now();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
		lastChangeDate = LocalDate.now();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
		lastChangeDate = LocalDate.now();
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
		lastChangeDate = LocalDate.now();
	}

	public String getHomeTelephone() {
		return homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
		lastChangeDate = LocalDate.now();
	}

	public String getMobileTelephone() {
		return mobileTelephone;
	}

	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
		lastChangeDate = LocalDate.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		lastChangeDate = LocalDate.now();
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
		lastChangeDate = LocalDate.now();
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
		lastChangeDate = LocalDate.now();
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
		lastChangeDate = LocalDate.now();
	}

	public LocalDate getLastChangeDate() {
		return lastChangeDate;
	}	
	
}	
