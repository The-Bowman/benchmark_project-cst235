package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import beans.Verse;
import database.DataAccessInterface;

@Stateless
@Local(BibleServiceInterface.class)
@LocalBean
@Alternative
public class BibleService implements BibleServiceInterface {

	@Inject
	DataAccessInterface db;
	
	

	@Override
	public Verse findFirst(String word) {
		return db.findFirst(word);
	}


}
