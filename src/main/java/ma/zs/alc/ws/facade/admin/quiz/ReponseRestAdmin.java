package  ma.zs.alc.ws.facade.admin.quiz;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.dao.criteria.core.quiz.ReponseCriteria;
import ma.zs.alc.service.facade.admin.quiz.ReponseAdminService;
import ma.zs.alc.ws.converter.quiz.ReponseConverter;
import ma.zs.alc.ws.dto.quiz.ReponseDto;
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
@RequestMapping("/api/admin/reponse/")
public class ReponseRestAdmin  extends AbstractController<Reponse, ReponseDto, ReponseCriteria, ReponseAdminService, ReponseConverter> {



    @Operation(summary = "upload one reponse")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reponses")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reponses")
    @GetMapping("")
    public ResponseEntity<List<ReponseDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all reponses")
    @GetMapping("optimized")
    public ResponseEntity<List<ReponseDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a reponse by lib")
    @GetMapping("lib/{lib}")
    public ResponseEntity<ReponseDto> findByLib(@PathVariable String lib) {
        return super.findByReferenceEntity(new Reponse(lib));
    }

    @Operation(summary = "Saves the specified  reponse")
    @PostMapping("")
    public ResponseEntity<ReponseDto> save(@RequestBody ReponseDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reponse")
    @PutMapping("")
    public ResponseEntity<ReponseDto> update(@RequestBody ReponseDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reponse")
    @PostMapping("multiple")
    public ResponseEntity<List<ReponseDto>> delete(@RequestBody List<ReponseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reponse")
    @DeleteMapping("")
    public ResponseEntity<ReponseDto> delete(@RequestBody ReponseDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reponse")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reponses by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by question id")
    @GetMapping("question/id/{id}")
    public List<ReponseDto> findByQuestionId(@PathVariable Long id){
        return findDtos(service.findByQuestionId(id));
    }
    @Operation(summary = "delete by question id")
    @DeleteMapping("question/id/{id}")
    public int deleteByQuestionId(@PathVariable Long id){
        return service.deleteByQuestionId(id);
    }

    @Operation(summary = "Finds a reponse and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReponseDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds reponses by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReponseDto>> findByCriteria(@RequestBody ReponseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reponses by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReponseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reponses by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReponseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reponse data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReponseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReponseRestAdmin (ReponseAdminService service, ReponseConverter converter) {
        super(service, converter);
    }




}
