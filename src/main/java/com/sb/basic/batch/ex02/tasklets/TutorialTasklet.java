package com.sb.basic.batch.ex02.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TutorialTasklet implements Tasklet {
//{
	@Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.debug("executed tasklet !!");
        return RepeatStatus.FINISHED;
    }
}
