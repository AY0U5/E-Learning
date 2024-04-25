package  ma.zs.alc.ws.facade.admin.recomrecla;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import ma.zs.alc.dao.criteria.core.recomrecla.TypeReclamationEtudiantCriteria;
import ma.zs.alc.service.facade.admin.recomrecla.TypeReclamationEtudiantAdminService;
import ma.zs.alc.ws.converter.recomrecla.TypeReclamationEtudiantConverter;
import ma.zs.alc.ws.dto.recomrecla.TypeReclamationEtudiantDto;
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
@RequestMapping("/api/admin/typeReclamationEtudiant/")
public class TypeReclamationEtudiantRestAdmin  extends AbstractController<TypeReclamationEtudiant, TypeReclamationEtudiantDto, TypeReclamationEtudiantCriteria, TypeReclamationEtudiantAdminService, TypeReclamationEtudiantConverter> {



    @Operation(summary = "upload one typeReclamationEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeReclamationEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeReclamationEtudiants")
    @GetMapping("")
    public ResponseEntity<List<TypeReclamationEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeReclamationEtudiants")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeReclamationEtudiantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeReclamationEtudiant by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypeReclamationEtudiantDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TypeReclamationEtudiant(libelle));
    }

    @Operation(summary = "Saves the specified  typeReclamationEtudiant")
    @PostMapping("")
    public ResponseEntity<TypeReclamationEtudiantDto> save(@RequestBody TypeReclamationEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeReclamationEtudiant")
    @PutMapping("")
    public ResponseEntity<TypeReclamationEtudiantDto> update(@RequestBody TypeReclamationEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeReclamationEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeReclamationEtudiantDto>> delete(@RequestBody List<TypeReclamationEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeReclamationEtudiant")
    @DeleteMapping("")
    public ResponseEntity<TypeReclamationEtudiantDto> delete(@RequestBody TypeReclamationEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeReclamationEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeReclamationEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeReclamationEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeReclamationEtudiantDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeReclamationEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeReclamationEtudiantDto>> findByCriteria(@RequestBody TypeReclamationEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeReclamationEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeReclamationEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeReclamationEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeReclamationEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeReclamationEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeReclamationEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeReclamationEtudiantRestAdmin (TypeReclamationEtudiantAdminService service, TypeReclamationEtudiantConverter converter) {
        super(service, converter);
    }




}
