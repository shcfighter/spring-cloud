package cloud.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecuteController {

	@GetMapping(value="/")
	public String execute(){
		return "ok";
	}
}
