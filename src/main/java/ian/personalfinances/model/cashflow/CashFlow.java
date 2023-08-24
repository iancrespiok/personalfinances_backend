package ian.personalfinances.model.cashflow;

import jakarta.persistence.Entity;
import model.PersistentEntity;

import java.time.LocalDate;

@Entity
public class CashFlow extends PersistentEntity {

    String descriptionName;
    LocalDate date;
    Double amount;

    public CashFlow(String descriptionName, LocalDate date, Double amount) {
        this.descriptionName = descriptionName;
        this.date = date;
        this.amount = amount;
    }

    public CashFlow() {

    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
