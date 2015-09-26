package tsme.table.cell.DAO;
import org.junit.Test;

import tsme.table.cell.bean.CELL;


//ÔöÉ¾¸Ä²é
public class test {
	@Test
	public void db(){
		CELL cell = new CELL();
		long involve_time = System.currentTimeMillis();
		float radius = (float) 11100.1234;
		long remove_time = System.currentTimeMillis();
		cell.setInvolve_time(involve_time);
		cell.setRadius(radius);
		cell.setRemove_time(remove_time);
		CellDAOImpl cellDAO = new CellDAOImpl();
		cellDAO.save(cell);
	}
	
}