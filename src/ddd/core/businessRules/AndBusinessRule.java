package ddd.core.businessRules;


import chess.businessRules.PieceNotPresentAtPosition;

import java.util.ArrayList;
import java.util.List;

class AndBusinessRule extends BusinessRule {
    private final BusinessRule _firstRule;
    private final BusinessRule _secondRule;

    public AndBusinessRule(BusinessRule firstRule, BusinessRule secondRule) {
        _firstRule = firstRule;
        _secondRule = secondRule;
    }

    public List<BusinessRuleViolation> CheckRule() {
        List<BusinessRuleViolation> result = new ArrayList<BusinessRuleViolation>();
        result.addAll(_firstRule.CheckRule());
        result.addAll(_secondRule.CheckRule());
        return result;
    }
}