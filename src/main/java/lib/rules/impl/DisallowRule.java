package lib.rules.impl;

import lib.models.Expense;
import lib.rules.ExpenseRule;
import lib.rules.Violation;

import java.util.Optional;

public class DisallowRule implements ExpenseRule {

    @Override
    public Optional<Violation> check(Expense e){
        return Optional.of(Violation.of("Expense Type"+e.getExpenseType()+"is not allowed"));
    }
}
