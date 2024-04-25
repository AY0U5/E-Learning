package  ma.zs.alc.ws.facade.admin.freetrial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.freetrial.FreeTrial;
import ma.zs.alc.dao.criteria.core.freetrial.FreeTrialCriteria;
import ma.zs.alc.service.facade.admin.freetrial.FreeTrialAdminService;
import ma.zs.alc.ws.converter.freetrial.FreeTrialConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialDto;
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
@RequestMapping("/api/admin/freeTrial/")
public class FreeTrialRestAdmin  extends AbstractController<FreeTrial, FreeTrialDto, FreeTrialCriteria, FreeTrialAdminService, FreeTrialConverter> {



    @Operation(summary = "upload one freeTrial")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple freeTrials")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all freeTrials")
    @GetMapping("")
    public ResponseEntity<List<FreeTrialDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all freeTrials")
    @GetMapping("optimized")
    public ResponseEntity<List<FreeTrialDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a freeTrial by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<FreeTrialDto> findByReference(@PathVariable String reference) {
        return super.findByReferenceEntity(new FreeTrial(reference));
    }

    @Operation(summary = "Saves the specified  freeTrial")
    @PostMapping("")
    public ResponseEntity<FreeTrialDto> save(@RequestBody FreeTrialDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  freeTrial")
    @PutMapping("")
    public ResponseEntity<FreeTrialDto> update(@RequestBody FreeTrialDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of freeTrial")
    @PostMapping("multiple")
    public ResponseEntity<List<FreeTrialDto>> delete(@RequestBody List<FreeTrialDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified freeTrial")
    @DeleteMapping("")
    public ResponseEntity<FreeTrialDto> delete(@RequestBody FreeTrialDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified freeTrial")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple freeTrials by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<FreeTrialDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by niveauEtude id")
    @GetMapping("niveauEtude/id/{id}")
    public List<FreeTrialDto> findByNiveauEtudeId(@PathVariable Long id){
        return findDtos(service.findByNiveauEtudeId(id));
    }
    @Operation(summary = "delete by niveauEtude id")
    @DeleteMapping("niveauEtude/id/{id}")
    public int deleteByNiveauEtudeId(@PathVariable Long id){
        return service.deleteByNiveauEtudeId(id);
    }
    @Operation(summary = "find by freeTrialStudentWhatsTemplate id")
    @GetMapping("freeTrialStudentWhatsTemplate/id/{id}")
    public List<FreeTrialDto> findByFreeTrialStudentWhatsTemplateId(@PathVariable Long id){
        return findDtos(service.findByFreeTrialStudentWhatsTemplateId(id));
    }
    @Operation(summary = "delete by freeTrialStudentWhatsTemplate id")
    @DeleteMapping("freeTrialStudentWhatsTemplate/id/{id}")
    public int deleteByFreeTrialStudentWhatsTemplateId(@PathVariable Long id){
        return service.deleteByFreeTrialStudentWhatsTemplateId(id);
    }
    @Operation(summary = "find by freeTrialStudentEmailTemplate id")
    @GetMapping("freeTrialStudentEmailTemplate/id/{id}")
    public List<FreeTrialDto> findByFreeTrialStudentEmailTemplateId(@PathVariable Long id){
        return findDtos(service.findByFreeTrialStudentEmailTemplateId(id));
    }
    @Operation(summary = "delete by freeTrialStudentEmailTemplate id")
    @DeleteMapping("freeTrialStudentEmailTemplate/id/{id}")
    public int deleteByFreeTrialStudentEmailTemplateId(@PathVariable Long id){
        return service.deleteByFreeTrialStudentEmailTemplateId(id);
    }
    @Operation(summary = "find by freeTrialTeacherEmailTemplate id")
    @GetMapping("freeTrialTeacherEmailTemplate/id/{id}")
    public List<FreeTrialDto> findByFreeTrialTeacherEmailTemplateId(@PathVariable Long id){
        return findDtos(service.findByFreeTrialTeacherEmailTemplateId(id));
    }
    @Operation(summary = "delete by freeTrialTeacherEmailTemplate id")
    @DeleteMapping("freeTrialTeacherEmailTemplate/id/{id}")
    public int deleteByFreeTrialTeacherEmailTemplateId(@PathVariable Long id){
        return service.deleteByFreeTrialTeacherEmailTemplateId(id);
    }
    @Operation(summary = "find by freeTrialTeacherWhatsTemplate id")
    @GetMapping("freeTrialTeacherWhatsTemplate/id/{id}")
    public List<FreeTrialDto> findByFreeTrialTeacherWhatsTemplateId(@PathVariable Long id){
        return findDtos(service.findByFreeTrialTeacherWhatsTemplateId(id));
    }
    @Operation(summary = "delete by freeTrialTeacherWhatsTemplate id")
    @DeleteMapping("freeTrialTeacherWhatsTemplate/id/{id}")
    public int deleteByFreeTrialTeacherWhatsTemplateId(@PathVariable Long id){
        return service.deleteByFreeTrialTeacherWhatsTemplateId(id);
    }
    @Operation(summary = "find by freeTrialConfiguration id")
    @GetMapping("freeTrialConfiguration/id/{id}")
    public List<FreeTrialDto> findByFreeTrialConfigurationId(@PathVariable Long id){
        return findDtos(service.findByFreeTrialConfigurationId(id));
    }
    @Operation(summary = "delete by freeTrialConfiguration id")
    @DeleteMapping("freeTrialConfiguration/id/{id}")
    public int deleteByFreeTrialConfigurationId(@PathVariable Long id){
        return service.deleteByFreeTrialConfigurationId(id);
    }
    @Operation(summary = "find by statutFreeTrial id")
    @GetMapping("statutFreeTrial/id/{id}")
    public List<FreeTrialDto> findByStatutFreeTrialId(@PathVariable Long id){
        return findDtos(service.findByStatutFreeTrialId(id));
    }
    @Operation(summary = "delete by statutFreeTrial id")
    @DeleteMapping("statutFreeTrial/id/{id}")
    public int deleteByStatutFreeTrialId(@PathVariable Long id){
        return service.deleteByStatutFreeTrialId(id);
    }

    @Operation(summary = "Finds a freeTrial and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<FreeTrialDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds freeTrials by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<FreeTrialDto>> findByCriteria(@RequestBody FreeTrialCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated freeTrials by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody FreeTrialCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports freeTrials by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody FreeTrialCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets freeTrial data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody FreeTrialCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public FreeTrialRestAdmin (FreeTrialAdminService service, FreeTrialConverter converter) {
        super(service, converter);
    }




}
