package tsme.table.bsCOP.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.bsCOP.bean.BSCOP;

@Repository("bsCOPDAO")
public class BsCOPDAOImpl extends TsmeMainDAOPracticeImpl<BSCOP> implements BsCOPDAO{

}
