package chopenteries.api.response.converter;

public interface DtoConverter<E> {

    E convertToEntity();

    E updateEntity(E e);
}
