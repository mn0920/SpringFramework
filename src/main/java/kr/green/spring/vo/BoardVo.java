package kr.green.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
	private int num;
	private String title;
	private String contents;
	private String author;
	private String file;
	private Date register_date;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getFile() {
		/*/년/월/일/파일명.확장자가 나오는 getter*/
		return file;
	}
	public String getOriFile() {
		/*파일명.확장자가 나오는 getter*/
		if(file == null) {
			return "";
		}
		return file.substring(file.indexOf/*문자열 또는 문자가 */('_')/*일 때*/+1/*그 다음 것 부터 저장하겠다.*/);
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getRegister_date() { //월 : 대문자 MM , 시간-분 : 소문자 mm
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일 hh:mm");
		return format.format(register_date);
	}
	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}
	
	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", title=" + title + ", contents=" + contents + ", author=" + author + ", file="
				+ file + ", register_date=" + register_date + "]";
	}
}
