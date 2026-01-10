package infrastructure.report;

import domain.ports.SensitiveReportPort;

public class RealSensitiveReport implements SensitiveReportPort {

	@Override
	public String getReport(
			final String subjectId) {
		return "FULL_SENSITIVE_REPORT";
	}

}
