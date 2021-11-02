package com.everisdarmytasksms.Ejercicio1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everisdarmytasksms.Ejercicio1.controller.Tareas;
import com.everisdarmytasksms.Ejercicio1.repository.Ejercicio1Repository;

@Service

public class Ejercicio1Service {

	
	@Autowired
	Ejercicio1Repository ejercicio1repository;
	
	public Tareas createTareas(String estado, String descripcion)
	{
		if(descripcion.length() < 256)
		{	
			Tareas tareas= new Tareas(estado,descripcion);
			return tareas;
		}
			else
			{
				return null;
			}
		
	
	}

	public Tareas getTareasById(Integer id) {
		// TODO Auto-generated method stub
		return  ejercicio1repository.findById(id).orElse(null);
	}
	
	
	
	
	
	
	
	
	
	
}
