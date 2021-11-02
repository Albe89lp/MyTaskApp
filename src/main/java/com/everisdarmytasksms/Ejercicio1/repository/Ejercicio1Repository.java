package com.everisdarmytasksms.Ejercicio1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everisdarmytasksms.Ejercicio1.controller.Tareas;

@Repository

public interface Ejercicio1Repository extends JpaRepository<Tareas, Integer>{

		List<Tareas> findAllByEstado(String Estado);
	
}
