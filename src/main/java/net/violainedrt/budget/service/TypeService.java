package net.violainedrt.budget.service;

import net.violainedrt.budget.dto.TypeDto;


import java.util.List;

public interface TypeService {
    TypeDto createType(TypeDto typeDto);
    TypeDto getTypeById(Long typeId);

    List<TypeDto> getAllTypes();
    void deleteType(Long typeId);


}
