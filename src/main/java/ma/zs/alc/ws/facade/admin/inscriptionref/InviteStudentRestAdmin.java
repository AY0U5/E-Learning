package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.InviteStudent;
import ma.zs.alc.dao.criteria.core.inscriptionref.InviteStudentCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.InviteStudentAdminService;
import ma.zs.alc.ws.converter.inscriptionref.InviteStudentConverter;
import ma.zs.alc.ws.dto.inscriptionref.InviteStudentDto;
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
@RequestMapping("/api/admin/inviteStudent/")
public class InviteStudentRestAdmin  extends AbstractController<InviteStudent, InviteStudentDto, InviteStudentCriteria, InviteStudentAdminService, InviteStudentConverter> {



    @Operation(summary = "upload one inviteStudent")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inviteStudents")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inviteStudents")
    @GetMapping("")
    public ResponseEntity<List<InviteStudentDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all inviteStudents")
    @GetMapping("optimized")
    public ResponseEntity<List<InviteStudentDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a inviteStudent by code")
    @GetMapping("code/{code}")
    public ResponseEntity<InviteStudentDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new InviteStudent(code));
    }

    @Operation(summary = "Saves the specified  inviteStudent")
    @PostMapping("")
    public ResponseEntity<InviteStudentDto> save(@RequestBody InviteStudentDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inviteStudent")
    @PutMapping("")
    public ResponseEntity<InviteStudentDto> update(@RequestBody InviteStudentDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inviteStudent")
    @PostMapping("multiple")
    public ResponseEntity<List<InviteStudentDto>> delete(@RequestBody List<InviteStudentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inviteStudent")
    @DeleteMapping("")
    public ResponseEntity<InviteStudentDto> delete(@RequestBody InviteStudentDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inviteStudent")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inviteStudents by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<InviteStudentDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }

    @Operation(summary = "Finds a inviteStudent and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InviteStudentDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds inviteStudents by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InviteStudentDto>> findByCriteria(@RequestBody InviteStudentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inviteStudents by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InviteStudentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inviteStudents by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InviteStudentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inviteStudent data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InviteStudentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InviteStudentRestAdmin (InviteStudentAdminService service, InviteStudentConverter converter) {
        super(service, converter);
    }




}
