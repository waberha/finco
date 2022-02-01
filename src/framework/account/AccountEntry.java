package framework.account;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AccountEntry implements IAccountEntry {

    protected final String id;
    protected final Account account;
    protected final double amount;
    protected final LocalDateTime date;

    public AccountEntry(Account account, double amount) {
        this.account = account;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.account.addEntry(this);
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
