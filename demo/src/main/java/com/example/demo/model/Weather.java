package com.example.demo.model;

public class Weather {

//	private String stationId;
	private String date;
	private String element;
	private String value1;
	private String mFlag;
	private String qFlag;
	private String sFlag;
	private String value2;

	public Weather(String date, String element, String value1, String mFlag, String qFlag, String sFlag, String value2) {
		super();
		this.date = date;
		this.element = element;
		this.value1 = value1;
		this.mFlag = mFlag;
		this.qFlag = qFlag;
		this.sFlag = sFlag;
		this.value2 = value2;
	}

	public Weather() {}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getmFlag() {
		return mFlag;
	}

	public void setmFlag(String mFlag) {
		this.mFlag = mFlag;
	}

	public String getqFlag() {
		return qFlag;
	}

	public void setqFlag(String qFlag) {
		this.qFlag = qFlag;
	}

	public String getsFlag() {
		return sFlag;
	}

	public void setsFlag(String sFlag) {
		this.sFlag = sFlag;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
}
