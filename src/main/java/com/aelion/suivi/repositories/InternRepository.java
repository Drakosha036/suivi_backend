/**
 * 
 */
package com.aelion.suivi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aelion.suivi.entities.InternEntity;

/**
 * @author Aelion
 *
 */
//CrudRepository<QuelEntity?, QuelTypeDId?>
public interface InternRepository extends CrudRepository<InternEntity, Long> {

	/** requetes deja existantes dans repository
	 * 
	 * DELETE FROM intern WHERE intern.id = 1; //delete(t)
	 * SELET * FROM intern; //findAll()
	 * SELECT * FROM intern WHERE intern.id = 1; //findOne
	 * 
	 *save(): 
	 * INSERT INTO intern  
	 * 	(name, first_name, birthdate, email, phone_number, address) 
	 * 	VALUES ('Tartempion', 'Jean', '1989-10-22', 'jdsd@gmail.com', '05', '10');
	 * 
	 *update()
	 * UPDATE intern SET name = 'Van Dame', first_name = 'Jean-Claude',
	 *  birthdate = '1963-04-15', email= 'sdqsfq@gmail.com', phone_number = '06', 
	 *  address = 'fqsfq rue sqdfsq' WHERE id = 4; 
	 */
	
	//findByQuelquechose doit respecter l'attribut dans InternEntity
	//findBy on peut faire sur n'import quelle colonne de tableau
	//tout le finBy retourne le List
	public List<InternEntity> findByName(String name);
	public List<InternEntity> findByFirstName(String firstName);

	//parametre nomme: ':email'
	@Query("SELECT i FROM InternEntity i WHERE i.email = :email") //passe JPQL requete
	//@Param("email") lie le nom de Param et le nom de QL
	public Optional<InternEntity> internByMail(@Param("email") String email); //parce que mail est unique; il n'y a pas de List<InternEntity>
	
	
}
