public class OperationMoney {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("01", "Ivan" , 1000.0);
        bankAccount.plusMoney(100.0);
        bankAccount.getBalance();
        bankAccount.minusMoney(300);
        bankAccount.getBalance();
    }
}

