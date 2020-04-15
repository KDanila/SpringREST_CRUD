package kdv.dao;

import kdv.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}











