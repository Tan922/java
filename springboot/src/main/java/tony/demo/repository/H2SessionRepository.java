package tony.demo.repository;

import tony.demo.entity.H2Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface H2SessionRepository extends CrudRepository<H2Session, Long> {

    /**
     * Finds H2 sessions by the USER_NAME.
     * We use a custom JPQL query because INFORMATION_SCHEMA tables
     * are system-managed and not standard entities.
     *
     * @param userName The user name to search for.
     * @return A list of H2Session objects matching the user name.
     */
    @Query("SELECT s FROM H2Session s WHERE s.userName = :userName")
    List<H2Session> findByUserName(@Param("userName") String userName);
}
