package database;

import javax.ejb.Local;
import beans.Verse;

@Local
public interface DataAccessInterface {



	public Verse findFirst(String term);

}
