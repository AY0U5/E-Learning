package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherWhatsTemplate;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialTeacherWhatsTemplateCriteria;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialTeacherWhatsTemplateAdminService;
import ma.zs.alc.ws.converter.freetrial.FreeTrialTeacherWhatsTemplateConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialTeacherWhatsTemplateDto;
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
@RequestMapping("/api/admin/freeTrialTeacherWhatsTemplate/")
public class FreeTrialTeacherWhatsTemplateRestAdmin  extends AbstractController<FreeTrialTeacherWhatsTemplate, FreeTrialTeacherWhatsTemplateDto, FreeTrialTeacherWhatsTemplateCriteria, FreeTrialTeacherWhatsTemplateAdminService, FreeTrialTeacherWhatsTemplateConverter> {



    @Operation(summary = "upload one freeTrialTeacherWhatsTemplate")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple freeTrialTeacherWhatsTemplates")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all freeTrialTeacherWhatsTemplates")
    @GetMapping("")
    public ResponseEntity<List<FreeTrialTeacherWhatsTemplateDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  freeTrialTeacherWhatsTemplate")
    @PostMapping("")
    public ResponseEntity<FreeTrialTeacherWhatsTemplateDto> save(@RequestBody FreeTrialTeacherWhatsTemplateDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  freeTrialTeacherWhatsTemplate")
    @PutMapping("")
    public ResponseEntity<FreeTrialTeacherWhatsTemplateDto> update(@RequestBody FreeTrialTeacherWhatsTemplateDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of freeTrialTeacherWhatsTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<FreeTrialTeacherWhatsTemplateDto>> delete(@RequestBody List<FreeTrialTeacherWhatsTemplateDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified freeTrialTeacherWhatsTemplate")
    @DeleteMapping("")
    public ResponseEntity<FreeTrialTeacherWhatsTemplateDto> delete(@RequestBody FreeTrialTeacherWhatsTemplateDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified freeTrialTeacherWhatsTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple freeTrialTeacherWhatsTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a freeTrialTeacherWhatsTemplate and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FreeTrialTeacherWhatsTemplateDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds freeTrialTeacherWhatsTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FreeTrialTeacherWhatsTemplateDto>> findByCriteria(@RequestBody FreeTrialTeacherWhatsTemplateCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated freeTrialTeacherWhatsTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FreeTrialTeacherWhatsTemplateCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports freeTrialTeacherWhatsTemplates by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FreeTrialTeacherWhatsTemplateCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets freeTrialTeacherWhatsTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FreeTrialTeacherWhatsTemplateCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FreeTrialTeacherWhatsTemplateRestAdmin (FreeTrialTeacherWhatsTemplateAdminService service, FreeTrialTeacherWhatsTemplateConverter converter) {
        super(service, converter);
    }




}
