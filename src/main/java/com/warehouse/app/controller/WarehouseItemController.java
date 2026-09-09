package com.warehouse.app.controller;

import com.warehouse.app.dto.ItemRequestDto;
import com.warehouse.app.dto.ItemResponseDto;
import com.warehouse.app.service.WarehouseItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/items")
public class WarehouseItemController {
    private  WarehouseItemService warehouseItemService;
    public WarehouseItemController(WarehouseItemService warehouseItemService) {
        this.warehouseItemService = warehouseItemService;
    }
    @PostMapping()
    public ResponseEntity<ItemResponseDto> create(@RequestBody ItemRequestDto itemRequestDto) {
        ItemResponseDto create= warehouseItemService.createItem(itemRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }
   @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
       boolean isDeleted = warehouseItemService.delete(id);
       if(!isDeleted) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found or may be already deleted");
       }
           return ResponseEntity.ok("Item Deleted Successfully");
   }
   @GetMapping()
   public ResponseEntity<List<ItemResponseDto>>getAll() {
       return ResponseEntity.ok(warehouseItemService.getAllItems());
   }
   @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id){
        ItemResponseDto getById = warehouseItemService.getItemById(id);
        if(getById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item not found or may be deleted");
        }
        return ResponseEntity.ok(getById);
   }
   @PatchMapping("/{id}")
    public ResponseEntity<?> updte(@PathVariable Long id, @RequestBody ItemRequestDto updateDto ) {
       ItemResponseDto update  = warehouseItemService.updateItem(id,updateDto);
       if(update == null) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("sorry! Item not found with id: " + id);
       }
        return ResponseEntity.ok(update);
   }

}
