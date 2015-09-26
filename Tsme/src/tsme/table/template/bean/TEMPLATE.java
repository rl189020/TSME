package tsme.table.template.bean;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

public class TEMPLATE extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8312151979197669833L;
	
	private String id;
	
	private long create_time;
	
	private boolean visible = true;
	
	private String nsc_name;
	
	private String community_name;
	
	private String frequency_assign;
	
	private String cell_optional_para;
	
	private String quality_switch;
	
	private String rxlev_switch;
	
	private String power_budget_switch;
	
	private String element;
	
	private String value;
	
	private String introduction;

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
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

	public String getNsc_name() {
		return nsc_name;
	}

	public void setNsc_name(String nsc_name) {
		this.nsc_name = nsc_name;
	}

	public String getCommunity_name() {
		return community_name;
	}

	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}

	public String getFrequency_assign() {
		return frequency_assign;
	}

	public void setFrequency_assign(String frequency_assign) {
		this.frequency_assign = frequency_assign;
	}

	public String getCell_optional_para() {
		return cell_optional_para;
	}

	public void setCell_optional_para(String cell_optional_para) {
		this.cell_optional_para = cell_optional_para;
	}

	public String getQuality_switch() {
		return quality_switch;
	}

	public void setQuality_switch(String quality_switch) {
		this.quality_switch = quality_switch;
	}

	public String getRxlev_switch() {
		return rxlev_switch;
	}

	public void setRxlev_switch(String rxlev_switch) {
		this.rxlev_switch = rxlev_switch;
	}

	public String getPower_budget_switch() {
		return power_budget_switch;
	}

	public void setPower_budget_switch(String power_budget_switch) {
		this.power_budget_switch = power_budget_switch;
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

	public String getId() {
		return id;
	}
}
