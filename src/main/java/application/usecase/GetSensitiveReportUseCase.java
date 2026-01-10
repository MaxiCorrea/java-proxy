package application.usecase;

import domain.ports.SensitiveReportPort;

public class GetSensitiveReportUseCase {

	private final SensitiveReportPort port;
	
	public GetSensitiveReportUseCase(
			final SensitiveReportPort port) {
		this.port = port;
	}
	
	public String execute(
			final String subjectId) {
		return port.getReport(subjectId);
	}
	
}
