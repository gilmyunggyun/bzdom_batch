package com.bizns.batch.batch;

import com.bizns.batch.batch.entity.ComCodeMst;
import com.bizns.batch.batch.repository.ComCodeMstRepository;
import java.util.Collections;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BiznsBatch {

    private final ComCodeMstRepository comCodeMstRepository;


    @Bean
    public ItemReader<ComCodeMst> itemReader() throws Exception {
        int maxId = 45;

        RepositoryItemReader<ComCodeMst> reader = new RepositoryItemReader<>();
        reader.setRepository(comCodeMstRepository);
        reader.setMethodName("findAll");
//        reader.setArguments(Collections.singletonList(maxId));
//        reader.setPageSize(20);

        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("codeCd", Sort.Direction.ASC);
        reader.setSort(sorts);

        System.err.println("read :" +reader.read());

        return reader;
//        return new BatchReader(comCodeMstRepository);
    }

    @Bean
    public ItemProcessor<ComCodeMst, ComCodeMst> itemProcessor() {
        return new BatchProcessor();
    }

    @Bean
    public ItemWriter<ComCodeMst> itemWriter() {
        return new BatchWriter();
    }
    @Bean
    public Job biznsBatchJob(JobRepository jobRepository, PlatformTransactionManager transactionManager)
        throws Exception {

        System.err.println("job");
        return new JobBuilder("chunksJob", jobRepository)

            .start(processLines(jobRepository, transactionManager, itemReader(), itemProcessor(), itemWriter()))

            .build();
    }


    @Bean
    protected Step processLines(JobRepository jobRepository
        , PlatformTransactionManager transactionManager
        , ItemReader<ComCodeMst> reader
        , ItemProcessor<ComCodeMst, ComCodeMst> processor
        , ItemWriter<ComCodeMst> writer) throws Exception {
        System.err.println("process");
//        System.err.println(reader.read());
        return new StepBuilder("processLines", jobRepository)
            .<ComCodeMst, ComCodeMst> chunk(1, transactionManager)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build();
    }

//    @Bean
//    protected Step processLinesStep2(JobRepository jobRepository, PlatformTransactionManager transactionManager, BatchReader<ComCodeMst> reader,
//        BatchProcessor<ComCodeMst, ComCodeMst> processor, BatchWriter<ComCodeMst> writer) {
//        System.err.println("next process");
//        return new StepBuilder("processLines2", jobRepository).<Line, Line> chunk(100, transactionManager)
//            .reader(reader)
//            .processor(processor)
//            .writer(writer)
//            .build();
//    }


}
