package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.FreeTrialDetail;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialDetailCriteria;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialDetailAdminService;
import ma.zs.alc.ws.converter.freetrial.FreeTrialDetailConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialDetailDto;
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
@RequestMapping("/api/admin/freeTrialDetail/")
public class FreeTrialDetailRestAdmin  extends AbstractController<FreeTrialDetail, FreeTrialDetailDto, FreeTrialDetailCriteria, FreeTrialDetailAdminService, FreeTrialDetailConverter> {



    @Operation(summary = "upload one freeTrialDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple freeTrialDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all freeTrialDetails")
    @GetMapping("")
    public ResponseEntity<List<FreeTrialDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  freeTrialDetail")
    @PostMapping("")
    public ResponseEntity<FreeTrialDetailDto> save(@RequestBody FreeTrialDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  freeTrialDetail")
    @PutMapping("")
    public ResponseEntity<FreeTrialDetailDto> update(@RequestBody FreeTrialDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of freeTrialDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<FreeTrialDetailDto>> delete(@RequestBody List<FreeTrialDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified freeTrialDetail")
    @DeleteMapping("")
    public ResponseEntity<FreeTrialDetailDto> delete(@RequestBody FreeTrialDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified freeTrialDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple freeTrialDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by freeTrial id")
    @GetMapping("freeTrial/id/{id}")
    public List<FreeTrialDetailDto> findByFreeTrialId(@PathVariable Long id){
        return findDtos(service.findByFreeTrialId(id));
    }
    @Operation(summary = "delete by freeTrial id")
    @DeleteMapping("freeTrial/id/{id}")
    public int deleteByFreeTrialId(@PathVariable Long id){
        return service.deleteByFreeTrialId(id);
    }
    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<FreeTrialDetailDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }

    @Operation(summary = "Finds a freeTrialDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FreeTrialDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds freeTrialDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FreeTrialDetailDto>> findByCriteria(@RequestBody FreeTrialDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated freeTrialDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FreeTrialDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports freeTrialDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FreeTrialDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets freeTrialDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FreeTrialDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FreeTrialDetailRestAdmin (FreeTrialDetailAdminService service, FreeTrialDetailConverter converter) {
        super(service, converter);
    }




}
