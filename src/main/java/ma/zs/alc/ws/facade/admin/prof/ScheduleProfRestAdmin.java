package  ma.zs.alc.ws.facade.admin.prof;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.prof.ScheduleProf;
import ma.zs.alc.dao.criteria.core.prof.ScheduleProfCriteria;
import ma.zs.alc.service.facade.admin.prof.ScheduleProfAdminService;
import ma.zs.alc.ws.converter.prof.ScheduleProfConverter;
import ma.zs.alc.ws.dto.prof.ScheduleProfDto;
import ma.zs.alc.zynerator.controller.AbstractController;
import ma.zs.alc.zynerator.dto.AuditEntityDto;
import ma.zs.alc.zynerator.util.PaginatedList;

import ma.zs.alc.zynerator.dto.ScheduleDto;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.alc.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.alc.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/scheduleProf/")
public class ScheduleProfRestAdmin  extends AbstractController<ScheduleProf, ScheduleProfDto, ScheduleProfCriteria, ScheduleProfAdminService, ScheduleProfConverter> {



    @Operation(summary = "upload one scheduleProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple scheduleProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all scheduleProfs")
    @GetMapping("")
    public ResponseEntity<List<ScheduleProfDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all scheduleProfs")
    @GetMapping("optimized")
    public ResponseEntity<List<ScheduleProfDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a scheduleProf by subject")
    @GetMapping("subject/{subject}")
    public ResponseEntity<ScheduleProfDto> findBySubject(@PathVariable String subject) {
        return super.findByReferenceEntity(new ScheduleProf(subject));
    }

    @Operation(summary = "Saves the specified  scheduleProf")
    @PostMapping("")
    public ResponseEntity<ScheduleProfDto> save(@RequestBody ScheduleProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  scheduleProf")
    @PutMapping("")
    public ResponseEntity<ScheduleProfDto> update(@RequestBody ScheduleProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of scheduleProf")
    @PostMapping("multiple")
    public ResponseEntity<List<ScheduleProfDto>> delete(@RequestBody List<ScheduleProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified scheduleProf")
    @DeleteMapping("")
    public ResponseEntity<ScheduleProfDto> delete(@RequestBody ScheduleProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified scheduleProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple scheduleProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by groupeEtudiant id")
    @GetMapping("groupeEtudiant/id/{id}")
    public List<ScheduleProfDto> findByGroupeEtudiantId(@PathVariable Long id){
        return findDtos(service.findByGroupeEtudiantId(id));
    }
    @Operation(summary = "delete by groupeEtudiant id")
    @DeleteMapping("groupeEtudiant/id/{id}")
    public int deleteByGroupeEtudiantId(@PathVariable Long id){
        return service.deleteByGroupeEtudiantId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<ScheduleProfDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by cours id")
    @GetMapping("cours/id/{id}")
    public List<ScheduleProfDto> findByCoursId(@PathVariable Long id){
        return findDtos(service.findByCoursId(id));
    }
    @Operation(summary = "delete by cours id")
    @DeleteMapping("cours/id/{id}")
    public int deleteByCoursId(@PathVariable Long id){
        return service.deleteByCoursId(id);
    }

    @Operation(summary = "Finds a scheduleProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ScheduleProfDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds scheduleProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ScheduleProfDto>> findByCriteria(@RequestBody ScheduleProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated scheduleProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ScheduleProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports scheduleProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ScheduleProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets scheduleProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ScheduleProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @GetMapping("start/{start}/end/{end}")
    public List<ScheduleDto> findSchedule(
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String start,
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String end) {
        return service.findSchedule(LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

    public ScheduleProfRestAdmin (ScheduleProfAdminService service, ScheduleProfConverter converter) {
        super(service, converter);
    }




}
