package  ma.zs.alc.ws.facade.admin.inscriptionref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.dao.criteria.core.inscriptionref.StatutSocialCriteria;
import ma.zs.alc.service.facade.admin.inscriptionref.StatutSocialAdminService;
import ma.zs.alc.ws.converter.inscriptionref.StatutSocialConverter;
import ma.zs.alc.ws.dto.inscriptionref.StatutSocialDto;
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
@RequestMapping("/api/admin/statutSocial/")
public class StatutSocialRestAdmin  extends AbstractController<StatutSocial, StatutSocialDto, StatutSocialCriteria, StatutSocialAdminService, StatutSocialConverter> {



    @Operation(summary = "upload one statutSocial")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple statutSocials")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all statutSocials")
    @GetMapping("")
    public ResponseEntity<List<StatutSocialDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all statutSocials")
    @GetMapping("optimized")
    public ResponseEntity<List<StatutSocialDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a statutSocial by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<StatutSocialDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new StatutSocial(libelle));
    }

    @Operation(summary = "Saves the specified  statutSocial")
    @PostMapping("")
    public ResponseEntity<StatutSocialDto> save(@RequestBody StatutSocialDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  statutSocial")
    @PutMapping("")
    public ResponseEntity<StatutSocialDto> update(@RequestBody StatutSocialDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of statutSocial")
    @PostMapping("multiple")
    public ResponseEntity<List<StatutSocialDto>> delete(@RequestBody List<StatutSocialDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified statutSocial")
    @DeleteMapping("")
    public ResponseEntity<StatutSocialDto> delete(@RequestBody StatutSocialDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified statutSocial")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple statutSocials by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a statutSocial and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StatutSocialDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds statutSocials by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StatutSocialDto>> findByCriteria(@RequestBody StatutSocialCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated statutSocials by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StatutSocialCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports statutSocials by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody StatutSocialCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets statutSocial data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StatutSocialCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public StatutSocialRestAdmin (StatutSocialAdminService service, StatutSocialConverter converter) {
        super(service, converter);
    }




}
