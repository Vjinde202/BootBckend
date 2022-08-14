package com.abc.asset.AssetManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.asset.AssetManagementSystem.Entity.RequestAsset;


@Repository
public interface RequestRepository extends JpaRepository<RequestAsset, Long>{

}