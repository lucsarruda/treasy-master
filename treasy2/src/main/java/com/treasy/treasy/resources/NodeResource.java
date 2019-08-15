package com.treasy.treasy.resources;


import com.treasy.treasy.models.Nodes;
import com.treasy.treasy.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.Collection;

@RestController
@RequestMapping("/node")
public class NodeResource {

    @Autowired
    private NodeRepository repository;


    @GetMapping
    public Collection<Nodes> get(@RequestParam(required = false, value = "description") String description) {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer  id) {
        Nodes nodes = repository.findById(id).orElse(null);
        if (nodes == null) {
            return ResponseEntity.notFound()
                    .header("", "")
                    .build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(nodes);
    }

    @PostMapping
    @Transactional
    public Nodes create(@RequestBody Nodes nodes) {
        return repository.save(nodes);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Nodes nodes) {
        return repository.findById(id)
                .map(record -> {
                    record.setCode(nodes.getCode());
                    record.setDescription(nodes.getDescription());
                    record.setParentId(nodes.getParentId());
                    record.setDetail(nodes.getDetail());
                    Nodes updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

}
