package lib.utils;

import lib.models.Expense;

import java.util.List;

public class ExpenseUtils {

    public static boolean areAllExpensesOfSameTrip(List<Expense> expenses) {
        if(expenses.isEmpty())
            return true;

        String tripId = expenses.get(0).getTripId();

        for(Expense expense : expenses){
            if(expense.getTripId() != tripId)
                return false;
        }

        return true;
    }
}
