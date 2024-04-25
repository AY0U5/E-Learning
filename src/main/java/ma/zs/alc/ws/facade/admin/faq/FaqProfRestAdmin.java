package  ma.zs.alc.ws.facade.admin.faq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.dao.criteria.core.faq.FaqProfCriteria;
import ma.zs.alc.service.facade.admin.faq.FaqProfAdminService;
import ma.zs.alc.ws.converter.faq.FaqProfConverter;
import ma.zs.alc.ws.dto.faq.FaqProfDto;
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
@RequestMapping("/api/admin/faqProf/")
public class FaqProfRestAdmin  extends AbstractController<FaqProf, FaqProfDto, FaqProfCriteria, FaqProfAdminService, FaqProfConverter> {



    @Operation(summary = "upload one faqProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple faqProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all faqProfs")
    @GetMapping("")
    public ResponseEntity<List<FaqProfDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all faqProfs")
    @GetMapping("optimized")
    public ResponseEntity<List<FaqProfDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a faqProf by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<FaqProfDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new FaqProf(libelle));
    }

    @Operation(summary = "Saves the specified  faqProf")
    @PostMapping("")
    public ResponseEntity<FaqProfDto> save(@RequestBody FaqProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  faqProf")
    @PutMapping("")
    public ResponseEntity<FaqProfDto> update(@RequestBody FaqProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of faqProf")
    @PostMapping("multiple")
    public ResponseEntity<List<FaqProfDto>> delete(@RequestBody List<FaqProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified faqProf")
    @DeleteMapping("")
    public ResponseEntity<FaqProfDto> delete(@RequestBody FaqProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified faqProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple faqProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<FaqProfDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by admin id")
    @GetMapping("admin/id/{id}")
    public List<FaqProfDto> findByAdminId(@PathVariable Long id){
        return findDtos(service.findByAdminId(id));
    }
    @Operation(summary = "delete by admin id")
    @DeleteMapping("admin/id/{id}")
    public int deleteByAdminId(@PathVariable Long id){
        return service.deleteByAdminId(id);
    }
    @Operation(summary = "find by faqType id")
    @GetMapping("faqType/id/{id}")
    public List<FaqProfDto> findByFaqTypeId(@PathVariable Long id){
        return findDtos(service.findByFaqTypeId(id));
    }
    @Operation(summary = "delete by faqType id")
    @DeleteMapping("faqType/id/{id}")
    public int deleteByFaqTypeId(@PathVariable Long id){
        return service.deleteByFaqTypeId(id);
    }

    @Operation(summary = "Finds a faqProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FaqProfDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds faqProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FaqProfDto>> findByCriteria(@RequestBody FaqProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated faqProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FaqProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports faqProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FaqProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets faqProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FaqProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FaqProfRestAdmin (FaqProfAdminService service, FaqProfConverter converter) {
        super(service, converter);
    }




}
