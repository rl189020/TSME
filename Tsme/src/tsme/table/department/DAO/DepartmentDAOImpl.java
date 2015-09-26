package tsme.table.department.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.department.bean.DEPARTMENT;

@Repository("departmentDAO")
public class DepartmentDAOImpl extends TsmeMainDAOPracticeImpl<DEPARTMENT> implements DepartmentDAO{

}
