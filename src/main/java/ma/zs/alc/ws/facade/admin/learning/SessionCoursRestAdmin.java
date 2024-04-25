package  ma.zs.alc.ws.facade.admin.learning;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.dao.criteria.core.learning.SessionCoursCriteria;
import ma.zs.alc.service.facade.admin.learning.SessionCoursAdminService;
import ma.zs.alc.ws.converter.learning.SessionCoursConverter;
import ma.zs.alc.ws.dto.learning.SessionCoursDto;
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
@RequestMapping("/api/admin/sessionCours/")
public class SessionCoursRestAdmin  extends AbstractController<SessionCours, SessionCoursDto, SessionCoursCriteria, SessionCoursAdminService, SessionCoursConverter> {



    @Operation(summary = "upload one sessionCours")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple sessionCourss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all sessionCourss")
    @GetMapping("")
    public ResponseEntity<List<SessionCoursDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all sessionCourss")
    @GetMapping("optimized")
    public ResponseEntity<List<SessionCoursDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a sessionCours by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<SessionCoursDto> findByReference(@PathVariable String reference) {
        return super.findByReferenceEntity(new SessionCours(reference));
    }

    @Operation(summary = "Saves the specified  sessionCours")
    @PostMapping("")
    public ResponseEntity<SessionCoursDto> save(@RequestBody SessionCoursDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  sessionCours")
    @PutMapping("")
    public ResponseEntity<SessionCoursDto> update(@RequestBody SessionCoursDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of sessionCours")
    @PostMapping("multiple")
    public ResponseEntity<List<SessionCoursDto>> delete(@RequestBody List<SessionCoursDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified sessionCours")
    @DeleteMapping("")
    public ResponseEntity<SessionCoursDto> delete(@RequestBody SessionCoursDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified sessionCours")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple sessionCourss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<SessionCoursDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by cours id")
    @GetMapping("cours/id/{id}")
    public List<SessionCoursDto> findByCoursId(@PathVariable Long id){
        return findDtos(service.findByCoursId(id));
    }
    @Operation(summary = "delete by cours id")
    @DeleteMapping("cours/id/{id}")
    public int deleteByCoursId(@PathVariable Long id){
        return service.deleteByCoursId(id);
    }
    @Operation(summary = "find by groupeEtudiant id")
    @GetMapping("groupeEtudiant/id/{id}")
    public List<SessionCoursDto> findByGroupeEtudiantId(@PathVariable Long id){
        return findDtos(service.findByGroupeEtudiantId(id));
    }
    @Operation(summary = "delete by groupeEtudiant id")
    @DeleteMapping("groupeEtudiant/id/{id}")
    public int deleteByGroupeEtudiantId(@PathVariable Long id){
        return service.deleteByGroupeEtudiantId(id);
    }
    @Operation(summary = "find by salary id")
    @GetMapping("salary/id/{id}")
    public List<SessionCoursDto> findBySalaryId(@PathVariable Long id){
        return findDtos(service.findBySalaryId(id));
    }
    @Operation(summary = "delete by salary id")
    @DeleteMapping("salary/id/{id}")
    public int deleteBySalaryId(@PathVariable Long id){
        return service.deleteBySalaryId(id);
    }

    @Operation(summary = "Finds a sessionCours and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SessionCoursDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds sessionCourss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SessionCoursDto>> findByCriteria(@RequestBody SessionCoursCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated sessionCourss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SessionCoursCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports sessionCourss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SessionCoursCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets sessionCours data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SessionCoursCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SessionCoursRestAdmin (SessionCoursAdminService service, SessionCoursConverter converter) {
        super(service, converter);
    }




}
