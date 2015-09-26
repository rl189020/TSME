package tsme.table.deviceStatistics.bean;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

public class DEVICESTATISTICS extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5329669639577670103L;

	private String id;
	
	private String device_id;
	
	private long create_time;
	
	private boolean visible = true;
	
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getId() {
		return id;
	}
}
