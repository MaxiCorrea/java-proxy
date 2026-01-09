package infrastructure.adapter;

import java.util.HashMap;
import java.util.Map;

import domain.ports.CreditScorePort;

public class CachedCreditScoreProxy implements CreditScorePort {

	private final Map<String, Integer> cache;
	private final CreditScorePort creditScorePort;
	
	public CachedCreditScoreProxy(
			final CreditScorePort creditScorePort) {
		this.cache = new HashMap<>();
		this.creditScorePort = creditScorePort;
	}
	
	@Override
	public int getScore(
			final String customerId) {
		if(cache.containsKey(customerId))
			return cache.get(customerId);
		
		int score = this.creditScorePort.getScore(customerId);
		this.cache.put(customerId, score);
		return score;
	}

}
