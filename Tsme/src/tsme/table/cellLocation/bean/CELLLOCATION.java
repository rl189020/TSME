package tsme.table.cellLocation.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import tsme.bean.mainBeanPractice.TsmeMainBeanPractice;
import tsme.bean.mainBeanPractice.TsmeMainBeanPracticeImpl;

/**
 * @date 20150922
 * @author lmq
 * 小区地理信息表
 */
public class CELLLOCATION extends TsmeMainBeanPracticeImpl implements TsmeMainBeanPractice{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5772703391061620143L;

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
	 * 国家
	 */
	private String country;
	
	/**
	 * 城市名
	 */
	private String city;
	
	/**
	 * 车站名称
	 */
	private String station;
	
	/**
	 * 线路名称
	 */
	private String line;
	
	/**
	 * 公里标
	 */
	private String km_stone;
	
	/**
	 * 经度
	 */
	private float LAT;
	
	/**
	 * 纬度
	 */
	private float LNG;
	
	/**
	 * 归属地
	 */
	private String location_show;
	
	/**
	 * 详细地址
	 */
	private String address;
	
	/**
	 * 小区名称
	 */
	private String community_name;
	
	/**
	 * 小区序号
	 */
	private String community_code;
	
	/**
	 * 全球小区识别码
	 */
	private String CI;
	
	/**
	 * 路由编码
	 */
	private String routing_code;
	
	private String create_time;
	
	/**
	 * 是否可见
	 */
	private boolean visible = true;
	
	/**
	 * 位置区域码，LAI=MCC+MNC+LAC
	 */
	private String LAI;
	
	/**
	 * 位置区号码
	 */
	private String LAC;
	
	/**
	 * 移动国家号
	 */
	private String MCC;
	
	/**
	 * 移动网络号
	 */
	private String MNC;
	
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getKm_stone() {
		return km_stone;
	}

	public void setKm_stone(String km_stone) {
		this.km_stone = km_stone;
	}

	public float getLAT() {
		return LAT;
	}

	public void setLAT(float lAT) {
		LAT = lAT;
	}

	public float getLNG() {
		return LNG;
	}

	public void setLNG(float lNG) {
		LNG = lNG;
	}

	public String getLocation_show() {
		return location_show;
	}

	public void setLocation_show(String location_show) {
		this.location_show = location_show;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCommunity_name() {
		return community_name;
	}

	public void setCommunity_name(String community_name) {
		this.community_name = community_name;
	}

	public String getCommunity_code() {
		return community_code;
	}

	public void setCommunity_code(String community_code) {
		this.community_code = community_code;
	}

	public String getCI() {
		return CI;
	}

	public void setCI(String cI) {
		CI = cI;
	}

	public String getRouting_code() {
		return routing_code;
	}

	public void setRouting_code(String routing_code) {
		this.routing_code = routing_code;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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
	
	public String getLAI() {
		return LAI;
	}

	public void setLAI(String lAI) {
		LAI = lAI;
	}

	public String getLAC() {
		return LAC;
	}

	public void setLAC(String lAC) {
		LAC = lAC;
	}

	public String getMCC() {
		return MCC;
	}

	public void setMCC(String mCC) {
		MCC = mCC;
	}

	public String getMNC() {
		return MNC;
	}

	public void setMNC(String mNC) {
		MNC = mNC;
	}
}
