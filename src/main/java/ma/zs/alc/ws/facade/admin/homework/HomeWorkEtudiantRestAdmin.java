package  ma.zs.alc.ws.facade.admin.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.dao.criteria.core.homework.HomeWorkEtudiantCriteria;
import ma.zs.alc.service.facade.admin.homework.HomeWorkEtudiantAdminService;
import ma.zs.alc.ws.converter.homework.HomeWorkEtudiantConverter;
import ma.zs.alc.ws.dto.homework.HomeWorkEtudiantDto;
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
@RequestMapping("/api/admin/homeWorkEtudiant/")
public class HomeWorkEtudiantRestAdmin  extends AbstractController<HomeWorkEtudiant, HomeWorkEtudiantDto, HomeWorkEtudiantCriteria, HomeWorkEtudiantAdminService, HomeWorkEtudiantConverter> {



    @Operation(summary = "upload one homeWorkEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple homeWorkEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all homeWorkEtudiants")
    @GetMapping("")
    public ResponseEntity<List<HomeWorkEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  homeWorkEtudiant")
    @PostMapping("")
    public ResponseEntity<HomeWorkEtudiantDto> save(@RequestBody HomeWorkEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  homeWorkEtudiant")
    @PutMapping("")
    public ResponseEntity<HomeWorkEtudiantDto> update(@RequestBody HomeWorkEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of homeWorkEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<HomeWorkEtudiantDto>> delete(@RequestBody List<HomeWorkEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified homeWorkEtudiant")
    @DeleteMapping("")
    public ResponseEntity<HomeWorkEtudiantDto> delete(@RequestBody HomeWorkEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified homeWorkEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple homeWorkEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<HomeWorkEtudiantDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by homeWork id")
    @GetMapping("homeWork/id/{id}")
    public List<HomeWorkEtudiantDto> findByHomeWorkId(@PathVariable Long id){
        return findDtos(service.findByHomeWorkId(id));
    }
    @Operation(summary = "delete by homeWork id")
    @DeleteMapping("homeWork/id/{id}")
    public int deleteByHomeWorkId(@PathVariable Long id){
        return service.deleteByHomeWorkId(id);
    }

    @Operation(summary = "Finds a homeWorkEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<HomeWorkEtudiantDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds homeWorkEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<HomeWorkEtudiantDto>> findByCriteria(@RequestBody HomeWorkEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated homeWorkEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody HomeWorkEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports homeWorkEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody HomeWorkEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets homeWorkEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody HomeWorkEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public HomeWorkEtudiantRestAdmin (HomeWorkEtudiantAdminService service, HomeWorkEtudiantConverter converter) {
        super(service, converter);
    }




}
