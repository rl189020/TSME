package tsme.table.deviceSignal.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.deviceSignal.bean.DEVICESIGNAL;

@Repository("deviceSignalDAO")
public class DeviceSignalDAOImpl extends TsmeMainDAOPracticeImpl<DEVICESIGNAL> implements DeviceSignalDAO{

}
