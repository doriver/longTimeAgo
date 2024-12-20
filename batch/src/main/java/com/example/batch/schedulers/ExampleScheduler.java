package com.example.batch.schedulers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling // 스케쥴러 기능 활성화
@RequiredArgsConstructor
@Component
public class ExampleScheduler { // 배치를 일정 주기로 실행시키기 위해서 Scheduler를 구현
	
	private final Job job;
	private final JobLauncher jobLauncher;
	
	// 상황에 맞게 조정하여 사용한다. 시간뿐만 아니라 요일, 오전, 오후 등 모두 설정 가능하다.
	@Scheduled(fixedDelay = 30000)
	public void startJob() {
		try {
			Map<String, JobParameter> jobParametersMap = new HashMap<>();
			
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();

			String time1 = format1.format(time);

			jobParametersMap.put("requestDate", new JobParameter(time1)); // requestDate 이름으로 jobParameter로 생성하고 

			JobParameters parameters = new JobParameters(jobParametersMap);

			JobExecution jobExecution = jobLauncher.run(job, parameters); // jobLauncher를 통해 job를 실행한다.

			while (jobExecution.isRunning()) {
				log.info("isRunning...");
			}
			
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
}
