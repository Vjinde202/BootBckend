package com.abc.asset.AssetManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.asset.AssetManagementSystem.Entity.Asset;



@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{

}
