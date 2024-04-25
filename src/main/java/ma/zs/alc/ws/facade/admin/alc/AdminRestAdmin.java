package  ma.zs.alc.ws.facade.admin.alc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.dao.criteria.core.alc.AdminCriteria;
import ma.zs.alc.service.facade.admin.alc.AdminAdminService;
import ma.zs.alc.ws.converter.alc.AdminConverter;
import ma.zs.alc.ws.dto.alc.AdminDto;
import ma.zs.alc.zynerator.controller.AbstractController;
import ma.zs.alc.zynerator.dto.AuditEntityDto;
import ma.zs.alc.zynerator.util.PaginatedList;


import ma.zs.alc.zynerator.security.bean.User;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.alc.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.alc.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/admin/")
public class AdminRestAdmin  extends AbstractController<Admin, AdminDto, AdminCriteria, AdminAdminService, AdminConverter> {



    @Operation(summary = "upload one admin")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple admins")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all admins")
    @GetMapping("")
    public ResponseEntity<List<AdminDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  admin")
    @PostMapping("")
    public ResponseEntity<AdminDto> save(@RequestBody AdminDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  admin")
    @PutMapping("")
    public ResponseEntity<AdminDto> update(@RequestBody AdminDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of admin")
    @PostMapping("multiple")
    public ResponseEntity<List<AdminDto>> delete(@RequestBody List<AdminDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified admin")
    @DeleteMapping("")
    public ResponseEntity<AdminDto> delete(@RequestBody AdminDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified admin")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple admins by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a admin and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AdminDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds admins by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AdminDto>> findByCriteria(@RequestBody AdminCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated admins by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AdminCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports admins by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AdminCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets admin data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AdminCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    @Operation(summary = "Change password to the specified  utilisateur")
    @PutMapping("changePassword")
    public boolean changePassword(@RequestBody User dto) throws Exception {
        return service.changePassword(dto.getUsername(),dto.getPassword());
    }
    public AdminRestAdmin (AdminAdminService service, AdminConverter converter) {
        super(service, converter);
    }




}
