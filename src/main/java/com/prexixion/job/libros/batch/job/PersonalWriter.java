package com.prexixion.job.libros.batch.job;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.prexixion.job.libros.model.Personal;

@Component
public class PersonalWriter implements ItemWriter<Personal>{

    @Override
    public void write(List<? extends Personal> items) throws Exception {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'write'");
        // Aquí puedes realizar cualquier lógica adicional antes de escribir en la base de datos
        // En este ejemplo, simplemente imprimiremos los datos en la consola
        System.out.println("Lista de Personal:");
        for (Personal personal : items) {
            System.out.println("DNI: " + personal.getDni());
            System.out.println("Nombres: " + personal.getNombres());
            System.out.println("Apellidos: " + personal.getApellidos());
            System.out.println("Fecha de Nacimiento: " + personal.getFechaNacimiento());
            System.out.println("--------------------------");
        }
        // Luego, puedes escribir los datos en la base de datos si es necesario
    }
    
}
