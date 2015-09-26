package tsme.table.deviceStatistics.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.deviceStatistics.bean.DEVICESTATISTICS;

@Repository("deviceStatisticeDAO")
public class DeviceStatisticsDAOImpl extends TsmeMainDAOPracticeImpl<DEVICESTATISTICS> implements DeviceStatisticsDAO{

}
