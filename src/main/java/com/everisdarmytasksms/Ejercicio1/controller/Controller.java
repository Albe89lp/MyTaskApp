package com.everisdarmytasksms.Ejercicio1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everisdarmytasksms.Ejercicio1.repository.Ejercicio1Repository;
import com.everisdarmytasksms.Ejercicio1.service.Ejercicio1Service;

@RestController
@RequestMapping("/welcome")
public class Controller {

	
	@Autowired
	Ejercicio1Repository ejercicio1repository;
	
	@Autowired
	Ejercicio1Service ejercicio1service;
	
	
	public String welcomepage() {
		return "Welcome Alberto";
	}
	
	//Crear nueva Tarea 
	
	@PostMapping("/createTareas")
	
	public ResponseEntity<String> createTareas(@RequestParam("estado") String estado, @RequestParam("descripcion") String descripcion)
	{
		Tareas tareas= ejercicio1service.createTareas(estado, descripcion);
		
		if(tareas != null)
		{
			ejercicio1repository.save(tareas);
			return new ResponseEntity<>("Tarea creada correctamente",HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>("la tarea debe tener una descripcion" + "con una longitud máxima de 255 caracteres",HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	
	//Obtener las tareas con sus estados
	
	@GetMapping("/getTareas/{estado}")
	
	public List<Tareas> getTareasByEstado(@PathVariable("estado")String estado)
	{
		return ejercicio1repository.findAllByEstado(estado);
		
	}

	//Actualizar el estado y descripciones de las tareas

	@PutMapping("/updateTareas/{id}")
	
	public ResponseEntity<Tareas> updateTareas(@PathVariable("id")Integer id,@RequestBody Tareas tareas)
	{
		Tareas existingTareas = ejercicio1service.getTareasById(id);//.getById(id);
		if (existingTareas != null)
		{
			existingTareas.setDescripcion(tareas.getDescripcion());
			existingTareas.setEstado(tareas.getEstado());
			ejercicio1repository.save(existingTareas);
			
			return new ResponseEntity<Tareas>(existingTareas,HttpStatus.OK);
			
		}
		
		else
		{
			return new ResponseEntity<Tareas>(HttpStatus.BAD_REQUEST);
		}
	
	
	
	}

	
	//Actualizar la tareas de descripcion
	
	@PutMapping("/updateDescripcionTareas/{id}")
	
	public ResponseEntity<Tareas>updateDescripcionTareas(@PathVariable("id")Integer id, @RequestParam("descripcion")String descripcion)
	{
		Tareas existingTareas = ejercicio1service.getTareasById(id);
	
		
		if(existingTareas !=null)
		{
			existingTareas.setDescripcion(descripcion);
			ejercicio1repository.save(existingTareas);
			
			return new ResponseEntity<Tareas>(existingTareas,HttpStatus.OK);
		}
		
		else
		{
			return new ResponseEntity<Tareas>(HttpStatus.BAD_REQUEST);
		}
			
	}


	//Actualizar el estado de las tareas
	@PutMapping("/updateEstadoTareas/{id}")
	
	public ResponseEntity<Tareas>updateEstadoTareas(@PathVariable("id")Integer id,@RequestParam("estado")String estado) 
	{
		Tareas existingTareas = ejercicio1service.getTareasById(id);
		
		if (existingTareas != null)
		{
			existingTareas.setEstado(estado);
			ejercicio1repository.save(existingTareas);
			
			return new ResponseEntity<Tareas>(HttpStatus.OK);
			
		}
		
		else
		{
			return new ResponseEntity<Tareas>(HttpStatus.BAD_REQUEST);
		}
	
	
	
	}
	

	//Borrar las Tareas 
	@DeleteMapping("/deleteTareas/{id}")
	public ResponseEntity<String> deleteTareas(@PathVariable("id")Integer id)
	{
		ejercicio1repository.deleteById(id);
		
		return new ResponseEntity<String>("Tarea eliminada correctamente",HttpStatus.OK);
	}


}