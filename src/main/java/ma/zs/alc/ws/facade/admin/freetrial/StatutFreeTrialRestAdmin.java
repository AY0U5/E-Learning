package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import ma.zs.alc.dao.criteria.core.freetrial.StatutFreeTrialCriteria;
import ma.zs.alc.service.facade.admin.freetrial.StatutFreeTrialAdminService;
import ma.zs.alc.ws.converter.freetrial.StatutFreeTrialConverter;
import ma.zs.alc.ws.dto.freetrial.StatutFreeTrialDto;
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
@RequestMapping("/api/admin/statutFreeTrial/")
public class StatutFreeTrialRestAdmin  extends AbstractController<StatutFreeTrial, StatutFreeTrialDto, StatutFreeTrialCriteria, StatutFreeTrialAdminService, StatutFreeTrialConverter> {



    @Operation(summary = "upload one statutFreeTrial")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple statutFreeTrials")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all statutFreeTrials")
    @GetMapping("")
    public ResponseEntity<List<StatutFreeTrialDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all statutFreeTrials")
    @GetMapping("optimized")
    public ResponseEntity<List<StatutFreeTrialDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a statutFreeTrial by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<StatutFreeTrialDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new StatutFreeTrial(libelle));
    }

    @Operation(summary = "Saves the specified  statutFreeTrial")
    @PostMapping("")
    public ResponseEntity<StatutFreeTrialDto> save(@RequestBody StatutFreeTrialDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  statutFreeTrial")
    @PutMapping("")
    public ResponseEntity<StatutFreeTrialDto> update(@RequestBody StatutFreeTrialDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of statutFreeTrial")
    @PostMapping("multiple")
    public ResponseEntity<List<StatutFreeTrialDto>> delete(@RequestBody List<StatutFreeTrialDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified statutFreeTrial")
    @DeleteMapping("")
    public ResponseEntity<StatutFreeTrialDto> delete(@RequestBody StatutFreeTrialDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified statutFreeTrial")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple statutFreeTrials by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a statutFreeTrial and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StatutFreeTrialDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds statutFreeTrials by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StatutFreeTrialDto>> findByCriteria(@RequestBody StatutFreeTrialCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated statutFreeTrials by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StatutFreeTrialCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports statutFreeTrials by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StatutFreeTrialCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets statutFreeTrial data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StatutFreeTrialCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public StatutFreeTrialRestAdmin (StatutFreeTrialAdminService service, StatutFreeTrialConverter converter) {
        super(service, converter);
    }




}
