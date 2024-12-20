package com.example.batch.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batch.model.Market;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchConfig{
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	
	// exampleJob 생성
	@Bean
	public Job exampleJob() throws Exception {
		return jobBuilderFactory.get("exampleJob")
				.start(exampleStep()).build();
	}
	
	// exampleStep 생성
	@Bean
	@JobScope
	public Step exampleStep() throws Exception {
		   return stepBuilderFactory.get("exampleStep")
	                .<Market, Market>chunk(10)
	                .reader(reader(null))
	                .processor(processor(null))
	                .writer(writer(null))
	                .build();
		
// 		### Tasklet Example ###		   
//		return stepBuilderFactory.get("exampleStep")
//				.tasklet(new ExampleTasklet()).build();	
	}
	
	/*	reader
	 * 	Market를 조회하는 과정으로 조건을 지정할 수 있으며 페이징 처리도 가능하다.
		price가 1000 이상인 데이터를 페이징 사이즈 10으로 조회하는 과정이다.
	 */
	@Bean
    @StepScope
    public JpaPagingItemReader<Market> reader(@Value("#{jobParameters[requestDate]}")  String requestDate) throws Exception {
        log.info("==> reader value : " + requestDate);

        Map<String, Object> parameterValues = new HashMap<>();
        parameterValues.put("price", 1000);
        
        return new JpaPagingItemReaderBuilder<Market>()
                .pageSize(10)
                .parameterValues(parameterValues)
                .queryString("SELECT m FROM Market m WHERE m.price >= : price")
                .entityManagerFactory(entityManagerFactory)
                .name("JpaPagingItemReader")
                .build();
    }

	/*	processor
		조회한 데이터를 가공할 수 있으며 여기서는 조회된 price에 +100을 추가한다.
	*/
    @Bean
    @StepScope
    public ItemProcessor<Market, Market> processor(@Value("#{jobParameters[requestDate]}")  String requestDate){
        return new ItemProcessor<Market, Market>() {
            @Override
            public Market process(Market market) throws Exception {

                log.info("==> processor Market : " + market);
                log.info("==> processor value : " + requestDate);

                // 100원 추가
                market.setPrice(market.getPrice() + 100);

                return market;
            }
        };
    }

    /*
     *	 writer
		가공한 데이터를 처리한다.
		Chunk 단위만큼 쌓이게 되면 Writer에 전달하고 Writer는 일괄 저장한다.
     */
    @Bean
    @StepScope
    public JpaItemWriter<Market> writer(@Value("#{jobParameters[requestDate]}")  String requestDate){
        log.info("==> writer value : " + requestDate);

        return new JpaItemWriterBuilder<Market>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }
}
