package tsme.table.supervisor.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.supervisor.bean.SUPERVISOR;

@Repository("supervisorDAO")
public class SupervisorDAOImpl extends TsmeMainDAOPracticeImpl<SUPERVISOR> implements SupervisorDAO{

}
