package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherEmailTemplate;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialTeacherEmailTemplateCriteria;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialTeacherEmailTemplateAdminService;
import ma.zs.alc.ws.converter.freetrial.FreeTrialTeacherEmailTemplateConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialTeacherEmailTemplateDto;
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
@RequestMapping("/api/admin/freeTrialTeacherEmailTemplate/")
public class FreeTrialTeacherEmailTemplateRestAdmin  extends AbstractController<FreeTrialTeacherEmailTemplate, FreeTrialTeacherEmailTemplateDto, FreeTrialTeacherEmailTemplateCriteria, FreeTrialTeacherEmailTemplateAdminService, FreeTrialTeacherEmailTemplateConverter> {



    @Operation(summary = "upload one freeTrialTeacherEmailTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple freeTrialTeacherEmailTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all freeTrialTeacherEmailTemplates")
    @GetMapping("")
    public ResponseEntity<List<FreeTrialTeacherEmailTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  freeTrialTeacherEmailTemplate")
    @PostMapping("")
    public ResponseEntity<FreeTrialTeacherEmailTemplateDto> save(@RequestBody FreeTrialTeacherEmailTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  freeTrialTeacherEmailTemplate")
    @PutMapping("")
    public ResponseEntity<FreeTrialTeacherEmailTemplateDto> update(@RequestBody FreeTrialTeacherEmailTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of freeTrialTeacherEmailTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<FreeTrialTeacherEmailTemplateDto>> delete(@RequestBody List<FreeTrialTeacherEmailTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified freeTrialTeacherEmailTemplate")
    @DeleteMapping("")
    public ResponseEntity<FreeTrialTeacherEmailTemplateDto> delete(@RequestBody FreeTrialTeacherEmailTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified freeTrialTeacherEmailTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple freeTrialTeacherEmailTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a freeTrialTeacherEmailTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FreeTrialTeacherEmailTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds freeTrialTeacherEmailTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FreeTrialTeacherEmailTemplateDto>> findByCriteria(@RequestBody FreeTrialTeacherEmailTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated freeTrialTeacherEmailTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FreeTrialTeacherEmailTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports freeTrialTeacherEmailTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FreeTrialTeacherEmailTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets freeTrialTeacherEmailTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FreeTrialTeacherEmailTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FreeTrialTeacherEmailTemplateRestAdmin (FreeTrialTeacherEmailTemplateAdminService service, FreeTrialTeacherEmailTemplateConverter converter) {
        super(service, converter);
    }




}
