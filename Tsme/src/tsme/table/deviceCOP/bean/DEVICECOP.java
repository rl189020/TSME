package tsme.table.deviceCOP.bean;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

public class DEVICECOP extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6334208872391439971L;

	private String id;
	
	private String device_id;
	
	private long create_time;
	
	private String status;
	
	private String reason;
	
	private boolean notify_flag;
	
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

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isNotify_flag() {
		return notify_flag;
	}

	public void setNotify_flag(boolean notify_flag) {
		this.notify_flag = notify_flag;
	}

	public String getId() {
		return id;
	}
}
