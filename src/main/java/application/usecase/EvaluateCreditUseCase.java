package application.usecase;

import domain.ports.CreditScorePort;

public class EvaluateCreditUseCase {

	private static final int MIN_APPROVED_SCORE = 700;
	
	private final CreditScorePort creditScorePort;
	
	public EvaluateCreditUseCase(
			final CreditScorePort creditScorePort) {
		this.creditScorePort = creditScorePort;
	}
	
	public boolean isCreditApproved(
			final String customerId) {
		int score = creditScorePort.getScore(customerId);
		return score >= MIN_APPROVED_SCORE;
	}
	
}
