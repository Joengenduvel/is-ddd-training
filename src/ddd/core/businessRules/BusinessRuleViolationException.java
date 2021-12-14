package ddd.core.businessRules;


import java.util.ArrayList;
import java.util.List;

public class BusinessRuleViolationException extends RuntimeException {

    private final List<BusinessRuleViolation> _violations;

    public List<BusinessRuleViolation> getViolations() {
        return _violations;
    }

    public BusinessRuleViolationException() {
        _violations = new ArrayList<BusinessRuleViolation>();
    }

    public BusinessRuleViolationException(List<BusinessRuleViolation> violations) {
        super("Rule Violations: " + violations.size() + " violations have been detected.");
        _violations = violations;
    }
}
