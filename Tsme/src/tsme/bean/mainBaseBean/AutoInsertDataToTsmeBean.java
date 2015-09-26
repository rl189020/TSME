package tsme.bean.mainBaseBean;

import java.util.UUID;

public abstract class AutoInsertDataToTsmeBean implements TsmeMainBaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6570101322500238575L;

	/*
	 * 利用构造器初始化实现类，并为每个领域对象自动加载UUID
	 * */
	public AutoInsertDataToTsmeBean(){
		setId(UUID.randomUUID().toString());
	}
}
