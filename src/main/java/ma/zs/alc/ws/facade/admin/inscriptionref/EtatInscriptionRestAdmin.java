package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtatInscriptionCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.EtatInscriptionAdminService;
import ma.zs.alc.ws.converter.inscriptionref.EtatInscriptionConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtatInscriptionDto;
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
@RequestMapping("/api/admin/etatInscription/")
public class EtatInscriptionRestAdmin  extends AbstractController<EtatInscription, EtatInscriptionDto, EtatInscriptionCriteria, EtatInscriptionAdminService, EtatInscriptionConverter> {



    @Operation(summary = "upload one etatInscription")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatInscriptions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatInscriptions")
    @GetMapping("")
    public ResponseEntity<List<EtatInscriptionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatInscriptions")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatInscriptionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatInscription by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatInscriptionDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new EtatInscription(libelle));
    }

    @Operation(summary = "Saves the specified  etatInscription")
    @PostMapping("")
    public ResponseEntity<EtatInscriptionDto> save(@RequestBody EtatInscriptionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatInscription")
    @PutMapping("")
    public ResponseEntity<EtatInscriptionDto> update(@RequestBody EtatInscriptionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatInscription")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatInscriptionDto>> delete(@RequestBody List<EtatInscriptionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatInscription")
    @DeleteMapping("")
    public ResponseEntity<EtatInscriptionDto> delete(@RequestBody EtatInscriptionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatInscription")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatInscriptions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a etatInscription and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatInscriptionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etatInscriptions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatInscriptionDto>> findByCriteria(@RequestBody EtatInscriptionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatInscriptions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatInscriptionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatInscriptions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatInscriptionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatInscription data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatInscriptionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatInscriptionRestAdmin (EtatInscriptionAdminService service, EtatInscriptionConverter converter) {
        super(service, converter);
    }




}
