package kdv.dao;

import kdv.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerJpaDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerJpaDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> getCustomers() {
        Query query = entityManager.createQuery("from Customer ");
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        Query query = entityManager.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }
}
