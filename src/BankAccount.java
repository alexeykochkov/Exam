//Содержать поля:
//accountNumber (уникальный номер счета),
//balance (текущий баланс),
//ownerName (имя владельца).
//
//Иметь методы:
//deposit(double amount) — пополнение счета (баланс увеличивается на amount).
//withdraw(double amount) — снятие средств (баланс уменьшается на amount, но не может быть отрицательным).
//getBalance() — возвращает текущий баланс.
//Обрабатывать некорректные действия:
//deposit и withdraw должны выбрасывать IllegalArgumentException, если amount ≤ 0.
//withdraw должен выбрасывать IllegalStateException, если недостаточно средств.


public class BankAccount {
    private String accountNumber;
    private Double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName, Double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void plusMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount <=0");
        }
        balance += amount;
    }

    public void minusMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount <=0");
        }
        if (amount > balance) {
            throw new IllegalStateException("balance < amount");
        }
        balance -= amount;
    }

    public void getBalance() {
        System.out.println(balance);
    }
}
