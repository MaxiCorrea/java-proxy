package infrastructure.proxy;

import application.port.SensitiveReportPort;
import domain.model.Role;
import domain.model.User;

public class AuthorizationProxy implements SensitiveReportPort {

	private final SensitiveReportPort port;
	private final User user;

	public AuthorizationProxy(
			final SensitiveReportPort port, 
			final User user) {
		this.port = port;
		this.user = user;
	}

	@Override
	public String getReport(
			final String subjectId) {
		if(!isAuthorized(user)) 
			throw new SecurityException("Access denied");
		return port.getReport(subjectId);
	}

	private boolean isAuthorized(User user) {
		return user.getRole() == Role.ADMIN || 
			   user.getRole() == Role.ANALYST;
	}

}
