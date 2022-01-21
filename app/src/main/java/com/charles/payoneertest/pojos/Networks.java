package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Networks{

	@SerializedName("applicable")
	private List<ApplicableItem> applicable;

	public List<ApplicableItem> getApplicable(){
		return applicable;
	}

	@Override
	public String toString() {
		return "Networks{" +
				"applicable=" + applicable +
				'}';
	}
}