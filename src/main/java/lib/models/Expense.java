package lib.models;

//Ideally we need builder pattern
public class Expense {
    private final String expenseName;
    private final Double expenseAmount;
    private final String tripId;
    private final ExpenseType expenseType;

    public Expense(String expenseName, Double expenseAmount, String tripId, ExpenseType expenseType) {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.tripId = tripId;
        this.expenseType = expenseType;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public String getTripId() {
        return tripId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }
}