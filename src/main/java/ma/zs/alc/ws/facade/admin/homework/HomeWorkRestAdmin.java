package  ma.zs.alc.ws.facade.admin.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.homework.HomeWork;
import ma.zs.alc.dao.criteria.core.homework.HomeWorkCriteria;
import ma.zs.alc.service.facade.admin.homework.HomeWorkAdminService;
import ma.zs.alc.ws.converter.homework.HomeWorkConverter;
import ma.zs.alc.ws.dto.homework.HomeWorkDto;
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
@RequestMapping("/api/admin/homeWork/")
public class HomeWorkRestAdmin  extends AbstractController<HomeWork, HomeWorkDto, HomeWorkCriteria, HomeWorkAdminService, HomeWorkConverter> {



    @Operation(summary = "upload one homeWork")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple homeWorks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all homeWorks")
    @GetMapping("")
    public ResponseEntity<List<HomeWorkDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all homeWorks")
    @GetMapping("optimized")
    public ResponseEntity<List<HomeWorkDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a homeWork by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<HomeWorkDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new HomeWork(libelle));
    }

    @Operation(summary = "Saves the specified  homeWork")
    @PostMapping("")
    public ResponseEntity<HomeWorkDto> save(@RequestBody HomeWorkDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  homeWork")
    @PutMapping("")
    public ResponseEntity<HomeWorkDto> update(@RequestBody HomeWorkDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of homeWork")
    @PostMapping("multiple")
    public ResponseEntity<List<HomeWorkDto>> delete(@RequestBody List<HomeWorkDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified homeWork")
    @DeleteMapping("")
    public ResponseEntity<HomeWorkDto> delete(@RequestBody HomeWorkDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified homeWork")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple homeWorks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by cours id")
    @GetMapping("cours/id/{id}")
    public List<HomeWorkDto> findByCoursId(@PathVariable Long id){
        return findDtos(service.findByCoursId(id));
    }
    @Operation(summary = "delete by cours id")
    @DeleteMapping("cours/id/{id}")
    public int deleteByCoursId(@PathVariable Long id){
        return service.deleteByCoursId(id);
    }
    @Operation(summary = "find by typeHomeWork id")
    @GetMapping("typeHomeWork/id/{id}")
    public List<HomeWorkDto> findByTypeHomeWorkId(@PathVariable Long id){
        return findDtos(service.findByTypeHomeWorkId(id));
    }
    @Operation(summary = "delete by typeHomeWork id")
    @DeleteMapping("typeHomeWork/id/{id}")
    public int deleteByTypeHomeWorkId(@PathVariable Long id){
        return service.deleteByTypeHomeWorkId(id);
    }

    @Operation(summary = "Finds a homeWork and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<HomeWorkDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds homeWorks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<HomeWorkDto>> findByCriteria(@RequestBody HomeWorkCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated homeWorks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody HomeWorkCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports homeWorks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody HomeWorkCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets homeWork data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody HomeWorkCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public HomeWorkRestAdmin (HomeWorkAdminService service, HomeWorkConverter converter) {
        super(service, converter);
    }




}
