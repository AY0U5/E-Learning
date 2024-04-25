package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.dao.criteria.core.inscriptionref.NiveauEtudeCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.NiveauEtudeAdminService;
import ma.zs.alc.ws.converter.inscriptionref.NiveauEtudeConverter;
import ma.zs.alc.ws.dto.inscriptionref.NiveauEtudeDto;
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
@RequestMapping("/api/admin/niveauEtude/")
public class NiveauEtudeRestAdmin  extends AbstractController<NiveauEtude, NiveauEtudeDto, NiveauEtudeCriteria, NiveauEtudeAdminService, NiveauEtudeConverter> {



    @Operation(summary = "upload one niveauEtude")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple niveauEtudes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all niveauEtudes")
    @GetMapping("")
    public ResponseEntity<List<NiveauEtudeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all niveauEtudes")
    @GetMapping("optimized")
    public ResponseEntity<List<NiveauEtudeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a niveauEtude by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<NiveauEtudeDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new NiveauEtude(libelle));
    }

    @Operation(summary = "Saves the specified  niveauEtude")
    @PostMapping("")
    public ResponseEntity<NiveauEtudeDto> save(@RequestBody NiveauEtudeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  niveauEtude")
    @PutMapping("")
    public ResponseEntity<NiveauEtudeDto> update(@RequestBody NiveauEtudeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of niveauEtude")
    @PostMapping("multiple")
    public ResponseEntity<List<NiveauEtudeDto>> delete(@RequestBody List<NiveauEtudeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified niveauEtude")
    @DeleteMapping("")
    public ResponseEntity<NiveauEtudeDto> delete(@RequestBody NiveauEtudeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified niveauEtude")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple niveauEtudes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a niveauEtude and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<NiveauEtudeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds niveauEtudes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<NiveauEtudeDto>> findByCriteria(@RequestBody NiveauEtudeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated niveauEtudes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody NiveauEtudeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports niveauEtudes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody NiveauEtudeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets niveauEtude data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody NiveauEtudeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public NiveauEtudeRestAdmin (NiveauEtudeAdminService service, NiveauEtudeConverter converter) {
        super(service, converter);
    }




}
