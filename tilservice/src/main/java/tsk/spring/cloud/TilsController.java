package tsk.spring.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("til")
public class TilsController {
	
	@Value("${til.message}")
    private String message;
	
	@Value ("${til.number}")
	private String tilNumber;
	
	@Value ("${til.disposition.status}")
	private String dispositionStatus;
	
	@Value ("${til.disposition.notes}")
	private String dispositionNotes;


    @RequestMapping("message")
	public String showTilMessage() {
		return message;
	}
    
    @RequestMapping("details")
    public String getTilDetail(){
    	return "Til #:" + tilNumber + "\nDisposition Status : " + dispositionStatus + "\nDisposition Notes: " + dispositionNotes;
    }
    
    @RequestMapping("fetchTilForOutage")
    public String getTilDetailForOutage(@RequestParam("outageId") String outageId){
    	return "Til Detail for " + outageId + "Til #:" + tilNumber + "\nDisposition Status : " + dispositionStatus + "\nDisposition Notes: " + dispositionNotes;
    }

}