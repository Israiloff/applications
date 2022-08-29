package uz.anorbank.applications.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
public class ApplicationDto {

    /**
     * ID of application
     */
    @ApiModelProperty("ID of application")
    private Long id;

    /**
     * Process name
     */
    @ApiModelProperty("Process name")
    @NotNull(message = "must not be null")
    @Size(max = 72)
    private String process;

    /**
     * Application's external id (Processing ID)
     */
    @ApiModelProperty("Application's external id (Processing ID)")
    @NotNull(message = "must not be null")
    @Size(max = 72)
    private String extId;

    /**
     * Request Status
     */
    @ApiModelProperty("Request Status")
    @NotNull(message = "must not be null")
    private String status;

    /**
     * Application created date
     */
    @ApiModelProperty("Application created date")
    @NotNull(message = "must not be null")
    private Instant date;

    /**
     * Unique ID of requested Agent
     */
    @ApiModelProperty("Unique ID of requested Agent")
    private String agent;

    /**
     * Unique ID of request given by caller
     */
    @ApiModelProperty("Unique ID of request given by caller")
    private Long requestId;
}
