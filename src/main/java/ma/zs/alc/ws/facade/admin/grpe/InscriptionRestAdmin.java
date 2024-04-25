package  ma.zs.alc.ws.facade.admin.grpe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.dao.criteria.core.grpe.InscriptionCriteria;
import ma.zs.alc.service.facade.admin.grpe.InscriptionAdminService;
import ma.zs.alc.ws.converter.grpe.InscriptionConverter;
import ma.zs.alc.ws.dto.grpe.InscriptionDto;
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
@RequestMapping("/api/admin/inscription/")
public class InscriptionRestAdmin  extends AbstractController<Inscription, InscriptionDto, InscriptionCriteria, InscriptionAdminService, InscriptionConverter> {



    @Operation(summary = "upload one inscription")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple inscriptions")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all inscriptions")
    @GetMapping("")
    public ResponseEntity<List<InscriptionDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  inscription")
    @PostMapping("")
    public ResponseEntity<InscriptionDto> save(@RequestBody InscriptionDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  inscription")
    @PutMapping("")
    public ResponseEntity<InscriptionDto> update(@RequestBody InscriptionDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of inscription")
    @PostMapping("multiple")
    public ResponseEntity<List<InscriptionDto>> delete(@RequestBody List<InscriptionDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified inscription")
    @DeleteMapping("")
    public ResponseEntity<InscriptionDto> delete(@RequestBody InscriptionDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified inscription")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple inscriptions by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<InscriptionDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }
    @Operation(summary = "find by etatInscription id")
    @GetMapping("etatInscription/id/{id}")
    public List<InscriptionDto> findByEtatInscriptionId(@PathVariable Long id){
        return findDtos(service.findByEtatInscriptionId(id));
    }
    @Operation(summary = "delete by etatInscription id")
    @DeleteMapping("etatInscription/id/{id}")
    public int deleteByEtatInscriptionId(@PathVariable Long id){
        return service.deleteByEtatInscriptionId(id);
    }
    @Operation(summary = "find by parcours id")
    @GetMapping("parcours/id/{id}")
    public List<InscriptionDto> findByParcoursId(@PathVariable Long id){
        return findDtos(service.findByParcoursId(id));
    }
    @Operation(summary = "delete by parcours id")
    @DeleteMapping("parcours/id/{id}")
    public int deleteByParcoursId(@PathVariable Long id){
        return service.deleteByParcoursId(id);
    }
    @Operation(summary = "find by groupeEtude id")
    @GetMapping("groupeEtude/id/{id}")
    public List<InscriptionDto> findByGroupeEtudeId(@PathVariable Long id){
        return findDtos(service.findByGroupeEtudeId(id));
    }
    @Operation(summary = "delete by groupeEtude id")
    @DeleteMapping("groupeEtude/id/{id}")
    public int deleteByGroupeEtudeId(@PathVariable Long id){
        return service.deleteByGroupeEtudeId(id);
    }
    @Operation(summary = "find by groupeType id")
    @GetMapping("groupeType/id/{id}")
    public List<InscriptionDto> findByGroupeTypeId(@PathVariable Long id){
        return findDtos(service.findByGroupeTypeId(id));
    }
    @Operation(summary = "delete by groupeType id")
    @DeleteMapping("groupeType/id/{id}")
    public int deleteByGroupeTypeId(@PathVariable Long id){
        return service.deleteByGroupeTypeId(id);
    }
    @Operation(summary = "find by statutSocial id")
    @GetMapping("statutSocial/id/{id}")
    public List<InscriptionDto> findByStatutSocialId(@PathVariable Long id){
        return findDtos(service.findByStatutSocialId(id));
    }
    @Operation(summary = "delete by statutSocial id")
    @DeleteMapping("statutSocial/id/{id}")
    public int deleteByStatutSocialId(@PathVariable Long id){
        return service.deleteByStatutSocialId(id);
    }
    @Operation(summary = "find by interetEtudiant id")
    @GetMapping("interetEtudiant/id/{id}")
    public List<InscriptionDto> findByInteretEtudiantId(@PathVariable Long id){
        return findDtos(service.findByInteretEtudiantId(id));
    }
    @Operation(summary = "delete by interetEtudiant id")
    @DeleteMapping("interetEtudiant/id/{id}")
    public int deleteByInteretEtudiantId(@PathVariable Long id){
        return service.deleteByInteretEtudiantId(id);
    }
    @Operation(summary = "find by niveauEtude id")
    @GetMapping("niveauEtude/id/{id}")
    public List<InscriptionDto> findByNiveauEtudeId(@PathVariable Long id){
        return findDtos(service.findByNiveauEtudeId(id));
    }
    @Operation(summary = "delete by niveauEtude id")
    @DeleteMapping("niveauEtude/id/{id}")
    public int deleteByNiveauEtudeId(@PathVariable Long id){
        return service.deleteByNiveauEtudeId(id);
    }
    @Operation(summary = "find by fonction id")
    @GetMapping("fonction/id/{id}")
    public List<InscriptionDto> findByFonctionId(@PathVariable Long id){
        return findDtos(service.findByFonctionId(id));
    }
    @Operation(summary = "delete by fonction id")
    @DeleteMapping("fonction/id/{id}")
    public int deleteByFonctionId(@PathVariable Long id){
        return service.deleteByFonctionId(id);
    }
    @Operation(summary = "find by quiz id")
    @GetMapping("quiz/id/{id}")
    public List<InscriptionDto> findByQuizId(@PathVariable Long id){
        return findDtos(service.findByQuizId(id));
    }
    @Operation(summary = "delete by quiz id")
    @DeleteMapping("quiz/id/{id}")
    public int deleteByQuizId(@PathVariable Long id){
        return service.deleteByQuizId(id);
    }
    @Operation(summary = "find by packStudent id")
    @GetMapping("packStudent/id/{id}")
    public List<InscriptionDto> findByPackStudentId(@PathVariable Long id){
        return findDtos(service.findByPackStudentId(id));
    }
    @Operation(summary = "delete by packStudent id")
    @DeleteMapping("packStudent/id/{id}")
    public int deleteByPackStudentId(@PathVariable Long id){
        return service.deleteByPackStudentId(id);
    }
    @Operation(summary = "find by skill id")
    @GetMapping("skill/id/{id}")
    public List<InscriptionDto> findBySkillId(@PathVariable Long id){
        return findDtos(service.findBySkillId(id));
    }
    @Operation(summary = "delete by skill id")
    @DeleteMapping("skill/id/{id}")
    public int deleteBySkillId(@PathVariable Long id){
        return service.deleteBySkillId(id);
    }

    @Operation(summary = "Finds a inscription and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InscriptionDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds inscriptions by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InscriptionDto>> findByCriteria(@RequestBody InscriptionCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated inscriptions by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InscriptionCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports inscriptions by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InscriptionCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets inscription data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InscriptionCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public InscriptionRestAdmin (InscriptionAdminService service, InscriptionConverter converter) {
        super(service, converter);
    }




}
