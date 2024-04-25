package  ma.zs.alc.ws.facade.admin.classroom;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.dao.criteria.core.classroom.ClassRoomCriteria;
import ma.zs.alc.service.facade.admin.classroom.ClassRoomAdminService;
import ma.zs.alc.ws.converter.classroom.ClassRoomConverter;
import ma.zs.alc.ws.dto.classroom.ClassRoomDto;
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
@RequestMapping("/api/admin/classRoom/")
public class ClassRoomRestAdmin  extends AbstractController<ClassRoom, ClassRoomDto, ClassRoomCriteria, ClassRoomAdminService, ClassRoomConverter> {



    @Operation(summary = "upload one classRoom")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple classRooms")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all classRooms")
    @GetMapping("")
    public ResponseEntity<List<ClassRoomDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all classRooms")
    @GetMapping("optimized")
    public ResponseEntity<List<ClassRoomDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a classRoom by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<ClassRoomDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new ClassRoom(libelle));
    }

    @Operation(summary = "Saves the specified  classRoom")
    @PostMapping("")
    public ResponseEntity<ClassRoomDto> save(@RequestBody ClassRoomDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  classRoom")
    @PutMapping("")
    public ResponseEntity<ClassRoomDto> update(@RequestBody ClassRoomDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of classRoom")
    @PostMapping("multiple")
    public ResponseEntity<List<ClassRoomDto>> delete(@RequestBody List<ClassRoomDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified classRoom")
    @DeleteMapping("")
    public ResponseEntity<ClassRoomDto> delete(@RequestBody ClassRoomDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified classRoom")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple classRooms by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<ClassRoomDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }

    @Operation(summary = "Finds a classRoom and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ClassRoomDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds classRooms by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ClassRoomDto>> findByCriteria(@RequestBody ClassRoomCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated classRooms by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ClassRoomCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports classRooms by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ClassRoomCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets classRoom data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ClassRoomCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ClassRoomRestAdmin (ClassRoomAdminService service, ClassRoomConverter converter) {
        super(service, converter);
    }




}
