package lib.rules.impl;

import lib.models.Expense;
import lib.models.ExpenseType;
import lib.rules.ExpenseRule;
import lib.rules.RuleEngine;
import lib.rules.TripRule;
import lib.rules.Violation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SimpleRuleEngine implements RuleEngine {
    @Override
    public List<Violation> evaluate( List<Expense> expenses,
                                     Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry,
                                     List<ExpenseRule> expenseRules,
                                     List<TripRule> tripRulesRegistry) {
        List<Violation> violations = new ArrayList<>();

        for (Expense expense : expenses) {
            //fetch all the rules for expense type, if no rules are found then we have empty list
            List<ExpenseRule> rules = expenseRuleRegistry.getOrDefault(expense.getExpenseType(), List.of());

            for(ExpenseRule rule : rules){
                Optional<Violation> violation = rule.check(expense);
                if(violation.isPresent()){
                    violations.add(violation.get());
                }
            }

            for(ExpenseRule rule : expenseRules){
                Optional<Violation> violation = rule.check(expense);
                if(violation.isPresent()){
                    violations.add(violation.get());
                }
            }
        }

        for(TripRule tripRule : tripRulesRegistry){
            Optional<Violation> violation = tripRule.check(expenses);
            if(violation.isPresent()){
                violations.add(violation.get());
            }
        }

        return violations;
    }
}
