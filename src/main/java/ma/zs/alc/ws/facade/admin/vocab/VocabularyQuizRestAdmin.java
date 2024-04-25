package  ma.zs.alc.ws.facade.admin.vocab;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.dao.criteria.core.vocab.VocabularyQuizCriteria;
import ma.zs.alc.service.facade.admin.vocab.VocabularyQuizAdminService;
import ma.zs.alc.ws.converter.vocab.VocabularyQuizConverter;
import ma.zs.alc.ws.dto.vocab.VocabularyQuizDto;
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
@RequestMapping("/api/admin/vocabularyQuiz/")
public class VocabularyQuizRestAdmin  extends AbstractController<VocabularyQuiz, VocabularyQuizDto, VocabularyQuizCriteria, VocabularyQuizAdminService, VocabularyQuizConverter> {



    @Operation(summary = "upload one vocabularyQuiz")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple vocabularyQuizs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all vocabularyQuizs")
    @GetMapping("")
    public ResponseEntity<List<VocabularyQuizDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all vocabularyQuizs")
    @GetMapping("optimized")
    public ResponseEntity<List<VocabularyQuizDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a vocabularyQuiz by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<VocabularyQuizDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new VocabularyQuiz(libelle));
    }

    @Operation(summary = "Saves the specified  vocabularyQuiz")
    @PostMapping("")
    public ResponseEntity<VocabularyQuizDto> save(@RequestBody VocabularyQuizDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  vocabularyQuiz")
    @PutMapping("")
    public ResponseEntity<VocabularyQuizDto> update(@RequestBody VocabularyQuizDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of vocabularyQuiz")
    @PostMapping("multiple")
    public ResponseEntity<List<VocabularyQuizDto>> delete(@RequestBody List<VocabularyQuizDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified vocabularyQuiz")
    @DeleteMapping("")
    public ResponseEntity<VocabularyQuizDto> delete(@RequestBody VocabularyQuizDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified vocabularyQuiz")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple vocabularyQuizs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by section id")
    @GetMapping("section/id/{id}")
    public List<VocabularyQuizDto> findBySectionId(@PathVariable Long id){
        return findDtos(service.findBySectionId(id));
    }
    @Operation(summary = "delete by section id")
    @DeleteMapping("section/id/{id}")
    public int deleteBySectionId(@PathVariable Long id){
        return service.deleteBySectionId(id);
    }

    @Operation(summary = "Finds a vocabularyQuiz and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VocabularyQuizDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds vocabularyQuizs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VocabularyQuizDto>> findByCriteria(@RequestBody VocabularyQuizCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated vocabularyQuizs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VocabularyQuizCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports vocabularyQuizs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VocabularyQuizCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets vocabularyQuiz data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VocabularyQuizCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public VocabularyQuizRestAdmin (VocabularyQuizAdminService service, VocabularyQuizConverter converter) {
        super(service, converter);
    }




}
