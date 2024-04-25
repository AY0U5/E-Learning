package  ma.zs.alc.ws.facade.admin.learning;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.dao.criteria.core.learning.SessionCoursSectionCriteria;
import ma.zs.alc.service.facade.admin.learning.SessionCoursSectionAdminService;
import ma.zs.alc.ws.converter.learning.SessionCoursSectionConverter;
import ma.zs.alc.ws.dto.learning.SessionCoursSectionDto;
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
@RequestMapping("/api/admin/sessionCoursSection/")
public class SessionCoursSectionRestAdmin  extends AbstractController<SessionCoursSection, SessionCoursSectionDto, SessionCoursSectionCriteria, SessionCoursSectionAdminService, SessionCoursSectionConverter> {



    @Operation(summary = "upload one sessionCoursSection")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple sessionCoursSections")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all sessionCoursSections")
    @GetMapping("")
    public ResponseEntity<List<SessionCoursSectionDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  sessionCoursSection")
    @PostMapping("")
    public ResponseEntity<SessionCoursSectionDto> save(@RequestBody SessionCoursSectionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  sessionCoursSection")
    @PutMapping("")
    public ResponseEntity<SessionCoursSectionDto> update(@RequestBody SessionCoursSectionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of sessionCoursSection")
    @PostMapping("multiple")
    public ResponseEntity<List<SessionCoursSectionDto>> delete(@RequestBody List<SessionCoursSectionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified sessionCoursSection")
    @DeleteMapping("")
    public ResponseEntity<SessionCoursSectionDto> delete(@RequestBody SessionCoursSectionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified sessionCoursSection")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple sessionCoursSections by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by sessionCours id")
    @GetMapping("sessionCours/id/{id}")
    public List<SessionCoursSectionDto> findBySessionCoursId(@PathVariable Long id){
        return findDtos(service.findBySessionCoursId(id));
    }
    @Operation(summary = "delete by sessionCours id")
    @DeleteMapping("sessionCours/id/{id}")
    public int deleteBySessionCoursId(@PathVariable Long id){
        return service.deleteBySessionCoursId(id);
    }
    @Operation(summary = "find by section id")
    @GetMapping("section/id/{id}")
    public List<SessionCoursSectionDto> findBySectionId(@PathVariable Long id){
        return findDtos(service.findBySectionId(id));
    }
    @Operation(summary = "delete by section id")
    @DeleteMapping("section/id/{id}")
    public int deleteBySectionId(@PathVariable Long id){
        return service.deleteBySectionId(id);
    }

    @Operation(summary = "Finds a sessionCoursSection and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SessionCoursSectionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds sessionCoursSections by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SessionCoursSectionDto>> findByCriteria(@RequestBody SessionCoursSectionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated sessionCoursSections by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SessionCoursSectionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports sessionCoursSections by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SessionCoursSectionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets sessionCoursSection data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SessionCoursSectionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SessionCoursSectionRestAdmin (SessionCoursSectionAdminService service, SessionCoursSectionConverter converter) {
        super(service, converter);
    }




}
