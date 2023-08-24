package ian.personalfinances.repositories;

import ian.personalfinances.model.FinancesPerYearMonth;
import ian.personalfinances.model.cashflow.InFlowsCategory;
import ian.personalfinances.model.cashflow.OutFlowsCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.Repository;
import java.time.YearMonth;

import java.util.List;

public interface FinancesPerYearMonthRepositorie extends Repository<FinancesPerYearMonth, Long> {
    @Query("SELECT f FROM FinancesPerYearMonth f WHERE f.yearMonth = :yearMonth")
    FinancesPerYearMonth findByYearMonth(@Param("yearMonth") YearMonth yearMonth);

    @Query("SELECT SUM(inf.amount) FROM FinancesPerYearMonth f JOIN f.inFlows inf " +
            "WHERE f.yearMonth = :yearMonth AND inf.inFlowsCategory = :category")
    Double getTotalAmountOfInFlowsByCategoryAndYearMonth(@Param("yearMonth") YearMonth yearMonth, @Param("category") InFlowsCategory inFlowsCategory);

    @Query("SELECT SUM(outf.amount) FROM FinancesPerYearMonth f JOIN f.outFlows outf " +
            "WHERE f.yearMonth = :yearMonth AND outf.outFlowsCategory = :category")
    Double getTotalAmountOfOutFlowsByCategoryAndYearMonth(@Param("yearMonth") YearMonth yearMonth, @Param("category") OutFlowsCategory outFlowsCategory);

    @Query("SELECT SUM(ri.amount) FROM ReturnIncome ri " +
            "JOIN InFlow inflow ON ri.id = inflow.id " +
            "JOIN FinancesPerYearMonth fpy ON inflow MEMBER OF fpy.inFlows " +
            "WHERE fpy.yearMonth = :yearMonth AND ri.returnOutFlowCategory = :category")
    Double getTotalAmountOfReturnsByCategoryAndYearMonth(@Param("yearMonth") YearMonth yearMonth, @Param("category") OutFlowsCategory outFlowsCategory);

}