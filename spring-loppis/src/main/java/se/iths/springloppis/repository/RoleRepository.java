package se.iths.springloppis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.springloppis.entity.RoleEntity;

import javax.management.relation.Role;

@Repository
public interface RoleRepository  extends CrudRepository<RoleEntity, Long> {
RoleEntity findByRole(String role);


}
