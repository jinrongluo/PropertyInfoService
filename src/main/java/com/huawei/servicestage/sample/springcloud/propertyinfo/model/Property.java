package com.huawei.servicestage.sample.springcloud.propertyinfo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	private String propertyId;
	private int year;
	private String buildingType;
	private int area;
	private String features;
	private double mgtFee;
	
	public Property() {
		
	}
	
	public Property(String propertyId, int year, String buildingType, int area, String features, double mgtFee) {
		this.propertyId = propertyId;
		this.year = year;
		this.buildingType = buildingType;
		this.area = area;
		this.features = features;
		this.mgtFee = mgtFee;
	}
	
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBuildingType() {
		return buildingType;
	}
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public double getMgtFee() {
		return mgtFee;
	}
	public void setMgtFee(double mgtFee) {
		this.mgtFee = mgtFee;
	}

}
