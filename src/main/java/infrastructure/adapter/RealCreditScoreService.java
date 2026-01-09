package infrastructure.adapter;

import java.time.Duration;

import domain.ports.CreditScorePort;

public class RealCreditScoreService implements CreditScorePort {

	@Override
	public int getScore(
			final String customerId) {
		simulateRemoteCall();
		return 750;
	}

	private void simulateRemoteCall() {
		try {
			Thread.sleep(Duration.ofMillis(500));
		} catch(InterruptedException ex) {}
	}

}
