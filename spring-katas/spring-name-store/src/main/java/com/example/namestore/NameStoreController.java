package com.example.namestore;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/names")
public class NameStoreController {

    private Map<UUID, String> names = new HashMap<>();

    @PostMapping
    public String post(@RequestBody String name) {
        final UUID uuid = UUID.randomUUID();
        names.put(uuid, name);
        return uuid.toString();
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Void> put(@PathVariable UUID uuid, @RequestBody String name) {
        if(names.containsKey(uuid)) {
            names.put(uuid, name);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
        if(names.containsKey(uuid)) {
            names.remove(uuid);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<String> get(@PathVariable UUID uuid) {
        return names.containsKey(uuid)
            ? ResponseEntity.ok(names.get(uuid))
            : ResponseEntity.notFound().build();
    }

    @GetMapping()
    public String list() {
        return names.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
