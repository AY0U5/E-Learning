package  ma.zs.alc.ws.facade.admin.salary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.dao.criteria.core.salary.WorkloadBonusProfCriteria;
import ma.zs.alc.service.facade.admin.salary.WorkloadBonusProfAdminService;
import ma.zs.alc.ws.converter.salary.WorkloadBonusProfConverter;
import ma.zs.alc.ws.dto.salary.WorkloadBonusProfDto;
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
@RequestMapping("/api/admin/workloadBonusProf/")
public class WorkloadBonusProfRestAdmin  extends AbstractController<WorkloadBonusProf, WorkloadBonusProfDto, WorkloadBonusProfCriteria, WorkloadBonusProfAdminService, WorkloadBonusProfConverter> {



    @Operation(summary = "upload one workloadBonusProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple workloadBonusProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all workloadBonusProfs")
    @GetMapping("")
    public ResponseEntity<List<WorkloadBonusProfDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  workloadBonusProf")
    @PostMapping("")
    public ResponseEntity<WorkloadBonusProfDto> save(@RequestBody WorkloadBonusProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  workloadBonusProf")
    @PutMapping("")
    public ResponseEntity<WorkloadBonusProfDto> update(@RequestBody WorkloadBonusProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of workloadBonusProf")
    @PostMapping("multiple")
    public ResponseEntity<List<WorkloadBonusProfDto>> delete(@RequestBody List<WorkloadBonusProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified workloadBonusProf")
    @DeleteMapping("")
    public ResponseEntity<WorkloadBonusProfDto> delete(@RequestBody WorkloadBonusProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified workloadBonusProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple workloadBonusProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by workloadBonus id")
    @GetMapping("workloadBonus/id/{id}")
    public List<WorkloadBonusProfDto> findByWorkloadBonusId(@PathVariable Long id){
        return findDtos(service.findByWorkloadBonusId(id));
    }
    @Operation(summary = "delete by workloadBonus id")
    @DeleteMapping("workloadBonus/id/{id}")
    public int deleteByWorkloadBonusId(@PathVariable Long id){
        return service.deleteByWorkloadBonusId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<WorkloadBonusProfDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by salary id")
    @GetMapping("salary/id/{id}")
    public List<WorkloadBonusProfDto> findBySalaryId(@PathVariable Long id){
        return findDtos(service.findBySalaryId(id));
    }
    @Operation(summary = "delete by salary id")
    @DeleteMapping("salary/id/{id}")
    public int deleteBySalaryId(@PathVariable Long id){
        return service.deleteBySalaryId(id);
    }

    @Operation(summary = "Finds a workloadBonusProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<WorkloadBonusProfDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds workloadBonusProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<WorkloadBonusProfDto>> findByCriteria(@RequestBody WorkloadBonusProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated workloadBonusProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody WorkloadBonusProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports workloadBonusProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody WorkloadBonusProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets workloadBonusProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody WorkloadBonusProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public WorkloadBonusProfRestAdmin (WorkloadBonusProfAdminService service, WorkloadBonusProfConverter converter) {
        super(service, converter);
    }




}
