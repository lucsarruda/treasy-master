package com.treasy.treasy.controller;

import com.treasy.treasy.models.NodePai;
import com.treasy.treasy.service.NodeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/node")
public class NodeController {

    private  NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping
    public Collection<NodePai> get() {
        return nodeService.findAll();
    }

    @PostMapping
    public NodePai create(@RequestBody NodePai nodePai) {
        return nodeService.save(nodePai);
    }

}
