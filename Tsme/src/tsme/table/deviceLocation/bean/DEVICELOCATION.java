package tsme.table.deviceLocation.bean;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

public class DEVICELOCATION extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6892652620328720977L;
	
	private String id;
	
	private String device_id;
	
	private float LNG;
	
	private float LAT;
	
	private int azimuth;
	
	private float distance;

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public float getLNG() {
		return LNG;
	}

	public void setLNG(float lNG) {
		LNG = lNG;
	}

	public float getLAT() {
		return LAT;
	}

	public void setLAT(float lAT) {
		LAT = lAT;
	}

	public int getAzimuth() {
		return azimuth;
	}

	public void setAzimuth(int azimuth) {
		this.azimuth = azimuth;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getId() {
		return id;
	}
}
