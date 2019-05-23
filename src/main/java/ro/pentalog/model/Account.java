package ro.pentalog.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_number", length = 50)
    private String accountNumber;

    @Column(name = "balance", precision = 16, scale = 2)
    private BigDecimal balance;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @OneToMany(targetEntity = Transaction.class, mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) &&
                Objects.equals(getUser(), account.getUser()) &&
                Objects.equals(getAccountNumber(), account.getAccountNumber()) &&
                Objects.equals(getBalance(), account.getBalance()) &&
                Objects.equals(getAccountType(), account.getAccountType()) &&
                Objects.equals(getCreatedTime(), account.getCreatedTime()) &&
                Objects.equals(getUpdatedTime(), account.getUpdatedTime()) &&
                Objects.equals(getTransactions(), account.getTransactions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getAccountNumber(), getBalance(), getAccountType(), getCreatedTime(), getUpdatedTime(), getTransactions());
    }

    @Override
    public String toString() {
        return  "Account id: " + id +
                ", Iban: " + accountNumber +
                ", balance: " + balance +
                ", currency type: " + accountType;
    }
}
