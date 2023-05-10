/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ptit.tmdt.bansach.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ptit.tmdt.bansach.entity.ProductEntity;

/**
 *
 * @author dovan
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    @Query("SELECT product FROM ProductEntity product WHERE product.productName LIKE :name")
    public List<ProductEntity> findAllByProductName(String name);

    // public String findIdByName(String productName);

    @Query(value = "SELECT * FROM database_bansach_pthttmdt_btl.product where product_name = ? order by product_id desc limit 1;", nativeQuery = true)
    public ProductEntity findByNameLatest(String productName);

    // public ProductEntity findAllById(Integer id);

}
