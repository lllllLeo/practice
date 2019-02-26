package net.reserve.db;

import java.sql.Timestamp;

public class ReservationBean {
	private String store_code;		//지점코드
	private String res_name;	//예약자이름
	private String res_phone;	//예약자 휴대폰번호
	private int res_ppl;		//예약인원
	private Timestamp res_date;		//예약날짜
	
	
	public String getStore_code() {
		return store_code;
	}
	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_phone() {
		return res_phone;
	}
	public void setRes_phone(String res_phone) {
		this.res_phone = res_phone;
	}
	public int getRes_ppl() {
		return res_ppl;
	}
	public void setRes_ppl(int res_ppl) {
		this.res_ppl = res_ppl;
	}
	public Timestamp getRes_date() {
		return res_date;
	}
	public void setRes_date(Timestamp res_date) {
		this.res_date = res_date;
	}
	
	
}
