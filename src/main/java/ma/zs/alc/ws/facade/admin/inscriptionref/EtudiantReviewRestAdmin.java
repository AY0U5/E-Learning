package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.EtudiantReview;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtudiantReviewCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.EtudiantReviewAdminService;
import ma.zs.alc.ws.converter.inscriptionref.EtudiantReviewConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantReviewDto;
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
@RequestMapping("/api/admin/etudiantReview/")
public class EtudiantReviewRestAdmin  extends AbstractController<EtudiantReview, EtudiantReviewDto, EtudiantReviewCriteria, EtudiantReviewAdminService, EtudiantReviewConverter> {



    @Operation(summary = "upload one etudiantReview")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etudiantReviews")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etudiantReviews")
    @GetMapping("")
    public ResponseEntity<List<EtudiantReviewDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  etudiantReview")
    @PostMapping("")
    public ResponseEntity<EtudiantReviewDto> save(@RequestBody EtudiantReviewDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etudiantReview")
    @PutMapping("")
    public ResponseEntity<EtudiantReviewDto> update(@RequestBody EtudiantReviewDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etudiantReview")
    @PostMapping("multiple")
    public ResponseEntity<List<EtudiantReviewDto>> delete(@RequestBody List<EtudiantReviewDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etudiantReview")
    @DeleteMapping("")
    public ResponseEntity<EtudiantReviewDto> delete(@RequestBody EtudiantReviewDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etudiantReview")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etudiantReviews by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<EtudiantReviewDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<EtudiantReviewDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by cours id")
    @GetMapping("cours/id/{id}")
    public List<EtudiantReviewDto> findByCoursId(@PathVariable Long id){
        return findDtos(service.findByCoursId(id));
    }
    @Operation(summary = "delete by cours id")
    @DeleteMapping("cours/id/{id}")
    public int deleteByCoursId(@PathVariable Long id){
        return service.deleteByCoursId(id);
    }

    @Operation(summary = "Finds a etudiantReview and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtudiantReviewDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etudiantReviews by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtudiantReviewDto>> findByCriteria(@RequestBody EtudiantReviewCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etudiantReviews by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtudiantReviewCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etudiantReviews by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtudiantReviewCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etudiantReview data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtudiantReviewCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtudiantReviewRestAdmin (EtudiantReviewAdminService service, EtudiantReviewConverter converter) {
        super(service, converter);
    }




}
