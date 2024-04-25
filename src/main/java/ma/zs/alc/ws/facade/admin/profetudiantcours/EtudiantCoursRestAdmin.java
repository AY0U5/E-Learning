package  ma.zs.alc.ws.facade.admin.profetudiantcours;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import ma.zs.alc.dao.criteria.core.profetudiantcours.EtudiantCoursCriteria;
import ma.zs.alc.service.facade.admin.profetudiantcours.EtudiantCoursAdminService;
import ma.zs.alc.ws.converter.profetudiantcours.EtudiantCoursConverter;
import ma.zs.alc.ws.dto.profetudiantcours.EtudiantCoursDto;
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
@RequestMapping("/api/admin/etudiantCours/")
public class EtudiantCoursRestAdmin  extends AbstractController<EtudiantCours, EtudiantCoursDto, EtudiantCoursCriteria, EtudiantCoursAdminService, EtudiantCoursConverter> {



    @Operation(summary = "upload one etudiantCours")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etudiantCourss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etudiantCourss")
    @GetMapping("")
    public ResponseEntity<List<EtudiantCoursDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  etudiantCours")
    @PostMapping("")
    public ResponseEntity<EtudiantCoursDto> save(@RequestBody EtudiantCoursDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etudiantCours")
    @PutMapping("")
    public ResponseEntity<EtudiantCoursDto> update(@RequestBody EtudiantCoursDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etudiantCours")
    @PostMapping("multiple")
    public ResponseEntity<List<EtudiantCoursDto>> delete(@RequestBody List<EtudiantCoursDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etudiantCours")
    @DeleteMapping("")
    public ResponseEntity<EtudiantCoursDto> delete(@RequestBody EtudiantCoursDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etudiantCours")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etudiantCourss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<EtudiantCoursDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<EtudiantCoursDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by cours id")
    @GetMapping("cours/id/{id}")
    public List<EtudiantCoursDto> findByCoursId(@PathVariable Long id){
        return findDtos(service.findByCoursId(id));
    }
    @Operation(summary = "delete by cours id")
    @DeleteMapping("cours/id/{id}")
    public int deleteByCoursId(@PathVariable Long id){
        return service.deleteByCoursId(id);
    }

    @Operation(summary = "Finds a etudiantCours and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtudiantCoursDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etudiantCourss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtudiantCoursDto>> findByCriteria(@RequestBody EtudiantCoursCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etudiantCourss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtudiantCoursCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etudiantCourss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtudiantCoursCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etudiantCours data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtudiantCoursCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtudiantCoursRestAdmin (EtudiantCoursAdminService service, EtudiantCoursConverter converter) {
        super(service, converter);
    }




}
