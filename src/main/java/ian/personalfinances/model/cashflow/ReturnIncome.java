package ian.personalfinances.model.cashflow;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class ReturnIncome extends InFlow {

    private OutFlowsCategory returnOutFlowCategory;

    public ReturnIncome(String descriptionName, LocalDate date, Double amount, OutFlowsCategory returnOutFlowCategory) {
        super(descriptionName, date, amount, InFlowsCategory.DEVOLUCION);
        this.returnOutFlowCategory =  returnOutFlowCategory;
    }

    public ReturnIncome() {

    }

    public OutFlowsCategory getReturnOutFlowCategory() {
        return returnOutFlowCategory;
    }

    public void setReturnInFlowCategory(OutFlowsCategory returnOutFlowCategory) {
        this.returnOutFlowCategory = returnOutFlowCategory;
    }
}
