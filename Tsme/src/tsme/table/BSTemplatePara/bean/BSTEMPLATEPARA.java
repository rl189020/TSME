package tsme.table.BSTemplatePara.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 基站监测参数表，基站一级子表
 */
public class BSTEMPLATEPARA extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9153377950580155823L;

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
	
	/**
	 * 参数名称
	 */
	private String element;
	
	/**
	 * 参数值
	 */
	private String value;
	
	/**
	 * 参数简介
	 */
	private String introduction;
	
	private long create_time;
	
	private boolean visible = true;
	
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

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getId() {
		return id;
	}
}
