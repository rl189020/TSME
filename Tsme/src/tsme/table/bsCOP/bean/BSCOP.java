package tsme.table.bsCOP.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 基站运行信息表
 */
public class BSCOP extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6106142927127516395L;
	
	/**
	 * VARCHAR2(50 BYTE) 主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String id;
	
	/**
	 * VARCHAR2(50 BYTE) 外键，基站表主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String base_station_id;
	
	private long create_time;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 出现事故原因
	 */
	private String reason;
	
	/**
	 * 是否已发送事故通知
	 */
	private boolean notify_flag;

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getBase_station_id() {
		return base_station_id;
	}

	public void setBase_station_id(String base_station_id) {
		this.base_station_id = base_station_id;
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
