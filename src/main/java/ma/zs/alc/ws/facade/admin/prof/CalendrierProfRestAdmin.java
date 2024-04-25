package  ma.zs.alc.ws.facade.admin.prof;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.dao.criteria.core.prof.CalendrierProfCriteria;
import ma.zs.alc.service.facade.admin.prof.CalendrierProfAdminService;
import ma.zs.alc.ws.converter.prof.CalendrierProfConverter;
import ma.zs.alc.ws.dto.prof.CalendrierProfDto;
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
@RequestMapping("/api/admin/calendrierProf/")
public class CalendrierProfRestAdmin  extends AbstractController<CalendrierProf, CalendrierProfDto, CalendrierProfCriteria, CalendrierProfAdminService, CalendrierProfConverter> {



    @Operation(summary = "upload one calendrierProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple calendrierProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all calendrierProfs")
    @GetMapping("")
    public ResponseEntity<List<CalendrierProfDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all calendrierProfs")
    @GetMapping("optimized")
    public ResponseEntity<List<CalendrierProfDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a calendrierProf by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<CalendrierProfDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new CalendrierProf(ref));
    }

    @Operation(summary = "Saves the specified  calendrierProf")
    @PostMapping("")
    public ResponseEntity<CalendrierProfDto> save(@RequestBody CalendrierProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  calendrierProf")
    @PutMapping("")
    public ResponseEntity<CalendrierProfDto> update(@RequestBody CalendrierProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of calendrierProf")
    @PostMapping("multiple")
    public ResponseEntity<List<CalendrierProfDto>> delete(@RequestBody List<CalendrierProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified calendrierProf")
    @DeleteMapping("")
    public ResponseEntity<CalendrierProfDto> delete(@RequestBody CalendrierProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified calendrierProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple calendrierProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<CalendrierProfDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<CalendrierProfDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }

    @Operation(summary = "Finds a calendrierProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CalendrierProfDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds calendrierProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CalendrierProfDto>> findByCriteria(@RequestBody CalendrierProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated calendrierProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CalendrierProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports calendrierProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CalendrierProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets calendrierProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CalendrierProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CalendrierProfRestAdmin (CalendrierProfAdminService service, CalendrierProfConverter converter) {
        super(service, converter);
    }




}
