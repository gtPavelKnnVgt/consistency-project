package demo.claims.app.api.impl;

import demo.claims.app.api.ScheduleCreationInbound;
import demo.claims.domain.FinancialClaim;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduleCreationUseCase implements ScheduleCreationInbound {
    private final Scheduler scheduler;

    @Override
    @Transactional
    public void schedule(List<FinancialClaim> financialClaims) {
        scheduleJob(financialClaims, "financialClaims");
    }

    @SneakyThrows
    private void scheduleJob(Object data, String jobKey) {
        log.info("Scheduling job for key: {}", jobKey);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("data", data);
        JobDetail jobDetail = JobBuilder.newJob()
                .withIdentity(jobKey, "Job")
                .setJobData(jobDataMap)
                .requestRecovery(true)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).startNow().build();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
