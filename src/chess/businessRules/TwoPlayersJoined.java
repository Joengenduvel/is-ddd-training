package chess.businessRules;

import chess.ChessPlayer;
import ddd.core.businessRules.BusinessRule;
import ddd.core.businessRules.BusinessRuleViolation;

import java.util.ArrayList;
import java.util.List;

public class TwoPlayersJoined extends BusinessRule {
    private final List<ChessPlayer> players;

    public TwoPlayersJoined(List<ChessPlayer> players) {
        this.players = players;
    }

    @Override
    public List<BusinessRuleViolation> CheckRule() {
        List<BusinessRuleViolation> rules = new ArrayList<>();
        if(players.size()!=2)
            rules.add(new NotAllPlayersJoined());
        return rules;
    }
}
