package org.pi4j.model;

public class ActorExtended extends ActorBasic {

	private int activity;
	private int audience;
	private int authority;
	private Demographics demographics;
	
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public int getAudience() {
		return audience;
	}
	public void setAudience(int audience) {
		this.audience = audience;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public Demographics getDemographics() {
		return demographics;
	}
	public void setDemographics(Demographics demographics) {
		this.demographics = demographics;
	}
}
