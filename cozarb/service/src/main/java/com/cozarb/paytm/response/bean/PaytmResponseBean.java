package com.cozarb.paytm.response.bean;

public class PaytmResponseBean {
	protected String CURRENCY;
	protected String GATEWAYNAME;
	protected String RESPMSG;
	protected String BANKNAME;
	protected String PAYMENTMODE;
	protected String MID;
	protected String RESPCODE;
	protected String TXNID;
	protected String TXNAMOUNT;
	protected String TXNTYPE;
	protected String ORDERID;
	protected String STATUS;
	protected String BANKTXNID;
	protected String TXNDATE;
	protected String CHECKSUMHASH;
	protected String REFUNDAMT;

	public String getCURRENCY() {
		return CURRENCY;
	}

	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}

	public String getGATEWAYNAME() {
		return GATEWAYNAME;
	}

	public void setGATEWAYNAME(String gATEWAYNAME) {
		GATEWAYNAME = gATEWAYNAME;
	}

	public String getRESPMSG() {
		return RESPMSG;
	}

	public void setRESPMSG(String rESPMSG) {
		RESPMSG = rESPMSG;
	}

	public String getBANKNAME() {
		return BANKNAME;
	}

	public void setBANKNAME(String bANKNAME) {
		BANKNAME = bANKNAME;
	}

	public String getPAYMENTMODE() {
		return PAYMENTMODE;
	}

	public void setPAYMENTMODE(String pAYMENTMODE) {
		PAYMENTMODE = pAYMENTMODE;
	}

	public String getMID() {
		return MID;
	}

	public void setMID(String mID) {
		MID = mID;
	}

	public String getRESPCODE() {
		return RESPCODE;
	}

	public void setRESPCODE(String rESPCODE) {
		RESPCODE = rESPCODE;
	}

	public String getTXNID() {
		return TXNID;
	}

	public void setTXNID(String tXNID) {
		TXNID = tXNID;
	}

	public String getTXNAMOUNT() {
		return TXNAMOUNT;
	}

	public void setTXNAMOUNT(String tXNAMOUNT) {
		TXNAMOUNT = tXNAMOUNT;
	}

	public String getORDERID() {
		return ORDERID;
	}

	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getBANKTXNID() {
		return BANKTXNID;
	}

	public void setBANKTXNID(String bANKTXNID) {
		BANKTXNID = bANKTXNID;
	}

	public String getTXNDATE() {
		return TXNDATE;
	}

	public void setTXNDATE(String tXNDATE) {
		TXNDATE = tXNDATE;
	}

	public String getCHECKSUMHASH() {
		return CHECKSUMHASH;
	}

	public void setCHECKSUMHASH(String cHECKSUMHASH) {
		CHECKSUMHASH = cHECKSUMHASH;
	}

	public String getTXNTYPE() {
		return TXNTYPE;
	}

	public void setTXNTYPE(String tXNTYPE) {
		TXNTYPE = tXNTYPE;
	}

	public String getREFUNDAMT() {
		return REFUNDAMT;
	}

	public void setREFUNDAMT(String rEFUNDAMT) {
		REFUNDAMT = rEFUNDAMT;
	}
}
