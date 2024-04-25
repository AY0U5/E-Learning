package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.ConfirmationToken;
import ma.zs.alc.dao.criteria.core.inscriptionref.ConfirmationTokenCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.ConfirmationTokenAdminService;
import ma.zs.alc.ws.converter.inscriptionref.ConfirmationTokenConverter;
import ma.zs.alc.ws.dto.inscriptionref.ConfirmationTokenDto;
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
@RequestMapping("/api/admin/confirmationToken/")
public class ConfirmationTokenRestAdmin  extends AbstractController<ConfirmationToken, ConfirmationTokenDto, ConfirmationTokenCriteria, ConfirmationTokenAdminService, ConfirmationTokenConverter> {



    @Operation(summary = "upload one confirmationToken")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple confirmationTokens")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all confirmationTokens")
    @GetMapping("")
    public ResponseEntity<List<ConfirmationTokenDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  confirmationToken")
    @PostMapping("")
    public ResponseEntity<ConfirmationTokenDto> save(@RequestBody ConfirmationTokenDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  confirmationToken")
    @PutMapping("")
    public ResponseEntity<ConfirmationTokenDto> update(@RequestBody ConfirmationTokenDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of confirmationToken")
    @PostMapping("multiple")
    public ResponseEntity<List<ConfirmationTokenDto>> delete(@RequestBody List<ConfirmationTokenDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified confirmationToken")
    @DeleteMapping("")
    public ResponseEntity<ConfirmationTokenDto> delete(@RequestBody ConfirmationTokenDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified confirmationToken")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple confirmationTokens by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<ConfirmationTokenDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }

    @Operation(summary = "Finds a confirmationToken and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ConfirmationTokenDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds confirmationTokens by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ConfirmationTokenDto>> findByCriteria(@RequestBody ConfirmationTokenCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated confirmationTokens by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ConfirmationTokenCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports confirmationTokens by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ConfirmationTokenCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets confirmationToken data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ConfirmationTokenCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ConfirmationTokenRestAdmin (ConfirmationTokenAdminService service, ConfirmationTokenConverter converter) {
        super(service, converter);
    }




}
