package com.prexixion.job.libros.batch.job;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.prexixion.job.libros.model.Personal;
import com.prexixion.job.libros.repository.PersonalRepository;

public class PersonalReader implements ItemReader<Personal>{

     @Autowired
    private PersonalRepository tuEntidadRepository;

    private Iterator<Personal> tuEntidadIterator;

    @Override
    public Personal read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'read'");
    
        // Verifica si hay más elementos en la lista
        if (tuEntidadIterator == null || !tuEntidadIterator.hasNext()) {
            initializeIterator();
        }

        // Devuelve el siguiente elemento si existe, o null si no hay más elementos
        return tuEntidadIterator.hasNext() ? tuEntidadIterator.next() : null;
    }

    private void initializeIterator() {
        // Obtiene los datos del personal desde la base de datos
        List<Personal> tuEntidades = tuEntidadRepository.findAll();

        // Inicializa el iterador con la lista de datos
        tuEntidadIterator = tuEntidades.iterator();
    }
    
}
