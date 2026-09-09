package com.warehouse.app.mapper;

import com.warehouse.app.dto.ItemRequestDto;
import com.warehouse.app.dto.ItemResponseDto;
import com.warehouse.app.entity.WarehouseItem;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Component;

@Component
public class WarehouseItemMapper {
    public  WarehouseItem mapToEntity(ItemRequestDto itemRequestDto) {
        WarehouseItem item = new WarehouseItem();
        item.setProductName(itemRequestDto.getProductName());
        item.setDescription(itemRequestDto.getDescription());
        item.setRetailPrice(itemRequestDto.getRetailPrice());
        item.setWholesalePrice(itemRequestDto.getWholesalePrice());
        item.setSku(itemRequestDto.getSku());
        item.setBinLocation(itemRequestDto.getBinLocation());
        item.setStockQuantity(itemRequestDto.getStockQuantity());
        item.setSupplierContactEmail(itemRequestDto.getSupplierContactEmail());
        return item;

    }
    public ItemResponseDto mapToResponse(WarehouseItem savedItem) {
        ItemResponseDto responseDto = new ItemResponseDto();
        responseDto.setId(savedItem.getId());
        responseDto.setProductName(savedItem.getProductName());
        responseDto.setRetailPrice(savedItem.getRetailPrice());
        responseDto.setSku(savedItem.getSku());
        responseDto.setStockQuantity(savedItem.getStockQuantity());
        responseDto.setDescription(savedItem.getDescription());
        return responseDto;
    }
    public WarehouseItem mapToUpdate(WarehouseItem existingItem,ItemRequestDto updateDto) {
        if(updateDto.getProductName() != null) {
            existingItem.setProductName(updateDto.getProductName());
        }
        if(updateDto.getBinLocation() != null) {
            existingItem.setBinLocation(updateDto.getBinLocation());
        }
        if(updateDto.getWholesalePrice() != null) {
            existingItem.setWholesalePrice(updateDto.getWholesalePrice());
        }
        if(updateDto.getDescription() != null) {
            existingItem.setDescription(updateDto.getDescription());
        }
        if(updateDto.getRetailPrice() != null) {
            existingItem.setRetailPrice(updateDto.getRetailPrice());
        }
        if(updateDto.getSupplierContactEmail() != null) {
            existingItem.setSupplierContactEmail(updateDto.getSupplierContactEmail());
        }
        if(updateDto.getStockQuantity() != null) {
            existingItem.setStockQuantity(updateDto.getStockQuantity());
        }
        if(updateDto.getSku() != null) {
            existingItem.setSku(updateDto.getSku());
        }

        return existingItem;

    }

}
