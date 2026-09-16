package lib.rules;

import java.util.Optional;
import lib.models.Expense;

public interface ExpenseRule {

    Optional<Violation> check(Expense expense);
    
}
