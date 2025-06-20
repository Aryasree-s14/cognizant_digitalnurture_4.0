package dependencyinject;

public class DependencyInjection 
{
	interface CustomerRepository 
	{
        String findCustomerById(int id);
    }

    
    static class CustomerRepositoryImpl implements CustomerRepository 
    {
       
        public String findCustomerById(int id) 
        {
            return "Customer with ID " + id + " is : Emma";
        }
    }

    static class CustomerService 
    {
        private final CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) 
        {
            this.customerRepository = customerRepository;
        }

        public void displayCustomer(int id)
        {
            String customer = customerRepository.findCustomerById(id);
            System.out.println(customer);
        }
    }

    
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService s = new CustomerService(repository);

        s.displayCustomer(30);
    }
}


