package com.sb.basic.batch.ex02.schedulers;

import java.time.LocalDateTime;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TutorialScheduler {

	private final Job job;  // tutorialJob
    private final JobLauncher jobLauncher;

    // 일정한 주기(5초마다 실행)마다 작성한 Job이 실행되도록 설정
    @Scheduled(fixedDelay = 5 * 1000L)
    public void executeJob () { // 등록된 Job을 스프링 배치의 JobLauncher 인스턴스를 통해서 실행
        try {
            jobLauncher.run(
                    job,
                    new JobParametersBuilder()
                            .addString("datetime", LocalDateTime.now().toString())
                    .toJobParameters()  // job parameter 설정
            );
        } catch (JobExecutionException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
