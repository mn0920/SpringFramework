package kr.green.spring.vo;

public class AccountVo {
	private String id;
	private String pw;
	private String email;
	private String gender;
	private String author;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", author=" + author
				+ "]";
	}
}
