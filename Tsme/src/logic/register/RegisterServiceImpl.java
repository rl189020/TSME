package logic.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tsme.table.supervisor.DAO.SupervisorDAO;
import tsme.table.supervisor.bean.SUPERVISOR;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	@Qualifier("supervisorDAO")
	private SupervisorDAO supervisorDAO;
	
	@Override
	public int save(SUPERVISOR su) {
		// TODO Auto-generated method stub
		supervisorDAO.save(su);
		return 0;
	}

}
