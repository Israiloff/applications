package uz.anorbank.applications.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import uz.anorbank.applications.enumration.ApplicationStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@Table("application")
public class Application {

    @Id
    @Column("id")
    private Long id;

    /**
     * Тип запрошенного процесса
     */
    @NotNull(message = "must not be null")
    @Size(max = 72)
    @Column("process")
    private String process;

    /**
     * Внешний номер заявки
     */
    @NotNull(message = "must not be null")
    @Size(max = 72)
    @Column("ext_id")
    private String extId;

    /**
     * Статус запроса
     */
    @NotNull(message = "must not be null")
    @Column("status")
    private ApplicationStatus status;

    /**
     * Время создания заявки
     */
    @NotNull(message = "must not be null")
    @Column("date")
    private Instant date;

    /**
     * Уникальный ид агента
     */
    @NotNull(message = "must not be null")
    @Size(max = 72)
    @Column("agent")
    private String agent;

    /**
     * Уникальный ид сохраненного тела входного запроса
     */
    @Column("request_id")
    private Long requestId;
}
