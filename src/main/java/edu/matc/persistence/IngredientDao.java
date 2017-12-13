package edu.matc.persistence;

import edu.matc.entity.Ingredient;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * The type Ingredient dao.
 */
public class IngredientDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Gets ingredient.
     *
     * @param id the id
     * @return the ingredient
     */
    public Ingredient getIngredient(int id) {
        Ingredient ingredient = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            ingredient = (Ingredient) session.get(Ingredient.class, id);
        } catch (HibernateException he) {
            log.error("Error getting ingredient with id: " + id, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ingredient;
    }
}
