package  ma.zs.alc.ws.facade.admin.quizetudiant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.dao.criteria.core.quizetudiant.QuizEtudiantCriteria;
import ma.zs.alc.service.facade.admin.quizetudiant.QuizEtudiantAdminService;
import ma.zs.alc.ws.converter.quizetudiant.QuizEtudiantConverter;
import ma.zs.alc.ws.dto.quizetudiant.QuizEtudiantDto;
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
@RequestMapping("/api/admin/quizEtudiant/")
public class QuizEtudiantRestAdmin  extends AbstractController<QuizEtudiant, QuizEtudiantDto, QuizEtudiantCriteria, QuizEtudiantAdminService, QuizEtudiantConverter> {



    @Operation(summary = "upload one quizEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple quizEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all quizEtudiants")
    @GetMapping("")
    public ResponseEntity<List<QuizEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all quizEtudiants")
    @GetMapping("optimized")
    public ResponseEntity<List<QuizEtudiantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a quizEtudiant by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<QuizEtudiantDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new QuizEtudiant(ref));
    }

    @Operation(summary = "Saves the specified  quizEtudiant")
    @PostMapping("")
    public ResponseEntity<QuizEtudiantDto> save(@RequestBody QuizEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  quizEtudiant")
    @PutMapping("")
    public ResponseEntity<QuizEtudiantDto> update(@RequestBody QuizEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of quizEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<QuizEtudiantDto>> delete(@RequestBody List<QuizEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified quizEtudiant")
    @DeleteMapping("")
    public ResponseEntity<QuizEtudiantDto> delete(@RequestBody QuizEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified quizEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple quizEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<QuizEtudiantDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by quiz id")
    @GetMapping("quiz/id/{id}")
    public List<QuizEtudiantDto> findByQuizId(@PathVariable Long id){
        return findDtos(service.findByQuizId(id));
    }
    @Operation(summary = "delete by quiz id")
    @DeleteMapping("quiz/id/{id}")
    public int deleteByQuizId(@PathVariable Long id){
        return service.deleteByQuizId(id);
    }

    @Operation(summary = "Finds a quizEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<QuizEtudiantDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds quizEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<QuizEtudiantDto>> findByCriteria(@RequestBody QuizEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated quizEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody QuizEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports quizEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody QuizEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets quizEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody QuizEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public QuizEtudiantRestAdmin (QuizEtudiantAdminService service, QuizEtudiantConverter converter) {
        super(service, converter);
    }




}
