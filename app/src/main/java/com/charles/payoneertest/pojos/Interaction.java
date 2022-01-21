package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class Interaction{

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
		return "Interaction{" +
				"reason='" + reason + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}