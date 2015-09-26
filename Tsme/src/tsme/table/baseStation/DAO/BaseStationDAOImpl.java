package tsme.table.baseStation.DAO;

import org.springframework.stereotype.Repository;

import tsme.DAO.mainDAOPractice.TsmeMainDAOPracticeImpl;
import tsme.table.baseStation.bean.BASESTATION;

@Repository("baseStationDAO")
public class BaseStationDAOImpl extends TsmeMainDAOPracticeImpl<BASESTATION> implements BaseStationDAO{

}