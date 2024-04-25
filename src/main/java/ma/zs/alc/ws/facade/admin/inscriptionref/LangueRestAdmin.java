package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.Langue;
import ma.zs.alc.dao.criteria.core.inscriptionref.LangueCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.LangueAdminService;
import ma.zs.alc.ws.converter.inscriptionref.LangueConverter;
import ma.zs.alc.ws.dto.inscriptionref.LangueDto;
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
@RequestMapping("/api/admin/langue/")
public class LangueRestAdmin  extends AbstractController<Langue, LangueDto, LangueCriteria, LangueAdminService, LangueConverter> {



    @Operation(summary = "upload one langue")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple langues")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all langues")
    @GetMapping("")
    public ResponseEntity<List<LangueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all langues")
    @GetMapping("optimized")
    public ResponseEntity<List<LangueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a langue by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<LangueDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Langue(libelle));
    }

    @Operation(summary = "Saves the specified  langue")
    @PostMapping("")
    public ResponseEntity<LangueDto> save(@RequestBody LangueDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  langue")
    @PutMapping("")
    public ResponseEntity<LangueDto> update(@RequestBody LangueDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of langue")
    @PostMapping("multiple")
    public ResponseEntity<List<LangueDto>> delete(@RequestBody List<LangueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified langue")
    @DeleteMapping("")
    public ResponseEntity<LangueDto> delete(@RequestBody LangueDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified langue")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple langues by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a langue and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LangueDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds langues by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LangueDto>> findByCriteria(@RequestBody LangueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated langues by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LangueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports langues by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LangueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets langue data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LangueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public LangueRestAdmin (LangueAdminService service, LangueConverter converter) {
        super(service, converter);
    }




}
