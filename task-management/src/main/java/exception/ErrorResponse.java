package exception;

import java.util.List;

public class ErrorResponse {

	private List<Error> error;
	
	public ErrorResponse(List<Error> errors) {
		this.error = errors;
	}

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}
	
	
}
