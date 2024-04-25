package  ma.zs.alc.ws.facade.admin.courseref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.courseref.LevelTestConfiguration;
import ma.zs.alc.dao.criteria.core.courseref.LevelTestConfigurationCriteria;
import ma.zs.alc.service.facade.admin.courseref.LevelTestConfigurationAdminService;
import ma.zs.alc.ws.converter.courseref.LevelTestConfigurationConverter;
import ma.zs.alc.ws.dto.courseref.LevelTestConfigurationDto;
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
@RequestMapping("/api/admin/levelTestConfiguration/")
public class LevelTestConfigurationRestAdmin  extends AbstractController<LevelTestConfiguration, LevelTestConfigurationDto, LevelTestConfigurationCriteria, LevelTestConfigurationAdminService, LevelTestConfigurationConverter> {



    @Operation(summary = "upload one levelTestConfiguration")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple levelTestConfigurations")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all levelTestConfigurations")
    @GetMapping("")
    public ResponseEntity<List<LevelTestConfigurationDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  levelTestConfiguration")
    @PostMapping("")
    public ResponseEntity<LevelTestConfigurationDto> save(@RequestBody LevelTestConfigurationDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  levelTestConfiguration")
    @PutMapping("")
    public ResponseEntity<LevelTestConfigurationDto> update(@RequestBody LevelTestConfigurationDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of levelTestConfiguration")
    @PostMapping("multiple")
    public ResponseEntity<List<LevelTestConfigurationDto>> delete(@RequestBody List<LevelTestConfigurationDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified levelTestConfiguration")
    @DeleteMapping("")
    public ResponseEntity<LevelTestConfigurationDto> delete(@RequestBody LevelTestConfigurationDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified levelTestConfiguration")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple levelTestConfigurations by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by parcours id")
    @GetMapping("parcours/id/{id}")
    public List<LevelTestConfigurationDto> findByParcoursId(@PathVariable Long id){
        return findDtos(service.findByParcoursId(id));
    }
    @Operation(summary = "delete by parcours id")
    @DeleteMapping("parcours/id/{id}")
    public int deleteByParcoursId(@PathVariable Long id){
        return service.deleteByParcoursId(id);
    }

    @Operation(summary = "Finds a levelTestConfiguration and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<LevelTestConfigurationDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds levelTestConfigurations by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<LevelTestConfigurationDto>> findByCriteria(@RequestBody LevelTestConfigurationCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated levelTestConfigurations by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody LevelTestConfigurationCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports levelTestConfigurations by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody LevelTestConfigurationCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets levelTestConfiguration data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody LevelTestConfigurationCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public LevelTestConfigurationRestAdmin (LevelTestConfigurationAdminService service, LevelTestConfigurationConverter converter) {
        super(service, converter);
    }




}
