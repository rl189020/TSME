package tsme.table.userDevice.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.userDevice.bean.USERDEVICE;

@Repository("userDeviceDAO")
public class UserDeviceDAOImpl extends TsmeMainDAOPracticeImpl<USERDEVICE> implements UserDeviceDAO{

}
