package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Recipe dao.
 */
public class RecipeDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Gets all recipes.
     *
     * @return the all recipes
     */
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            recipes = session.createCriteria(Recipe.class).list();
        } catch (HibernateException he) {
            log.error("Error getting all recipes", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recipes;
    }

    /**
     * Gets recipe.
     *
     * @param id the id
     * @return the recipe
     */
    public Recipe getRecipe(int id) {
        Recipe recipe = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            recipe = (Recipe) session.get(Recipe.class, id);
        } catch (HibernateException he) {
            log.error("Error getting recipe with id: " + id, he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recipe;
    }

    /**
     * Add recipe recipe.
     *
     * @param recipe the recipe
     * @return the recipe
     */
    public Recipe addRecipe(Recipe recipe) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(recipe);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back save of recipe: " + recipe, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recipe;
    }

    /**
     * Delete recipe.
     *
     * @param recipe the recipe
     */
    public void deleteRecipe(Recipe recipe) {

        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(recipe);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Error rolling back delete of recipe id: " + recipe, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    /**
     * Update recipe.
     *
     * @param recipe the recipe
     */
    public void updateRecipe(Recipe recipe) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(recipe);
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Could not update recipe: " + recipe, he2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Gets user recipes.
     *
     * @param user the user
     * @return the user recipes
     */
    public List<Integer> getUserRecipes(User user) {
        List<Integer> recipes = new ArrayList<Integer>();
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();

            String sql = "SELECT recipeid FROM recipe WHERE login='" + user.getLogin() + "'";
            SQLQuery query = session.createSQLQuery(sql);
            /*query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);*/
            query.setResultTransformer(Criteria.ROOT_ENTITY);
            recipes = query.list();
            log.info(recipes.toString());
        } catch (HibernateException he) {
            log.error("Error getting all recipes", he);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return recipes;
    }

}
