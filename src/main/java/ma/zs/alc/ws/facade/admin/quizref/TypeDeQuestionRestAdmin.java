package  ma.zs.alc.ws.facade.admin.quizref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.dao.criteria.core.quizref.TypeDeQuestionCriteria;
import ma.zs.alc.service.facade.admin.quizref.TypeDeQuestionAdminService;
import ma.zs.alc.ws.converter.quizref.TypeDeQuestionConverter;
import ma.zs.alc.ws.dto.quizref.TypeDeQuestionDto;
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
@RequestMapping("/api/admin/typeDeQuestion/")
public class TypeDeQuestionRestAdmin  extends AbstractController<TypeDeQuestion, TypeDeQuestionDto, TypeDeQuestionCriteria, TypeDeQuestionAdminService, TypeDeQuestionConverter> {



    @Operation(summary = "upload one typeDeQuestion")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeDeQuestions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeDeQuestions")
    @GetMapping("")
    public ResponseEntity<List<TypeDeQuestionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeDeQuestions")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeDeQuestionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeDeQuestion by lib")
    @GetMapping("lib/{lib}")
    public ResponseEntity<TypeDeQuestionDto> findByLib(@PathVariable String lib) {
        return super.findByReferenceEntity(new TypeDeQuestion(lib));
    }

    @Operation(summary = "Saves the specified  typeDeQuestion")
    @PostMapping("")
    public ResponseEntity<TypeDeQuestionDto> save(@RequestBody TypeDeQuestionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeDeQuestion")
    @PutMapping("")
    public ResponseEntity<TypeDeQuestionDto> update(@RequestBody TypeDeQuestionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeDeQuestion")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeDeQuestionDto>> delete(@RequestBody List<TypeDeQuestionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeDeQuestion")
    @DeleteMapping("")
    public ResponseEntity<TypeDeQuestionDto> delete(@RequestBody TypeDeQuestionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeDeQuestion")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeDeQuestions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeDeQuestion and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeDeQuestionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeDeQuestions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeDeQuestionDto>> findByCriteria(@RequestBody TypeDeQuestionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeDeQuestions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeDeQuestionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeDeQuestions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeDeQuestionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeDeQuestion data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeDeQuestionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeDeQuestionRestAdmin (TypeDeQuestionAdminService service, TypeDeQuestionConverter converter) {
        super(service, converter);
    }




}
