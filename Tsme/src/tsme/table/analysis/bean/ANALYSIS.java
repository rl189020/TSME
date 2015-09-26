package tsme.table.analysis.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 设备分析结果表，二级子表
 */
public class ANALYSIS extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8972964572965671416L;
	
	/**
	 * VARCHAR2(50 BYTE) 唯一标识
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String id;
	
	/**
	 * VARCHAR2(50 BYTE) 外键，小区模板表主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String cellTemplate_id;
	
	/**
	 * VARCHAR2(50 BYTE) 外键，设备地理信息表主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String device_location_id;
	
	private long create_time;
	
	/**
	 * 分析结果存储路径
	 */
	private String src;
	
	/**
	 * 异常类型
	 */
	private String type;

	public String getCellTemplate_id() {
		return cellTemplate_id;
	}

	public void setCellTemplate_id(String cellTemplate_id) {
		this.cellTemplate_id = cellTemplate_id;
	}

	public String getDevice_location_id() {
		return device_location_id;
	}

	public void setDevice_location_id(String device_location_id) {
		this.device_location_id = device_location_id;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
}
