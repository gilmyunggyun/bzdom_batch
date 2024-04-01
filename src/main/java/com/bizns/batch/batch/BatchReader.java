package com.bizns.batch.batch;

import com.bizns.batch.batch.entity.ComCodeMst;
import com.bizns.batch.batch.repository.ComCodeMstRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.item.util.FileUtils;

@Slf4j
//@RequiredArgsConstructor
public class BatchReader implements
    ItemReader<ComCodeMst>, StepExecutionListener {

    private ComCodeMstRepository comCodeMstRepository;

    BatchReader (ComCodeMstRepository comCodeMstRepository){
        this.comCodeMstRepository = comCodeMstRepository;
    }

    private FileUtils fu;

    @Override
    public void beforeStep(StepExecution stepExecution) {

        System.err.println("Line Reader initialized.");
    }

    @Override
    public ComCodeMst read() throws Exception {

        return new IteratorItemReader<>(this.comCodeMsts()).read();
    }


    private List<ComCodeMst> comCodeMsts() {
         List<ComCodeMst> comCodeMsts = comCodeMstRepository.findAll();
        if (comCodeMsts != null) log.info("Read line: " + comCodeMsts.toString());

        return comCodeMsts;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
//        fu.closeReader();
        log.info("Line Reader ended.");
        return ExitStatus.COMPLETED;
    }
}
