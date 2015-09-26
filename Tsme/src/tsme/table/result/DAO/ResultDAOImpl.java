package tsme.table.result.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.result.bean.RESULT;

@Repository("resultDAO")
public class ResultDAOImpl extends TsmeMainDAOPracticeImpl<RESULT> implements ResultDAO{

}
