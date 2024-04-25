package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialformuleCriteria;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialformuleAdminService;
import ma.zs.alc.ws.converter.freetrial.FreeTrialformuleConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialformuleDto;
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
@RequestMapping("/api/admin/freeTrialformule/")
public class FreeTrialformuleRestAdmin  extends AbstractController<FreeTrialformule, FreeTrialformuleDto, FreeTrialformuleCriteria, FreeTrialformuleAdminService, FreeTrialformuleConverter> {



    @Operation(summary = "upload one freeTrialformule")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple freeTrialformules")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all freeTrialformules")
    @GetMapping("")
    public ResponseEntity<List<FreeTrialformuleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all freeTrialformules")
    @GetMapping("optimized")
    public ResponseEntity<List<FreeTrialformuleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a freeTrialformule by code")
    @GetMapping("code/{code}")
    public ResponseEntity<FreeTrialformuleDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new FreeTrialformule(code));
    }

    @Operation(summary = "Saves the specified  freeTrialformule")
    @PostMapping("")
    public ResponseEntity<FreeTrialformuleDto> save(@RequestBody FreeTrialformuleDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  freeTrialformule")
    @PutMapping("")
    public ResponseEntity<FreeTrialformuleDto> update(@RequestBody FreeTrialformuleDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of freeTrialformule")
    @PostMapping("multiple")
    public ResponseEntity<List<FreeTrialformuleDto>> delete(@RequestBody List<FreeTrialformuleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified freeTrialformule")
    @DeleteMapping("")
    public ResponseEntity<FreeTrialformuleDto> delete(@RequestBody FreeTrialformuleDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified freeTrialformule")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple freeTrialformules by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by inscription id")
    @GetMapping("inscription/id/{id}")
    public List<FreeTrialformuleDto> findByInscriptionId(@PathVariable Long id){
        return findDtos(service.findByInscriptionId(id));
    }
    @Operation(summary = "delete by inscription id")
    @DeleteMapping("inscription/id/{id}")
    public int deleteByInscriptionId(@PathVariable Long id){
        return service.deleteByInscriptionId(id);
    }

    @Operation(summary = "Finds a freeTrialformule and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FreeTrialformuleDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds freeTrialformules by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FreeTrialformuleDto>> findByCriteria(@RequestBody FreeTrialformuleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated freeTrialformules by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FreeTrialformuleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports freeTrialformules by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FreeTrialformuleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets freeTrialformule data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FreeTrialformuleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FreeTrialformuleRestAdmin (FreeTrialformuleAdminService service, FreeTrialformuleConverter converter) {
        super(service, converter);
    }




}
