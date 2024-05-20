package  ma.zs.alc.ws.facade.admin.courseref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.courseref.EtatSection;
import ma.zs.alc.dao.criteria.core.courseref.EtatSectionCriteria;
import ma.zs.alc.service.facade.admin.courseref.EtatSectionAdminService;
import ma.zs.alc.ws.converter.courseref.EtatSectionConverter;
import ma.zs.alc.ws.dto.courseref.EtatSectionDto;
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
@RequestMapping("/api/admin/etatSection/")
public class EtatSectionRestAdmin  extends AbstractController<EtatSection, EtatSectionDto, EtatSectionCriteria, EtatSectionAdminService, EtatSectionConverter> {



    @Operation(summary = "upload one etatSection")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatSections")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatSections")
    @GetMapping("")
    public ResponseEntity<List<EtatSectionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatSections")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatSectionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatSection by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatSectionDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new EtatSection(libelle));
    }

    @Operation(summary = "Saves the specified  etatSection")
    @PostMapping("")
    public ResponseEntity<EtatSectionDto> save(@RequestBody EtatSectionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatSection")
    @PutMapping("")
    public ResponseEntity<EtatSectionDto> update(@RequestBody EtatSectionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatSection")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatSectionDto>> delete(@RequestBody List<EtatSectionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatSection")
    @DeleteMapping("")
    public ResponseEntity<EtatSectionDto> delete(@RequestBody EtatSectionDto dto) throws Exception {
        return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatSection")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatSections by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }



    @Operation(summary = "Finds a etatSection and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatSectionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etatSections by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatSectionDto>> findByCriteria(@RequestBody EtatSectionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatSections by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatSectionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatSections by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatSectionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatSection data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatSectionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatSectionRestAdmin (EtatSectionAdminService service, EtatSectionConverter converter) {
        super(service, converter);
    }




}
