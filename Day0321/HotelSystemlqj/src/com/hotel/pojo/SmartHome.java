package com.hotel.pojo;

public class SmartHome {
	private String roomId;
	private String clean;
	private String wash;
	private String tv;
	private String curtain;
	private String light;
	private String airConditioner;
	private String tem;
	
	public SmartHome() {
	}
	public SmartHome(String roomId, String clean, String wash, String tv, String curtain, String light,
			String airConditioner, String tem) {
		super();
		this.roomId = roomId;
		this.clean = clean;
		this.wash = wash;
		this.tv = tv;
		this.curtain = curtain;
		this.light = light;
		this.airConditioner = airConditioner;
		this.tem = tem;
	}
	/**
	 * @return the curtain
	 */
	public String getCurtain() {
		return curtain;
	}
	/**
	 * @param curtain the curtain to set
	 */
	public void setCurtain(String curtain) {
		this.curtain = curtain;
	}
	/**
	 * @return the roomId
	 */
	public String getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the clean
	 */
	public String getClean() {
		return clean;
	}
	/**
	 * @param clean the clean to set
	 */
	public void setClean(String clean) {
		this.clean = clean;
	}
	/**
	 * @return the wash
	 */
	public String getWash() {
		return wash;
	}
	/**
	 * @param wash the wash to set
	 */
	public void setWash(String wash) {
		this.wash = wash;
	}
	/**
	 * @return the tv
	 */
	public String getTv() {
		return tv;
	}
	/**
	 * @param tv the tv to set
	 */
	public void setTv(String tv) {
		this.tv = tv;
	}
	/**
	 * @return the light
	 */
	public String getLight() {
		return light;
	}
	/**
	 * @param light the light to set
	 */
	public void setLight(String light) {
		this.light = light;
	}
	/**
	 * @return the airConditioner
	 */
	public String getAirConditioner() {
		return airConditioner;
	}
	/**
	 * @param airConditioner the airConditioner to set
	 */
	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}
	/**
	 * @return the tem
	 */
	public String getTem() {
		return tem;
	}
	/**
	 * @param tem the tem to set
	 */
	public void setTem(String tem) {
		this.tem = tem;
	}
	@Override
	public String toString() {
		return "SmartHome [roomId=" + roomId + ", clean=" + clean + ", wash=" + wash + ", tv=" + tv + ", curtain="
				+ curtain + ", light=" + light + ", airConditioner=" + airConditioner + ", tem=" + tem + "]";
	}
	
	
}
