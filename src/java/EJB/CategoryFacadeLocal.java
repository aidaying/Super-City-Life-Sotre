/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Category;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aida
 */
@Local
public interface CategoryFacadeLocal {

    void create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    List<Category> findAll();

    List<Category> findRange(int[] range);

    int count();

    void addCategory(Category category);

    void removeCategory(int categoryId);

    void editCategory(Category category);

    Category getCategory(int categoryId);

    List<Category> getAllCategory();
    
}
