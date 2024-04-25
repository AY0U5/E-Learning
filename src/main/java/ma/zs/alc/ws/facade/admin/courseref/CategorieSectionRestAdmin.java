package  ma.zs.alc.ws.facade.admin.courseref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.dao.criteria.core.courseref.CategorieSectionCriteria;
import ma.zs.alc.service.facade.admin.courseref.CategorieSectionAdminService;
import ma.zs.alc.ws.converter.courseref.CategorieSectionConverter;
import ma.zs.alc.ws.dto.courseref.CategorieSectionDto;
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
@RequestMapping("/api/admin/categorieSection/")
public class CategorieSectionRestAdmin  extends AbstractController<CategorieSection, CategorieSectionDto, CategorieSectionCriteria, CategorieSectionAdminService, CategorieSectionConverter> {



    @Operation(summary = "upload one categorieSection")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categorieSections")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categorieSections")
    @GetMapping("")
    public ResponseEntity<List<CategorieSectionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categorieSections")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieSectionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categorieSection by code")
    @GetMapping("code/{code}")
    public ResponseEntity<CategorieSectionDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new CategorieSection(code));
    }

    @Operation(summary = "Saves the specified  categorieSection")
    @PostMapping("")
    public ResponseEntity<CategorieSectionDto> save(@RequestBody CategorieSectionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categorieSection")
    @PutMapping("")
    public ResponseEntity<CategorieSectionDto> update(@RequestBody CategorieSectionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categorieSection")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieSectionDto>> delete(@RequestBody List<CategorieSectionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categorieSection")
    @DeleteMapping("")
    public ResponseEntity<CategorieSectionDto> delete(@RequestBody CategorieSectionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categorieSection")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categorieSections by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by superCategorieSection id")
    @GetMapping("superCategorieSection/id/{id}")
    public List<CategorieSectionDto> findBySuperCategorieSectionId(@PathVariable Long id){
        return findDtos(service.findBySuperCategorieSectionId(id));
    }
    @Operation(summary = "delete by superCategorieSection id")
    @DeleteMapping("superCategorieSection/id/{id}")
    public int deleteBySuperCategorieSectionId(@PathVariable Long id){
        return service.deleteBySuperCategorieSectionId(id);
    }

    @Operation(summary = "Finds a categorieSection and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieSectionDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds categorieSections by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieSectionDto>> findByCriteria(@RequestBody CategorieSectionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categorieSections by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieSectionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categorieSections by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieSectionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categorieSection data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieSectionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategorieSectionRestAdmin (CategorieSectionAdminService service, CategorieSectionConverter converter) {
        super(service, converter);
    }




}
