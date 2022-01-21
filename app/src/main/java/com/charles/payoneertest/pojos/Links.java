package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("self")
	private String self;

	@SerializedName("lang")
	private String lang;

	@SerializedName("logo")
	private String logo;

	@SerializedName("operation")
	private String operation;

	@SerializedName("validation")
	private String validation;

	public String getSelf(){
		return self;
	}

	public String getLang(){
		return lang;
	}

	public String getLogo(){
		return logo;
	}

	public String getOperation(){
		return operation;
	}

	public String getValidation(){
		return validation;
	}

	@Override
	public String toString() {
		return "Links{" +
				"self='" + self + '\'' +
				", lang='" + lang + '\'' +
				", logo='" + logo + '\'' +
				", operation='" + operation + '\'' +
				", validation='" + validation + '\'' +
				'}';
	}
}