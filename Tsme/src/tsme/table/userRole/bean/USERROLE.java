package tsme.table.userRole.bean;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

public class USERROLE extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -889114660250093249L;

	private String id;
	
	private String supervisor_id;
	
	private String role_id;
	
	private long create_time;
	
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(String supervisor_id) {
		this.supervisor_id = supervisor_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getId() {
		return id;
	}
}
