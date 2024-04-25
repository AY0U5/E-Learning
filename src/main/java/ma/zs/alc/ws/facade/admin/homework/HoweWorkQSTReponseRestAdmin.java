package  ma.zs.alc.ws.facade.admin.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.dao.criteria.core.homework.HoweWorkQSTReponseCriteria;
import ma.zs.alc.service.facade.admin.homework.HoweWorkQSTReponseAdminService;
import ma.zs.alc.ws.converter.homework.HoweWorkQSTReponseConverter;
import ma.zs.alc.ws.dto.homework.HoweWorkQSTReponseDto;
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
@RequestMapping("/api/admin/howeWorkQSTReponse/")
public class HoweWorkQSTReponseRestAdmin  extends AbstractController<HoweWorkQSTReponse, HoweWorkQSTReponseDto, HoweWorkQSTReponseCriteria, HoweWorkQSTReponseAdminService, HoweWorkQSTReponseConverter> {



    @Operation(summary = "upload one howeWorkQSTReponse")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple howeWorkQSTReponses")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all howeWorkQSTReponses")
    @GetMapping("")
    public ResponseEntity<List<HoweWorkQSTReponseDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all howeWorkQSTReponses")
    @GetMapping("optimized")
    public ResponseEntity<List<HoweWorkQSTReponseDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a howeWorkQSTReponse by lib")
    @GetMapping("lib/{lib}")
    public ResponseEntity<HoweWorkQSTReponseDto> findByLib(@PathVariable String lib) {
        return super.findByReferenceEntity(new HoweWorkQSTReponse(lib));
    }

    @Operation(summary = "Saves the specified  howeWorkQSTReponse")
    @PostMapping("")
    public ResponseEntity<HoweWorkQSTReponseDto> save(@RequestBody HoweWorkQSTReponseDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  howeWorkQSTReponse")
    @PutMapping("")
    public ResponseEntity<HoweWorkQSTReponseDto> update(@RequestBody HoweWorkQSTReponseDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of howeWorkQSTReponse")
    @PostMapping("multiple")
    public ResponseEntity<List<HoweWorkQSTReponseDto>> delete(@RequestBody List<HoweWorkQSTReponseDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified howeWorkQSTReponse")
    @DeleteMapping("")
    public ResponseEntity<HoweWorkQSTReponseDto> delete(@RequestBody HoweWorkQSTReponseDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified howeWorkQSTReponse")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple howeWorkQSTReponses by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by homeWorkQuestion id")
    @GetMapping("homeWorkQuestion/id/{id}")
    public List<HoweWorkQSTReponseDto> findByHomeWorkQuestionId(@PathVariable Long id){
        return findDtos(service.findByHomeWorkQuestionId(id));
    }
    @Operation(summary = "delete by homeWorkQuestion id")
    @DeleteMapping("homeWorkQuestion/id/{id}")
    public int deleteByHomeWorkQuestionId(@PathVariable Long id){
        return service.deleteByHomeWorkQuestionId(id);
    }

    @Operation(summary = "Finds a howeWorkQSTReponse and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<HoweWorkQSTReponseDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds howeWorkQSTReponses by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<HoweWorkQSTReponseDto>> findByCriteria(@RequestBody HoweWorkQSTReponseCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated howeWorkQSTReponses by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody HoweWorkQSTReponseCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports howeWorkQSTReponses by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody HoweWorkQSTReponseCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets howeWorkQSTReponse data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody HoweWorkQSTReponseCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public HoweWorkQSTReponseRestAdmin (HoweWorkQSTReponseAdminService service, HoweWorkQSTReponseConverter converter) {
        super(service, converter);
    }




}
