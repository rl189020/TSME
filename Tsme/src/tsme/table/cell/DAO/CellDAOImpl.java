package tsme.table.cell.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.cell.bean.CELL;

@Repository("cellDAO")
public class CellDAOImpl extends TsmeMainDAOPracticeImpl<CELL> implements CellDAO{

}
