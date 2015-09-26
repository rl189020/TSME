package tsme.table.cellTemplate.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.cellTemplate.bean.CELLTEMPLATE;

@Repository("cellTemplateDAO")
public class CellTemplateDAOImpl extends TsmeMainDAOPracticeImpl<CELLTEMPLATE> implements CellTemplateDAO{

}
