package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.dao.criteria.core.inscriptionref.TeacherLocalityCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.TeacherLocalityAdminService;
import ma.zs.alc.ws.converter.inscriptionref.TeacherLocalityConverter;
import ma.zs.alc.ws.dto.inscriptionref.TeacherLocalityDto;
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
@RequestMapping("/api/admin/teacherLocality/")
public class TeacherLocalityRestAdmin  extends AbstractController<TeacherLocality, TeacherLocalityDto, TeacherLocalityCriteria, TeacherLocalityAdminService, TeacherLocalityConverter> {



    @Operation(summary = "upload one teacherLocality")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple teacherLocalitys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all teacherLocalitys")
    @GetMapping("")
    public ResponseEntity<List<TeacherLocalityDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all teacherLocalitys")
    @GetMapping("optimized")
    public ResponseEntity<List<TeacherLocalityDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a teacherLocality by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TeacherLocalityDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new TeacherLocality(libelle));
    }

    @Operation(summary = "Saves the specified  teacherLocality")
    @PostMapping("")
    public ResponseEntity<TeacherLocalityDto> save(@RequestBody TeacherLocalityDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  teacherLocality")
    @PutMapping("")
    public ResponseEntity<TeacherLocalityDto> update(@RequestBody TeacherLocalityDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of teacherLocality")
    @PostMapping("multiple")
    public ResponseEntity<List<TeacherLocalityDto>> delete(@RequestBody List<TeacherLocalityDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified teacherLocality")
    @DeleteMapping("")
    public ResponseEntity<TeacherLocalityDto> delete(@RequestBody TeacherLocalityDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified teacherLocality")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple teacherLocalitys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a teacherLocality and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TeacherLocalityDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds teacherLocalitys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TeacherLocalityDto>> findByCriteria(@RequestBody TeacherLocalityCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated teacherLocalitys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TeacherLocalityCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports teacherLocalitys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody TeacherLocalityCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets teacherLocality data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TeacherLocalityCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public TeacherLocalityRestAdmin (TeacherLocalityAdminService service, TeacherLocalityConverter converter) {
        super(service, converter);
    }




}
