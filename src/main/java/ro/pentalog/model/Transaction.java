package ro.pentalog.model;
import ro.pentalog.enums.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account", length = 50)
    private String accountNumber;

    @Column(name = "amount", precision = 16, scale = 2)
    private BigDecimal amount;

    @Column(name = "details", length = 100)
    private String details;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 50, nullable = false)
    private TransactionType type;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction(String accountNumber, BigDecimal amount, String details, TransactionType type, LocalDateTime createdTime, Account account) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.details = details;
        this.type = type;
        this.createdTime = createdTime;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal balance) {
        this.amount = balance;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAccountNumber(), that.getAccountNumber()) &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getDetails(), that.getDetails()) &&
                getType() == that.getType() &&
                Objects.equals(getCreatedTime(), that.getCreatedTime()) &&
                Objects.equals(getAccount(), that.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountNumber(), getAmount(), getDetails(), getType(), getCreatedTime(), getAccount());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", account='" + accountNumber + '\'' +
                ", balance=" + amount +
                ", details='" + details + '\'' +
                ", createdTime=" + createdTime +
                ", account=" + account +
                '}';
    }
}
