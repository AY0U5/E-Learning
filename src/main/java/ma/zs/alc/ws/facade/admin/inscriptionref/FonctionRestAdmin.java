package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.dao.criteria.core.inscriptionref.FonctionCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.FonctionAdminService;
import ma.zs.alc.ws.converter.inscriptionref.FonctionConverter;
import ma.zs.alc.ws.dto.inscriptionref.FonctionDto;
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
@RequestMapping("/api/admin/fonction/")
public class FonctionRestAdmin  extends AbstractController<Fonction, FonctionDto, FonctionCriteria, FonctionAdminService, FonctionConverter> {



    @Operation(summary = "upload one fonction")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple fonctions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all fonctions")
    @GetMapping("")
    public ResponseEntity<List<FonctionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all fonctions")
    @GetMapping("optimized")
    public ResponseEntity<List<FonctionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a fonction by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<FonctionDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Fonction(libelle));
    }

    @Operation(summary = "Saves the specified  fonction")
    @PostMapping("")
    public ResponseEntity<FonctionDto> save(@RequestBody FonctionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  fonction")
    @PutMapping("")
    public ResponseEntity<FonctionDto> update(@RequestBody FonctionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of fonction")
    @PostMapping("multiple")
    public ResponseEntity<List<FonctionDto>> delete(@RequestBody List<FonctionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified fonction")
    @DeleteMapping("")
    public ResponseEntity<FonctionDto> delete(@RequestBody FonctionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified fonction")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple fonctions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a fonction and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FonctionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds fonctions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FonctionDto>> findByCriteria(@RequestBody FonctionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated fonctions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FonctionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports fonctions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FonctionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets fonction data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FonctionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FonctionRestAdmin (FonctionAdminService service, FonctionConverter converter) {
        super(service, converter);
    }




}
