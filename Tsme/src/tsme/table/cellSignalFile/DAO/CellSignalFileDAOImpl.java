package tsme.table.cellSignalFile.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.cellSignalFile.bean.CELLSIGNALFILE;

@Repository("cellSignalDAO")
public class CellSignalFileDAOImpl extends TsmeMainDAOPracticeImpl<CELLSIGNALFILE> implements CellSignalFileDAO{

}
