package com.ajal.service;

import com.ajal.dto.GradeDTO;
import com.ajal.dto.response.SchoolGradeInfoResponse;
import com.ajal.entity.Grade;
import com.ajal.exception.GenericGradeException;
import com.ajal.exception.GradeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface SchoolGradeService {

    @Transactional(readOnly = true, rollbackFor = GradeNotFoundException.class)
    Grade findGradeOrThrowException(int gradeId) throws GradeNotFoundException;

    @Transactional
    GradeDTO registerNewGrade(GradeDTO dto);

    @Transactional(rollbackFor = GenericGradeException.class)
    GradeDTO updateGrade(int gradeId, GradeDTO dto) throws GenericGradeException;

    @Transactional(readOnly = true, rollbackFor = GradeNotFoundException.class)
    SchoolGradeInfoResponse findGradesAndAverage(int studentId) throws GenericGradeException;

    @Transactional(rollbackFor = GradeNotFoundException.class)
    void deleteGrade(int gradeId) throws GenericGradeException;

    @Transactional(readOnly = true, rollbackFor = GradeNotFoundException.class)
    default Grade findGradeOrThrowException(GradeDTO dto) throws GradeNotFoundException {
        return findGradeOrThrowException(dto.getId());
    }
}
