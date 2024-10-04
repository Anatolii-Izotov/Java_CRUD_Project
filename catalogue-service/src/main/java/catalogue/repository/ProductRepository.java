package catalogue.repository;

import catalogue.endity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // написание собственных запросов
    // вариант написания кастомных запросов в репозиториях
    // (так же можно использовать именованые запросы, которые описываются в классах сущностях)

    // JPQL запрос
    //@Query(value = "select p from Product p where p.title ilike :filter")
    // нативный запрос на языке sql
    //@Query(value = "select * from catalogue.t_product where c_title ilike :filter", nativeQuery = true)

    //@Query(name = "Product.findAllByTitleLikeIgnoringCase", nativeQuery = true)
    Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String filter);

    /*
    название данного метода преобразуется примерно в такой запрос:
    select * from catalogue.t_product where c_title ilike :filter
    */


}