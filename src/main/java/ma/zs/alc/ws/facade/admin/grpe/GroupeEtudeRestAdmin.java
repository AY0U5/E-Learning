package  ma.zs.alc.ws.facade.admin.grpe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudeCriteria;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudeAdminService;
import ma.zs.alc.ws.converter.grpe.GroupeEtudeConverter;
import ma.zs.alc.ws.dto.grpe.GroupeEtudeDto;
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
@RequestMapping("/api/admin/groupeEtude/")
public class GroupeEtudeRestAdmin  extends AbstractController<GroupeEtude, GroupeEtudeDto, GroupeEtudeCriteria, GroupeEtudeAdminService, GroupeEtudeConverter> {



    @Operation(summary = "upload one groupeEtude")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple groupeEtudes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all groupeEtudes")
    @GetMapping("")
    public ResponseEntity<List<GroupeEtudeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all groupeEtudes")
    @GetMapping("optimized")
    public ResponseEntity<List<GroupeEtudeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a groupeEtude by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<GroupeEtudeDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new GroupeEtude(libelle));
    }

    @Operation(summary = "Saves the specified  groupeEtude")
    @PostMapping("")
    public ResponseEntity<GroupeEtudeDto> save(@RequestBody GroupeEtudeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  groupeEtude")
    @PutMapping("")
    public ResponseEntity<GroupeEtudeDto> update(@RequestBody GroupeEtudeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of groupeEtude")
    @PostMapping("multiple")
    public ResponseEntity<List<GroupeEtudeDto>> delete(@RequestBody List<GroupeEtudeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified groupeEtude")
    @DeleteMapping("")
    public ResponseEntity<GroupeEtudeDto> delete(@RequestBody GroupeEtudeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified groupeEtude")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple groupeEtudes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a groupeEtude and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<GroupeEtudeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds groupeEtudes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<GroupeEtudeDto>> findByCriteria(@RequestBody GroupeEtudeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated groupeEtudes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody GroupeEtudeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports groupeEtudes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody GroupeEtudeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets groupeEtude data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody GroupeEtudeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public GroupeEtudeRestAdmin (GroupeEtudeAdminService service, GroupeEtudeConverter converter) {
        super(service, converter);
    }




}
