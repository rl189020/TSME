package tsme.table.cellSignalFile.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @Date 201509022
 * @author lmq
 * 小区信息文件提交表
 */
public class CELLSIGNALFILE extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7200086631743285889L;

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
	 * 提交状态
	 */
	private String status;
	
	/**
	 * 信息文件是否已全部提交
	 */
	private boolean finish_flag;
	
	/**
	 * 文件提交时间
	 */
	private long submit_time;
	
	/**
	 * 提交类型：正常，异常类型1.2.3.
	 */
	private String type;
	
	/**
	 * 信息本地存储路径
	 */
	private String src;
	
	/**
	 * 文件是否已擦除
	 */
	private boolean erased;
	
	/**
	 * 上传完成时间
	 */
	private long finish_time;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isFinish_flag() {
		return finish_flag;
	}

	public void setFinish_flag(boolean finish_flag) {
		this.finish_flag = finish_flag;
	}

	public long getSubmit_time() {
		return submit_time;
	}

	public void setSubmit_time(long submit_time) {
		this.submit_time = submit_time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public boolean isErased() {
		return erased;
	}

	public void setErased(boolean erased) {
		this.erased = erased;
	}

	public long getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(long finish_time) {
		this.finish_time = finish_time;
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
