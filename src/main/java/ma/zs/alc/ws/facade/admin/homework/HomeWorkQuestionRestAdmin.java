package  ma.zs.alc.ws.facade.admin.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.dao.criteria.core.homework.HomeWorkQuestionCriteria;
import ma.zs.alc.service.facade.admin.homework.HomeWorkQuestionAdminService;
import ma.zs.alc.ws.converter.homework.HomeWorkQuestionConverter;
import ma.zs.alc.ws.dto.homework.HomeWorkQuestionDto;
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
@RequestMapping("/api/admin/homeWorkQuestion/")
public class HomeWorkQuestionRestAdmin  extends AbstractController<HomeWorkQuestion, HomeWorkQuestionDto, HomeWorkQuestionCriteria, HomeWorkQuestionAdminService, HomeWorkQuestionConverter> {



    @Operation(summary = "upload one homeWorkQuestion")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple homeWorkQuestions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all homeWorkQuestions")
    @GetMapping("")
    public ResponseEntity<List<HomeWorkQuestionDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all homeWorkQuestions")
    @GetMapping("optimized")
    public ResponseEntity<List<HomeWorkQuestionDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a homeWorkQuestion by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<HomeWorkQuestionDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new HomeWorkQuestion(libelle));
    }

    @Operation(summary = "Saves the specified  homeWorkQuestion")
    @PostMapping("")
    public ResponseEntity<HomeWorkQuestionDto> save(@RequestBody HomeWorkQuestionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  homeWorkQuestion")
    @PutMapping("")
    public ResponseEntity<HomeWorkQuestionDto> update(@RequestBody HomeWorkQuestionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of homeWorkQuestion")
    @PostMapping("multiple")
    public ResponseEntity<List<HomeWorkQuestionDto>> delete(@RequestBody List<HomeWorkQuestionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified homeWorkQuestion")
    @DeleteMapping("")
    public ResponseEntity<HomeWorkQuestionDto> delete(@RequestBody HomeWorkQuestionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified homeWorkQuestion")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple homeWorkQuestions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by typeDeQuestion id")
    @GetMapping("typeDeQuestion/id/{id}")
    public List<HomeWorkQuestionDto> findByTypeDeQuestionId(@PathVariable Long id){
        return findDtos(service.findByTypeDeQuestionId(id));
    }
    @Operation(summary = "delete by typeDeQuestion id")
    @DeleteMapping("typeDeQuestion/id/{id}")
    public int deleteByTypeDeQuestionId(@PathVariable Long id){
        return service.deleteByTypeDeQuestionId(id);
    }
    @Operation(summary = "find by homeWork id")
    @GetMapping("homeWork/id/{id}")
    public List<HomeWorkQuestionDto> findByHomeWorkId(@PathVariable Long id){
        return findDtos(service.findByHomeWorkId(id));
    }
    @Operation(summary = "delete by homeWork id")
    @DeleteMapping("homeWork/id/{id}")
    public int deleteByHomeWorkId(@PathVariable Long id){
        return service.deleteByHomeWorkId(id);
    }

    @Operation(summary = "Finds a homeWorkQuestion and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<HomeWorkQuestionDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds homeWorkQuestions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<HomeWorkQuestionDto>> findByCriteria(@RequestBody HomeWorkQuestionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated homeWorkQuestions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody HomeWorkQuestionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports homeWorkQuestions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody HomeWorkQuestionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets homeWorkQuestion data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody HomeWorkQuestionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public HomeWorkQuestionRestAdmin (HomeWorkQuestionAdminService service, HomeWorkQuestionConverter converter) {
        super(service, converter);
    }




}
