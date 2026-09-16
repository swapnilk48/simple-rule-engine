package lib.rules.impl;

import lib.models.Expense;
import lib.rules.ExpenseRule;
import lib.rules.Violation;

import java.util.Optional;

public class MaxAmountRule implements ExpenseRule {
    private final Double maxAmount;

    public MaxAmountRule(Double maxAmount) {
        this.maxAmount = maxAmount;
    }


    @Override
    public Optional<Violation> check(Expense expense) {
       if(expense.getExpenseAmount() > maxAmount){
           return Optional.of(Violation.of("Expense amount is greater than max amount"));
       }

       return Optional.empty();
    }
}
