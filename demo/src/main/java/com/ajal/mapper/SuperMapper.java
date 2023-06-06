package com.ajal.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface SuperMapper<Entity, DTO extends Serializable> {

    Entity map(DTO dto);

    Entity map(DTO dto, Entity base);

    DTO map(Entity entity);

    default List<Entity> mapAllToEntities(List<DTO> DTOs) { return map(DTOs, this::map); }

    default List<DTO> mapAllToDTOs(List<Entity> entities) { return map(entities, this::map); }

    private <T, R> List<R> map(List<T> source, Function<T, R> mapper) {
        return source.stream().map(mapper).collect(Collectors.toList());
    }

}
