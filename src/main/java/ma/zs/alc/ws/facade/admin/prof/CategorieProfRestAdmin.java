package  ma.zs.alc.ws.facade.admin.prof;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.dao.criteria.core.prof.CategorieProfCriteria;
import ma.zs.alc.service.facade.admin.prof.CategorieProfAdminService;
import ma.zs.alc.ws.converter.prof.CategorieProfConverter;
import ma.zs.alc.ws.dto.prof.CategorieProfDto;
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
@RequestMapping("/api/admin/categorieProf/")
public class CategorieProfRestAdmin  extends AbstractController<CategorieProf, CategorieProfDto, CategorieProfCriteria, CategorieProfAdminService, CategorieProfConverter> {



    @Operation(summary = "upload one categorieProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple categorieProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all categorieProfs")
    @GetMapping("")
    public ResponseEntity<List<CategorieProfDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all categorieProfs")
    @GetMapping("optimized")
    public ResponseEntity<List<CategorieProfDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a categorieProf by code")
    @GetMapping("code/{code}")
    public ResponseEntity<CategorieProfDto> findByCode(@PathVariable String code) {
        return super.findByReferenceEntity(new CategorieProf(code));
    }

    @Operation(summary = "Saves the specified  categorieProf")
    @PostMapping("")
    public ResponseEntity<CategorieProfDto> save(@RequestBody CategorieProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  categorieProf")
    @PutMapping("")
    public ResponseEntity<CategorieProfDto> update(@RequestBody CategorieProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of categorieProf")
    @PostMapping("multiple")
    public ResponseEntity<List<CategorieProfDto>> delete(@RequestBody List<CategorieProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified categorieProf")
    @DeleteMapping("")
    public ResponseEntity<CategorieProfDto> delete(@RequestBody CategorieProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified categorieProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple categorieProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a categorieProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategorieProfDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds categorieProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategorieProfDto>> findByCriteria(@RequestBody CategorieProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated categorieProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategorieProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports categorieProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CategorieProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets categorieProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategorieProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CategorieProfRestAdmin (CategorieProfAdminService service, CategorieProfConverter converter) {
        super(service, converter);
    }




}
