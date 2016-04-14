package com.cardvalue.wechat.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_startup_image")
@NamedNativeQuery(name="findUserStartupImageCount", query="select count(*) from user_startup_image where user_id=:userId and image_id=:imageId")
public class UserStartupImage implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="user_id", unique=false)  
	private WeUser user;
	
    @OneToOne(optional=false,cascade={CascadeType.ALL})  
    @JoinColumn(name="image_id", unique=false)  
	private StartupImage startupImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WeUser getUser() {
		return user;
	}

	public void setUser(WeUser user) {
		this.user = user;
	}

	public StartupImage getStartupImage() {
		return startupImage;
	}

	public void setStartupImage(StartupImage startupImage) {
		this.startupImage = startupImage;
	}
    
}
