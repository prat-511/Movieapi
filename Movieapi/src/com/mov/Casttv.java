package com.mov;

public class Casttv {
	String credit_id;
	int id;
	int gender;
	String name;
	int order;
	String profile_path;
	String character;
	public String getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	@Override
	public String toString() {
		return "Casttv [credit_id=" + credit_id + ", id=" + id + ", gender=" + gender + ", name=" + name + ", order="
				+ order + ", profile_path=" + profile_path + ", character=" + character + "]";
	}
	public Casttv(String credit_id, int id, int gender, String name, int order, String profile_path, String character) {
		super();
		this.credit_id = credit_id;
		this.id = id;
		this.gender = gender;
		this.name = name;
		this.order = order;
		this.profile_path = profile_path;
		this.character = character;
	}
	public Casttv() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
