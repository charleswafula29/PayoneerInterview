package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class ReturnCode{

	@SerializedName("name")
	private String name;

	@SerializedName("source")
	private String source;

	public String getName(){
		return name;
	}

	public String getSource(){
		return source;
	}

	@Override
	public String toString() {
		return "ReturnCode{" +
				"name='" + name + '\'' +
				", source='" + source + '\'' +
				'}';
	}
}