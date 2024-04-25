package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtatEtudiantScheduleCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.EtatEtudiantScheduleAdminService;
import ma.zs.alc.ws.converter.inscriptionref.EtatEtudiantScheduleConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtatEtudiantScheduleDto;
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
@RequestMapping("/api/admin/etatEtudiantSchedule/")
public class EtatEtudiantScheduleRestAdmin  extends AbstractController<EtatEtudiantSchedule, EtatEtudiantScheduleDto, EtatEtudiantScheduleCriteria, EtatEtudiantScheduleAdminService, EtatEtudiantScheduleConverter> {



    @Operation(summary = "upload one etatEtudiantSchedule")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatEtudiantSchedules")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatEtudiantSchedules")
    @GetMapping("")
    public ResponseEntity<List<EtatEtudiantScheduleDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatEtudiantSchedules")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatEtudiantScheduleDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatEtudiantSchedule by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatEtudiantScheduleDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new EtatEtudiantSchedule(libelle));
    }

    @Operation(summary = "Saves the specified  etatEtudiantSchedule")
    @PostMapping("")
    public ResponseEntity<EtatEtudiantScheduleDto> save(@RequestBody EtatEtudiantScheduleDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatEtudiantSchedule")
    @PutMapping("")
    public ResponseEntity<EtatEtudiantScheduleDto> update(@RequestBody EtatEtudiantScheduleDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatEtudiantSchedule")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatEtudiantScheduleDto>> delete(@RequestBody List<EtatEtudiantScheduleDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatEtudiantSchedule")
    @DeleteMapping("")
    public ResponseEntity<EtatEtudiantScheduleDto> delete(@RequestBody EtatEtudiantScheduleDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatEtudiantSchedule")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatEtudiantSchedules by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a etatEtudiantSchedule and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatEtudiantScheduleDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etatEtudiantSchedules by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatEtudiantScheduleDto>> findByCriteria(@RequestBody EtatEtudiantScheduleCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatEtudiantSchedules by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatEtudiantScheduleCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatEtudiantSchedules by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatEtudiantScheduleCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatEtudiantSchedule data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatEtudiantScheduleCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatEtudiantScheduleRestAdmin (EtatEtudiantScheduleAdminService service, EtatEtudiantScheduleConverter converter) {
        super(service, converter);
    }




}
