package  ma.zs.alc.ws.facade.admin.review;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.review.ProfReview;
import ma.zs.alc.dao.criteria.core.review.ProfReviewCriteria;
import ma.zs.alc.service.facade.admin.review.ProfReviewAdminService;
import ma.zs.alc.ws.converter.review.ProfReviewConverter;
import ma.zs.alc.ws.dto.review.ProfReviewDto;
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
@RequestMapping("/api/admin/profReview/")
public class ProfReviewRestAdmin  extends AbstractController<ProfReview, ProfReviewDto, ProfReviewCriteria, ProfReviewAdminService, ProfReviewConverter> {



    @Operation(summary = "upload one profReview")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple profReviews")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all profReviews")
    @GetMapping("")
    public ResponseEntity<List<ProfReviewDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  profReview")
    @PostMapping("")
    public ResponseEntity<ProfReviewDto> save(@RequestBody ProfReviewDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  profReview")
    @PutMapping("")
    public ResponseEntity<ProfReviewDto> update(@RequestBody ProfReviewDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of profReview")
    @PostMapping("multiple")
    public ResponseEntity<List<ProfReviewDto>> delete(@RequestBody List<ProfReviewDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified profReview")
    @DeleteMapping("")
    public ResponseEntity<ProfReviewDto> delete(@RequestBody ProfReviewDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified profReview")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple profReviews by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<ProfReviewDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<ProfReviewDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by cours id")
    @GetMapping("cours/id/{id}")
    public List<ProfReviewDto> findByCoursId(@PathVariable Long id){
        return findDtos(service.findByCoursId(id));
    }
    @Operation(summary = "delete by cours id")
    @DeleteMapping("cours/id/{id}")
    public int deleteByCoursId(@PathVariable Long id){
        return service.deleteByCoursId(id);
    }

    @Operation(summary = "Finds a profReview and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProfReviewDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds profReviews by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProfReviewDto>> findByCriteria(@RequestBody ProfReviewCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated profReviews by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProfReviewCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports profReviews by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProfReviewCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets profReview data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProfReviewCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProfReviewRestAdmin (ProfReviewAdminService service, ProfReviewConverter converter) {
        super(service, converter);
    }




}
