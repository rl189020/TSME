package tsme.table.bsStatistics.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.bsStatistics.bean.BSSTATISTICS;

@Repository("bsStatisticsDAO")
public class BsStatisticsDAOImpl extends TsmeMainDAOPracticeImpl<BSSTATISTICS> implements BsStatisticsDAO{

}
