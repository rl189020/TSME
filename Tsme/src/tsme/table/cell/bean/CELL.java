package tsme.table.cell.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 小区信息表，父表
 */
public class CELL extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7636565689289209210L;

	/**
	 * VARCHAR2(50 BYTE) 主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String id;
	
	/**
	 * VARCHAR2(50 BYTE) 外键，员工信息表主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String supervisor_id;
	
	/**
	 * 扫描区域半径
	 */
	private float radius;
	
	/**
	 * 该小区纳入扫描范围的时间
	 */
	private long involve_time;
	
	/**
	 * 该小区停止监测的时间
	 */
	private long remove_time;
	
	/**
	 * 监测异常次数
	 */
	private int warn_signal_num;
	
	/**
	 * 是否可见
	 */
	private boolean visible = true;;
	
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

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public long getInvolve_time() {
		return involve_time;
	}

	public void setInvolve_time(long involve_time) {
		this.involve_time = involve_time;
	}

	public long getRemove_time() {
		return remove_time;
	}

	public void setRemove_time(long remove_time) {
		this.remove_time = remove_time;
	}

	public int getWarn_signal_num() {
		return warn_signal_num;
	}

	public void setWarn_signal_num(int warn_signal_num) {
		this.warn_signal_num = warn_signal_num;
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
