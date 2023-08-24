package ian.personalfinances.services;

import ian.personalfinances.model.FinancesPerYearMonth;
import ian.personalfinances.model.cashflow.OutFlow;
import ian.personalfinances.model.cashflow.OutFlowsCategory;
import ian.personalfinances.repositories.FinancesPerYearMonthRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class FinancesServices {
    @Autowired
    FinancesPerYearMonthRepositorie financesPerYearMonthRepositorie;

    public void addOutFlow(String descriptionName, LocalDate date, OutFlowsCategory outFlowsCategory, Double amount, Boolean isCredit) {
        YearMonth yearMonth = isCredit ? YearMonth.of(date.getYear(),date.getMonth().plus(1)) : YearMonth.of(date.getYear(),date.getMonth());
        FinancesPerYearMonth financesPerYearMonth = financesPerYearMonthRepositorie.findByYearMonth(yearMonth);
        OutFlow outFlow = new OutFlow(descriptionName, date, amount, outFlowsCategory,isCredit,1);

        if (financesPerYearMonth == null) {
            financesPerYearMonth = new FinancesPerYearMonth(yearMonth);
        }

        financesPerYearMonth.getOutFlows().add(outFlow);
        financesPerYearMonthRepositorie.save
    }
    public void addOutFlow(String descriptionName, LocalDate date, OutFlowsCategory outFlowsCategory, Double amount, Boolean isCredit, Integer quotas) {
        OutFlow outFlow = new OutFlow(descriptionName,date,amount,outFlowsCategory, isCredit, quotas);
        for (int i = 1; i <= quotas; i++) {

        }
    }

    public Double getSpendsOn(OutFlowsCategory outFlowsCategory, YearMonth yearMonth) {
        Double totalAmountOfOutFlows = financesPerYearMonthRepositorie.getTotalAmountOfOutFlowsByCategoryAndYearMonth(yearMonth,outFlowsCategory);
        Double totalAmountOfReturns = financesPerYearMonthRepositorie.getTotalAmountOfReturnsByCategoryAndYearMonth(yearMonth, outFlowsCategory);
        return totalAmountOfOutFlows - totalAmountOfReturns;
    }


}
