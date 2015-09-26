package tsme.table.deviceLoginLog.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.deviceLoginLog.bean.DEVICELOGINLOG;

@Repository("deviceLoginLogDAO")
public class DeviceLoginLogDAOImpl extends TsmeMainDAOPracticeImpl<DEVICELOGINLOG> implements DeviceLoginLogDAO{

}
