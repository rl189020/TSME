package tsme.table.deviceCOP.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.deviceCOP.bean.DEVICECOP;

@Repository("deviceCOPDAO")
public class DeviceCOPDAOImpl extends TsmeMainDAOPracticeImpl<DEVICECOP> implements DeviceCOPDAO{

}
