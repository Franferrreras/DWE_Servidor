package org.iesalixar.servidor.repository;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Long> {

}
