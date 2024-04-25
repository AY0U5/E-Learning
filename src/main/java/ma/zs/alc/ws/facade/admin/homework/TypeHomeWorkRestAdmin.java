package  ma.zs.alc.ws.facade.admin.homework;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.dao.criteria.core.homework.TypeHomeWorkCriteria;
import ma.zs.alc.service.facade.admin.homework.TypeHomeWorkAdminService;
import ma.zs.alc.ws.converter.homework.TypeHomeWorkConverter;
import ma.zs.alc.ws.dto.homework.TypeHomeWorkDto;
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
@RequestMapping("/api/admin/typeHomeWork/")
public class TypeHomeWorkRestAdmin  extends AbstractController<TypeHomeWork, TypeHomeWorkDto, TypeHomeWorkCriteria, TypeHomeWorkAdminService, TypeHomeWorkConverter> {



    @Operation(summary = "upload one typeHomeWork")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple typeHomeWorks")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all typeHomeWorks")
    @GetMapping("")
    public ResponseEntity<List<TypeHomeWorkDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all typeHomeWorks")
    @GetMapping("optimized")
    public ResponseEntity<List<TypeHomeWorkDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a typeHomeWork by lib")
    @GetMapping("lib/{lib}")
    public ResponseEntity<TypeHomeWorkDto> findByLib(@PathVariable String lib) {
        return super.findByReferenceEntity(new TypeHomeWork(lib));
    }

    @Operation(summary = "Saves the specified  typeHomeWork")
    @PostMapping("")
    public ResponseEntity<TypeHomeWorkDto> save(@RequestBody TypeHomeWorkDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  typeHomeWork")
    @PutMapping("")
    public ResponseEntity<TypeHomeWorkDto> update(@RequestBody TypeHomeWorkDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of typeHomeWork")
    @PostMapping("multiple")
    public ResponseEntity<List<TypeHomeWorkDto>> delete(@RequestBody List<TypeHomeWorkDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified typeHomeWork")
    @DeleteMapping("")
    public ResponseEntity<TypeHomeWorkDto> delete(@RequestBody TypeHomeWorkDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified typeHomeWork")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple typeHomeWorks by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a typeHomeWork and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypeHomeWorkDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds typeHomeWorks by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypeHomeWorkDto>> findByCriteria(@RequestBody TypeHomeWorkCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated typeHomeWorks by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypeHomeWorkCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports typeHomeWorks by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TypeHomeWorkCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets typeHomeWork data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypeHomeWorkCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TypeHomeWorkRestAdmin (TypeHomeWorkAdminService service, TypeHomeWorkConverter converter) {
        super(service, converter);
    }




}
