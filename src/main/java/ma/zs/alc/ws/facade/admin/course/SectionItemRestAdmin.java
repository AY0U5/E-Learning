package  ma.zs.alc.ws.facade.admin.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.course.SectionItem;
import ma.zs.alc.dao.criteria.core.course.SectionItemCriteria;
import ma.zs.alc.service.facade.admin.course.SectionItemAdminService;
import ma.zs.alc.ws.converter.course.SectionItemConverter;
import ma.zs.alc.ws.dto.course.SectionItemDto;
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
@RequestMapping("/api/admin/sectionItem/")
public class SectionItemRestAdmin  extends AbstractController<SectionItem, SectionItemDto, SectionItemCriteria, SectionItemAdminService, SectionItemConverter> {



    @Operation(summary = "upload one sectionItem")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple sectionItems")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all sectionItems")
    @GetMapping("")
    public ResponseEntity<List<SectionItemDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  sectionItem")
    @PostMapping("")
    public ResponseEntity<SectionItemDto> save(@RequestBody SectionItemDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  sectionItem")
    @PutMapping("")
    public ResponseEntity<SectionItemDto> update(@RequestBody SectionItemDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of sectionItem")
    @PostMapping("multiple")
    public ResponseEntity<List<SectionItemDto>> delete(@RequestBody List<SectionItemDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified sectionItem")
    @DeleteMapping("")
    public ResponseEntity<SectionItemDto> delete(@RequestBody SectionItemDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified sectionItem")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple sectionItems by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by section id")
    @GetMapping("section/id/{id}")
    public List<SectionItemDto> findBySectionId(@PathVariable Long id){
        return findDtos(service.findBySectionId(id));
    }
    @Operation(summary = "delete by section id")
    @DeleteMapping("section/id/{id}")
    public int deleteBySectionId(@PathVariable Long id){
        return service.deleteBySectionId(id);
    }

    @Operation(summary = "Finds a sectionItem and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SectionItemDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds sectionItems by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SectionItemDto>> findByCriteria(@RequestBody SectionItemCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated sectionItems by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SectionItemCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports sectionItems by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SectionItemCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets sectionItem data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SectionItemCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SectionItemRestAdmin (SectionItemAdminService service, SectionItemConverter converter) {
        super(service, converter);
    }




}
