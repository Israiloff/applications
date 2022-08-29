package uz.anorbank.applications.mapper;

public interface EntityMapper<TEntity, TDto> {

    TDto toDto(TEntity entity);

    TEntity toEntity(TDto dto);
}
