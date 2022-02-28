import lab01.example.model.AccountHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmSpecificTest {
    public static final int ATM_FEE = 1;

    private SimpleBankAccountWithAtm bankAccount;
    private AccountHolder accountHolder;

    @BeforeEach
    void setUp() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testDepositWithAtm() {
        this.bankAccount.depositWithAtm(this.accountHolder.getId(), 100);
        assertEquals(100 - ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30 - ATM_FEE, this.bankAccount.getBalance());
    }
}