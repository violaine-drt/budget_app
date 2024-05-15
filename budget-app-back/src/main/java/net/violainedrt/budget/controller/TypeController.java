package net.violainedrt.budget.controller;

import lombok.AllArgsConstructor;
import net.violainedrt.budget.dto.TypeDto;
import net.violainedrt.budget.entity.Type;
import net.violainedrt.budget.mapper.TypeMapper;
import net.violainedrt.budget.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/types")
public class TypeController {
    private TypeService typeService;
    // Build Add Type REST API
    @PostMapping
    public ResponseEntity<TypeDto> createType(@RequestBody TypeDto typeDto){
        TypeDto savedType = typeService.createType(typeDto);
        return new ResponseEntity<>(savedType, HttpStatus.CREATED);

    }

    //Build Get Type REST API
    @GetMapping("{id}")
     public ResponseEntity<TypeDto> getTypeById(@PathVariable("id") Long typeId){
        TypeDto typeDto = typeService.getTypeById(typeId);
        return ResponseEntity.ok(typeDto);
     }

     //Build Get All types REST API
    @GetMapping
    public ResponseEntity<List<TypeDto>> getAllTypes(){
        List<TypeDto> types = typeService.getAllTypes();
        return ResponseEntity.ok(types);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteType(@PathVariable("id") Long typeId){
        typeService.deleteType(typeId);
        return ResponseEntity.ok("Type deleted successfully");
    }
}
