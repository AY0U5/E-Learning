package  ma.zs.alc.ws.facade.admin.recomrecla;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import ma.zs.alc.dao.criteria.core.recomrecla.RecommendTeacherCriteria;
import ma.zs.alc.service.facade.admin.recomrecla.RecommendTeacherAdminService;
import ma.zs.alc.ws.converter.recomrecla.RecommendTeacherConverter;
import ma.zs.alc.ws.dto.recomrecla.RecommendTeacherDto;
import ma.zs.alc.zynerator.controller.AbstractController;
import ma.zs.alc.zynerator.dto.AuditEntityDto;
import ma.zs.alc.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.alc.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.alc.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/recommendTeacher/")
public class RecommendTeacherRestAdmin  extends AbstractController<RecommendTeacher, RecommendTeacherDto, RecommendTeacherCriteria, RecommendTeacherAdminService, RecommendTeacherConverter> {



    @Operation(summary = "upload one recommendTeacher")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple recommendTeachers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all recommendTeachers")
    @GetMapping("")
    public ResponseEntity<List<RecommendTeacherDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all recommendTeachers")
    @GetMapping("optimized")
    public ResponseEntity<List<RecommendTeacherDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a recommendTeacher by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<RecommendTeacherDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new RecommendTeacher(ref));
    }

    @Operation(summary = "Saves the specified  recommendTeacher")
    @PostMapping("")
    public ResponseEntity<RecommendTeacherDto> save(@RequestBody RecommendTeacherDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  recommendTeacher")
    @PutMapping("")
    public ResponseEntity<RecommendTeacherDto> update(@RequestBody RecommendTeacherDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of recommendTeacher")
    @PostMapping("multiple")
    public ResponseEntity<List<RecommendTeacherDto>> delete(@RequestBody List<RecommendTeacherDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified recommendTeacher")
    @DeleteMapping("")
    public ResponseEntity<RecommendTeacherDto> delete(@RequestBody RecommendTeacherDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified recommendTeacher")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple recommendTeachers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<RecommendTeacherDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }

    @Operation(summary = "Finds a recommendTeacher and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<RecommendTeacherDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds recommendTeachers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<RecommendTeacherDto>> findByCriteria(@RequestBody RecommendTeacherCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated recommendTeachers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody RecommendTeacherCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports recommendTeachers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody RecommendTeacherCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets recommendTeacher data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody RecommendTeacherCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public RecommendTeacherRestAdmin (RecommendTeacherAdminService service, RecommendTeacherConverter converter) {
        super(service, converter);
    }




}
