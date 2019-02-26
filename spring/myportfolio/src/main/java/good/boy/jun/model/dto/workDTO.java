package good.boy.jun.model.dto;

import java.util.Date;

public class workDTO {

	private String work_number; // 시퀀스 번호
	private String work_title; // 제목
	private String work_used; // 사용된 언어
	private String work_description; // 설명
	private int work_viewcount; // 조회수
	private Date work_date; // 날짜
	private String work_image1; // 이미지1
	private String work_image2; // 이미지2
	private String work_image3; // 이미지3
	private String work_image4; // 이미지4

	public String getWork_number() {
		return work_number;
	}

	public void setWork_number(String work_number) {
		this.work_number = work_number;
	}

	public String getWork_title() {
		return work_title;
	}

	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}

	public String getWork_used() {
		return work_used;
	}

	public void setWork_used(String work_used) {
		this.work_used = work_used;
	}

	public String getWork_description() {
		return work_description;
	}

	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}

	public int getWork_viewcount() {
		return work_viewcount;
	}

	public void setWork_viewcount(int work_viewcount) {
		this.work_viewcount = work_viewcount;
	}

	public Date getWork_date() {
		return work_date;
	}

	public void setWork_date(Date work_date) {
		this.work_date = work_date;
	}

	public String getWork_image1() {
		return work_image1;
	}

	public void setWork_image1(String work_image1) {
		this.work_image1 = work_image1;
	}

	public String getWork_image2() {
		return work_image2;
	}

	public void setWork_image2(String work_image2) {
		this.work_image2 = work_image2;
	}

	public String getWork_image3() {
		return work_image3;
	}

	public void setWork_image3(String work_image3) {
		this.work_image3 = work_image3;
	}

	public String getWork_image4() {
		return work_image4;
	}

	public void setWork_image4(String work_image4) {
		this.work_image4 = work_image4;
	}

	@Override
	public String toString() {
		return "workDTO [work_number=" + work_number + ", work_title=" + work_title + ", work_used=" + work_used
				+ ", work_description=" + work_description + ", work_viewcount=" + work_viewcount + ", work_date="
				+ work_date + ", work_image1=" + work_image1 + ", work_image2=" + work_image2 + ", work_image3="
				+ work_image3 + ", work_image4=" + work_image4 + "]";
	}

}
