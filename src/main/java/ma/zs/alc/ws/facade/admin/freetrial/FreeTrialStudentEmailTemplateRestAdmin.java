package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialStudentEmailTemplateCriteria;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialStudentEmailTemplateAdminService;
import ma.zs.alc.ws.converter.freetrial.FreeTrialStudentEmailTemplateConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialStudentEmailTemplateDto;
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
@RequestMapping("/api/admin/freeTrialStudentEmailTemplate/")
public class FreeTrialStudentEmailTemplateRestAdmin  extends AbstractController<FreeTrialStudentEmailTemplate, FreeTrialStudentEmailTemplateDto, FreeTrialStudentEmailTemplateCriteria, FreeTrialStudentEmailTemplateAdminService, FreeTrialStudentEmailTemplateConverter> {



    @Operation(summary = "upload one freeTrialStudentEmailTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple freeTrialStudentEmailTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all freeTrialStudentEmailTemplates")
    @GetMapping("")
    public ResponseEntity<List<FreeTrialStudentEmailTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  freeTrialStudentEmailTemplate")
    @PostMapping("")
    public ResponseEntity<FreeTrialStudentEmailTemplateDto> save(@RequestBody FreeTrialStudentEmailTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  freeTrialStudentEmailTemplate")
    @PutMapping("")
    public ResponseEntity<FreeTrialStudentEmailTemplateDto> update(@RequestBody FreeTrialStudentEmailTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of freeTrialStudentEmailTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<FreeTrialStudentEmailTemplateDto>> delete(@RequestBody List<FreeTrialStudentEmailTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified freeTrialStudentEmailTemplate")
    @DeleteMapping("")
    public ResponseEntity<FreeTrialStudentEmailTemplateDto> delete(@RequestBody FreeTrialStudentEmailTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified freeTrialStudentEmailTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple freeTrialStudentEmailTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a freeTrialStudentEmailTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FreeTrialStudentEmailTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds freeTrialStudentEmailTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FreeTrialStudentEmailTemplateDto>> findByCriteria(@RequestBody FreeTrialStudentEmailTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated freeTrialStudentEmailTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FreeTrialStudentEmailTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports freeTrialStudentEmailTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FreeTrialStudentEmailTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets freeTrialStudentEmailTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FreeTrialStudentEmailTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FreeTrialStudentEmailTemplateRestAdmin (FreeTrialStudentEmailTemplateAdminService service, FreeTrialStudentEmailTemplateConverter converter) {
        super(service, converter);
    }




}
