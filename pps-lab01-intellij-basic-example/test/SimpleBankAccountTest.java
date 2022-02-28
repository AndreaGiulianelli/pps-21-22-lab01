import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBasicBankAccountTest {

    @Override
    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccount(accountHolder, 0);
    }

}
