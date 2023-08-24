package ian.personalfinances.model.cashflow;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class InFlow extends CashFlow {
    InFlowsCategory inFlowsCategory;

    public InFlow(String descriptionName, LocalDate date, Double amount, InFlowsCategory inFlowsCategory) {
        super(descriptionName, date, amount);
        this.inFlowsCategory = inFlowsCategory;
    }

    public InFlow() {

    }

    public InFlowsCategory getInFlowsCategory() {
        return inFlowsCategory;
    }

    public void setInFlowsCategory(InFlowsCategory inFlowsCategory) {
        this.inFlowsCategory = inFlowsCategory;
    }
}
