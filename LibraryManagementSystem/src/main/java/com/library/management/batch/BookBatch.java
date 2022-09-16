package com.library.management.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import com.library.management.Entity.Books;
import com.library.management.repository.BookRepository;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BookBatch {

	 @Autowired
	 private JobBuilderFactory jobBuilderFactory;
	 
	 @Autowired
	 private BookRepository bookRepository;

	    @Bean
	    public FlatFileItemReader<Books> reader() {
	        FlatFileItemReader<Books> itemReader = new FlatFileItemReader<>();
	        itemReader.setResource(new FileSystemResource("src/main/resources/Book.csv"));
	        itemReader.setName("csvReader");
	        itemReader.setLinesToSkip(1);
	        itemReader.setLineMapper(lineMapper());
	        return itemReader;
	        }
	    
	
	    private LineMapper<Books> lineMapper() {
	        DefaultLineMapper<Books> lineMapper = new DefaultLineMapper<>();
	        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
	        lineTokenizer.setDelimiter(",");
	        lineTokenizer.setStrict(false);
	        lineTokenizer.setNames(new String[] {"BookId", "Title", "Edition", "Author","Publisher","Category","Price","Copies"});
	        BeanWrapperFieldSetMapper<Books> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	        fieldSetMapper.setTargetType(Books.class);
	        lineMapper.setLineTokenizer(lineTokenizer);
	        lineMapper.setFieldSetMapper(fieldSetMapper);
	        return lineMapper;

	    }
	    
	    @Bean
	    public BookProcessor processor() {
	        return new BookProcessor();
	    }

	    @Bean
	    public RepositoryItemWriter<Books> writer() {
	        RepositoryItemWriter<Books> writer = new RepositoryItemWriter<>();
	        writer.setRepository(bookRepository);
	        writer.setMethodName("save");
	        return writer;
	        
	    }
	    
	    @Autowired
		private StepBuilderFactory sbf;

	    @Bean
	    public Step step1() {
	        return sbf.get("step1").<Books, Books>chunk(10)
	                .reader(reader())
	                .processor(processor())
	                .writer(writer())
	                .taskExecutor(taskExecutor())
	                .build();
	    }
	    @Bean
	    public Job runJob() {
	        return jobBuilderFactory.get("importBookDetails")
	                .flow(step1()).end().build();

	    }

	    @Bean
	    public TaskExecutor taskExecutor() {
	        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
	        asyncTaskExecutor.setConcurrencyLimit(10);
	        return asyncTaskExecutor;
	    }
	
}
