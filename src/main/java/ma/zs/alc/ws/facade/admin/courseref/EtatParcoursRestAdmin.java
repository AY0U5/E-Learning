package  ma.zs.alc.ws.facade.admin.courseref;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.bean.core.courseref.EtatParcours;
import ma.zs.alc.dao.criteria.core.courseref.EtatParcoursCriteria;
import ma.zs.alc.service.facade.admin.courseref.EtatCoursAdminService;
import ma.zs.alc.service.facade.admin.courseref.EtatParcoursAdminService;
import ma.zs.alc.ws.converter.courseref.EtatParcoursConverter;
import ma.zs.alc.ws.dto.course.SectionDto;
import ma.zs.alc.ws.dto.courseref.EtatParcoursDto;
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
@RequestMapping("/api/admin/etatParcours/")
public class EtatParcoursRestAdmin  extends AbstractController<EtatParcours, EtatParcoursDto, EtatParcoursCriteria, EtatParcoursAdminService, EtatParcoursConverter> {
    @Operation(summary = "Finds a etatParcours  by code")
    @GetMapping("code/{code}")
    public ResponseEntity<EtatParcoursDto> findByCode(@PathVariable String code) {
        return  super.findByReferenceEntity ( new EtatParcours(code));
    }

    public int deleteByCode(String code) {
        return etatCoursAdminService.deleteByCode(code);
    }

    private @Autowired EtatCoursAdminService etatCoursAdminService;

    @Operation(summary = "upload one etatParcours")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple etatParcourss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all etatParcourss")
    @GetMapping("")
    public ResponseEntity<List<EtatParcoursDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all etatParcourss")
    @GetMapping("optimized")
    public ResponseEntity<List<EtatParcoursDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a etatParcours by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EtatParcoursDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new EtatParcours(libelle));
    }

    @Operation(summary = "Saves the specified  etatParcours")
    @PostMapping("")
    public ResponseEntity<EtatParcoursDto> save(@RequestBody EtatParcoursDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  etatParcours")
    @PutMapping("")
    public ResponseEntity<EtatParcoursDto> update(@RequestBody EtatParcoursDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of etatParcours")
    @PostMapping("multiple")
    public ResponseEntity<List<EtatParcoursDto>> delete(@RequestBody List<EtatParcoursDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified etatParcours")
    @DeleteMapping("")
    public ResponseEntity<EtatParcoursDto> delete(@RequestBody EtatParcoursDto dto) throws Exception {
        return super.delete(dto);
    }

    @Operation(summary = "Delete the specified etatParcours")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple etatParcourss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        return super.deleteByIdIn(ids);
    }



    @Operation(summary = "Finds a etatParcours and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EtatParcoursDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds etatParcourss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EtatParcoursDto>> findByCriteria(@RequestBody EtatParcoursCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated etatParcourss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EtatParcoursCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports etatParcourss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EtatParcoursCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets etatParcours data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EtatParcoursCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EtatParcoursRestAdmin (EtatParcoursAdminService service, EtatParcoursConverter converter) {
        super(service, converter);
    }




}
