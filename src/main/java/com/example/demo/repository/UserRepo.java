package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	//Método para obtener un usuario por su username
		public User findByUsername(String username);
		public User findByEmail(String email);
		
		@Query(value="SELECT username FROM user WHERE username = ?1", nativeQuery = true) 
		String getUserName(String newUsername);
		
		@Query(value= "SELECT password FROM user", nativeQuery = true)
		List<String> getPasswords();
		
		@Query(value = "SELECT email FROM user", nativeQuery = true)
		List<String> getEmails();
		
		@Query(value = "SELECT username FROM user", nativeQuery = true)
		List<String> getUsernames();
		
		/**
		 * Query para volver a poner a 0 los objetivos de los usuarios todos los lunes a las 00:00:00
		 * A tener en cuenta que el update tiene que tener el mismo nombre que poseen las columnas en la BBDD
		 */
		@Query(value = "UPDATE user SET avance_semana_food = 0, avance_semana_sport = 0", nativeQuery = true)
		void reiniciaAvance();
		

		/**
		 * Petición para no traerme todos los usuarios
		 * Devuelve las ids de los usuarios
		 * @return
		 */
		@Query(value = "SELECT id FROM user", nativeQuery = true)
		List<Long> getIdsUsers();
		
	
	
}
