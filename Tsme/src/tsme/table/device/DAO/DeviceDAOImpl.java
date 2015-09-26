package tsme.table.device.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.device.bean.DEVICE;

@Repository("deviceDAO")
public class DeviceDAOImpl extends TsmeMainDAOPracticeImpl<DEVICE> implements DeviceDAO{

}
