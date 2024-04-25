package  ma.zs.alc.ws.facade.admin.pack;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.dao.criteria.core.pack.PackStudentCriteria;
import ma.zs.alc.service.facade.admin.pack.PackStudentAdminService;
import ma.zs.alc.ws.converter.pack.PackStudentConverter;
import ma.zs.alc.ws.dto.pack.PackStudentDto;
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
@RequestMapping("/api/admin/packStudent/")
public class PackStudentRestAdmin  extends AbstractController<PackStudent, PackStudentDto, PackStudentCriteria, PackStudentAdminService, PackStudentConverter> {



    @Operation(summary = "upload one packStudent")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple packStudents")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all packStudents")
    @GetMapping("")
    public ResponseEntity<List<PackStudentDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all packStudents")
    @GetMapping("optimized")
    public ResponseEntity<List<PackStudentDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a packStudent by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<PackStudentDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new PackStudent(libelle));
    }

    @Operation(summary = "Saves the specified  packStudent")
    @PostMapping("")
    public ResponseEntity<PackStudentDto> save(@RequestBody PackStudentDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  packStudent")
    @PutMapping("")
    public ResponseEntity<PackStudentDto> update(@RequestBody PackStudentDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of packStudent")
    @PostMapping("multiple")
    public ResponseEntity<List<PackStudentDto>> delete(@RequestBody List<PackStudentDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified packStudent")
    @DeleteMapping("")
    public ResponseEntity<PackStudentDto> delete(@RequestBody PackStudentDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified packStudent")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple packStudents by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by parcours id")
    @GetMapping("parcours/id/{id}")
    public List<PackStudentDto> findByParcoursId(@PathVariable Long id){
        return findDtos(service.findByParcoursId(id));
    }
    @Operation(summary = "delete by parcours id")
    @DeleteMapping("parcours/id/{id}")
    public int deleteByParcoursId(@PathVariable Long id){
        return service.deleteByParcoursId(id);
    }
    @Operation(summary = "find by price id")
    @GetMapping("price/id/{id}")
    public List<PackStudentDto> findByPriceId(@PathVariable Long id){
        return findDtos(service.findByPriceId(id));
    }
    @Operation(summary = "delete by price id")
    @DeleteMapping("price/id/{id}")
    public int deleteByPriceId(@PathVariable Long id){
        return service.deleteByPriceId(id);
    }

    @Operation(summary = "Finds a packStudent and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PackStudentDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds packStudents by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PackStudentDto>> findByCriteria(@RequestBody PackStudentCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated packStudents by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PackStudentCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports packStudents by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PackStudentCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets packStudent data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PackStudentCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PackStudentRestAdmin (PackStudentAdminService service, PackStudentConverter converter) {
        super(service, converter);
    }




}
