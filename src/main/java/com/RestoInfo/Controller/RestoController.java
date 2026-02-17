package com.RestoInfo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestoInfo.Model.Resto;
import com.RestoInfo.Service.RestoService;



@RestController
@RequestMapping("/restoapi")
public class RestoController 
{
	
	@Autowired
	private RestoService restoservice;
	
	
	@GetMapping("/allresto")
	public List<Resto> fetchAllResto()
	{
		return restoservice.getAllResto();
	}
	
	@GetMapping("/{id}")
	public Optional<Resto> fetchRestoById(@PathVariable int id)
	{
		return Optional.ofNullable(restoservice.getRestoById(id).orElseThrow());
	}
	
	@PostMapping("/addResto")
	public Resto saveProduct(@RequestBody Resto resto)
	{
		return restoservice.saveResto(resto);
	}
	
	@PutMapping("/updateResto/{id}")
	public Resto updateRestoById(@PathVariable int id, @RequestBody Resto resto)
	{
		Resto l = restoservice.getRestoById(id).orElseThrow();
		
		l.setName(resto.getName());
		l.setBest(resto.getBest());
		l.setRating(resto.getRating());
		
		return restoservice.saveResto(resto);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteRestoById(@PathVariable int id)
	{
		restoservice.deleteById(id);
	}
}
