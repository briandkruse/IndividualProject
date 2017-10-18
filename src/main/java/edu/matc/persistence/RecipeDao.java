package edu.matc.persistence;

import edu.matc.entity.Recipe;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RecipeDao {
    private final Logger log = Logger.getLogger(this.getClass());

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

    public Recipe addRecipe(Recipe recipe) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(recipe);
            transaction.commit();
        } catch (HibernateException he){
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

    public void deleteRecipe(int id) {

        Recipe recipe = new Recipe();
        recipe.setId(id);

        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(recipe);
            transaction.commit();
        } catch (HibernateException he){
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

    public void updateRecipe(Recipe recipe) {
        Transaction transaction = null;
        Session session= null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(recipe);
            transaction.commit();
        } catch (HibernateException he){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException he2) {
                    log.error("Could not update recipe: " + recipe, he2);
                }
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

}
