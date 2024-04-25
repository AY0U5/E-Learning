package  ma.zs.alc.ws.facade.admin.quiz;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.dao.criteria.core.quiz.QuizClassRoomCriteria;
import ma.zs.alc.service.facade.admin.quiz.QuizClassRoomAdminService;
import ma.zs.alc.ws.converter.quiz.QuizClassRoomConverter;
import ma.zs.alc.ws.dto.quiz.QuizClassRoomDto;
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
@RequestMapping("/api/admin/quizClassRoom/")
public class QuizClassRoomRestAdmin  extends AbstractController<QuizClassRoom, QuizClassRoomDto, QuizClassRoomCriteria, QuizClassRoomAdminService, QuizClassRoomConverter> {



    @Operation(summary = "upload one quizClassRoom")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple quizClassRooms")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all quizClassRooms")
    @GetMapping("")
    public ResponseEntity<List<QuizClassRoomDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  quizClassRoom")
    @PostMapping("")
    public ResponseEntity<QuizClassRoomDto> save(@RequestBody QuizClassRoomDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  quizClassRoom")
    @PutMapping("")
    public ResponseEntity<QuizClassRoomDto> update(@RequestBody QuizClassRoomDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of quizClassRoom")
    @PostMapping("multiple")
    public ResponseEntity<List<QuizClassRoomDto>> delete(@RequestBody List<QuizClassRoomDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified quizClassRoom")
    @DeleteMapping("")
    public ResponseEntity<QuizClassRoomDto> delete(@RequestBody QuizClassRoomDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified quizClassRoom")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple quizClassRooms by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by classRoom id")
    @GetMapping("classRoom/id/{id}")
    public List<QuizClassRoomDto> findByClassRoomId(@PathVariable Long id){
        return findDtos(service.findByClassRoomId(id));
    }
    @Operation(summary = "delete by classRoom id")
    @DeleteMapping("classRoom/id/{id}")
    public int deleteByClassRoomId(@PathVariable Long id){
        return service.deleteByClassRoomId(id);
    }
    @Operation(summary = "find by quiz id")
    @GetMapping("quiz/id/{id}")
    public List<QuizClassRoomDto> findByQuizId(@PathVariable Long id){
        return findDtos(service.findByQuizId(id));
    }
    @Operation(summary = "delete by quiz id")
    @DeleteMapping("quiz/id/{id}")
    public int deleteByQuizId(@PathVariable Long id){
        return service.deleteByQuizId(id);
    }

    @Operation(summary = "Finds a quizClassRoom and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<QuizClassRoomDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds quizClassRooms by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<QuizClassRoomDto>> findByCriteria(@RequestBody QuizClassRoomCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated quizClassRooms by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody QuizClassRoomCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports quizClassRooms by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody QuizClassRoomCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets quizClassRoom data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody QuizClassRoomCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public QuizClassRoomRestAdmin (QuizClassRoomAdminService service, QuizClassRoomConverter converter) {
        super(service, converter);
    }




}
