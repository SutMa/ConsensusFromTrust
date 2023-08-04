import java.util.ArrayList;
import java.util.Set;

public class CompliantNode implements Node {

    private ArrayList<Transaction> proposalList;
    private boolean[] followees;
    private int finalRound;
    private int currentRound;
    private ArrayList<Transaction> consensusTransactions;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        this.finalRound = numRounds;
        this.currentRound = 0;
        this.proposalList = new ArrayList<>();
        this.consensusTransactions = new ArrayList<>();
    }

    @Override
    public void setFollowees(boolean[] followees) {
        this.followees = followees;
    }

    @Override
    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        this.proposalList.addAll(pendingTransactions);
    }

    @Override
    public Set<Transaction> sendToFollowers() {
        this.currentRound++;
        if (this.currentRound == this.finalRound) {
            return new Set<>(this.consensusTransactions);
        } else {
            return new Set<>(this.proposalList);
        }
    }

    @Override
    public void receiveFromFollowees(Set<Candidate> candidates) {
        for (Candidate candidate : candidates) {
            if (this.followees[candidate.sender] && !this.consensusTransactions.contains(candidate.tx)) {
                this.consensusTransactions.add(candidate.tx);
            }
        }
    }
}
