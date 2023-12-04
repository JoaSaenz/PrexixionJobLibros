package com.prexixion.job.libros.batch.job;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.prexixion.job.libros.model.Personal;

@Component
public class PersonalProcessor implements ItemProcessor<Personal, Personal> {

    @Override
    public Personal process(Personal personal) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'process'");
        return personal;
    }
    
}
