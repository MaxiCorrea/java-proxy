package infrastructure.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import domain.model.Role;
import domain.model.User;
import domain.ports.SensitiveReportPort;

class AuthorizationProxyTest {

	@Test
	void shouldAllowAccessForAuthorizedUser() {
		User user = new User("user-1", Role.ADMIN);
		SensitiveReportPort real = mock(SensitiveReportPort.class);
		SensitiveReportPort proxy = new AuthorizationProxy(real, user);
		Mockito.when(real.getReport("123")).thenReturn("REPORT");
		String report = proxy.getReport("123");
		assertEquals("REPORT", report);
		verify(real).getReport("123");
	}

	@Test
	void shouldDenyAccessForUnauthorizedUser() {
		User user = new User("user-1", Role.AUDITOR);
		SensitiveReportPort real = mock(SensitiveReportPort.class);
		SensitiveReportPort proxy = new AuthorizationProxy(real, user);
		assertThrows(SecurityException.class, () -> {
			proxy.getReport("123");
		});
		verifyNoInteractions(real);
		
	}

}
