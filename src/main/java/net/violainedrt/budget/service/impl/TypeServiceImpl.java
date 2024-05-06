package net.violainedrt.budget.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.violainedrt.budget.dto.TypeDto;
import net.violainedrt.budget.entity.Type;
import net.violainedrt.budget.entity.User;
import net.violainedrt.budget.exception.ResourceNotFoundException;
import net.violainedrt.budget.mapper.TypeMapper;
import net.violainedrt.budget.repository.TypeRepository;
import net.violainedrt.budget.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;
    @Override
    public TypeDto createType(TypeDto typeDto) {
        Type type = TypeMapper.mapToType(typeDto);
        Type savedType = typeRepository.save(type);
        return TypeMapper.mapToTypeDto(savedType);
    }

    @Override
    public TypeDto getTypeById(Long typeId) {
       Type type = typeRepository.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Type does not exist with given ID : " + typeId));
       return TypeMapper.mapToTypeDto(type);
    }
    @Override
    public List<TypeDto> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        return types.stream().map((type) -> TypeMapper.mapToTypeDto(type))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteType(Long typeId) {
        Type type = typeRepository.findById(typeId).orElseThrow(
                () -> new ResourceNotFoundException("Type does not exist with given id: "+typeId)
        );
        typeRepository.deleteById(typeId);

    }

}
