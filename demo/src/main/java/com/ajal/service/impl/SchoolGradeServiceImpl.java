package com.ajal.service.impl;

import com.ajal.dto.GradeDTO;
import com.ajal.dto.response.SchoolGradeInfoResponse;
import com.ajal.entity.Grade;
import com.ajal.exception.GenericGradeException;
import com.ajal.exception.GradeNotFoundException;
import com.ajal.mapper.GradeMapper;
import com.ajal.repository.GradeRepository;
import com.ajal.service.SchoolGradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolGradeServiceImpl implements SchoolGradeService {

    private final GradeRepository gradeRepository;

    private final GradeMapper gradeMapper;

    public SchoolGradeServiceImpl(GradeRepository gradeRepository, GradeMapper gradeMapper) {
        this.gradeRepository = gradeRepository;
        this.gradeMapper = gradeMapper;
    }

    @Override
    public Grade findGradeOrThrowException(int gradeId) throws GradeNotFoundException {
        return gradeRepository.findById(gradeId).orElseThrow(() -> new GradeNotFoundException("La calificacion que intenta buscar, no existe en la base de datos"));
    }

    @Override
    public GradeDTO registerNewGrade(GradeDTO dto) {
        return gradeMapper.map(gradeRepository.save(gradeMapper.map(dto)));
    }

    @Override
    public GradeDTO updateGrade(int gradeId, GradeDTO dto) throws GenericGradeException {
        Grade gradeFound = findGradeOrThrowException(gradeId);
        return gradeMapper.map(gradeRepository.save(gradeMapper.map(dto, gradeFound)));
    }

    @Override
    public SchoolGradeInfoResponse findGradesAndAverage(int studentId) throws GenericGradeException {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);

        if(grades == null || grades.isEmpty())
            throw new GradeNotFoundException("Este estudiante no tiene calificaciones asignadas");

        SchoolGradeInfoResponse infoResponse = new SchoolGradeInfoResponse();
        infoResponse.setGrades(gradeMapper.mapAllToDTOs(grades));
        infoResponse.setAverage(infoResponse.getGrades().stream()
                                                        .map(GradeDTO::getNote)
                                                        .reduce(0d, (a, b) -> a + b));
        return infoResponse;
    }

    @Override
    public void deleteGrade(int gradeId) throws GenericGradeException {
        gradeRepository.delete(findGradeOrThrowException(gradeId));
    }
}
