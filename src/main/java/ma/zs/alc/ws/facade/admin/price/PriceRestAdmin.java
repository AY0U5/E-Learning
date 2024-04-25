package  ma.zs.alc.ws.facade.admin.price;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.alc.bean.core.price.Price;
import ma.zs.alc.dao.criteria.core.price.PriceCriteria;
import ma.zs.alc.service.facade.admin.price.PriceAdminService;
import ma.zs.alc.ws.converter.price.PriceConverter;
import ma.zs.alc.ws.dto.price.PriceDto;
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
@RequestMapping("/api/admin/price/")
public class PriceRestAdmin  extends AbstractController<Price, PriceDto, PriceCriteria, PriceAdminService, PriceConverter> {



    @Operation(summary = "upload one price")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple prices")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all prices")
    @GetMapping("")
    public ResponseEntity<List<PriceDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all prices")
    @GetMapping("optimized")
    public ResponseEntity<List<PriceDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a price by lib")
    @GetMapping("lib/{lib}")
    public ResponseEntity<PriceDto> findByLib(@PathVariable String lib) {
        return super.findByReferenceEntity(new Price(lib));
    }

    @Operation(summary = "Saves the specified  price")
    @PostMapping("")
    public ResponseEntity<PriceDto> save(@RequestBody PriceDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  price")
    @PutMapping("")
    public ResponseEntity<PriceDto> update(@RequestBody PriceDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of price")
    @PostMapping("multiple")
    public ResponseEntity<List<PriceDto>> delete(@RequestBody List<PriceDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified price")
    @DeleteMapping("")
    public ResponseEntity<PriceDto> delete(@RequestBody PriceDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified price")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple prices by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }



    @Operation(summary = "Finds a price and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PriceDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds prices by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PriceDto>> findByCriteria(@RequestBody PriceCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated prices by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PriceCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports prices by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody PriceCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets price data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PriceCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public PriceRestAdmin (PriceAdminService service, PriceConverter converter) {
        super(service, converter);
    }




}
