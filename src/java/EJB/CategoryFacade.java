/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aida
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {
    @PersistenceContext(unitName = "Super_City_Life_SotrePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }

    @Override
    public void addCategory(Category category) {
       em.persist(category);
    }

    @Override
    public void removeCategory(int categoryId) {
        em.remove(getCategory(categoryId));
    }

    @Override
    public void editCategory(Category category) {
        em.merge(category);
    }

    @Override
    public Category getCategory(int categoryId) {
        return em.find(Category.class,categoryId);
    }

    @Override
    public List<Category> getAllCategory() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }
    
    
    
    
}
