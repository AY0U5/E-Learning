package  ma.zs.alc.ws.facade.admin.recomrecla;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import ma.zs.alc.dao.criteria.core.recomrecla.ReclamationProfCriteria;
import ma.zs.alc.service.facade.admin.recomrecla.ReclamationProfAdminService;
import ma.zs.alc.ws.converter.recomrecla.ReclamationProfConverter;
import ma.zs.alc.ws.dto.recomrecla.ReclamationProfDto;
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
@RequestMapping("/api/admin/reclamationProf/")
public class ReclamationProfRestAdmin  extends AbstractController<ReclamationProf, ReclamationProfDto, ReclamationProfCriteria, ReclamationProfAdminService, ReclamationProfConverter> {



    @Operation(summary = "upload one reclamationProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reclamationProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reclamationProfs")
    @GetMapping("")
    public ResponseEntity<List<ReclamationProfDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reclamationProfs")
    @GetMapping("optimized")
    public ResponseEntity<List<ReclamationProfDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reclamationProf by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<ReclamationProfDto> findByReference(@PathVariable String reference) {
        return super.findByReferenceEntity(new ReclamationProf(reference));
    }

    @Operation(summary = "Saves the specified  reclamationProf")
    @PostMapping("")
    public ResponseEntity<ReclamationProfDto> save(@RequestBody ReclamationProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reclamationProf")
    @PutMapping("")
    public ResponseEntity<ReclamationProfDto> update(@RequestBody ReclamationProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reclamationProf")
    @PostMapping("multiple")
    public ResponseEntity<List<ReclamationProfDto>> delete(@RequestBody List<ReclamationProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reclamationProf")
    @DeleteMapping("")
    public ResponseEntity<ReclamationProfDto> delete(@RequestBody ReclamationProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reclamationProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reclamationProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by admin id")
    @GetMapping("admin/id/{id}")
    public List<ReclamationProfDto> findByAdminId(@PathVariable Long id){
        return findDtos(service.findByAdminId(id));
    }
    @Operation(summary = "delete by admin id")
    @DeleteMapping("admin/id/{id}")
    public int deleteByAdminId(@PathVariable Long id){
        return service.deleteByAdminId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<ReclamationProfDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by typeReclamationProf id")
    @GetMapping("typeReclamationProf/id/{id}")
    public List<ReclamationProfDto> findByTypeReclamationProfId(@PathVariable Long id){
        return findDtos(service.findByTypeReclamationProfId(id));
    }
    @Operation(summary = "delete by typeReclamationProf id")
    @DeleteMapping("typeReclamationProf/id/{id}")
    public int deleteByTypeReclamationProfId(@PathVariable Long id){
        return service.deleteByTypeReclamationProfId(id);
    }

    @Operation(summary = "Finds a reclamationProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReclamationProfDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds reclamationProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReclamationProfDto>> findByCriteria(@RequestBody ReclamationProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reclamationProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReclamationProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reclamationProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReclamationProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reclamationProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReclamationProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReclamationProfRestAdmin (ReclamationProfAdminService service, ReclamationProfConverter converter) {
        super(service, converter);
    }




}
