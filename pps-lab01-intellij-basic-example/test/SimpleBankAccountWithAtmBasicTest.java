import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
class SimpleBankAccountWithAtmBasicTest extends AbstractBasicBankAccountTest{
    @Override
    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }
}
