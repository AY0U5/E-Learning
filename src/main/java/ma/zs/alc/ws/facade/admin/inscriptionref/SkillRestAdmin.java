package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.dao.criteria.core.inscriptionref.SkillCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.SkillAdminService;
import ma.zs.alc.ws.converter.inscriptionref.SkillConverter;
import ma.zs.alc.ws.dto.inscriptionref.SkillDto;
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
@RequestMapping("/api/admin/skill/")
public class SkillRestAdmin  extends AbstractController<Skill, SkillDto, SkillCriteria, SkillAdminService, SkillConverter> {



    @Operation(summary = "upload one skill")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple skills")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all skills")
    @GetMapping("")
    public ResponseEntity<List<SkillDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all skills")
    @GetMapping("optimized")
    public ResponseEntity<List<SkillDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a skill by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<SkillDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Skill(libelle));
    }

    @Operation(summary = "Saves the specified  skill")
    @PostMapping("")
    public ResponseEntity<SkillDto> save(@RequestBody SkillDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  skill")
    @PutMapping("")
    public ResponseEntity<SkillDto> update(@RequestBody SkillDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of skill")
    @PostMapping("multiple")
    public ResponseEntity<List<SkillDto>> delete(@RequestBody List<SkillDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified skill")
    @DeleteMapping("")
    public ResponseEntity<SkillDto> delete(@RequestBody SkillDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified skill")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple skills by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a skill and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SkillDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds skills by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SkillDto>> findByCriteria(@RequestBody SkillCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated skills by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SkillCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports skills by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SkillCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets skill data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SkillCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SkillRestAdmin (SkillAdminService service, SkillConverter converter) {
        super(service, converter);
    }




}
