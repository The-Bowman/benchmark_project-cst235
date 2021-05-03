package business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import beans.Verse;

@RequestScoped
@Path("/verse")
@Produces("application/json")
@Consumes("application/json")
public class BibleWebService {

	@Inject
	BibleServiceInterface bible;

	
	
	@GET
	@Path("/getFirst")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFirst(@QueryParam("word") String word) {
		System.out.println("We have reached getFirst() in Web Service");
		Verse v = bible.findFirst(word);
		return v.getBook_name() + " " + v.getChapter() + ":" + v.getVerse();
	}
	
	
}
