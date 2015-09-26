package tsme.table.bsStatistics.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 2015922 
 * @author lmq
 * 基站信息统计表
 */
public class BSSTATISTICS extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1994221794939514743L;
	
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
	 * 是否可见
	 */
	private boolean visible;
	
	/**
	 * 被检测异常次数
	 */
	private int warn_signal_num;
	
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getWarn_signal_num() {
		return warn_signal_num;
	}

	public void setWarn_signal_num(int warn_signal_num) {
		this.warn_signal_num = warn_signal_num;
	}

	public String getId() {
		return id;
	}
}
