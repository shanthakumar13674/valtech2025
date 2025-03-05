package com.valtech.training.restapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restapis.services.OwnerService;
import com.valtech.training.restapis.vos.OwnerVO;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PutMapping("/{id}/watches")
	public OwnerVO updateWatches(@PathVariable("id")long id
			,@RequestBody List<Long> watches)	{
		return ownerService.addWatchesToOwner(id,watches);
	}

//	Get OwnerByid 
	@GetMapping("/{id}")
	public OwnerVO getOwner(@PathVariable long id) {
		return ownerService.getOwner(id);
	}

//	getallOwners
	@GetMapping("/")
	public List<OwnerVO> getOwners() {
		return ownerService.getOwners();
	}

//create Owner
	@PostMapping("/")
	public OwnerVO createOwner(@RequestBody OwnerVO ownerVo) {
		return ownerService.createOwner(ownerVo);
	}
// UpdateOwner
	@PutMapping("/{id}")
	public OwnerVO updateOwner(@RequestBody OwnerVO ownerVo,@PathVariable long id) {
		return ownerService.updateOwner(id, ownerVo);
	}
	
	// Delete Owner
	@DeleteMapping("/{id}")
	public void deleteOwner(@PathVariable long id) {
		System.out.println("Not doing anything...");
	}

}
