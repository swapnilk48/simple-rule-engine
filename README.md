# Simple Rule Engine

A Java starter project for modelling expenses and defining rules that can be applied to them. The source uses the standard Maven/Gradle-compatible Java layout, even though a build tool has not yet been added.

## Project structure

```text
src/main/java/
├── lib/models/
│   ├── Expense.java
│   └── ExpenseType.java
└── lib/rules/
    └── ExpenseRule.java
```

## Commit history

### `3628a5d` — Add expense models

This initial commit establishes the domain model used by the rule engine.

- `Expense` is an immutable value object. It stores the expense name, amount, trip identifier, and category, and exposes getters for each field. Its fields are `final`, so an expense cannot be changed after construction.
- `ExpenseType` is an enum that defines the supported expense categories: restaurant, transportation, accommodation, entertainment, groceries, utilities, and other.
- Both classes are in the `lib.models` package and are placed beneath `src/main/java`, making their directory path match the package declaration.

### `2933c3c` — Add expense rule

This commit introduces the `lib.rules` package and adds `ExpenseRule`. It is currently an empty class: a deliberate placeholder for the rule-evaluation behavior to be implemented next. Separating rules from models keeps the domain data independent from the business logic that validates or evaluates it.

## Next steps

- Define the rule contract in `ExpenseRule` (for example, a method that evaluates an `Expense`).
- Add concrete rules such as a maximum amount or an allowed expense-type rule.
- Add unit tests and a build tool configuration.
