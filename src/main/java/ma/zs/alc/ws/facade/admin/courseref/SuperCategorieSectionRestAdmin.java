package  ma.zs.alc.ws.facade.admin.courseref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.courseref.SuperCategorieSection;
import ma.zs.alc.dao.criteria.core.courseref.SuperCategorieSectionCriteria;
import ma.zs.alc.service.facade.admin.courseref.SuperCategorieSectionAdminService;
import ma.zs.alc.ws.converter.courseref.SuperCategorieSectionConverter;
import ma.zs.alc.ws.dto.courseref.SuperCategorieSectionDto;
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
@RequestMapping("/api/admin/superCategorieSection/")
public class SuperCategorieSectionRestAdmin  extends AbstractController<SuperCategorieSection, SuperCategorieSectionDto, SuperCategorieSectionCriteria, SuperCategorieSectionAdminService, SuperCategorieSectionConverter> {



    @Operation(summary = "upload one superCategorieSection")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple superCategorieSections")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all superCategorieSections")
    @GetMapping("")
    public ResponseEntity<List<SuperCategorieSectionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all superCategorieSections")
    @GetMapping("optimized")
    public ResponseEntity<List<SuperCategorieSectionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a superCategorieSection by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<SuperCategorieSectionDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new SuperCategorieSection(libelle));
    }

    @Operation(summary = "Saves the specified  superCategorieSection")
    @PostMapping("")
    public ResponseEntity<SuperCategorieSectionDto> save(@RequestBody SuperCategorieSectionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  superCategorieSection")
    @PutMapping("")
    public ResponseEntity<SuperCategorieSectionDto> update(@RequestBody SuperCategorieSectionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of superCategorieSection")
    @PostMapping("multiple")
    public ResponseEntity<List<SuperCategorieSectionDto>> delete(@RequestBody List<SuperCategorieSectionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified superCategorieSection")
    @DeleteMapping("")
    public ResponseEntity<SuperCategorieSectionDto> delete(@RequestBody SuperCategorieSectionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified superCategorieSection")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple superCategorieSections by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a superCategorieSection and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SuperCategorieSectionDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds superCategorieSections by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SuperCategorieSectionDto>> findByCriteria(@RequestBody SuperCategorieSectionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated superCategorieSections by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SuperCategorieSectionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports superCategorieSections by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SuperCategorieSectionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets superCategorieSection data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SuperCategorieSectionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SuperCategorieSectionRestAdmin (SuperCategorieSectionAdminService service, SuperCategorieSectionConverter converter) {
        super(service, converter);
    }




}
