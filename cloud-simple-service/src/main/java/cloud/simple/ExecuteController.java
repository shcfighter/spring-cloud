package cloud.simple;

import cloud.simple.bus.BusModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ExecuteController {

	@Resource
	private BusModel busModel;

	@GetMapping(value="/")
	public String execute(){
		System.out.println(busModel.getUser());
		return busModel.getUser();
	}
}
