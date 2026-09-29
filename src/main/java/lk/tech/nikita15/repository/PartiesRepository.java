package lk.tech.nikita15.repository;

import lk.tech.nikita15.dto.PartieDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PartiesRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final Path path = Path.of("data", "parties.json");

    @SneakyThrows
    public List<PartieDTO> load() {
        if (Files.notExists(path)) {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Files.createFile(path);
        }

        String json = Files.readString(path);
        if (json.isBlank()) {
            return new ArrayList<>();
        }

//        return objectMapper.readValue(json, new TypeReference<List<PartieDTO>>() {});
        PartieDTO[] partieDTOS = objectMapper.readValue(json, PartieDTO[].class);
        List<PartieDTO> list = Arrays.asList(partieDTOS);
        return new ArrayList<>(list);
    }



    @SneakyThrows
    public void save(List<PartieDTO> partiesDTO) {
        String json = objectMapper.writeValueAsString(partiesDTO);
        Files.writeString(path, json);
    }
}