package com.RestoInfo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestoInfo.Model.Resto;
import com.RestoInfo.Repository.RestoRepository;

@Service
public class RestoService
{
	@Autowired
	private RestoRepository restorepository;
	
	public List<Resto> getAllResto()
	{
		return restorepository.findAll();
	}
	
	public Optional<Resto> getRestoById(int id)
	{
		return restorepository.findById(id);
	}
	
	public Resto saveResto(Resto resto)
	{
		return restorepository.save(resto);
	}
	
	public void deleteById(int id)
	{
		restorepository.deleteById(id);
	}
}
