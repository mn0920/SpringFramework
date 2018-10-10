package kr.green.spring.vo;

public class AccountVo {
	//서버에서 사용하기 위한 객체를 만들기위한 것이다. 갖고 올 수 있고(회원가입), 가져다 놓을 수 있다(게시판에 자료 뿌리기).
	//VO의 멘버 변수 이름과 DB의 속성의 이름이 같아야한다. = 만약 다르다면 Mapping을 해줘야함.(나중에 할 것임)
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
