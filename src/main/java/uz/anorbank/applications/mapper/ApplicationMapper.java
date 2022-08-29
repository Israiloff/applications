package uz.anorbank.applications.mapper;

import org.mapstruct.Mapper;
import uz.anorbank.applications.domain.Application;
import uz.anorbank.applications.dto.ApplicationDto;

@Mapper(componentModel = "spring")
public interface ApplicationMapper extends EntityMapper<Application, ApplicationDto> {
}
