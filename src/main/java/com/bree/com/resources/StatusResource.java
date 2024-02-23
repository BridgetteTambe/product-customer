package com.bree.com.resources;

import com.bree.com.models.Status;
import com.bree.com.service.StatusService;
import com.bree.com.utils.ConstandField;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:4200", "http://localhost:4201", "https://product-admin-view.vercel.app/", "https://product-customer-view.vercel.app/"})
public class StatusResource {

//    @Autowired
    StatusService statusService;
    private static final String ENTITY = "Status";

    public StatusResource(StatusService statusService) {
        this.statusService = statusService;
    }

    private Logger LOGGER = LoggerFactory.getLogger(StatusResource.class);

    @PostMapping("/status")
    public Status createStatus(@RequestBody Status status) throws Exception {
        LOGGER.info(ConstandField.REST_SAVE_LOG.replaceAll("#ENTITY", ENTITY), status);

        if (status.getId() != null) {
            throw new Exception(ConstandField.ID_EXISTS.replaceAll("#ID", String.valueOf(status.getId())
                    .replaceAll("ENTITY", ENTITY)));
        }

        return this.statusService.save(status);
    }

    @PutMapping("/status")
    public Status updateStatus(@RequestBody Status status) throws Exception {
        LOGGER.info(ConstandField.REST_UPDATE_LOG.replaceAll("ENTITY", ENTITY), status);
        if (status.getId() == null) {
            throw new Exception(ConstandField.ID_NULL.replaceAll("ID", String.valueOf(status.getId())
                    .replaceAll("ENTITY", ENTITY)));

        }

        return this.statusService.save(status);
    }


    @DeleteMapping("/status")
    public Status cancelOrder(@RequestBody Status status) {
        LOGGER.info(ConstandField.DELETE_LOG.replaceAll("ENTITY", ENTITY), status);
        this.statusService.delete(status);
        return status;
    }


    @GetMapping("/status/{id}")
    public Status findById(@PathVariable Long id) {
        LOGGER.info(ConstandField.REST_GET_LOG.replaceAll("ENTITY", ENTITY), id);
        return statusService.findById(id);
    }


    @GetMapping("/status")
    public Page<Status> findAllStatus(Pageable pageable) {
        LOGGER.info(ConstandField.REST_DELETE_LOG.replaceAll("ENTITY", ENTITY), pageable);
        return this.statusService.findAll(pageable);
    }

}
