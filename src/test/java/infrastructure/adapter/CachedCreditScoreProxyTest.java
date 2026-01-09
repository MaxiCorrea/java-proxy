package infrastructure.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import domain.ports.CreditScorePort;

class CachedCreditScoreProxyTest {

	@Test
	void shouldCallRealServicesOnlyOnceDueToCache() {
		CreditScorePort port = Mockito.mock(CreditScorePort.class);
		CreditScorePort proxy = new CachedCreditScoreProxy(port);
		Mockito.when(port.getScore("123")).thenReturn(720);
		int firstCall = proxy.getScore("123");
		int secondCall = proxy.getScore("123");
		assertEquals(720, firstCall);
		assertEquals(720, secondCall);
		verify(port, times(1)).getScore("123");
	}

}
