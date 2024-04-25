package  ma.zs.alc.ws.facade.admin.faq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.faq.Faq;
import ma.zs.alc.dao.criteria.core.faq.FaqCriteria;
import ma.zs.alc.service.facade.admin.faq.FaqAdminService;
import ma.zs.alc.ws.converter.faq.FaqConverter;
import ma.zs.alc.ws.dto.faq.FaqDto;
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
@RequestMapping("/api/admin/faq/")
public class FaqRestAdmin  extends AbstractController<Faq, FaqDto, FaqCriteria, FaqAdminService, FaqConverter> {



    @Operation(summary = "upload one faq")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple faqs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all faqs")
    @GetMapping("")
    public ResponseEntity<List<FaqDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all faqs")
    @GetMapping("optimized")
    public ResponseEntity<List<FaqDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a faq by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<FaqDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Faq(libelle));
    }

    @Operation(summary = "Saves the specified  faq")
    @PostMapping("")
    public ResponseEntity<FaqDto> save(@RequestBody FaqDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  faq")
    @PutMapping("")
    public ResponseEntity<FaqDto> update(@RequestBody FaqDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of faq")
    @PostMapping("multiple")
    public ResponseEntity<List<FaqDto>> delete(@RequestBody List<FaqDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified faq")
    @DeleteMapping("")
    public ResponseEntity<FaqDto> delete(@RequestBody FaqDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified faq")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple faqs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by faqType id")
    @GetMapping("faqType/id/{id}")
    public List<FaqDto> findByFaqTypeId(@PathVariable Long id){
        return findDtos(service.findByFaqTypeId(id));
    }
    @Operation(summary = "delete by faqType id")
    @DeleteMapping("faqType/id/{id}")
    public int deleteByFaqTypeId(@PathVariable Long id){
        return service.deleteByFaqTypeId(id);
    }

    @Operation(summary = "Finds a faq and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FaqDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds faqs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FaqDto>> findByCriteria(@RequestBody FaqCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated faqs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FaqCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports faqs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FaqCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets faq data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FaqCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FaqRestAdmin (FaqAdminService service, FaqConverter converter) {
        super(service, converter);
    }




}
