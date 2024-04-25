package  ma.zs.alc.ws.facade.admin.grpe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.dao.criteria.core.grpe.GroupeTypeCriteria;
import ma.zs.alc.service.facade.admin.grpe.GroupeTypeAdminService;
import ma.zs.alc.ws.converter.grpe.GroupeTypeConverter;
import ma.zs.alc.ws.dto.grpe.GroupeTypeDto;
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
@RequestMapping("/api/admin/groupeType/")
public class GroupeTypeRestAdmin  extends AbstractController<GroupeType, GroupeTypeDto, GroupeTypeCriteria, GroupeTypeAdminService, GroupeTypeConverter> {



    @Operation(summary = "upload one groupeType")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple groupeTypes")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all groupeTypes")
    @GetMapping("")
    public ResponseEntity<List<GroupeTypeDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all groupeTypes")
    @GetMapping("optimized")
    public ResponseEntity<List<GroupeTypeDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a groupeType by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<GroupeTypeDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new GroupeType(libelle));
    }

    @Operation(summary = "Saves the specified  groupeType")
    @PostMapping("")
    public ResponseEntity<GroupeTypeDto> save(@RequestBody GroupeTypeDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  groupeType")
    @PutMapping("")
    public ResponseEntity<GroupeTypeDto> update(@RequestBody GroupeTypeDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of groupeType")
    @PostMapping("multiple")
    public ResponseEntity<List<GroupeTypeDto>> delete(@RequestBody List<GroupeTypeDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified groupeType")
    @DeleteMapping("")
    public ResponseEntity<GroupeTypeDto> delete(@RequestBody GroupeTypeDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified groupeType")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple groupeTypes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a groupeType and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<GroupeTypeDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds groupeTypes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<GroupeTypeDto>> findByCriteria(@RequestBody GroupeTypeCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated groupeTypes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody GroupeTypeCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports groupeTypes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody GroupeTypeCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets groupeType data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody GroupeTypeCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public GroupeTypeRestAdmin (GroupeTypeAdminService service, GroupeTypeConverter converter) {
        super(service, converter);
    }




}
