package  ma.zs.alc.ws.facade.admin.prof;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.prof.TrancheHoraireProf;
import ma.zs.alc.dao.criteria.core.prof.TrancheHoraireProfCriteria;
import ma.zs.alc.service.facade.admin.prof.TrancheHoraireProfAdminService;
import ma.zs.alc.ws.converter.prof.TrancheHoraireProfConverter;
import ma.zs.alc.ws.dto.prof.TrancheHoraireProfDto;
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
@RequestMapping("/api/admin/trancheHoraireProf/")
public class TrancheHoraireProfRestAdmin  extends AbstractController<TrancheHoraireProf, TrancheHoraireProfDto, TrancheHoraireProfCriteria, TrancheHoraireProfAdminService, TrancheHoraireProfConverter> {



    @Operation(summary = "upload one trancheHoraireProf")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple trancheHoraireProfs")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all trancheHoraireProfs")
    @GetMapping("")
    public ResponseEntity<List<TrancheHoraireProfDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  trancheHoraireProf")
    @PostMapping("")
    public ResponseEntity<TrancheHoraireProfDto> save(@RequestBody TrancheHoraireProfDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  trancheHoraireProf")
    @PutMapping("")
    public ResponseEntity<TrancheHoraireProfDto> update(@RequestBody TrancheHoraireProfDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of trancheHoraireProf")
    @PostMapping("multiple")
    public ResponseEntity<List<TrancheHoraireProfDto>> delete(@RequestBody List<TrancheHoraireProfDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified trancheHoraireProf")
    @DeleteMapping("")
    public ResponseEntity<TrancheHoraireProfDto> delete(@RequestBody TrancheHoraireProfDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified trancheHoraireProf")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple trancheHoraireProfs by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<TrancheHoraireProfDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }

    @Operation(summary = "Finds a trancheHoraireProf and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TrancheHoraireProfDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds trancheHoraireProfs by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TrancheHoraireProfDto>> findByCriteria(@RequestBody TrancheHoraireProfCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated trancheHoraireProfs by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TrancheHoraireProfCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports trancheHoraireProfs by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TrancheHoraireProfCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets trancheHoraireProf data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TrancheHoraireProfCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TrancheHoraireProfRestAdmin (TrancheHoraireProfAdminService service, TrancheHoraireProfConverter converter) {
        super(service, converter);
    }




}
