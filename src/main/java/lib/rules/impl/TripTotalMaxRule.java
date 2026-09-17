package lib.rules.impl;

import lib.models.Expense;
import lib.rules.TripRule;
import lib.rules.Violation;
import lib.utils.ExpenseUtils;

import java.util.List;
import java.util.Optional;

public class TripTotalMaxRule implements TripRule {
    private final double maxAmount;

    public TripTotalMaxRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> check(List<Expense> expenses) {
        if(!ExpenseUtils.areAllExpensesOfSameTrip(expenses)) {
            return Optional.of(Violation.of("Expenses are not from same trip"));
        }
        double total = 0;
        for(Expense e : expenses){
            total += e.getExpenseAmount();
        }

        if(total > maxAmount){
            return Optional.of(Violation.of("Trip Total is greater than max allowed amount"));
        }

        return Optional.empty();
    }

}
