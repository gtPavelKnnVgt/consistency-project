package demo.claims.app.api.impl;

import demo.claims.app.api.CreateFinancialClaimInbound;
import demo.claims.domain.FinancialClaim;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClaimCreationJob implements Job {
    private final CreateFinancialClaimInbound createFinancialClaimInbound;

    @Override
    @SuppressWarnings("unchecked")
    public void execute(JobExecutionContext jobExecutionContext) {
        String jobKey = jobExecutionContext.getJobDetail().getKey().getName();
        log.info("Executing claims creation for jobKey: {}", jobKey);
        List<FinancialClaim> claims = (List<FinancialClaim>) jobExecutionContext.getMergedJobDataMap().get("data");
        createFinancialClaimInbound.createBatch(claims);
    }
}
