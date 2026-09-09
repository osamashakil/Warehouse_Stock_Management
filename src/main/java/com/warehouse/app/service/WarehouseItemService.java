package com.warehouse.app.service;

import com.warehouse.app.dto.ItemRequestDto;
import com.warehouse.app.dto.ItemResponseDto;
import com.warehouse.app.entity.WarehouseItem;
import com.warehouse.app.repository.WarehouseRepository;
import com.warehouse.app.mapper.WarehouseItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseItemService {
    private final WarehouseItemMapper warehouseItemMapper;
    private final WarehouseRepository warehouseRepository;

    public WarehouseItemService(WarehouseRepository warehouseRepository, WarehouseItemMapper warehouseItemMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseItemMapper = warehouseItemMapper;
    }
    // creating database entity
    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        WarehouseItem mapped = warehouseItemMapper.mapToEntity(itemRequestDto);
        // save to database
        WarehouseItem savedItem = warehouseRepository.save(mapped);
        // Map Saved Entity -> Response DTO (Exclude sensitive fields)
        return warehouseItemMapper.mapToResponse(savedItem);

    }
    // Hard Delete
    public boolean delete(Long id) {

        if (!warehouseRepository.existsById(id)) {
            return false;
        }
        warehouseRepository.deleteById(id);
        return true;
    }
    // Get all items
    public List<ItemResponseDto> getAllItems() {
        List<WarehouseItem> allItems = warehouseRepository.findAll();

    return allItems.stream()
            .map(warehouseItemMapper::mapToResponse)
            .toList();
    }
    // Get items by id
    public ItemResponseDto getItemById(Long id) {
        return warehouseRepository.findById(id)
                .map(warehouseItemMapper::mapToResponse)
                .orElse(null);
    }

    public ItemResponseDto updateItem(Long id, ItemRequestDto updateDto) {
        WarehouseItem existingItem = warehouseRepository.findById(id).orElse(null);
       if(existingItem == null){
           return null;
       }
       WarehouseItem updatedItem = warehouseItemMapper.mapToUpdate(existingItem,updateDto);
       warehouseRepository.save(updatedItem);
       return warehouseItemMapper.mapToResponse(updatedItem);

    }
}


