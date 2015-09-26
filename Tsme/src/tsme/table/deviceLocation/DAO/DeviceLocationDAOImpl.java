package tsme.table.deviceLocation.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.deviceLocation.bean.DEVICELOCATION;

@Repository("deviceLocationDAO")
public class DeviceLocationDAOImpl extends TsmeMainDAOPracticeImpl<DEVICELOCATION> implements DeviceLocationDAO{

}
