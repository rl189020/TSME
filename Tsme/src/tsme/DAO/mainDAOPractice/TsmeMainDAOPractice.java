package tsme.DAO.mainDAOPractice;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface TsmeMainDAOPractice<T>{
	/*保存实体方法*/
	public int save(T entity);
	public int[] batchSave(Collection<T> entityCollection);
	public boolean cascadedSave(T entity);
	public boolean cascadedBatchSave(Collection<T> entityCollection);
	
	//删除实体方法
	public int delete(T entity);
	public int deleteById(Serializable id);
	public int[] batchDelete(Collection<T> entityCollection);
	public boolean cascadedDeleteById(Serializable id);
	public boolean cascadedBatchDelete(Collection<T> entityCollection);
	
	//更新实体方法
	public int update(T entity);
	public int[] batchUpdate(Collection<T> entityCollection);
	public boolean cascadedUpdate(T entity);
	public boolean cascadedBatchUpdate(Collection<T> entityCollection);
	public boolean cascadedSetActiveById(Serializable id, boolean active);
	
	//查找实体方法
	public T findActivatedById(Serializable id);
	public T findInactivatedById(Serializable id);
	public T findBothById(Serializable id);
	public List<T> findAllActivated(Class<T> entityClass, Serializable order);
	public List<T> findAllInactivated(Class<T> entityClass, Serializable order);
	public List<T> findAll(Class<T> entityClass, Serializable order);
	public T cascadedQueryById(Serializable id, boolean active, short rank, Serializable order);
	public T cascadedQueryBothById(Serializable id, short rank, Serializable order);
	public List<?> findByQuery(String sql, Class<?> entityClass);
	public List<?> findByQueryForList(String sql, Class<?> elementType);
	public long getTotalItemsNumBySelectQuery(String sql);

	//自定义SQL操作
	public void executeBySql(String sql);
	
}