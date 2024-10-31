package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.SeasonsData;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.repository.ISerieRepository;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvertirDatos;
import org.springframework.beans.factory.annotation.Value;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private ConsumoAPI APIConsumption = new ConsumoAPI();
    private ConvertirDatos conversor = new ConvertirDatos();

    private final String BASE_URL = "https://www.omdbapi.com/?t=";
    @Value("${api.key}")
    private String API_KEY; // = "&apikey=53b3a0b1"; //En variables de entorno/ambiente

    private List<SeriesData> seriesDataList = new ArrayList<>();
    private ISerieRepository repository;

    public Main(ISerieRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {

        var option = -1;
        while (option != 0) {
            var menu = """
                    1) Search series
                    2) Search episodes
                    3) Show series
                    0) Exit                   
                    """;
            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    searchSerie();
                    break;
                case 2:
                    searchEpisode();
                    break;
                case 3:
                    showSearchedSeries();
                    break;
                case 0:
                    System.out.println("EXITING APP...");
                    break;
                default:
                    System.out.println("¡¡¡Invalid option!!!");
            }
        }
    }

    private SeriesData getSeriesData() {
        System.out.println("Type the name of the serie you want to search");
        var serieToSearch = sc.nextLine();
        var json = APIConsumption.obtenerDatos(BASE_URL + serieToSearch.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, SeriesData.class);
        return datos;
    }

    private void searchEpisode() {
        SeriesData seriesData = getSeriesData();
        List<SeasonsData> seasons = new ArrayList<>();
        for (int i = 1; i <= seriesData.seasons(); i++) {
            var json = APIConsumption.obtenerDatos(BASE_URL + seriesData.title().replace(" ", "+") + "&Season=" + i + API_KEY);
            var seasonsData = conversor.obtenerDatos(json, SeasonsData.class);
            seasons.add(seasonsData);
        }
        seasons.forEach(System.out::println);
    }

    private void searchSerie() {
        SeriesData seriesData = getSeriesData();
        //seriesDataList.add(seriesData);
        Serie serie = new Serie(seriesData);
        repository.save(serie);
        System.out.println(seriesData);

    }

    private void showSearchedSeries() {
        List<Serie> series = repository.findAll();
        series.stream().sorted(Comparator.comparing(Serie::getGenre)).forEach(System.out::println);

    }
}
