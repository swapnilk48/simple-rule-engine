package lib.rules;

import lib.models.Expense;
import lib.models.ExpenseType;

import java.util.List;
import java.util.Map;

public interface RuleEngine {

    List<Violation> evaluate(
            List<Expense> expenses,
            Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry,
            List<ExpenseRule> expenseRules,
            List<TripRule> tripRulesRegistry
    );
}
