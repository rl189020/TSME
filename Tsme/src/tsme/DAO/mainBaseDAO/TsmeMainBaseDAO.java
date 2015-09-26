package tsme.DAO.mainBaseDAO;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import utils.GenericsUtils;


public class TsmeMainBaseDAO<T>{
	
	//获取实体对象类型
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public TsmeMainBaseDAO() {
		entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	}
	
	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("namedParameterJdbcTemplate")
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/**
	 * 保存实体方法。
	 * 包含四个方法。
	 * 保存单个实体：public int save(T entity)；
	 * 批量保存实体：public int[] batchSave(Collection<T> entityCollection)；
	 * 级联保存单个实体：public boolean cascadedSave(T entity);
	 * 级联批量保存实体：public boolean cascadedBatchSave(Collection<T> entityCollection)；
	 **/
	@SuppressWarnings("rawtypes")
	public int save(T entity) {	
		StringBuffer sql = new StringBuffer("INSERT INTO " + entityClass.getSimpleName() + " (");
		StringBuffer sql1 = new StringBuffer("VALUES (");
		Field[] fields = entityClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + ", ");
					sql1.append(":" + fieldName + ", ");
			}
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), ") ");
		sql1.replace(sql1.lastIndexOf(","), sql1.length(), ")");
		sql.append(sql1);
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		
		return namedParameterJdbcTemplate.update(sql.toString(), sps);
		/*
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplateContent);	
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		
		return insertActor.withTableName(entityClass.getSimpleName()).execute(sps);
		*/
	}
	
	@SuppressWarnings("rawtypes")
	public int[] batchSave(Collection<T> entityCollection){
		StringBuffer sql = new StringBuffer("INSERT INTO " + entityClass.getSimpleName() + " (");
		StringBuffer sql1 = new StringBuffer("VALUES (");
		Field[] fields = entityClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + ", ");
					sql1.append(":" + fieldName + ", ");
			}
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), ") ");
		sql1.replace(sql1.lastIndexOf(","), sql1.length(), ")");
		sql.append(sql1);
		
		SqlParameterSource[] batchSPS = SqlParameterSourceUtils.createBatch(entityCollection.toArray());   
		
		return namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchSPS);
		/*
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplateContent);
		SqlParameterSource[] batchSPS = SqlParameterSourceUtils.createBatch(entityCollection.toArray());
	
		return insertActor.withTableName(entityClass.getSimpleName()).executeBatch(batchSPS);
		*/
	}
	
	@SuppressWarnings("rawtypes")
	private int[] batchSaveEntity(List<Object> entityList){
		StringBuffer sql = new StringBuffer("INSERT INTO " + entityList.get(0).getClass().getSimpleName() + " (");
		StringBuffer sql1 = new StringBuffer("VALUES (");
		Field[] fields = entityList.get(0).getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + ", ");
					sql1.append(":" + fieldName + ", ");
			}
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), ") ");
		sql1.replace(sql1.lastIndexOf(","), sql1.length(), ")");
		sql.append(sql1);
		
		SqlParameterSource[] batchSPS = SqlParameterSourceUtils.createBatch(entityList.toArray());   
		
		return namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchSPS);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Object> saveIterator(List<Object> objList){
		List<Object> tempList = new Vector<Object>();
		for(Object obj : objList){
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields){
				if(field.getType().equals(List.class)){
					String methodName = "get" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
					try {
						List temp = (List) obj.getClass().getMethod(methodName).invoke(obj);
						if(!temp.isEmpty()){
							batchSaveEntity(temp);
							tempList.addAll(temp);
						}	
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return tempList;
	}
	
	public boolean cascadedSave(T entity){
		save(entity);
		List<Object> objList = new Vector<Object>();
		objList.add(entity);
		boolean flag = true;
		while(flag == true){
			objList = saveIterator(objList);
			if(!objList.isEmpty()){
				flag = true;
			}	
			else 
				flag = false;
		}
		return true;
	}
	
	
	public boolean cascadedBatchSave(Collection<T> entityCollection){
		batchSave(entityCollection);
		List<Object> objList = new Vector<Object>();
		objList.addAll(entityCollection);
		boolean flag = true;
		while(flag == true){
			objList = saveIterator(objList);
			if(!objList.isEmpty()){
				flag = true;
			}	
			else 
				flag = false;
		}
		return true;
	}
	
	
	/**
	 * 删除实体方法。
	 * 包含五个方法。
	 * 删除单个实体：public int delete(T entity);
	 * 按照id删除单个实体：public int deleteById(Serializable id);
	 * 批量删除实体：public int[] batchDelete(Collection<T> entityCollection);
	 * 按照id级联删除单个实体：public boolean cascadedDeleteById(Serializable id);
	 * 级联批量删除实体：public boolean cascadedBatchDelete(Collection<T> entityCollection);
	 **/
	public int delete(T entity){
		String sql = "DELETE FROM " + entityClass.getSimpleName() + " WHERE id = :id";
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		
		return namedParameterJdbcTemplate.update(sql, sps);
	}
	
	public int deleteById(Serializable id){
		String sql = "DELETE FROM " + entityClass.getSimpleName() + " WHERE id = ?";
		
		return jdbcTemplate.update(sql, id);
	}
	
	public int[] batchDelete(Collection<T> entityCollection){
		String sql = "DELETE FROM " + entityClass.getSimpleName() + " WHERE id = :id";
		SqlParameterSource[] batchSPS = SqlParameterSourceUtils.createBatch(entityCollection.toArray());
	
		return namedParameterJdbcTemplate.batchUpdate(sql, batchSPS);
	}
	
	@SuppressWarnings("unused")
	private class StackItem{
		private String id;
		private String entityName;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getEntityName() {
			return entityName;
		}
		public void setEntityName(String entityName) {
			this.entityName = entityName;
		}
	}
	
	private int deleteEntityByIdAndName(Serializable id, Serializable entityName){
		String sql = "DELETE FROM " + entityName + " WHERE id = :id";
		return jdbcTemplate.update(sql, id);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Object> iterator(List<Object> objList, Stack stack){
		List<Object> tempList = new Vector<Object>();
		for(Object obj : objList){
			StackItem stackItem = new StackItem();
			/*主表id即为子表外键，先通过对象得到对象类名，再通过类名查找类中定义的方法，得到对象中存储的id*/
			String foreignId = null;
			try {
				foreignId = (String) obj.getClass().getMethod("getId").invoke(obj);
				stackItem.id = foreignId;
				stackItem.entityName = obj.getClass().getSimpleName();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/*通过主表的领域值查找子表名，并查询子表内容*/
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields){
				if(field.getType().equals(List.class)){
					String childTableName = GenericsUtils.getFieldGenericType(field).getSimpleName();//装配子表名称
					String sql = "SELECT * FROM " + childTableName + " WHERE " + obj.getClass().getSimpleName() + "_id ='" + foreignId + "'";	
					List list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(GenericsUtils.getFieldGenericType(field)));//获得子表列表
					if(!list.isEmpty())
						tempList.addAll(list);
				}
			}
			stack.push(stackItem);
		}
		return tempList;	
	}
	
	public boolean cascadedDeleteById(Serializable id){
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE id =?";
		Object obj = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(entityClass), id);	
		List<Object> objList = new Vector<Object>();
		objList.add(obj);
		Stack<StackItem> stack = new Stack<StackItem>();

		boolean flag = true;
		while(flag == true){
			objList = iterator(objList, stack);
			if(!objList.isEmpty()){
				flag = true;
			}	
			else 
				flag = false;
		}
		while(!stack.isEmpty()){
			StackItem stackItem = stack.pop();
			deleteEntityByIdAndName(stackItem.getId(), stackItem.getEntityName());
		}
		return true;
	}
	
	
	public boolean cascadedBatchDelete(Collection<T> entityCollection){
		List<Object> objList = new Vector<Object>();
		objList.addAll(entityCollection);
		Stack<StackItem> stack = new Stack<StackItem>();

		boolean flag = true;
		while(flag == true){
			objList = iterator(objList, stack);
			if(!objList.isEmpty()){
				flag = true;
			}	
			else 
				flag = false;
		}
		while(!stack.isEmpty()){
			StackItem stackItem = stack.pop();
			deleteEntityByIdAndName(stackItem.getId(), stackItem.getEntityName());
		}
		return true;
	}
	
	/**
	 * 更新实体方法。
	 * 包含五个方法。
	 * 更新单个实体：public int update(T entity);
	 * 批量更新实体：public int[] batchUpdate(Collection<T> entityCollection);
	 * 级联更新单个实体：public boolean cascadedUpdate(T entity);
	 * 级联批量更新实体：public boolean cascadedBatchUpdate(Collection<T> entityCollection);
	 * 按照id级联设置active属性：public boolean cascadedSetActiveById(Serializable id, boolean active);
	 **/
	@SuppressWarnings("rawtypes")
	public int update(T entity) {
		StringBuffer sql = new StringBuffer("UPDATE " + entityClass.getSimpleName() + " SET ");
		Field[] fields = entityClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("id") &&
				!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + " = :" + fieldName + ",");
			}
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		sql.append(" WHERE id = :id");
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		
		return namedParameterJdbcTemplate.update(sql.toString(), sps);
	}
	
	
	@SuppressWarnings("rawtypes")
	public int[] batchUpdate(Collection<T> entityCollection){
		StringBuffer sql = new StringBuffer("UPDATE " + entityClass.getSimpleName() + " SET ");
		Field[] fields = entityClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("id") &&
				!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + " = :" + fieldName + ",");
			}
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		sql.append(" WHERE id = :id");
		
		SqlParameterSource[] batchSPS = SqlParameterSourceUtils.createBatch(entityCollection.toArray());   
		
		return namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchSPS);
	}
	
	
	@SuppressWarnings("rawtypes")
	private int[] batchUpdateEntity(List<Object> entityList){
		StringBuffer sql = new StringBuffer("UPDATE " + entityList.get(0).getClass().getSimpleName() + " SET ");
		Field[] fields = entityList.get(0).getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("id") &&
				!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + " = :" + fieldName + ",");
			}
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		sql.append(" WHERE id = :id");
		
		SqlParameterSource[] batchSPS = SqlParameterSourceUtils.createBatch(entityList.toArray());   
		
		return namedParameterJdbcTemplate.batchUpdate(sql.toString(), batchSPS);	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Object> updateIterator(List<Object> objList){
		List<Object> tempList = new Vector<Object>();
		for(Object obj : objList){
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields){
				if(field.getType().equals(List.class)){
					String methodName = "get" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
					try {
						List temp = (List) obj.getClass().getMethod(methodName).invoke(obj);
						if(!temp.isEmpty()){
							batchUpdateEntity(temp);
							tempList.addAll(temp);
						}	
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return tempList;
	}
	
	public boolean cascadedUpdate(T entity){
		update(entity);
		List<Object> objList = new Vector<Object>();
		objList.add(entity);
		boolean flag = true;
		while(flag == true){
			objList = updateIterator(objList);
			if(!objList.isEmpty()){
				flag = true;
			}	
			else 
				flag = false;
		}
		return true;
	}
	

	public boolean cascadedBatchUpdate(Collection<T> entityCollection){
		batchUpdate(entityCollection);
		List<Object> objList = new Vector<Object>();
		objList.addAll(entityCollection);
		boolean flag = true;
		while(flag == true){
			objList = updateIterator(objList);
			if(!objList.isEmpty()){
				flag = true;
			}	
			else 
				flag = false;
		}
		return true;
	}
	
	
	@SuppressWarnings("rawtypes")
	private int updateEntity(Object entity){
		
		StringBuffer sql = new StringBuffer("UPDATE " + entity.getClass().getSimpleName() + " SET ");
		Field[] fields = entity.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++){
			Field field = fields[i];
			String fieldName = field.getName();
			Class fieldType = field.getType();
			if (!fieldName.equalsIgnoreCase("id") &&
				!fieldName.equalsIgnoreCase("serialVersionUID") &&
				!fieldType.equals(Collections.class) &&
				!fieldType.equals(Map.class) &&
				!fieldType.equals(List.class) &&
				!fieldType.equals(Set.class)){
					sql.append(fieldName + " = :" + fieldName + ",");
			}
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		sql.append(" WHERE id = :id");
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		return namedParameterJdbcTemplate.update(sql.toString(), sps);
		
	}
	
	@SuppressWarnings({"rawtypes", "unchecked" })
	private List<Object> iterator(List<Object> objList, boolean active){
		List<Object> tempList = new Vector<Object>();
		for(Object obj : objList){
			try {
				obj.getClass().getMethod("setActive", boolean.class).invoke(obj, active);
				updateEntity(obj);
			} catch (IllegalAccessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IllegalArgumentException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (InvocationTargetException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (NoSuchMethodException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SecurityException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			/*主表id即为子表外键，先通过对象得到对象类名，再通过类名查找类中定义的方法，得到对象中存储的id*/
			String foreignId = null;
			try {
				foreignId = (String) obj.getClass().getMethod("getId").invoke(obj);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/*通过主表的领域值查找子表名，并查询子表内容*/
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields){
				if(field.getType().equals(List.class)){
					String childTableName = GenericsUtils.getFieldGenericType(field).getSimpleName();//装配子表名称
					String sql2 = "SELECT * FROM " + childTableName + " WHERE " + obj.getClass().getSimpleName() + "_id ='" + foreignId + "'";	
					List list = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(GenericsUtils.getFieldGenericType(field)));//获得子表列表
					if(!list.isEmpty())
						tempList.addAll(list);
				}
			}
		}
		return tempList;	
	}
	
	public boolean cascadedSetActiveById(Serializable id, boolean active){
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE id =?";
		Object obj = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(entityClass), id);	
		List<Object> objList = new Vector<Object>();
		objList.add(obj);
		boolean flag = true;
		while(flag == true){
			objList = iterator(objList, active);
			if(!objList.isEmpty())
				flag = true;
			else 
				flag = false;
		}
		return true;//任何情况下都返回true这一点有待改进
	}	
	
	/*
	public int activate(T entity) {
		StringBuffer sql = new StringBuffer("UPDATE " + entityClass.getSimpleName() + " SET ");	
		sql.append("active = :active");
		sql.append(" WHERE id = :id");
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		MapSqlParameterSource msps = new MapSqlParameterSource().addValue("active", true).addValue("id", sps.getValue("id"));
		
		return namedParameterJdbcTemplateContent.update(sql.toString(), msps);
	}
	
	
	public int inactivate(T entity) {
		StringBuffer sql = new StringBuffer("UPDATE " + entityClass.getSimpleName() + " SET ");	
		sql.append("active = :active");
		sql.append(" WHERE id = :id");
		SqlParameterSource sps = new BeanPropertySqlParameterSource(entity);
		MapSqlParameterSource msps = new MapSqlParameterSource().addValue("active", false).addValue("id", sps.getValue("id"));
		return namedParameterJdbcTemplateContent.update(sql.toString(), msps);
	}
	*/
	/**
	 * 查找实体方法。
	 * 包含九个方法。
	 * 通过id查找active属性为1的实体：public T findActivatedById(Serializable id);
	 * 通过id查找active属性为0的实体：public T findInactivatedById(Serializable id);
	 * 通过id查找实体：public T findBothById(Serializable id);
	 * 查找所有active属性为1的实体：public List<T> findAllActivated(Class<T> entityClass, String order);
	 * 查找所有active属性为0的实体：public List<T> findAllInactivated(Class<T> entityClass, String order);
	 * 查找所有实体：public List<T> findAll(Class<T> entityClass, String order);
	 * 按照查询语句查找列族：public List<?> findByQueryForList(String sql, Class<?> elementType);
	 * 按照查询语句查找表族：public List<?> findByQuery(String sql, Class<?> entityClass);
	 * 按照id、active属性和级数级联查询实体：public T cascadedQueryById(Serializable id, boolean active, short rank, String order); 
	 **/
	public T findActivatedById(Serializable id) {
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE active=1 AND id=?";
 
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(entityClass), id);
	}
	
	
	public T findInactivatedById(Serializable id) {
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE active=0 AND id=?";  
		
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(entityClass), id);
	}
	
	
	public T findBothById(Serializable id) {
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE id=?";   
		
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(entityClass), id);
	}
	
	
	public List<T> findAllActivated(Class<T> entityClass, Serializable order){
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE active=1 ORDER BY create_time " + order;   
		
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(entityClass));
	}
	
	public List<T> findAllInactivated(Class<T> entityClass, Serializable order){
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE active=0 ORDER BY create_time " + order;   
		
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(entityClass));
	}
	
	public List<T> findAll(Class<T> entityClass, Serializable order){
		String sql = "SELECT * FROM " + entityClass.getSimpleName() + " ORDER BY create_time " + order;  
		
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(entityClass));
	}
	
	public List<?> findByQuery(String sql, Class<?> entityClass){
		
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(entityClass));
	}
	
	public List<?> findByQueryForList(String sql, Class<?> elementType){
		
		return jdbcTemplate.queryForList(sql, elementType);
	}
	
	//获取数据总条目
	public long getTotalItemsNumBySelectQuery(String sql){
		String[] temp = sql.split(" ");
		
		long totalNum = 0;
		
		if(temp[0].equalsIgnoreCase("SELECT")){
			//拼凑数据条目查询语句
			String countSql = "SELECT COUNT(1)";
			int k = 0;
			for(int i = 2; i < temp.length; i++){
				if(temp[i].equalsIgnoreCase("FROM")){
					k = i;
					break;
				}
			}
			for(int i = k; i < temp.length; i++){
				countSql = countSql + " " + temp[i];
			}
			//计算符合条件的总数据条目数
			totalNum = jdbcTemplate.queryForLong(countSql);
		}
		
		return totalNum;
	}
	
	//以ROWID为依据分块查询，返回选定表族
	/*	@SuppressWarnings("unchecked")
	public boolean pagingFindBySelectQueryAndSortByRowidForSingleTable(String sql, Class<?> entityClass, PageView<T> pageView, Serializable colToSort, Serializable order){
		String[] temp = sql.split(" ");
		
		long startNum = pageView.getStartNum() - 1;
		long finishNum = pageView.getFinishNum() + 1;
		
		if(temp[0].equalsIgnoreCase("SELECT") && pageView.getTotalNum() != 0){
			//拼凑分页查询语句
			int k = 0;
			for(int i = 2; i < temp.length; i++){
				if(temp[i].equalsIgnoreCase("FROM")){
					k = i;
					break;
				}
			}			
			
			String querySql = "SELECT ROWID rd," + colToSort;
			for(int i = k; i < temp.length; i++){
				querySql = querySql + " " + temp[i];
			}
			
			querySql = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE ROWID IN " + 
							"(" + "SELECT rd FROM " + 
								"(" + "SELECT ROWNUM rn,rd FROM " + 
									"(" +
										querySql +
									") " +
									"WHERE ROWNUM<" + finishNum +
								") " + "WHERE rn>" + startNum +
							") " + 
						"ORDER BY " + colToSort + " " + order;
			
			List<?> items = jdbcTemplateContent.query(querySql, BeanPropertyRowMapper.newInstance(entityClass));
			pageView.setItems((List<T>) items);
			
			return true;
		}
		else
			return false;
	}*/
	
	//以ROWNUM为依据分块查询，返回选定表族
	/*@SuppressWarnings("unchecked")
	public boolean pagingFindBySelectQueryAndSortByRownumForSingleTable(String sql, Class<?> entityClass, PageView<T> pageView){
		String[] temp = sql.split(" ");
		
		long startNum = pageView.getStartNum() - 1;
		long finishNum = pageView.getFinishNum() + 1;
		
		if(temp[0].equalsIgnoreCase("SELECT") && pageView.getTotalNum() != 0){
			//拼凑分页查询语句
			String querySql = sql;
			
			querySql = "SELECT * FROM " +
							"(" + "SELECT t.*,rownum rn FROM " + 
								"(" + 
									querySql +
								") " + "t WHERE rownum<" + finishNum +
							") " +
						"WHERE rn>" + startNum;

			List<?> items = jdbcTemplateContent.query(querySql, BeanPropertyRowMapper.newInstance(entityClass));
			pageView.setItems((List<T>) items);
			
			return true;
		}
		else
			return false;
	}*/
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private List<Object> iteratorQuery(List<Object> objList, short active, Serializable order){
		List<Object> tempList = new Vector<Object>();
		for(Object obj : objList){		
			/*主表id即为子表外键，先通过对象得到对象类名，再通过类名查找类中定义的方法，得到对象中存储的id*/
			Class fatherClazz = obj.getClass();
			String foreignId = null;
			try {
				foreignId = (String) fatherClazz.getMethod("getId").invoke(obj);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/*通过主表的领域值查找子表名，并查询子表内容*/
			Field[] fields = fatherClazz.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().equals(List.class)){
					String childTableName = GenericsUtils.getFieldGenericType(field).getSimpleName();//装配子表名称
					String sql2 = "SELECT * FROM " + childTableName + " WHERE active = " + active + " AND " + fatherClazz.getSimpleName() + "_id ='" + foreignId + "' ORDER BY create_time " + order; 	
					List list = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(GenericsUtils.getFieldGenericType(field)));//获得子表列表
					
					if(!list.isEmpty()){
						/*通过方法名称查询方法并用查询到的方法恢复子属性值*/
						String methodName = "set" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
						try {
							fatherClazz.getMethod(methodName,List.class).invoke(obj, list);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						methodName = "get" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
						try {
							tempList.addAll((List<Object>) fatherClazz.getMethod(methodName).invoke(obj));
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
								e.printStackTrace();
						}
					}
				}
			}
		}
		return tempList;
	}
	
	@SuppressWarnings("unchecked")
	public T cascadedQueryById(Serializable id, boolean active, short rank, Serializable order){
		short temp = 0;
		if(active == true)
			temp = 1;
			
		String sql1 = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE active =" + temp + " AND id =?";
		Object result = jdbcTemplate.queryForObject(sql1, BeanPropertyRowMapper.newInstance(entityClass), id);
		List<Object> objList = new Vector<Object>();
		objList.add(result);
		
		for(short i = 1; i <= rank; i ++){
			objList = iteratorQuery(objList, temp, order);
		}
		return (T)result;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private List<Object> iteratorQuery(List<Object> objList, Serializable order){
		List<Object> tempList = new Vector<Object>();
		for(Object obj : objList){		
			/*主表id即为子表外键，先通过对象得到对象类名，再通过类名查找类中定义的方法，得到对象中存储的id*/
			Class fatherClazz = obj.getClass();
			String foreignId = null;
			try {
				foreignId = (String) fatherClazz.getMethod("getId").invoke(obj);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			/*通过主表的领域值查找子表名，并查询子表内容*/
			Field[] fields = fatherClazz.getDeclaredFields();
			for(Field field : fields){
				if(field.getType().equals(List.class)){
					String childTableName = GenericsUtils.getFieldGenericType(field).getSimpleName();//装配子表名称
					String sql2 = "SELECT * FROM " + childTableName + " WHERE " + fatherClazz.getSimpleName() + "_id = '" + foreignId + "' ORDER BY create_time " + order;	
					List list = jdbcTemplate.query(sql2, BeanPropertyRowMapper.newInstance(GenericsUtils.getFieldGenericType(field)));//获得子表列表
					
					if(!list.isEmpty()){
						/*通过方法名称查询方法并用查询到的方法恢复子属性值*/
						String methodName = "set" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
						try {
							fatherClazz.getMethod(methodName,List.class).invoke(obj, list);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						methodName = "get" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
						try {
							tempList.addAll((List<Object>) fatherClazz.getMethod(methodName).invoke(obj));
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
								e.printStackTrace();
						}
					}
				}
			}
		}
		return tempList;
	}
	
	@SuppressWarnings("unchecked")
	public T cascadedQueryBothById(Serializable id, short rank, Serializable order){
		String sql1 = "SELECT * FROM " + entityClass.getSimpleName() + " WHERE id = ?";
		Object result = jdbcTemplate.queryForObject(sql1, BeanPropertyRowMapper.newInstance(entityClass), id);
		List<Object> objList = new Vector<Object>();
		objList.add(result);
		
		for(short i = 1; i <= rank; i ++){
			objList = iteratorQuery(objList, order);
		}
		return (T)result;
	}
	
	/*
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private Map<Serializable, Class> iterator(Map<Serializable, Class> classMap, Object obj){
		
		Map<Serializable, Class> childClassMap = new HashMap<Serializable, Class>();
		
		for(Map.Entry<Serializable, Class> entry : classMap.entrySet()){		
			/*主表id即为子表外键
			String foreignId = entry.getKey().toString();
			Class fatherClazz = entry.getValue();
			
			fatherClazz = obj.getClass();
			
			/*通过主表的领域值查找子表名，并查询子表内容
			Field[] fields = fatherClazz.getDeclaredFields();
			for(Field field : fields){
				
				if(field.getType().equals(List.class)){
					String childTableName = GenericsUtils.getFieldGenericType(field).getSimpleName();//装配子表名称
					String sql2 = "SELECT * FROM " + childTableName + " WHERE active = 1 AND " + fatherClazz.getSimpleName() + "_id ='" + foreignId + "'";	
					List list = jdbcTemplateContent.query(sql2, BeanPropertyRowMapper.newInstance(GenericsUtils.getFieldGenericType(field)));//获得子表列表
					
					/*通过方法名称查询方法并用查询到的方法恢复子属性值
					String methodName = "set" + (char)(field.getName().charAt(0)-32) + field.getName().substring(1);//装配方法名称
					try {
						fatherClazz.getMethod(methodName,List.class).invoke(obj, list);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					for(Object obj1 : list){
						try {
							childClassMap.put((Serializable)obj1.getClass().getMethod("getId").invoke(obj1), obj1.getClass());
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					
					}
					System.out.println(list);
				}
			}
		}
		return childClassMap;
	}*/
	
	public void executeBySql(String sql){
		jdbcTemplate.execute(sql);
	}
}
