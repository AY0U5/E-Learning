package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.dao.criteria.core.inscriptionref.InteretEtudiantCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.InteretEtudiantAdminService;
import ma.zs.alc.ws.converter.inscriptionref.InteretEtudiantConverter;
import ma.zs.alc.ws.dto.inscriptionref.InteretEtudiantDto;
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
@RequestMapping("/api/admin/interetEtudiant/")
public class InteretEtudiantRestAdmin  extends AbstractController<InteretEtudiant, InteretEtudiantDto, InteretEtudiantCriteria, InteretEtudiantAdminService, InteretEtudiantConverter> {



    @Operation(summary = "upload one interetEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple interetEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all interetEtudiants")
    @GetMapping("")
    public ResponseEntity<List<InteretEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all interetEtudiants")
    @GetMapping("optimized")
    public ResponseEntity<List<InteretEtudiantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a interetEtudiant by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<InteretEtudiantDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new InteretEtudiant(libelle));
    }

    @Operation(summary = "Saves the specified  interetEtudiant")
    @PostMapping("")
    public ResponseEntity<InteretEtudiantDto> save(@RequestBody InteretEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  interetEtudiant")
    @PutMapping("")
    public ResponseEntity<InteretEtudiantDto> update(@RequestBody InteretEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of interetEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<InteretEtudiantDto>> delete(@RequestBody List<InteretEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified interetEtudiant")
    @DeleteMapping("")
    public ResponseEntity<InteretEtudiantDto> delete(@RequestBody InteretEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified interetEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple interetEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a interetEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InteretEtudiantDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds interetEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InteretEtudiantDto>> findByCriteria(@RequestBody InteretEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated interetEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InteretEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports interetEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InteretEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets interetEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InteretEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InteretEtudiantRestAdmin (InteretEtudiantAdminService service, InteretEtudiantConverter converter) {
        super(service, converter);
    }




}
