package tsme.table.parameter.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.parameter.bean.PARAMETER;

@Repository("parameterDAO")
public class ParamerterDAOImpl extends TsmeMainDAOPracticeImpl<PARAMETER> implements ParameterDAO{

}
