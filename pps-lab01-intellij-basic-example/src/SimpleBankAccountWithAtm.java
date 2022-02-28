import lab01.example.model.AbstractSimpleBankAccount;
import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.BankAccountWithAtm;

public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount implements BankAccountWithAtm {
    public static final int ATM_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    @Override
    public void depositWithAtm(final int userID, final double amount) {
        double amountWithFee = amount - ATM_FEE;
        this.deposit(userID, amountWithFee);
    }

    @Override
    public void withdrawWithAtm(final int userID, final double amount) {
        double amountWithFee = amount + ATM_FEE;
        this.withdraw(userID, amountWithFee);
    }

    @Override
    protected void handleBalanceNotSufficient() {
        throw new IllegalStateException("Balance not sufficient");
    }
}
