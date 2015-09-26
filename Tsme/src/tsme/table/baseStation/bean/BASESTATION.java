package tsme.table.baseStation.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 2010922
 * @author lmq
 * 基站信息表，一级子表
 */
public class BASESTATION extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9013425786867550830L;
	
	/**
	 * VARCHAR2(50 BYTE) 主键
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
	private String cell_id;
	
	private long create_time;
	
	/**
	 * 基站简介
	 */
	private String introduction;
	
	/**
	 * 是否可见
	 */
	private boolean visible = true;
	
	/**
	 * 基站名称
	 */
	private String name;
	
	/**
	 * 基站站型
	 */
	private String model;
	
	/**
	 * 扫描半径
	 */
	private float radius;
	
	/**
	 * 基站识别码
	 */
	private String BSIC;

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getCell_id() {
		return cell_id;
	}

	public void setCell_id(String cell_id) {
		this.cell_id = cell_id;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public String getBSIC() {
		return BSIC;
	}

	public void setBSIC(String bSIC) {
		BSIC = bSIC;
	}
}

