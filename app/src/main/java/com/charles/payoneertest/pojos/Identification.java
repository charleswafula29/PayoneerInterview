package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class Identification{

	@SerializedName("shortId")
	private String shortId;

	@SerializedName("longId")
	private String longId;

	@SerializedName("transactionId")
	private String transactionId;

	public String getShortId(){
		return shortId;
	}

	public String getLongId(){
		return longId;
	}

	public String getTransactionId(){
		return transactionId;
	}

	@Override
	public String toString() {
		return "Identification{" +
				"shortId='" + shortId + '\'' +
				", longId='" + longId + '\'' +
				", transactionId='" + transactionId + '\'' +
				'}';
	}
}