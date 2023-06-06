package com.ajal.mapper;

import com.ajal.dto.GradeDTO;
import com.ajal.entity.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {SchoolSubjectMapper.class, StudentMapper.class})
public interface GradeMapper extends SuperMapper<Grade, GradeDTO> {

    @Override
    Grade map(GradeDTO dto, @MappingTarget Grade grade);

}
