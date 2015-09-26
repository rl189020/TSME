package tsme.table.deviceLoginLog.bean;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

public class DEVICELOGINLOG extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2757232242756563833L;
	
	private String id;
	
	private String device_id;
	
	private String supervisor_id;
	
	private long create_time;
	
	private String operation;

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

	public String getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getId() {
		return id;
	}
}
