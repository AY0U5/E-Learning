package  ma.zs.alc.ws.facade.admin.prof;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.dao.criteria.core.prof.TypeTeacherCriteria;
import ma.zs.alc.service.facade.admin.prof.TypeTeacherAdminService;
import ma.zs.alc.ws.converter.prof.TypeTeacherConverter;
import ma.zs.alc.ws.dto.prof.TypeTeacherDto;
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
@RequestMapping("/api/admin/typeTeacher/")
public class TypeTeacherRestAdmin  extends AbstractController<TypeTeacher, TypeTeacherDto, TypeTeacherCriteria, TypeTeacherAdminService, TypeTeacherConverter> {



    @Operation(summary = "upload one typeTeacher")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeTeachers")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeTeachers")
    @GetMapping("")
    public ResponseEntity<List<TypeTeacherDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeTeachers")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeTeacherDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeTeacher by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeTeacherDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TypeTeacher(libelle));
    }

    @Operation(summary = "Saves the specified  typeTeacher")
    @PostMapping("")
    public ResponseEntity<TypeTeacherDto> save(@RequestBody TypeTeacherDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeTeacher")
    @PutMapping("")
    public ResponseEntity<TypeTeacherDto> update(@RequestBody TypeTeacherDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeTeacher")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeTeacherDto>> delete(@RequestBody List<TypeTeacherDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeTeacher")
    @DeleteMapping("")
    public ResponseEntity<TypeTeacherDto> delete(@RequestBody TypeTeacherDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeTeacher")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeTeachers by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeTeacher and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeTeacherDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeTeachers by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeTeacherDto>> findByCriteria(@RequestBody TypeTeacherCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeTeachers by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeTeacherCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeTeachers by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeTeacherCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeTeacher data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeTeacherCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeTeacherRestAdmin (TypeTeacherAdminService service, TypeTeacherConverter converter) {
        super(service, converter);
    }




}
