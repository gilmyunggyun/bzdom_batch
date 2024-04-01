package com.bizns.batch.batch;

import com.bizns.batch.batch.entity.ComCodeMst;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.util.FileUtils;

@Slf4j
public class BatchWriter implements ItemWriter<ComCodeMst>, StepExecutionListener {


    private FileUtils fu;

//    @Override
//    public void beforeStep(StepExecution stepExecution) {
////        fu = new FileUtils("output.csv");
//        System.err.println("Line Writer initialized.");
//    }


    @Override
    public void write(Chunk<? extends ComCodeMst> lines) throws Exception {
        for (ComCodeMst line : lines) {
            System.err.println("Wrote line test");
            log.info("Wrote line " + line.toString());
        }
    }

//    @Override
//    public ExitStatus afterStep(StepExecution stepExecution) {
////        fu.closeWriter();
//        System.err.println("Line Writer ended.");
//        return ExitStatus.COMPLETED;
//    }

//    @Override
//    public void write(Chunk<? extends Line> chunk) throws Exception {
//
//    }
}

