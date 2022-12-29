package sirdarey;

public class DTO <T>{
	
	int recordCount;
	T response;
	
	public DTO() {}

	public DTO(int recordCount, T response) {
		this.recordCount = recordCount;
		this.response = response;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}	
}
