import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        this.bankAccount.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(30 - ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void testWithdrawMoreThanDeposited() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertThrows(IllegalStateException.class, () -> this.bankAccount.withdraw(this.accountHolder.getId(), 101));
    }

    @Test
    void testWithdrawMoreThanDepositedGoldAccount() {
        this.bankAccount.setGoldAccount(true);
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(this.accountHolder.getId(), 101);
        assertEquals(-1, this.bankAccount.getBalance());
    }

}