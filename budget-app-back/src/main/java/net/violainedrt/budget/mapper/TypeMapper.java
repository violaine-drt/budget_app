package net.violainedrt.budget.mapper;

import net.violainedrt.budget.dto.TypeDto;
import net.violainedrt.budget.entity.Type;

public class TypeMapper {
    public static TypeDto mapToTypeDto(Type type){
        return new TypeDto(
                type.getId(),
                type.getName()
        );
    }

    public static Type mapToType(TypeDto typeDto){
        return new Type(
                typeDto.getId(),
                typeDto.getName()
        );
    }
}
