package com.bizns.batch.batch;

import com.bizns.batch.batch.entity.ComCodeMst;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class BatchProcessor implements
    ItemProcessor<ComCodeMst, ComCodeMst>{


//    @Override
//    public void beforeStep(StepExecution stepExecution) {
//        System.err.println("batch Processor initialized.");
//    }

    @Override
    public ComCodeMst process(ComCodeMst item) throws Exception {
        System.err.println("batch process step :" +item.toString());
        return item;
    }



//    @Override
//    public ExitStatus afterStep(StepExecution stepExecution) {
//        System.err.println("batch Processor ended.");
//        return ExitStatus.COMPLETED;
//    }
}
