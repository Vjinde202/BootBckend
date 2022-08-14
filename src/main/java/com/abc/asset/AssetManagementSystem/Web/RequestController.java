package com.abc.asset.AssetManagementSystem.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.asset.AssetManagementSystem.Entity.Asset;
import com.abc.asset.AssetManagementSystem.Entity.RequestAsset;
import com.abc.asset.AssetManagementSystem.Exception.ResourceNotFoundException;
import com.abc.asset.AssetManagementSystem.Repository.RequestRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/request/")
public class RequestController {

	@Autowired
	private RequestRepository requestRepository;
	
	//get all employees
	
	@GetMapping("/assets") //localhost:8080/assets
	public List<RequestAsset> getAllRequests()
	{
		return requestRepository.findAll();
	}
	//get request by id
	@GetMapping("/assets/{id}")//localhost:8080/assetManagement/asset/idnumber
	public ResponseEntity<RequestAsset> getRequestById(@PathVariable Long id) {
		
		RequestAsset requestAsset = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		return ResponseEntity.ok(requestAsset);
	}
	//deleteRequest
	
	@DeleteMapping("/delete/{id}") //8080/assetManagement/delete/id
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Long id){
		RequestAsset requestAsset = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		
		requestRepository.delete(requestAsset);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}