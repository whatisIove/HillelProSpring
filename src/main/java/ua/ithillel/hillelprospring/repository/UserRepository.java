package ua.ithillel.hillelprospring.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelprospring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.name = :name, u.surname = :surname where u.id = :id")
    Integer updateNameAndSurnameById(final Integer id, final String name, final String surname);

    User getUserByEmailAndPhone(final String email, final Long phone);

    User getByAgeOrEmailOrPhone(final Integer age, final String email, final Long phone);

}