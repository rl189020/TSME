package tsme.table.userRole.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.userRole.bean.USERROLE;

@Repository("userRoleDAO")
public class UserRoleDAOImpl extends TsmeMainDAOPracticeImpl<USERROLE> implements UserRoleDAO{

}
