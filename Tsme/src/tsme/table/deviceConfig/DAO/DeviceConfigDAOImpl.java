package tsme.table.deviceConfig.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.deviceConfig.bean.DEVICECONFIG;

@Repository("deviceConfigDAO")
public class DeviceConfigDAOImpl extends TsmeMainDAOPracticeImpl<DEVICECONFIG> implements DeviceConfigDAO{

}
