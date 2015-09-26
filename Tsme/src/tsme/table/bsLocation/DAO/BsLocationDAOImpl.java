package tsme.table.bsLocation.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.bsLocation.bean.BSLOCATION;

@Repository("bsLocationdAO")
public class BsLocationDAOImpl extends TsmeMainDAOPracticeImpl<BSLOCATION> implements BsLocationDAO{

}
