package tsme.table.realtimeMonitor.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.realtimeMonitor.bean.REALTIMEMONITOR;

@Repository("realtimeMonitorDAO")
public class RealtimeMonitorDAOImpl extends TsmeMainDAOPracticeImpl<REALTIMEMONITOR> implements RealtimeMonitorDAO{

}
