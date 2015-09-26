package tsme.table.cellTemplate.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 小区模板表，一级子表
 */
public class CELLTEMPLATE extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665007986413229152L;

	/**
	 * VARCHAR2(50 BYTE) 主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String id;
	
	/**
	 * VARCHAR2(50 BYTE) 外键，小区表主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String cell_id;
	
	/**
	 * VARCHAR2(50 BYTE) 外键，系统模板表主键
	 * 非空
	 */
	@NotEmpty
	@Length(max=50)
	private String template_id;
	
	/**
	 * 频点
	 */
	private String frequency_range;
	
	/**
	 * 信号类型：同频，临频1,2,3
	 */
	private String type;
	
	/**
	 * 电平值, 65dBm
	 */
	private int RxLev;
	
	/**
	 * 载干比，2dB
	 */
	private int C_I;
	
	/**
	 * 频率
	 */
	private int frequency;
	
	private long create_time;
	
	/**
	 * 广播控制信号道
	 */
	private String BCCH;
	
	/**
	 * 载频数
	 */
	private String TRX;
	
	/**
	 * 信元
	 */
	private String cell;
	
	/**
	 * 精度
	 */
	private String precision;
	
	/**
	 * 是否可见
	 */
	private boolean visible = true;
	
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

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getFrequency_range() {
		return frequency_range;
	}

	public void setFrequency_range(String frequency_range) {
		this.frequency_range = frequency_range;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRxLev() {
		return RxLev;
	}

	public void setRxLev(int rxLev) {
		RxLev = rxLev;
	}

	public int getC_I() {
		return C_I;
	}

	public void setC_I(int c_I) {
		C_I = c_I;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getBCCH() {
		return BCCH;
	}

	public void setBCCH(String bCCH) {
		BCCH = bCCH;
	}

	public String getTRX() {
		return TRX;
	}

	public void setTRX(String tRX) {
		TRX = tRX;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
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
