package tsme.table.department.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 部门信息表
 */
public class DEPARTMENT extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

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
	
	private long create_time;
	
	/**
	 * 部门名称
	 */
	private String name;
	
	/**
	 * 部门编码
	 */
	private String deptno;
	
	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
}
