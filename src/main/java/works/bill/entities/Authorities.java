/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package works.bill.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bill
 */
@Entity
public class Authorities {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    
    private String username;
    
    private String authority;

    public Authorities() {};
    
    public Authorities(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }
    
}
