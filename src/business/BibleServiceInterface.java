package business;

import javax.ejb.Local;
import beans.Verse;

@Local
public interface BibleServiceInterface {

	public Verse findFirst(String word);

}
