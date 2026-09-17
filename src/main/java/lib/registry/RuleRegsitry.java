package lib.registry;

import lib.models.ExpenseType;
import lib.rules.ExpenseRule;
import lib.rules.TripRule;
import lib.rules.impl.DisallowRule;
import lib.rules.impl.MaxAmountRule;
import lib.rules.impl.TripTotalMaxRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleRegsitry {
    public static Map<ExpenseType, List<ExpenseRule>> getExpenseRuleRegistry(){
        Map<ExpenseType, List<ExpenseRule>> registry = new HashMap<>();

        registry.put(ExpenseType.RESTAURANT, List.of(
                new MaxAmountRule(75d)
        ));

        registry.put(ExpenseType.AIRFARE, List.of(
                new DisallowRule()
        ));
        return registry;
    }

    public static List<ExpenseRule> getAllExpenseRulesRegistry(){
        return List.of(
                new MaxAmountRule(200d)
        );
    }

    public static List<TripRule> getAllTripRulesRegistry(){
        return List.of(
                new TripTotalMaxRule(1000)
        );
    }
}
