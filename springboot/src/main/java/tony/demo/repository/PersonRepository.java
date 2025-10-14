package tony.demo.repository;

import tony.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// The @Repository annotation is optional since Spring Data will detect it,
// but it's good practice for clarity.
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // You can define custom query methods here.
    // Spring Data automatically generates the query based on the method name.
    Person findByName(String name);
}
