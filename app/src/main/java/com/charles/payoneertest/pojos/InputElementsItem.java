package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class InputElementsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("type")
	private String type;

	public String getName(){
		return name;
	}

	public String getType(){
		return type;
	}

	@Override
	public String toString() {
		return "InputElementsItem{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}