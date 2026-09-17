package lib;

import lib.models.Expense;
import lib.models.ExpenseType;
import lib.registry.RuleRegsitry;
import lib.rules.RuleEngine;
import lib.rules.Violation;
import lib.rules.impl.SimpleRuleEngine;

import java.util.List;

/**
 * Small executable example for exercising the rule engine.
 */
public class Main {

    public static void main(String[] args) {
        List<Expense> expenses = List.of(
                new Expense("Team dinner", 100.0, "TRIP-101", ExpenseType.RESTAURANT),
                new Expense("Flight to conference", 300.0, "TRIP-101", ExpenseType.AIRFARE),
                new Expense("Show tickets", 700.0, "TRIP-101", ExpenseType.ENTERTAINMENT)
        );

        RuleEngine ruleEngine = new SimpleRuleEngine();
        List<Violation> violations = ruleEngine.evaluate(
                expenses,
                RuleRegsitry.getExpenseRuleRegistry(),
                RuleRegsitry.getAllExpenseRulesRegistry(),
                RuleRegsitry.getAllTripRulesRegistry()
        );

        if (violations.isEmpty()) {
            System.out.println("All expenses satisfy the rules.");
            return;
        }

        System.out.println("Rule violations:");
        violations.forEach(violation -> System.out.println("- " + violation.getMessage()));
    }
}
