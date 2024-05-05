package  ma.zs.alc.ws.facade.admin.course;

import io.swagger.v3.oas.annotations.Operation;

import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.dao.criteria.core.course.CoursCriteria;
import ma.zs.alc.service.facade.admin.course.CoursAdminService;
import ma.zs.alc.ws.converter.course.CoursConverter;
import ma.zs.alc.ws.dto.course.CoursDto;
import ma.zs.alc.ws.dto.course.ParcoursDto;
import ma.zs.alc.zynerator.controller.AbstractController;
import ma.zs.alc.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.alc.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/cours/")
public class CoursRestAdmin  extends AbstractController<Cours, CoursDto, CoursCriteria, CoursAdminService, CoursConverter> {
    //added
    @Operation(summary = "find by cours code")
    @GetMapping("/code/{code}")
    public Cours findByCode(String code) {
        return coursAdminService.findByCode(code);
    }
    @Operation(summary = "delete by cours code")
    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return coursAdminService.deleteByCode(code);
    }

    private @Autowired CoursAdminService coursAdminService;

    @Operation(summary = "find by parcours code")
    @GetMapping("parcours/code/{code}")
    public List<CoursDto> findByParcoursCode(@PathVariable String code) {
        return findDtos(coursAdminService.findByParcoursCode(code));
    }
    @Operation(summary = "delete by parcours code")
    @DeleteMapping("parcours/code/{code}")
    public int deleteByParcoursCode( @PathVariable String code) {
        return coursAdminService.deleteByParcoursCode(code);
    }


    //
    @Operation(summary = "upload one cours")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple courss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all courss")
    @GetMapping("")
    public ResponseEntity<List<CoursDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all courss")
    @GetMapping("optimized")
    public ResponseEntity<List<CoursDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a cours by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<CoursDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Cours(libelle));
    }

    @Operation(summary = "Saves the specified  cours")
    @PostMapping("")
    public ResponseEntity<CoursDto> save(@RequestBody CoursDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            Cours myT = converter.toItem(dto);
            Cours t = service.saveCours(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                CoursDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }
    /*public ResponseEntity<CoursDto> save(@RequestBody CoursDto dto) throws Exception {
        return super.save(dto);
    }*/

    @Operation(summary = "Updates the specified  cours")
    @PutMapping("")
    public ResponseEntity<CoursDto> update(@RequestBody CoursDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of cours")
    @PostMapping("multiple")
    public ResponseEntity<List<CoursDto>> delete(@RequestBody List<CoursDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified cours")
    @DeleteMapping("")
    public ResponseEntity<CoursDto> delete(@RequestBody CoursDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified cours")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple courss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by etatCours id")
    @GetMapping("etatCours/id/{id}")
    public List<CoursDto> findByEtatCoursId(@PathVariable Long id){
        return findDtos(service.findByEtatCoursId(id));
    }
    @Operation(summary = "delete by etatCours id")
    @DeleteMapping("etatCours/id/{id}")
    public int deleteByEtatCoursId(@PathVariable Long id){
        return service.deleteByEtatCoursId(id);
    }
    @Operation(summary = "find by parcours id")
    @GetMapping("parcours/id/{id}")
    public List<CoursDto> findByParcoursId(@PathVariable Long id){
        return findDtos(service.findByParcoursId(id));
    }
    @Operation(summary = "delete by parcours id")
    @DeleteMapping("parcours/id/{id}")
    public int deleteByParcoursId(@PathVariable Long id){
        return service.deleteByParcoursId(id);
    }

    @Operation(summary = "Finds a cours and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CoursDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds courss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CoursDto>> findByCriteria(@RequestBody CoursCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated courss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CoursCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports courss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody CoursCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets cours data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CoursCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public CoursRestAdmin (CoursAdminService service, CoursConverter converter) {
        super(service, converter);
    }




}
