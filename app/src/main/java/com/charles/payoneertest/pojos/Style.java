package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class Style{

	@SerializedName("language")
	private String language;

	public String getLanguage(){
		return language;
	}

	@Override
	public String toString() {
		return "Style{" +
				"language='" + language + '\'' +
				'}';
	}
}