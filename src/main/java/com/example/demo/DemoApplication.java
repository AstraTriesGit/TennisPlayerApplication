package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlayerSpringDataRepository repo;
//	PlayerRepository repo;
//	PlayerDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n\nInserting Player: {}", repo.save(new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
		logger.info("\n\n>>Inserting Player: {}\n", repo.save(new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
		logger.info("\n\n>>Inserting Player: {}\n", repo.save(new Player("Thiem", "Austria", new Date(System.currentTimeMillis()), 17)));

		logger.info("\n\n>>Updating player with id 3: {}", repo.save(new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));

		logger.info("\n\n>>Player with id 2: {}", repo.findById(2));
		repo.deleteById(2);
		logger.info("\n\n>>All players in the db: {}", repo.findAll());
	}

//	@Override
//	public void run(String... args) throws Exception {
//		//insert players
//		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
//				new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
//		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
//				new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));
//		logger.info("\n\n>> Inserting Player: {}\n", repo.insertPlayer(
//				new Player("Thiem", "Austria",
//						new Date(System.currentTimeMillis()), 17)));
//		//update player
//		logger.info("\n\n>> Updating Player with Id 3: {}\n", repo.updatePlayer(
//				new Player(3, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));
//		//get player
//		logger.info("\n\n>> Player with id 3: {}\n", repo.getPlayerById(3));
//		repo.deleteById(2);
//		logger.info("All players in the db are: {}", repo.getAllPlayers());
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Inserting player 4: {}", dao.insertPlayer(
//				new Player(4, "Thiem", "Austria",
//						new Date(System.currentTimeMillis()),
//						17)
//		));
//		logger.info("All players data: {}", dao.getAllPlayers());
//		logger.info("Updating player with id 4: {}", dao.updatePlayer(
//				new Player(
//						4, "Thiem", "Austria",
//						Date.valueOf("1993-09-03"), 17
//				)
//		));
//		logger.warn("Player with id 4 is {}", dao.getPlayerById(4));
////		logger.warn("Deleting player with ID 2 :{}", dao.deletePlayerById(2));
////		logger.info("All players data: {}", dao.getAllPlayers());
//		dao.createTournamentTable();
//		logger.info("French players :{}", dao.getPlayerByNationality("France"));
//	}
}
