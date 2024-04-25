package  ma.zs.alc.ws.facade.admin.quizetudiant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.dao.criteria.core.quizetudiant.ReponseEtudiantCriteria;
import ma.zs.alc.service.facade.admin.quizetudiant.ReponseEtudiantAdminService;
import ma.zs.alc.ws.converter.quizetudiant.ReponseEtudiantConverter;
import ma.zs.alc.ws.dto.quizetudiant.ReponseEtudiantDto;
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
@RequestMapping("/api/admin/reponseEtudiant/")
public class ReponseEtudiantRestAdmin  extends AbstractController<ReponseEtudiant, ReponseEtudiantDto, ReponseEtudiantCriteria, ReponseEtudiantAdminService, ReponseEtudiantConverter> {



    @Operation(summary = "upload one reponseEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reponseEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reponseEtudiants")
    @GetMapping("")
    public ResponseEntity<List<ReponseEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reponseEtudiants")
    @GetMapping("optimized")
    public ResponseEntity<List<ReponseEtudiantDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reponseEtudiant by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<ReponseEtudiantDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new ReponseEtudiant(ref));
    }

    @Operation(summary = "Saves the specified  reponseEtudiant")
    @PostMapping("")
    public ResponseEntity<ReponseEtudiantDto> save(@RequestBody ReponseEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reponseEtudiant")
    @PutMapping("")
    public ResponseEntity<ReponseEtudiantDto> update(@RequestBody ReponseEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reponseEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<ReponseEtudiantDto>> delete(@RequestBody List<ReponseEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reponseEtudiant")
    @DeleteMapping("")
    public ResponseEntity<ReponseEtudiantDto> delete(@RequestBody ReponseEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reponseEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reponseEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by reponse id")
    @GetMapping("reponse/id/{id}")
    public List<ReponseEtudiantDto> findByReponseId(@PathVariable Long id){
        return findDtos(service.findByReponseId(id));
    }
    @Operation(summary = "delete by reponse id")
    @DeleteMapping("reponse/id/{id}")
    public int deleteByReponseId(@PathVariable Long id){
        return service.deleteByReponseId(id);
    }
    @Operation(summary = "find by quizEtudiant id")
    @GetMapping("quizEtudiant/id/{id}")
    public List<ReponseEtudiantDto> findByQuizEtudiantId(@PathVariable Long id){
        return findDtos(service.findByQuizEtudiantId(id));
    }
    @Operation(summary = "delete by quizEtudiant id")
    @DeleteMapping("quizEtudiant/id/{id}")
    public int deleteByQuizEtudiantId(@PathVariable Long id){
        return service.deleteByQuizEtudiantId(id);
    }
    @Operation(summary = "find by question id")
    @GetMapping("question/id/{id}")
    public List<ReponseEtudiantDto> findByQuestionId(@PathVariable Long id){
        return findDtos(service.findByQuestionId(id));
    }
    @Operation(summary = "delete by question id")
    @DeleteMapping("question/id/{id}")
    public int deleteByQuestionId(@PathVariable Long id){
        return service.deleteByQuestionId(id);
    }

    @Operation(summary = "Finds a reponseEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReponseEtudiantDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds reponseEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReponseEtudiantDto>> findByCriteria(@RequestBody ReponseEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reponseEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReponseEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reponseEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReponseEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reponseEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReponseEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReponseEtudiantRestAdmin (ReponseEtudiantAdminService service, ReponseEtudiantConverter converter) {
        super(service, converter);
    }




}
