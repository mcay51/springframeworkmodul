package tr.com.mustafacay.web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import tr.com.mustafacay.web.dto.UserDto;
import tr.com.mustafacay.web.entity.User;

/**
 * User ve UserDto arasında dönüşüm yapan mapper interface
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    /**
     * User entity'sini UserDto'ya dönüştürür
     */
    UserDto toDto(User user);
    
    /**
     * UserDto'yu User entity'sine dönüştürür
     * @param dto dönüştürülecek dto
     * @return User entity
     */
    @Mapping(target = "active", constant = "true")
    User toEntity(UserDto dto);
    
    /**
     * Var olan User entity'sini günceller
     * @param dto güncel bilgiler
     * @param user güncellenecek entity
     */
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(UserDto dto, @MappingTarget User user);
} 