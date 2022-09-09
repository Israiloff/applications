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
     * Application's system unique id
     */
    @ApiModelProperty("Application's system unique id")
    @NotNull(message = "must not be null")
    @Size(max = 72)
    private String systemId;

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
}
