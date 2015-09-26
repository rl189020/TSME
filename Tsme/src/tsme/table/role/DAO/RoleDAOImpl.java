package tsme.table.role.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.role.bean.ROLE;

@Repository("roleDAO")
public class RoleDAOImpl extends TsmeMainDAOPracticeImpl<ROLE> implements RoleDAO{

}
