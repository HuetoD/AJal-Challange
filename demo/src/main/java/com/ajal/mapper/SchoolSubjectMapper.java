package com.ajal.mapper;

import com.ajal.dto.SchoolSubjectDTO;
import com.ajal.entity.SchoolSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SchoolSubjectMapper extends SuperMapper<SchoolSubject, SchoolSubjectDTO> {

    @Override
    @Mapping(target = "grades", ignore = true)
    SchoolSubject map(SchoolSubjectDTO dto);

    @Override
    @Mapping(target = "grades", ignore = true)
    SchoolSubject map(SchoolSubjectDTO dto, @MappingTarget SchoolSubject subject);
}
