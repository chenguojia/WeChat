package com.cardvalue.wechat.dto;

import org.apache.commons.lang.StringUtils;


public class AroundMerchantDTO {

	private double lat;
	
	private double lng;
	
	private String name;
	
	private String id;
	
	private double distance;
	
	private double credit;
	
	private String wgsLat;
	
	private String wgsLng;

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public String getMId() {
		return StringUtils.substringBefore(id, "_");
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getDistance() {
		return distance;
	}
	
	public long getDistanceLabel() {
		return Math.round(distance);
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getCredit() {
		return credit;
	}

	public long getCreditLabel() {
		return Math.round(credit);
	}
	
	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getWgsLat() {
		return wgsLat;
	}

	public void setWgsLat(String wgsLat) {
		this.wgsLat = wgsLat;
	}

	public String getWgsLng() {
		return wgsLng;
	}

	public void setWgsLng(String wgsLng) {
		this.wgsLng = wgsLng;
	}
	
}
