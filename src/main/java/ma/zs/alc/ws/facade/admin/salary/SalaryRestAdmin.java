package  ma.zs.alc.ws.facade.admin.salary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.salary.Salary;
import ma.zs.alc.dao.criteria.core.salary.SalaryCriteria;
import ma.zs.alc.service.facade.admin.salary.SalaryAdminService;
import ma.zs.alc.ws.converter.salary.SalaryConverter;
import ma.zs.alc.ws.dto.salary.SalaryDto;
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
@RequestMapping("/api/admin/salary/")
public class SalaryRestAdmin  extends AbstractController<Salary, SalaryDto, SalaryCriteria, SalaryAdminService, SalaryConverter> {



    @Operation(summary = "upload one salary")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple salarys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all salarys")
    @GetMapping("")
    public ResponseEntity<List<SalaryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all salarys")
    @GetMapping("optimized")
    public ResponseEntity<List<SalaryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a salary by code")
    @GetMapping("code/{code}")
    public ResponseEntity<SalaryDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new Salary(code));
    }

    @Operation(summary = "Saves the specified  salary")
    @PostMapping("")
    public ResponseEntity<SalaryDto> save(@RequestBody SalaryDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  salary")
    @PutMapping("")
    public ResponseEntity<SalaryDto> update(@RequestBody SalaryDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of salary")
    @PostMapping("multiple")
    public ResponseEntity<List<SalaryDto>> delete(@RequestBody List<SalaryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified salary")
    @DeleteMapping("")
    public ResponseEntity<SalaryDto> delete(@RequestBody SalaryDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified salary")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple salarys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<SalaryDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }

    @Operation(summary = "Finds a salary and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SalaryDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds salarys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SalaryDto>> findByCriteria(@RequestBody SalaryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated salarys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SalaryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports salarys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SalaryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets salary data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SalaryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SalaryRestAdmin (SalaryAdminService service, SalaryConverter converter) {
        super(service, converter);
    }




}
