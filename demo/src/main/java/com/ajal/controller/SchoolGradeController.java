package com.ajal.controller;

import com.ajal.dto.GradeDTO;
import com.ajal.dto.response.GenericStringResponse;
import com.ajal.dto.response.SchoolGradeInfoResponse;
import com.ajal.service.SchoolGradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ajal/v1/grades/")
public class SchoolGradeController {

    private final SchoolGradeService schoolGradeService;

    public SchoolGradeController(SchoolGradeService schoolGradeService) {
        this.schoolGradeService = schoolGradeService;
    }

    @PostMapping("new-grade")
    public GenericStringResponse registerSchoolGrade(@RequestBody GradeDTO grade) {
        schoolGradeService.registerNewGrade(grade);
        return GenericStringResponse.ok("calificacion actualizada");
    }

    @GetMapping("find-grades-and-average")
    public ResponseEntity<SchoolGradeInfoResponse> findGradesAndAverage(@RequestParam("student-id") int studentId) {
        return ResponseEntity.ok(schoolGradeService.findGradesAndAverage(studentId));
    }

    @PutMapping("update-grade/{grade-id}")
    public GenericStringResponse updateGrade(@RequestParam("grade-id") int gradeId,
                                             @RequestBody GradeDTO updated) {
        schoolGradeService.updateGrade(gradeId, updated);
        return GenericStringResponse.ok("Calificacion actualizada");
    }

    @DeleteMapping("delete-grade/{grade-id}")
    public GenericStringResponse deleteGrade(@RequestParam("grade-id") int gradeId) {
        schoolGradeService.deleteGrade(gradeId);
        return GenericStringResponse.ok("Calificacion eliminada");
    }

}
