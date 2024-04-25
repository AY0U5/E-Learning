package  ma.zs.alc.ws.facade.admin.prof;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;
import ma.zs.alc.service.facade.admin.prof.ProfAdminService;
import ma.zs.alc.ws.converter.prof.ProfConverter;
import ma.zs.alc.ws.dto.prof.ProfDto;
import ma.zs.alc.zynerator.controller.AbstractController;
import ma.zs.alc.zynerator.dto.AuditEntityDto;
import ma.zs.alc.zynerator.util.PaginatedList;


import ma.zs.alc.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.alc.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.alc.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/prof/")
public class ProfRestAdmin  extends AbstractController<Prof, ProfDto, ProfCriteria, ProfAdminService, ProfConverter> {



    @Operation(summary = "upload one prof")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple profs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all profs")
    @GetMapping("")
    public ResponseEntity<List<ProfDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all profs")
    @GetMapping("optimized")
    public ResponseEntity<List<ProfDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a prof by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<ProfDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new Prof(ref));
    }

    @Operation(summary = "Saves the specified  prof")
    @PostMapping("")
    public ResponseEntity<ProfDto> save(@RequestBody ProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  prof")
    @PutMapping("")
    public ResponseEntity<ProfDto> update(@RequestBody ProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of prof")
    @PostMapping("multiple")
    public ResponseEntity<List<ProfDto>> delete(@RequestBody List<ProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified prof")
    @DeleteMapping("")
    public ResponseEntity<ProfDto> delete(@RequestBody ProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified prof")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple profs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by parcours id")
    @GetMapping("parcours/id/{id}")
    public List<ProfDto> findByParcoursId(@PathVariable Long id){
        return findDtos(service.findByParcoursId(id));
    }
    @Operation(summary = "delete by parcours id")
    @DeleteMapping("parcours/id/{id}")
    public int deleteByParcoursId(@PathVariable Long id){
        return service.deleteByParcoursId(id);
    }
    @Operation(summary = "find by categorieProf id")
    @GetMapping("categorieProf/id/{id}")
    public List<ProfDto> findByCategorieProfId(@PathVariable Long id){
        return findDtos(service.findByCategorieProfId(id));
    }
    @Operation(summary = "delete by categorieProf id")
    @DeleteMapping("categorieProf/id/{id}")
    public int deleteByCategorieProfId(@PathVariable Long id){
        return service.deleteByCategorieProfId(id);
    }
    @Operation(summary = "find by typeTeacher id")
    @GetMapping("typeTeacher/id/{id}")
    public List<ProfDto> findByTypeTeacherId(@PathVariable Long id){
        return findDtos(service.findByTypeTeacherId(id));
    }
    @Operation(summary = "delete by typeTeacher id")
    @DeleteMapping("typeTeacher/id/{id}")
    public int deleteByTypeTeacherId(@PathVariable Long id){
        return service.deleteByTypeTeacherId(id);
    }

    @Operation(summary = "Finds a prof and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProfDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds profs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProfDto>> findByCriteria(@RequestBody ProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated profs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports profs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets prof data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public ProfRestAdmin (ProfAdminService service, ProfConverter converter) {
        super(service, converter);
    }




}
