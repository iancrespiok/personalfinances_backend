package ian.personalfinances.model.cashflow;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

@Entity
public class OutFlow extends CashFlow {
    OutFlowsCategory outFlowsCategory;
    Boolean isCredit;
    Integer quotas;

    public OutFlow(String descriptionName, LocalDate date, Double amount, OutFlowsCategory outFlowsCategory, Boolean isCredit, Integer quotas) {
        super(descriptionName, date, amount);
        this.outFlowsCategory = outFlowsCategory;
        this.isCredit = isCredit;
        this.quotas = quotas;
    }

    public OutFlow() {

    }

    public OutFlowsCategory getOutFlowsCategory() {
        return outFlowsCategory;
    }

    public void setOutFlowsCategory(OutFlowsCategory outFlowsCategory) {
        this.outFlowsCategory = outFlowsCategory;
    }

    public Integer quotaToPay() { // Que cuota se paga en este mes
        YearMonth nowYearMonth = YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonth());
        Long monthsBetween = monthToStartPaying().until(nowYearMonth, ChronoUnit.MONTHS);
        return monthsBetween.intValue();
    }

    public YearMonth monthToStartPaying() {
        if (isCredit) {
            return YearMonth.of(this.date.plusMonths(1).getYear(), this.date.plusMonths(1).getMonth());
        } else {
            return YearMonth.of(this.date.getYear(), this.date.getMonth());
        }
    }
}
