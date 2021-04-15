package VO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Timestamp;
public class DeliveryVO {
	private String dvr_num;
	private String in_name;
	private Timestamp dvr_date;
	
	private String dvr_cnt;
	private Timestamp rcv_date;

	public DeliveryVO(String dvr_num, String in_name, Timestamp dvr_date2, String dvr_cnt, Timestamp rcv_date2) {
		super();
		this.dvr_num = dvr_num;
		this.in_name = in_name;
		this.dvr_date = (Timestamp) dvr_date2;
		this.dvr_cnt = dvr_cnt;
		this.rcv_date = (Timestamp) rcv_date2;
	}

	public String getDvr_num() {
		return dvr_num;
	}

	public String getIn_name() {
		return in_name;
	}

	public Timestamp getDvr_date() {
		return dvr_date;
	}

	public String getDvr_cnt() {
		return dvr_cnt;
	}

	public Timestamp getRcv_date() {
		return rcv_date;
	}
}
