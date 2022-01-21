package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("reason")
	private String reason;

	@SerializedName("code")
	private String code;

	public String getReason(){
		return reason;
	}

	public String getCode(){
		return code;
	}

	@Override
	public String toString() {
		return "Status{" +
				"reason='" + reason + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}