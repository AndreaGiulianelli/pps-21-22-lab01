import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the lab01.example.model.SimpleBankAccountWithAtm implementation
 */
class SimpleBankAccountWithAtmBasicTest extends AbstractBasicBankAccountTest{
    @Override
    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }
}
