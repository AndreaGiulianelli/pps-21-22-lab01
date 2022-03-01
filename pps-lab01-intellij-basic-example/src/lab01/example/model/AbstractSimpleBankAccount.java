package lab01.example.model;

public abstract class AbstractSimpleBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;

    public AbstractSimpleBankAccount(final AccountHolder holder, final double balance) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public final AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public final double getBalance() {
        return this.balance;
    }

    @Override
    public final void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public final void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    protected abstract boolean isWithdrawAllowedBalanceNotSufficient();

    protected final boolean isWithdrawAllowed(final double amount) {
        if (!(this.balance >= amount)) {
            return this.isWithdrawAllowedBalanceNotSufficient();
        }
        return true;
    }

    protected final boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
