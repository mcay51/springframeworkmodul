package tr.com.mustafacay.spel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tr.com.mustafacay.spel.dto.SpELRequestDTO;
import tr.com.mustafacay.spel.dto.SpELResponseDTO;

/**
 * SpEL ile ilgili DTO dönüşümlerini sağlayan mapper interface.
 */
@Mapper(componentModel = "spring")
public interface SpELMapper {
    
    @Mapping(target = "result", ignore = true)
    @Mapping(target = "resultType", ignore = true)
    @Mapping(target = "successful", constant = "true")
    @Mapping(target = "errorMessage", ignore = true)
    SpELResponseDTO toResponseDTO(SpELRequestDTO request);
    
    @Mapping(target = "expression", source = "request.expression")
    @Mapping(target = "result", source = "evaluationResult")
    @Mapping(target = "resultType", expression = "java(evaluationResult != null ? evaluationResult.getClass().getSimpleName() : null)")
    @Mapping(target = "successful", constant = "true")
    @Mapping(target = "errorMessage", ignore = true)
    SpELResponseDTO toResponseDTO(SpELRequestDTO request, Object evaluationResult);
} 