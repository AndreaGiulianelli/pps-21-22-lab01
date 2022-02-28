package lab01.example.model;

public interface BankAccountWithAtm extends BankAccount{

    /**
     * Same as deposit, but using an ATM.
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    void depositWithAtm(int userID, double amount);
}
