package  ma.zs.alc.ws.facade.admin.paiement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.paiement.Paiement;
import ma.zs.alc.dao.criteria.core.paiement.PaiementCriteria;
import ma.zs.alc.service.facade.admin.paiement.PaiementAdminService;
import ma.zs.alc.ws.converter.paiement.PaiementConverter;
import ma.zs.alc.ws.dto.paiement.PaiementDto;
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
@RequestMapping("/api/admin/paiement/")
public class PaiementRestAdmin  extends AbstractController<Paiement, PaiementDto, PaiementCriteria, PaiementAdminService, PaiementConverter> {



    @Operation(summary = "upload one paiement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple paiements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all paiements")
    @GetMapping("")
    public ResponseEntity<List<PaiementDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  paiement")
    @PostMapping("")
    public ResponseEntity<PaiementDto> save(@RequestBody PaiementDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  paiement")
    @PutMapping("")
    public ResponseEntity<PaiementDto> update(@RequestBody PaiementDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of paiement")
    @PostMapping("multiple")
    public ResponseEntity<List<PaiementDto>> delete(@RequestBody List<PaiementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified paiement")
    @DeleteMapping("")
    public ResponseEntity<PaiementDto> delete(@RequestBody PaiementDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified paiement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple paiements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by prof id")
    @GetMapping("prof/id/{id}")
    public List<PaiementDto> findByProfId(@PathVariable Long id){
        return findDtos(service.findByProfId(id));
    }
    @Operation(summary = "delete by prof id")
    @DeleteMapping("prof/id/{id}")
    public int deleteByProfId(@PathVariable Long id){
        return service.deleteByProfId(id);
    }
    @Operation(summary = "find by groupeEtudiant id")
    @GetMapping("groupeEtudiant/id/{id}")
    public List<PaiementDto> findByGroupeEtudiantId(@PathVariable Long id){
        return findDtos(service.findByGroupeEtudiantId(id));
    }
    @Operation(summary = "delete by groupeEtudiant id")
    @DeleteMapping("groupeEtudiant/id/{id}")
    public int deleteByGroupeEtudiantId(@PathVariable Long id){
        return service.deleteByGroupeEtudiantId(id);
    }

    @Operation(summary = "Finds a paiement and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PaiementDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds paiements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PaiementDto>> findByCriteria(@RequestBody PaiementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated paiements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PaiementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports paiements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PaiementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets paiement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PaiementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PaiementRestAdmin (PaiementAdminService service, PaiementConverter converter) {
        super(service, converter);
    }




}
