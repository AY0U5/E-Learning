package  ma.zs.alc.ws.facade.admin.salary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.salary.WorkloadBonus;
import ma.zs.alc.dao.criteria.core.salary.WorkloadBonusCriteria;
import ma.zs.alc.service.facade.admin.salary.WorkloadBonusAdminService;
import ma.zs.alc.ws.converter.salary.WorkloadBonusConverter;
import ma.zs.alc.ws.dto.salary.WorkloadBonusDto;
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
@RequestMapping("/api/admin/workloadBonus/")
public class WorkloadBonusRestAdmin  extends AbstractController<WorkloadBonus, WorkloadBonusDto, WorkloadBonusCriteria, WorkloadBonusAdminService, WorkloadBonusConverter> {



    @Operation(summary = "upload one workloadBonus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple workloadBonuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all workloadBonuss")
    @GetMapping("")
    public ResponseEntity<List<WorkloadBonusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all workloadBonuss")
    @GetMapping("optimized")
    public ResponseEntity<List<WorkloadBonusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a workloadBonus by code")
    @GetMapping("code/{code}")
    public ResponseEntity<WorkloadBonusDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new WorkloadBonus(code));
    }

    @Operation(summary = "Saves the specified  workloadBonus")
    @PostMapping("")
    public ResponseEntity<WorkloadBonusDto> save(@RequestBody WorkloadBonusDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  workloadBonus")
    @PutMapping("")
    public ResponseEntity<WorkloadBonusDto> update(@RequestBody WorkloadBonusDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of workloadBonus")
    @PostMapping("multiple")
    public ResponseEntity<List<WorkloadBonusDto>> delete(@RequestBody List<WorkloadBonusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified workloadBonus")
    @DeleteMapping("")
    public ResponseEntity<WorkloadBonusDto> delete(@RequestBody WorkloadBonusDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified workloadBonus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple workloadBonuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a workloadBonus and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<WorkloadBonusDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds workloadBonuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<WorkloadBonusDto>> findByCriteria(@RequestBody WorkloadBonusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated workloadBonuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody WorkloadBonusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports workloadBonuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody WorkloadBonusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets workloadBonus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody WorkloadBonusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public WorkloadBonusRestAdmin (WorkloadBonusAdminService service, WorkloadBonusConverter converter) {
        super(service, converter);
    }




}
