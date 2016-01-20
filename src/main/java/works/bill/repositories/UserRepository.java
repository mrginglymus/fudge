/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.bill.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import works.bill.entities.User;

/**
 *
 * @author bill
 */
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByEmail(String email);
    
    User findOneByEmail(String email);
}
