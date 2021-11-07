package lotto.model;

import java.util.List;

public class MatchResults {
  private final List<MatchResult> matchResults;

  public MatchResults(List<MatchResult> matchResults) {
    this.matchResults = matchResults;
  }

  public long getTotalWinningAmount() {
    long sum = 0;
    for (MatchResult matchResult : matchResults) {
      sum += ((long) matchResult.getMatchCount() * matchResult.getLottoRank().getMoney());
    }
    return sum;
  }

  public double calculateYield(PurchaseAmount purchaseAmount) {
    return purchaseAmount.calculateYield(getTotalWinningAmount());
  }

  public List<MatchResult> getMatchResults() {
    return matchResults;
  }
}
