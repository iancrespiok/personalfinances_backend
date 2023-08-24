package ian.personalfinances.model;

import ian.personalfinances.model.cashflow.InFlow;
import ian.personalfinances.model.cashflow.InFlowsCategory;
import ian.personalfinances.model.cashflow.OutFlow;
import ian.personalfinances.model.cashflow.OutFlowsCategory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class FinancesPerYearMonth extends model.PersistentEntity {
    @OneToMany
    private List<OutFlow> outFlows = new ArrayList<>();
    @OneToMany
    private List<InFlow> inFlows = new ArrayList<>();
    @Column(name = "`year_month`")
    private YearMonth yearMonth;

    public FinancesPerYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public FinancesPerYearMonth() {
    }

    public List<OutFlow> getOutFlows() {
        return outFlows;
    }

    public void setOutFlows(List<OutFlow> outFlows) {
        this.outFlows = outFlows;
    }

    public List<InFlow> getInFlows() {
        return inFlows;
    }

    public void setInFlows(List<InFlow> inFlows) {
        this.inFlows = inFlows;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    Double getFinanzasNetasDelMes() {
        Double sumIns = inFlows.stream().mapToDouble(inFlow -> inFlow.getAmount()).sum();
        Double sumOuts = outFlows.stream().mapToDouble(outFlow -> outFlow.getAmount()).sum();
        return  sumIns - sumOuts;
    }
}
