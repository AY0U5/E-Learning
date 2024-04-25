package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtudiantClassRoomCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.EtudiantClassRoomAdminService;
import ma.zs.alc.ws.converter.inscriptionref.EtudiantClassRoomConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantClassRoomDto;
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
@RequestMapping("/api/admin/etudiantClassRoom/")
public class EtudiantClassRoomRestAdmin  extends AbstractController<EtudiantClassRoom, EtudiantClassRoomDto, EtudiantClassRoomCriteria, EtudiantClassRoomAdminService, EtudiantClassRoomConverter> {



    @Operation(summary = "upload one etudiantClassRoom")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etudiantClassRooms")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etudiantClassRooms")
    @GetMapping("")
    public ResponseEntity<List<EtudiantClassRoomDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  etudiantClassRoom")
    @PostMapping("")
    public ResponseEntity<EtudiantClassRoomDto> save(@RequestBody EtudiantClassRoomDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etudiantClassRoom")
    @PutMapping("")
    public ResponseEntity<EtudiantClassRoomDto> update(@RequestBody EtudiantClassRoomDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etudiantClassRoom")
    @PostMapping("multiple")
    public ResponseEntity<List<EtudiantClassRoomDto>> delete(@RequestBody List<EtudiantClassRoomDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etudiantClassRoom")
    @DeleteMapping("")
    public ResponseEntity<EtudiantClassRoomDto> delete(@RequestBody EtudiantClassRoomDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etudiantClassRoom")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etudiantClassRooms by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by classRoom id")
    @GetMapping("classRoom/id/{id}")
    public List<EtudiantClassRoomDto> findByClassRoomId(@PathVariable Long id){
        return findDtos(service.findByClassRoomId(id));
    }
    @Operation(summary = "delete by classRoom id")
    @DeleteMapping("classRoom/id/{id}")
    public int deleteByClassRoomId(@PathVariable Long id){
        return service.deleteByClassRoomId(id);
    }
    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<EtudiantClassRoomDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }

    @Operation(summary = "Finds a etudiantClassRoom and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtudiantClassRoomDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etudiantClassRooms by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtudiantClassRoomDto>> findByCriteria(@RequestBody EtudiantClassRoomCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etudiantClassRooms by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtudiantClassRoomCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etudiantClassRooms by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtudiantClassRoomCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etudiantClassRoom data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtudiantClassRoomCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtudiantClassRoomRestAdmin (EtudiantClassRoomAdminService service, EtudiantClassRoomConverter converter) {
        super(service, converter);
    }




}
