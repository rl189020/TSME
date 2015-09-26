package tsme.table.analysis.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.analysis.bean.ANALYSIS;

@Repository("analysisDAO")
public class AnalysisDAOImpl extends TsmeMainDAOPracticeImpl<ANALYSIS> implements AnalysisDAO{

}
