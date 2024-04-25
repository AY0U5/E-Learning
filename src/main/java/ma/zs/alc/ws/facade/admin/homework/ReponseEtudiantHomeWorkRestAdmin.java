package  ma.zs.alc.ws.facade.admin.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.dao.criteria.core.homework.ReponseEtudiantHomeWorkCriteria;
import ma.zs.alc.service.facade.admin.homework.ReponseEtudiantHomeWorkAdminService;
import ma.zs.alc.ws.converter.homework.ReponseEtudiantHomeWorkConverter;
import ma.zs.alc.ws.dto.homework.ReponseEtudiantHomeWorkDto;
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
@RequestMapping("/api/admin/reponseEtudiantHomeWork/")
public class ReponseEtudiantHomeWorkRestAdmin  extends AbstractController<ReponseEtudiantHomeWork, ReponseEtudiantHomeWorkDto, ReponseEtudiantHomeWorkCriteria, ReponseEtudiantHomeWorkAdminService, ReponseEtudiantHomeWorkConverter> {



    @Operation(summary = "upload one reponseEtudiantHomeWork")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple reponseEtudiantHomeWorks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all reponseEtudiantHomeWorks")
    @GetMapping("")
    public ResponseEntity<List<ReponseEtudiantHomeWorkDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  reponseEtudiantHomeWork")
    @PostMapping("")
    public ResponseEntity<ReponseEtudiantHomeWorkDto> save(@RequestBody ReponseEtudiantHomeWorkDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  reponseEtudiantHomeWork")
    @PutMapping("")
    public ResponseEntity<ReponseEtudiantHomeWorkDto> update(@RequestBody ReponseEtudiantHomeWorkDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of reponseEtudiantHomeWork")
    @PostMapping("multiple")
    public ResponseEntity<List<ReponseEtudiantHomeWorkDto>> delete(@RequestBody List<ReponseEtudiantHomeWorkDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified reponseEtudiantHomeWork")
    @DeleteMapping("")
    public ResponseEntity<ReponseEtudiantHomeWorkDto> delete(@RequestBody ReponseEtudiantHomeWorkDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified reponseEtudiantHomeWork")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple reponseEtudiantHomeWorks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by howeWorkQSTReponse id")
    @GetMapping("howeWorkQSTReponse/id/{id}")
    public List<ReponseEtudiantHomeWorkDto> findByHoweWorkQSTReponseId(@PathVariable Long id){
        return findDtos(service.findByHoweWorkQSTReponseId(id));
    }
    @Operation(summary = "delete by howeWorkQSTReponse id")
    @DeleteMapping("howeWorkQSTReponse/id/{id}")
    public int deleteByHoweWorkQSTReponseId(@PathVariable Long id){
        return service.deleteByHoweWorkQSTReponseId(id);
    }
    @Operation(summary = "find by homeWorkEtudiant id")
    @GetMapping("homeWorkEtudiant/id/{id}")
    public List<ReponseEtudiantHomeWorkDto> findByHomeWorkEtudiantId(@PathVariable Long id){
        return findDtos(service.findByHomeWorkEtudiantId(id));
    }
    @Operation(summary = "delete by homeWorkEtudiant id")
    @DeleteMapping("homeWorkEtudiant/id/{id}")
    public int deleteByHomeWorkEtudiantId(@PathVariable Long id){
        return service.deleteByHomeWorkEtudiantId(id);
    }
    @Operation(summary = "find by homeWorkQuestion id")
    @GetMapping("homeWorkQuestion/id/{id}")
    public List<ReponseEtudiantHomeWorkDto> findByHomeWorkQuestionId(@PathVariable Long id){
        return findDtos(service.findByHomeWorkQuestionId(id));
    }
    @Operation(summary = "delete by homeWorkQuestion id")
    @DeleteMapping("homeWorkQuestion/id/{id}")
    public int deleteByHomeWorkQuestionId(@PathVariable Long id){
        return service.deleteByHomeWorkQuestionId(id);
    }

    @Operation(summary = "Finds a reponseEtudiantHomeWork and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ReponseEtudiantHomeWorkDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds reponseEtudiantHomeWorks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ReponseEtudiantHomeWorkDto>> findByCriteria(@RequestBody ReponseEtudiantHomeWorkCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated reponseEtudiantHomeWorks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ReponseEtudiantHomeWorkCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports reponseEtudiantHomeWorks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ReponseEtudiantHomeWorkCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets reponseEtudiantHomeWork data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ReponseEtudiantHomeWorkCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ReponseEtudiantHomeWorkRestAdmin (ReponseEtudiantHomeWorkAdminService service, ReponseEtudiantHomeWorkConverter converter) {
        super(service, converter);
    }




}
