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
        if (this.checkUser(userID)) {
            this.balance += amount - ATM_FEE;
        }
    }
}
