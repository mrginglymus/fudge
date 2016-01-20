/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.bill.repositories;

import org.springframework.data.repository.CrudRepository;
import works.bill.entities.Authorities;

/**
 *
 * @author bill
 */
public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {
    
}
