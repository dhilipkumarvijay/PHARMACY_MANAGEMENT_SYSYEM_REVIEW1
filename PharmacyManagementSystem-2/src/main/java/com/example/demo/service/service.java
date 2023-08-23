package com.example.demo.service;
import com.example.demo.model.*;
import com.example.demo.repo.*;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class service {
	@Autowired
	repo grepo;
		public model saveDetails(model gm) {
		return grepo.save(gm);
	}
	public model updateDetails(model gm) {
		return grepo.saveAndFlush(gm);
	}
	public void delete(int serialNum) {
		System.out.print("Deleted");
		grepo.deleteById(serialNum);
	}
	public boolean deleteGift(int serialNum) {
		if(grepo.existsById(serialNum)) {
			grepo.deleteById(serialNum);
			return true;
		}
		return false;
	}
	public Optional<model> getUserId(int userId)
	   {
		   Optional<model>gift=grepo.findById(userId);
		   if(gift.isPresent())
		   {
			   return gift;
		   }
		   return null;
	   }
	public List<model> getDetails()
	{
		return grepo.findAll();
	}
	
}