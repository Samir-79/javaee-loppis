package se.iths.service;

import se.iths.entity.Item;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ItemService {

    @PersistenceContext
    EntityManager entityManager;

    public void createItem(Item item) {
        entityManager.persist(item);
    }

    public void update(Item item) {
        entityManager.merge(item);
    }

    public Item findItemById(Long id) {
        return entityManager.find(Item.class, id);
    }

    public List<Item> getAllItems() {

        return entityManager.createQuery("SELECT i from Item  i", Item.class).getResultList();
    }

    public Item findItemByPrice(double price) {
        return entityManager.find(Item.class, price);
    }


    public void deleteItem(Long id) {
        Item foundItem = entityManager.find(Item.class, id);
        entityManager.remove(foundItem);
    }


    public Item updateName(Long id, String name) {
        Item foundItem = entityManager.find(Item.class, id);
        foundItem.setName(name);
        //merge() behövs ej
        //return entityManager.merge(foundItem);
        return foundItem;
    }


    public List<Item> findItemsByPriceRange(double minPrice, double maxPrice) {
        return entityManager.createQuery("SELECT i from Item i WHERE i.price >= :minPrice and i.price <= :maxPrice", Item.class).
                setParameter("minPrice", minPrice).setParameter("maxPrice", maxPrice).getResultList();
    }

    @PostConstruct
    public void itemClassCreate() {
        System.out.println("Item entity class created!");
    }

    @PreDestroy
    public void itemClassDestroy() {
        System.out.println("Item entity says goodbye for now!");
    }


    //JPQL QUERIES


    // DYNAMIC
    public List<Item> getByNameDynamicQuery(String name) {
        String query = "SELECT i FROM Item i WHERE i.name = '" + name + "'";
        return entityManager.createQuery(query, Item.class).getResultList();

    }

    public List<Item> getByNamedParameters(String name) {
        String query = "SELECT i FROM Item i where i.name= :name";
        return entityManager.createQuery(query, Item.class).setParameter("name", name).getResultList();
    }

    public List<Item> getByNamedPositionalParameters(String name) {
        String query = "SELECT i FROM Item i where i.name= ?1";
        return entityManager.createQuery(query, Item.class).setParameter(1, name).getResultList();
    }

    public List<Item> getAllItemsBetweenPrice(double minPrice, double maxPrice) {
        String query = "SELECT i FROM Item i WHERE i.price BETWEEN :minPrice AND :maxPrice";
        return entityManager.createQuery(query, Item.class).setParameter("minPrice", minPrice)
                .setParameter("maxPrice", maxPrice).getResultList();
    }


    public List<Item> getAllNames() {

        String query = "SELECT i.name FROM Item i";
        return entityManager.createQuery(query, Item.class).getResultList();

    }

    public List<Item> getAllItemsSortedByCategory() {

        String query = "SELECT  i FROM  Item i ORDER BY i.category";
        return entityManager.createQuery(query, Item.class).getResultList();
    }

    public Double selectMaxPrice() {

        TypedQuery<Double> typedQuery = entityManager.createQuery("SELECT MAX(i.price) FROM Item i", Double.class);
        return typedQuery.getSingleResult();
    }

    //GET ALL ITEMS WITH NAMED QUERIES
    public List<Item> getAllWithNamedQuery() {

        return entityManager.createNamedQuery("itemEntity.findAll", Item.class).getResultList();

    }

    public void updatePrice() {

        String query = "UPDATE Item i SET i.price= 200.00 WHERE i.price > 200.00";
        entityManager.createQuery(query).executeUpdate();
    }

    public void deleteExpensive() {
        String query = "DELETE FROM Item i WHERE i.price > 200.00";
        entityManager.createQuery(query).executeUpdate();
    }

    // CRITERIA API QUERIES

    // Get all  items

    public List<Item> getAllItemsCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);

        // Root<Item> item = criteriaQuery.from(Item.class);
        TypedQuery<Item> typedQuery = entityManager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }

    //ORDER BY CATEGORY

    public List<Item> getAllItemsSortedByCategoryCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> item = criteriaQuery.from(Item.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(item.get("category")));
        TypedQuery<Item> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }


}