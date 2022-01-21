package com.charles.payoneertest.pojos;

import com.google.gson.annotations.SerializedName;

public class ContractData{

	@SerializedName("PAGE_ENVIRONMENT")
	private String pAGEENVIRONMENT;

	@SerializedName("JAVASCRIPT_INTEGRATION")
	private String jAVASCRIPTINTEGRATION;

	@SerializedName("PAGE_BUTTON_LOCALE")
	private String pAGEBUTTONLOCALE;

	public String getPAGEENVIRONMENT(){
		return pAGEENVIRONMENT;
	}

	public String getJAVASCRIPTINTEGRATION(){
		return jAVASCRIPTINTEGRATION;
	}

	public String getPAGEBUTTONLOCALE(){
		return pAGEBUTTONLOCALE;
	}

	@Override
	public String toString() {
		return "ContractData{" +
				"pAGEENVIRONMENT='" + pAGEENVIRONMENT + '\'' +
				", jAVASCRIPTINTEGRATION='" + jAVASCRIPTINTEGRATION + '\'' +
				", pAGEBUTTONLOCALE='" + pAGEBUTTONLOCALE + '\'' +
				'}';
	}
}