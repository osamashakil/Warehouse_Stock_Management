package com.warehouse.app.repository;

import com.warehouse.app.entity.WarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseItem,Long> {
}
