package  ma.zs.alc.ws.facade.admin.faq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.faq.FaqEtudiant;
import ma.zs.alc.dao.criteria.core.faq.FaqEtudiantCriteria;
import ma.zs.alc.service.facade.admin.faq.FaqEtudiantAdminService;
import ma.zs.alc.ws.converter.faq.FaqEtudiantConverter;
import ma.zs.alc.ws.dto.faq.FaqEtudiantDto;
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
@RequestMapping("/api/admin/faqEtudiant/")
public class FaqEtudiantRestAdmin  extends AbstractController<FaqEtudiant, FaqEtudiantDto, FaqEtudiantCriteria, FaqEtudiantAdminService, FaqEtudiantConverter> {



    @Operation(summary = "upload one faqEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple faqEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all faqEtudiants")
    @GetMapping("")
    public ResponseEntity<List<FaqEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all faqEtudiants")
    @GetMapping("optimized")
    public ResponseEntity<List<FaqEtudiantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a faqEtudiant by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<FaqEtudiantDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new FaqEtudiant(libelle));
    }

    @Operation(summary = "Saves the specified  faqEtudiant")
    @PostMapping("")
    public ResponseEntity<FaqEtudiantDto> save(@RequestBody FaqEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  faqEtudiant")
    @PutMapping("")
    public ResponseEntity<FaqEtudiantDto> update(@RequestBody FaqEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of faqEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<FaqEtudiantDto>> delete(@RequestBody List<FaqEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified faqEtudiant")
    @DeleteMapping("")
    public ResponseEntity<FaqEtudiantDto> delete(@RequestBody FaqEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified faqEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple faqEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<FaqEtudiantDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by admin id")
    @GetMapping("admin/id/{id}")
    public List<FaqEtudiantDto> findByAdminId(@PathVariable Long id){
        return findDtos(service.findByAdminId(id));
    }
    @Operation(summary = "delete by admin id")
    @DeleteMapping("admin/id/{id}")
    public int deleteByAdminId(@PathVariable Long id){
        return service.deleteByAdminId(id);
    }
    @Operation(summary = "find by faqType id")
    @GetMapping("faqType/id/{id}")
    public List<FaqEtudiantDto> findByFaqTypeId(@PathVariable Long id){
        return findDtos(service.findByFaqTypeId(id));
    }
    @Operation(summary = "delete by faqType id")
    @DeleteMapping("faqType/id/{id}")
    public int deleteByFaqTypeId(@PathVariable Long id){
        return service.deleteByFaqTypeId(id);
    }

    @Operation(summary = "Finds a faqEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FaqEtudiantDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds faqEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FaqEtudiantDto>> findByCriteria(@RequestBody FaqEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated faqEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FaqEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports faqEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FaqEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets faqEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FaqEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FaqEtudiantRestAdmin (FaqEtudiantAdminService service, FaqEtudiantConverter converter) {
        super(service, converter);
    }




}
