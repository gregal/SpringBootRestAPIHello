package restapists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ArtigoNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ArtigoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(ArtigoNotFoundException ex) {
//		return "{errorMessage: \"" + ex.getMessage() + "\"}";
		return ex.getMessage();
	}
}