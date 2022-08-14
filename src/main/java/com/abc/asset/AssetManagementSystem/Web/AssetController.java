package com.abc.asset.AssetManagementSystem.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.asset.AssetManagementSystem.Entity.Asset;
import com.abc.asset.AssetManagementSystem.Exception.ResourceNotFoundException;
import com.abc.asset.AssetManagementSystem.Repository.AssetRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/assetManagement")
public class AssetController {
	
	@Autowired
	private AssetRepository assetRepository;
	
	//get all assets
	@GetMapping("/assets") //localhost:8080/assetManagement/assets
	public List<Asset> getAllAssets()
	{
		return assetRepository.findAll();
	}
	
	//add asset
	@PostMapping("/add") //localhost:8080/assetManagement/add
	public Asset addAsset(@RequestBody Asset asset)
	{
	return assetRepository.save(asset);	
	}
	
	//get asset by id
	@GetMapping("/assets/{id}")//localhost:8080/assetManagement/assets/idnumber
	public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
		
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		return ResponseEntity.ok(asset);
	}
	
	//update asset
	@PutMapping("/assets/{id}")//localhost:8080/assetManagement/update/id
	public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails){
		
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		
		asset.setAssetName(assetDetails.getAssetName());
		asset.setAssetModel(assetDetails.getAssetModel());
		asset.setAssetOS(assetDetails.getAssetOS());
		asset.setWarranty(assetDetails.getWarranty());
		asset.setPurchaseAmount(assetDetails.getPurchaseAmount());
		
		Asset updatedAsset = assetRepository.save(asset);
		return ResponseEntity.ok(updatedAsset);
		
	}
	
	@DeleteMapping("/delete/{id}") //8080/assetManagement/delete/id
	public ResponseEntity<Map<String, Boolean>> deleteAsset(@PathVariable Long id){
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset not exist with id :" + id));
		
		assetRepository.delete(asset);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
