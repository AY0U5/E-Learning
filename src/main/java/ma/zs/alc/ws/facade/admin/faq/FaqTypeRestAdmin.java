package  ma.zs.alc.ws.facade.admin.faq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.dao.criteria.core.faq.FaqTypeCriteria;
import ma.zs.alc.service.facade.admin.faq.FaqTypeAdminService;
import ma.zs.alc.ws.converter.faq.FaqTypeConverter;
import ma.zs.alc.ws.dto.faq.FaqTypeDto;
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
@RequestMapping("/api/admin/faqType/")
public class FaqTypeRestAdmin  extends AbstractController<FaqType, FaqTypeDto, FaqTypeCriteria, FaqTypeAdminService, FaqTypeConverter> {



    @Operation(summary = "upload one faqType")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple faqTypes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all faqTypes")
    @GetMapping("")
    public ResponseEntity<List<FaqTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all faqTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<FaqTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a faqType by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<FaqTypeDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new FaqType(libelle));
    }

    @Operation(summary = "Saves the specified  faqType")
    @PostMapping("")
    public ResponseEntity<FaqTypeDto> save(@RequestBody FaqTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  faqType")
    @PutMapping("")
    public ResponseEntity<FaqTypeDto> update(@RequestBody FaqTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of faqType")
    @PostMapping("multiple")
    public ResponseEntity<List<FaqTypeDto>> delete(@RequestBody List<FaqTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified faqType")
    @DeleteMapping("")
    public ResponseEntity<FaqTypeDto> delete(@RequestBody FaqTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified faqType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple faqTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a faqType and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FaqTypeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds faqTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FaqTypeDto>> findByCriteria(@RequestBody FaqTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated faqTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FaqTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports faqTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FaqTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets faqType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FaqTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FaqTypeRestAdmin (FaqTypeAdminService service, FaqTypeConverter converter) {
        super(service, converter);
    }




}
