package  ma.zs.alc.ws.facade.admin.quiz;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.dao.criteria.core.quiz.QuestionCriteria;
import ma.zs.alc.service.facade.admin.quiz.QuestionAdminService;
import ma.zs.alc.ws.converter.quiz.QuestionConverter;
import ma.zs.alc.ws.dto.quiz.QuestionDto;
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
@RequestMapping("/api/admin/question/")
public class QuestionRestAdmin  extends AbstractController<Question, QuestionDto, QuestionCriteria, QuestionAdminService, QuestionConverter> {



    @Operation(summary = "upload one question")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple questions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all questions")
    @GetMapping("")
    public ResponseEntity<List<QuestionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all questions")
    @GetMapping("optimized")
    public ResponseEntity<List<QuestionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a question by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<QuestionDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Question(libelle));
    }

    @Operation(summary = "Saves the specified  question")
    @PostMapping("")
    public ResponseEntity<QuestionDto> save(@RequestBody QuestionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  question")
    @PutMapping("")
    public ResponseEntity<QuestionDto> update(@RequestBody QuestionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of question")
    @PostMapping("multiple")
    public ResponseEntity<List<QuestionDto>> delete(@RequestBody List<QuestionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified question")
    @DeleteMapping("")
    public ResponseEntity<QuestionDto> delete(@RequestBody QuestionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified question")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple questions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeDeQuestion id")
    @GetMapping("typeDeQuestion/id/{id}")
    public List<QuestionDto> findByTypeDeQuestionId(@PathVariable Long id){
        return findDtos(service.findByTypeDeQuestionId(id));
    }
    @Operation(summary = "delete by typeDeQuestion id")
    @DeleteMapping("typeDeQuestion/id/{id}")
    public int deleteByTypeDeQuestionId(@PathVariable Long id){
        return service.deleteByTypeDeQuestionId(id);
    }
    @Operation(summary = "find by quiz id")
    @GetMapping("quiz/id/{id}")
    public List<QuestionDto> findByQuizId(@PathVariable Long id){
        return findDtos(service.findByQuizId(id));
    }
    @Operation(summary = "delete by quiz id")
    @DeleteMapping("quiz/id/{id}")
    public int deleteByQuizId(@PathVariable Long id){
        return service.deleteByQuizId(id);
    }
    @Operation(summary = "find by homeWork id")
    @GetMapping("homeWork/id/{id}")
    public List<QuestionDto> findByHomeWorkId(@PathVariable Long id){
        return findDtos(service.findByHomeWorkId(id));
    }
    @Operation(summary = "delete by homeWork id")
    @DeleteMapping("homeWork/id/{id}")
    public int deleteByHomeWorkId(@PathVariable Long id){
        return service.deleteByHomeWorkId(id);
    }

    @Operation(summary = "Finds a question and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<QuestionDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds questions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<QuestionDto>> findByCriteria(@RequestBody QuestionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated questions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody QuestionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports questions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody QuestionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets question data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody QuestionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public QuestionRestAdmin (QuestionAdminService service, QuestionConverter converter) {
        super(service, converter);
    }




}
