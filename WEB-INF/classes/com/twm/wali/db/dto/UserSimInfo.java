package com.twm.wali.db.dto;

import java.util.Date;

public class UserSimInfo {

	private Integer sId;

	private Integer waliId;

	private String iccId;

	private String myfareId;

	private Integer jointSim;

	private Boolean isEnable;

	private Date createDate;

	private Date updateDate;

	public UserSimInfo() {
		super();
	}

	public UserSimInfo(Integer sId, Integer waliId, String iccId, String myfareId, Integer jointSim, Boolean isEnable,
			Date createDate, Date updateDate) {
		super();
		this.sId = sId;
		this.waliId = waliId;
		this.iccId = iccId;
		this.myfareId = myfareId;
		this.jointSim = jointSim;
		this.isEnable = isEnable;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public Integer getWaliId() {
		return waliId;
	}

	public void setWaliId(Integer waliId) {
		this.waliId = waliId;
	}

	public String getIccId() {
		return iccId;
	}

	public void setIccId(String iccId) {
		this.iccId = iccId;
	}

	public String getMyfareId() {
		return myfareId;
	}

	public void setMyfareId(String myfareId) {
		this.myfareId = myfareId;
	}

	public Integer getJointSim() {
		return jointSim;
	}

	public void setJointSim(Integer jointSim) {
		this.jointSim = jointSim;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "UserSimInfo [sId=" + sId + ", waliId=" + waliId + ", iccId=" + iccId + ", myfareId=" + myfareId
				+ ", jointSim=" + jointSim + ", isEnable=" + isEnable + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
