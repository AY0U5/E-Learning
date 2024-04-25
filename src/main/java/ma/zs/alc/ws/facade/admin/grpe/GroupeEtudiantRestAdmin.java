package  ma.zs.alc.ws.facade.admin.grpe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.dao.criteria.core.grpe.GroupeEtudiantCriteria;
import ma.zs.alc.service.facade.admin.grpe.GroupeEtudiantAdminService;
import ma.zs.alc.ws.converter.grpe.GroupeEtudiantConverter;
import ma.zs.alc.ws.dto.grpe.GroupeEtudiantDto;
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
@RequestMapping("/api/admin/groupeEtudiant/")
public class GroupeEtudiantRestAdmin  extends AbstractController<GroupeEtudiant, GroupeEtudiantDto, GroupeEtudiantCriteria, GroupeEtudiantAdminService, GroupeEtudiantConverter> {



    @Operation(summary = "upload one groupeEtudiant")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple groupeEtudiants")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all groupeEtudiants")
    @GetMapping("")
    public ResponseEntity<List<GroupeEtudiantDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  groupeEtudiant")
    @PostMapping("")
    public ResponseEntity<GroupeEtudiantDto> save(@RequestBody GroupeEtudiantDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  groupeEtudiant")
    @PutMapping("")
    public ResponseEntity<GroupeEtudiantDto> update(@RequestBody GroupeEtudiantDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of groupeEtudiant")
    @PostMapping("multiple")
    public ResponseEntity<List<GroupeEtudiantDto>> delete(@RequestBody List<GroupeEtudiantDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified groupeEtudiant")
    @DeleteMapping("")
    public ResponseEntity<GroupeEtudiantDto> delete(@RequestBody GroupeEtudiantDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified groupeEtudiant")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple groupeEtudiants by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by groupeEtude id")
    @GetMapping("groupeEtude/id/{id}")
    public List<GroupeEtudiantDto> findByGroupeEtudeId(@PathVariable Long id){
        return findDtos(service.findByGroupeEtudeId(id));
    }
    @Operation(summary = "delete by groupeEtude id")
    @DeleteMapping("groupeEtude/id/{id}")
    public int deleteByGroupeEtudeId(@PathVariable Long id){
        return service.deleteByGroupeEtudeId(id);
    }
    @Operation(summary = "find by groupeType id")
    @GetMapping("groupeType/id/{id}")
    public List<GroupeEtudiantDto> findByGroupeTypeId(@PathVariable Long id){
        return findDtos(service.findByGroupeTypeId(id));
    }
    @Operation(summary = "delete by groupeType id")
    @DeleteMapping("groupeType/id/{id}")
    public int deleteByGroupeTypeId(@PathVariable Long id){
        return service.deleteByGroupeTypeId(id);
    }
    @Operation(summary = "find by groupeEtat id")
    @GetMapping("groupeEtat/id/{id}")
    public List<GroupeEtudiantDto> findByGroupeEtatId(@PathVariable Long id){
        return findDtos(service.findByGroupeEtatId(id));
    }
    @Operation(summary = "delete by groupeEtat id")
    @DeleteMapping("groupeEtat/id/{id}")
    public int deleteByGroupeEtatId(@PathVariable Long id){
        return service.deleteByGroupeEtatId(id);
    }
    @Operation(summary = "find by parcours id")
    @GetMapping("parcours/id/{id}")
    public List<GroupeEtudiantDto> findByParcoursId(@PathVariable Long id){
        return findDtos(service.findByParcoursId(id));
    }
    @Operation(summary = "delete by parcours id")
    @DeleteMapping("parcours/id/{id}")
    public int deleteByParcoursId(@PathVariable Long id){
        return service.deleteByParcoursId(id);
    }
    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<GroupeEtudiantDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }

    @Operation(summary = "Finds a groupeEtudiant and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<GroupeEtudiantDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds groupeEtudiants by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<GroupeEtudiantDto>> findByCriteria(@RequestBody GroupeEtudiantCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated groupeEtudiants by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody GroupeEtudiantCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports groupeEtudiants by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody GroupeEtudiantCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets groupeEtudiant data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody GroupeEtudiantCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public GroupeEtudiantRestAdmin (GroupeEtudiantAdminService service, GroupeEtudiantConverter converter) {
        super(service, converter);
    }




}
