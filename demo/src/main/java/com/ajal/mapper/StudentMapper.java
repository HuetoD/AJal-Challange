package com.ajal.mapper;

import com.ajal.dto.StudentDTO;
import com.ajal.entity.Student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper extends SuperMapper<Student, StudentDTO> {

    @Override
    @Mapping(target = "grades", ignore = true)
    Student map(StudentDTO studentDTO, @MappingTarget Student student);

    @Override
    @Mapping(target = "grades", ignore = true)
    Student map(StudentDTO dto);

}
