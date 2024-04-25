package  ma.zs.alc.ws.facade.admin.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.common.ClassAverageBonus;
import ma.zs.alc.dao.criteria.core.common.ClassAverageBonusCriteria;
import ma.zs.alc.service.facade.admin.common.ClassAverageBonusAdminService;
import ma.zs.alc.ws.converter.common.ClassAverageBonusConverter;
import ma.zs.alc.ws.dto.common.ClassAverageBonusDto;
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
@RequestMapping("/api/admin/classAverageBonus/")
public class ClassAverageBonusRestAdmin  extends AbstractController<ClassAverageBonus, ClassAverageBonusDto, ClassAverageBonusCriteria, ClassAverageBonusAdminService, ClassAverageBonusConverter> {



    @Operation(summary = "upload one classAverageBonus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple classAverageBonuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all classAverageBonuss")
    @GetMapping("")
    public ResponseEntity<List<ClassAverageBonusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all classAverageBonuss")
    @GetMapping("optimized")
    public ResponseEntity<List<ClassAverageBonusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a classAverageBonus by code")
    @GetMapping("code/{code}")
    public ResponseEntity<ClassAverageBonusDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new ClassAverageBonus(code));
    }

    @Operation(summary = "Saves the specified  classAverageBonus")
    @PostMapping("")
    public ResponseEntity<ClassAverageBonusDto> save(@RequestBody ClassAverageBonusDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  classAverageBonus")
    @PutMapping("")
    public ResponseEntity<ClassAverageBonusDto> update(@RequestBody ClassAverageBonusDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of classAverageBonus")
    @PostMapping("multiple")
    public ResponseEntity<List<ClassAverageBonusDto>> delete(@RequestBody List<ClassAverageBonusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified classAverageBonus")
    @DeleteMapping("")
    public ResponseEntity<ClassAverageBonusDto> delete(@RequestBody ClassAverageBonusDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified classAverageBonus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple classAverageBonuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a classAverageBonus and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClassAverageBonusDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds classAverageBonuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClassAverageBonusDto>> findByCriteria(@RequestBody ClassAverageBonusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated classAverageBonuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClassAverageBonusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports classAverageBonuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClassAverageBonusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets classAverageBonus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClassAverageBonusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ClassAverageBonusRestAdmin (ClassAverageBonusAdminService service, ClassAverageBonusConverter converter) {
        super(service, converter);
    }




}
