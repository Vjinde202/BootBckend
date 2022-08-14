package com.abc.asset.AssetManagementSystem.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity



public class Asset 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
	
   private String assetName;
   private String assetModel;
   private String assetOS;
   private String warranty;
   private Double purchaseAmount;
   
   
public Asset() {
	
}


public Asset(String assetName, String assetModel, String assetOS, String warranty,
		Double purchaseAmount) {
	super();
	this.assetName = assetName;
	this.assetModel = assetModel;
	this.assetOS = assetOS;
	this.warranty = warranty;
	
	this.purchaseAmount = purchaseAmount;
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getAssetName() {
	return assetName;
}


public void setAssetName(String assetName) {
	this.assetName = assetName;
}


public String getAssetModel() {
	return assetModel;
}


public void setAssetModel(String assetModel) {
	this.assetModel = assetModel;
}


public String getAssetOS() {
	return assetOS;
}


public void setAssetOS(String assetOS) {
	this.assetOS = assetOS;
}


public String getWarranty() {
	return warranty;
}


public void setWarranty(String warranty) {
	this.warranty = warranty;
}



public Double getPurchaseAmount() {
	return purchaseAmount;
}


public void setPurchaseAmount(Double purchaseAmount) {
	this.purchaseAmount = purchaseAmount;
}


@Override
public String toString() {
	return "Asset [id=" + id + ", assetName=" + assetName + ", assetModel=" + assetModel + ", assetOS=" + assetOS
			+ ", warranty=" + warranty + ", purchaseAmount=" + purchaseAmount + "]";
}

   
   

}
