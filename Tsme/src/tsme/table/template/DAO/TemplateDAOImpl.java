package tsme.table.template.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.template.bean.TEMPLATE;

@Repository("templateDAO")
public class TemplateDAOImpl extends TsmeMainDAOPracticeImpl<TEMPLATE> implements TemplateDAO{

}
