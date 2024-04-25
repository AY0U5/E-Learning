package  ma.zs.alc.ws.facade.admin.inscription;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.inscription.Dictionary;
import ma.zs.alc.dao.criteria.core.inscription.DictionaryCriteria;
import ma.zs.alc.service.facade.admin.inscription.DictionaryAdminService;
import ma.zs.alc.ws.converter.inscription.DictionaryConverter;
import ma.zs.alc.ws.dto.inscription.DictionaryDto;
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
@RequestMapping("/api/admin/dictionary/")
public class DictionaryRestAdmin  extends AbstractController<Dictionary, DictionaryDto, DictionaryCriteria, DictionaryAdminService, DictionaryConverter> {



    @Operation(summary = "upload one dictionary")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple dictionarys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all dictionarys")
    @GetMapping("")
    public ResponseEntity<List<DictionaryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all dictionarys")
    @GetMapping("optimized")
    public ResponseEntity<List<DictionaryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a dictionary by word")
    @GetMapping("word/{word}")
    public ResponseEntity<DictionaryDto> findByWord(@PathVariable String word) {
        return super.findByReferenceEntity(new Dictionary(word));
    }

    @Operation(summary = "Saves the specified  dictionary")
    @PostMapping("")
    public ResponseEntity<DictionaryDto> save(@RequestBody DictionaryDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  dictionary")
    @PutMapping("")
    public ResponseEntity<DictionaryDto> update(@RequestBody DictionaryDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of dictionary")
    @PostMapping("multiple")
    public ResponseEntity<List<DictionaryDto>> delete(@RequestBody List<DictionaryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified dictionary")
    @DeleteMapping("")
    public ResponseEntity<DictionaryDto> delete(@RequestBody DictionaryDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified dictionary")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple dictionarys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etudiant id")
    @GetMapping("etudiant/id/{id}")
    public List<DictionaryDto> findByEtudiantId(@PathVariable Long id){
        return findDtos(service.findByEtudiantId(id));
    }
    @Operation(summary = "delete by etudiant id")
    @DeleteMapping("etudiant/id/{id}")
    public int deleteByEtudiantId(@PathVariable Long id){
        return service.deleteByEtudiantId(id);
    }

    @Operation(summary = "Finds a dictionary and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<DictionaryDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds dictionarys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<DictionaryDto>> findByCriteria(@RequestBody DictionaryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated dictionarys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody DictionaryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports dictionarys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody DictionaryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets dictionary data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody DictionaryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public DictionaryRestAdmin (DictionaryAdminService service, DictionaryConverter converter) {
        super(service, converter);
    }




}
