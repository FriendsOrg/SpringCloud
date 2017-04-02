package tsk.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("outage")
public class OutageController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Value("${outage.message}")
	String message;
	
	@Value("${outage.id}")
	String outageId;
	
	@Value("${outage.plant.name}")
	String plantName;
	
	@Value("${outage.start.date}")
	String startDate;

	@Value("${outage.end.date}")
	String endDate;

	@RequestMapping("message")
	public String showOutageMessage() {
		return message;
	}
	
	@RequestMapping("details")
	public String getOutageDetail(){
		return "Outage #:" + outageId + "\nPlant Name : " + plantName + "\nStart Date: " + startDate + "\nEnd Date: " + endDate;
	}
	
	@RequestMapping("fetchOutageForTil")
	public String getOutageDetailForTil(@RequestParam("tilNum") String tilNum){
		return "Outage Detail for " +  tilNum + restTemplate.getForObject("http://til/details", String.class);
	}

}
