package tsme.table.cellLocation.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.cellLocation.bean.CELLLOCATION;

@Repository("cellLocationDAO")
public class CellLocationDAOImpl extends TsmeMainDAOPracticeImpl<CELLLOCATION> implements CellLocationDAO{

}
