package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.main.Main;
import com.aluracursos.screenmatch.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	@Autowired //Inyección de dependencias
	private ISerieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*//System.out.println("Hello world!! From Spring");
		var consumoAPI = new ConsumoAPI();
		ConvertirDatos conversor = new ConvertirDatos();
		var json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?apikey=53b3a0b1&t=game+of+thrones");
		System.out.println(json);
		var datos = conversor.obtenerDatos(json, Serie.class);
		System.out.println(datos);

		json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?apikey=53b3a0b1&t=game+of+thrones&season=1&episode=1");
		Episode episode = conversor.obtenerDatos(json, Episode.class);
		System.out.println(episode);*/
		Main main = new Main(repository);
		main.showMenu();

		//EjemploStreams ejemploStreams = new EjemploStreams();
		//ejemploStreams.showExample();





	}
}
